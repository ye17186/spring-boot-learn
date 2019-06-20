package com.yclouds.demo.file.service.impl;

import com.yclouds.demo.file.request.DownloadRequest;
import com.yclouds.demo.file.request.UploadRequest;
import com.yclouds.demo.file.response.UploadResponse;
import com.yclouds.demo.file.service.FileService;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.UUID;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

/**
 * com.yclouds.demo.upload.service.impl.FileServiceImpl
 *
 * @author ye17186
 * @version 2019/6/19 10:29
 */
@Slf4j
@Service
public class FileServiceImpl implements FileService {

    @Value("${file.save-path:}")
    String fileSavePath;

    @Value("${file.url-prefix:}")
    String fileUrlPrefix;

    @Override
    public UploadResponse uploadFile(UploadRequest request) {

        MultipartFile file = request.getFile();
        String parentPath = calcParentPath(request.getType());
        String fileName = calcFileName(file);

        Path path = Paths.get(fileSavePath + parentPath + fileName);

        UploadResponse response = new UploadResponse();
        try {
            // 父目录不存在，则创建
            if (!Files.exists(path.getParent())) {
                Files.createDirectories(path.getParent());
            }

            Files.write(path, file.getBytes());

            response.setName(file.getOriginalFilename());
            response.setSize(file.getSize());
            response.setPath(path.toString());
            response.setUrl(fileUrlPrefix + parentPath + fileName);
        } catch (IOException e) {
            log.error("文件上传异常", e);
        }
        return response;
    }

    @Override
    public void downloadFile(DownloadRequest request, HttpServletResponse response) {
        try (
            FileChannel fileChannel = FileChannel
                .open(Paths.get(fileSavePath + request.getFilePath()), StandardOpenOption.READ);
            OutputStream os = response.getOutputStream()
        ) {
            // 指定为下载
            response.setContentType("application/x-download");
            // 设置文件名(中文编码)
            String fileName = new String(request.getFileName().getBytes(StandardCharsets.UTF_8),
                StandardCharsets.ISO_8859_1);
            response.addHeader("Content-Disposition", "attachment;filename=" + fileName);

            // 缓冲区大小
            ByteBuffer buf = ByteBuffer.allocate(1024);

            // 设置响应内容长度
            response.setContentLengthLong(fileChannel.size());

            // 写入os
            int len = fileChannel.read(buf);
            while (len != -1) {
                buf.flip();
                while (buf.hasRemaining()) {
                    os.write(buf.get());
                }
                buf.clear();
                len = fileChannel.read(buf);
            }
        } catch (IOException e) {
            log.error("文件下载异常", e);
        }
    }

    /**
     * 根据不同的文件类型，计算出文件保存路径
     * <pre>例1：type=FILE，方法返回 /file/2019-06-19/</pre>
     * <pre>例2：type=IMAGE，方法返回 /image/2019-06-19/</pre>
     *
     * @param type 文件类型
     * @return 文件真实保存路径
     */
    private String calcParentPath(String type) {
        return File.separator + type.toLowerCase() + File.separator + LocalDate.now().toString()
            + File.separator;
    }

    /**
     * 计算保存后的文件名
     * <pre>保存在服务器中的文件名应该保证唯一性，这里是有UUID作为保存文件名</pre>
     *
     * @param file 原文件
     * @return 保存在服务器中的文件名
     */
    private String calcFileName(MultipartFile file) {
        if(StringUtils.isEmpty(file.getOriginalFilename())) {
            throw new RuntimeException("文件名不存在");
        }
        String name = UUID.randomUUID().toString().replaceAll("-", "");
        String ext = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        return name + ext;
    }
}
