package com.yclouds.demo.file.controller;

import com.yclouds.demo.file.request.DownloadRequest;
import com.yclouds.demo.file.request.UploadRequest;
import com.yclouds.demo.file.response.UploadResponse;
import com.yclouds.demo.file.service.FileService;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * com.yclouds.demo.upload.controller.FileController
 *
 * @author ye17186
 * @version 2019/6/19 8:56
 */
@Slf4j
@RestController
@RequestMapping("/file")
public class FileController {

    @Autowired
    FileService fileService;


    @PostMapping("/upload")
    public UploadResponse upload(@Validated UploadRequest request) {

        return fileService.uploadFile(request);
    }

    @GetMapping("/download")
    public void download(@Validated DownloadRequest request, HttpServletResponse response) {

        fileService.downloadFile(request, response);
    }
}
