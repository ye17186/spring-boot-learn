package com.yclouds.demo.file.service;

import com.yclouds.demo.file.request.DownloadRequest;
import com.yclouds.demo.file.request.UploadRequest;
import com.yclouds.demo.file.response.UploadResponse;
import javax.servlet.http.HttpServletResponse;

/**
 * com.yclouds.demo.upload.service.FileService
 *
 * @author ye17186
 * @version 2019/6/19 10:28
 */
public interface FileService {

    UploadResponse uploadFile(UploadRequest request);

    void downloadFile(DownloadRequest request, HttpServletResponse response);
}
