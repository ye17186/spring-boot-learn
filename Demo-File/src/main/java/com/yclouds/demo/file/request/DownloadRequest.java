package com.yclouds.demo.file.request;

import java.io.Serializable;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

/**
 * com.yclouds.demo.upload.request.DownloadRequest
 *
 * @author ye17186
 * @version 2019/6/19 10:54
 */
@Data
public class DownloadRequest implements Serializable {

    private static final long serialVersionUID = 2128126309335848737L;
    /**
     * 文件相对路径
     */
    @NotEmpty
    String filePath;

    /**
     * 下载文件名
     */
    @NotEmpty
    String fileName;
}
