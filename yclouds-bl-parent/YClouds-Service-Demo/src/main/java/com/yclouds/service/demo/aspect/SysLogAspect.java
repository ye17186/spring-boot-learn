package com.yclouds.service.demo.aspect;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.TextNode;
import com.google.common.collect.Maps;
import com.yclouds.common.core.aspect.SysLogModel;
import com.yclouds.common.core.aspect.SysLogPoint;
import com.yclouds.common.core.aspect.SysLogType;
import com.yclouds.common.core.utils.JsonUtils;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

/**
 * 系统日志切面处理
 *
 * @author ye17186
 * @version 2019/3/26 16:22
 */
@Slf4j
@Component
@Aspect
public class SysLogAspect {

    /**
     * 正常返回处理
     *
     * @param jp 连接点
     * @param point 注解
     * @param result 返回结果
     */
    @AfterReturning(value = "@annotation(point)", returning = "result")
    public void afterReturn(JoinPoint jp, SysLogPoint point, Object result) {

        SysLogModel sysLog = buildLog(jp, point, result, null);
        saveLog(sysLog);
    }

    /**
     * 抛出异常的处理
     *
     * @param jp 连接点
     * @param point 注解
     * @param ex 异常对象
     */
    @AfterThrowing(value = "@annotation(point)", throwing = "ex")
    public void afterThrowing(JoinPoint jp, SysLogPoint point, Throwable ex) {

        SysLogModel sysLog = buildLog(jp, point, null, ex);
        saveLog(sysLog);
    }

    private void saveLog(SysLogModel sysLog) {

        // 本例中直接打印日志，生产环境中可采用异步的方式，保存到DB等媒介中
        log.info("[SysLog]: {}", JsonUtils.toJson(sysLog));
    }

    /**
     * 构建日志对象
     *
     * @param jp 连接点
     * @param point 注解
     * @param result 处理结果对象
     * @param ex 处理异常对象
     * @return 日志日志对象
     */
    private SysLogModel buildLog(JoinPoint jp, SysLogPoint point, Object result, Throwable ex) {

        SysLogModel sysLog = new SysLogModel();
        sysLog.setActionName(point.actionName());
        sysLog.setTarget(point.target().name());
        sysLog.setType(ex == null ? SysLogType.RETURN.name() : SysLogType.THROWING.name());

        sysLog.setInput(handleInput(jp.getArgs(), Arrays.asList(point.sensitiveParams())));
        sysLog.setOutput(handleOutput(result, point.ignoreOutput()));
        sysLog.setExMsg(handleException(ex));

        return sysLog;
    }


    /**
     * 处理输入参数
     *
     * @param args 入参
     * @param sensitiveParams 敏感参数关键字
     * @return 特殊处理都的入参
     */
    private String handleInput(Object[] args, List<String> sensitiveParams) {

        Map<String, Object> argMap = Maps.newTreeMap();
        ObjectMapper om = new ObjectMapper();
        if (!ObjectUtils.isEmpty(args)) {
            for (int i = 0; i < args.length; i++) {
                if (!ObjectUtils.isEmpty(sensitiveParams)) {
                    try {
                        JsonNode root = om.readTree(JsonUtils.toJson(args[i]));
                        handleSensitiveParams(root, sensitiveParams);
                        argMap.put("arg" + (i + 1), root);
                    } catch (IOException e) {
                        argMap.put("arg" + (i + 1), "[exception]");
                    }
                } else {
                    argMap.put("arg" + (i + 1), args[i]);
                }
            }
        }
        return JsonUtils.toJson(argMap);
    }

    /**
     * 处理输出结果
     *
     * @param result 源输出结果
     * @param ignore 是否忽略结果
     * @return 处理后的输出结果
     */
    private String handleOutput(Object result, boolean ignore) {

        return (ignore || result == null) ? null : JsonUtils.toJson(result);
    }


    /**
     * 处理异常信息
     *
     * @param ex 异常对象
     * @return 处理后的异常信息
     */
    private String handleException(Throwable ex) {
        return ex == null ? null : ex.toString();
    }

    /**
     * 处理敏感参数
     *
     * @param root jackson节点
     * @param params 敏感参数名列表
     */
    private void handleSensitiveParams(JsonNode root, List<String> params) {

        if (root.isObject()) {
            Iterator<Entry<String, JsonNode>> rootIt = root.fields();
            while (rootIt.hasNext()) {
                Entry<String, JsonNode> node = rootIt.next();
                if (params.contains(node.getKey())) {
                    node.setValue(new TextNode("[hidden]"));
                } else {
                    JsonNode tmpNode = node.getValue();
                    if (tmpNode.isObject()) {
                        handleSensitiveParams(tmpNode, params);
                    } else if (tmpNode.isArray()) {
                        for (JsonNode jsonNode : tmpNode) {
                            handleSensitiveParams(jsonNode, params);
                        }
                    }
                }
            }
        } else if (root.isArray()) {
            for (JsonNode jsonNode : root) {
                handleSensitiveParams(jsonNode, params);
            }
        }
    }
}
