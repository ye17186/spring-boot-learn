package com.yclouds.demo.file.response;

import java.io.Serializable;
import lombok.Data;

/**
 * com.yclouds.demo.upload.response.UploadResponse
 *
 * @author yemeng-lhq
 * @version 2019/6/19 9:34
 */
@Data
public class UploadResponse implements Serializable {

    private static final long serialVersionUID = 6498668523150542576L;

    private String name;

    private Long size;

    private String path;

    private String url;
}
