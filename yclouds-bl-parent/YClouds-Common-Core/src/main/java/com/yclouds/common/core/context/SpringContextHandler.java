package com.yclouds.common.core.context;

import com.yclouds.common.core.utils.SpringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 自动初始化Spring Context
 * <br>
 * 具体获取Bean操作，还是依赖SpringUtils
 * <br>
 * 可通知@EnableSpringContext注解，启用本功能
 *
 * @author ye17186
 * @version 2019/3/22 16:44
 * @see SpringUtils
 */
@Slf4j
public class SpringContextHandler implements ApplicationContextAware {

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringUtils.initContext(applicationContext);
        log.info("Spring Context自动初始化完成，可以通过SpringUtils类提供的方法来获取Bean.");
    }
}
