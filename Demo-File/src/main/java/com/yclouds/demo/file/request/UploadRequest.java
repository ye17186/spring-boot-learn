package com.yclouds.demo.file.request;

import java.io.Serializable;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

/**
 * com.yclouds.demo.upload.model.UploadRequest
 *
 * @author ye17186
 * @version 2019/6/19 9:03
 */
@Data
public class UploadRequest implements Serializable {

    private static final long serialVersionUID = -4858947763998837283L;
    /**
     * 文件对象
     */
    @NotNull
    private MultipartFile file;

    /**
     * 文件类型(一般可传入FILE、IMAGE等)
     */
    @NotEmpty
    private String type;
}
