package top.oldwei.fileupload.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import top.oldwei.common.core.Result;
import top.oldwei.common.dto.FileUploadDTO;

/**
 * @Author:weizd
 * @Date:20-1-16
 *
 * 分块上传
 *
 *
 */

@RestController
@RequestMapping("/chunk")
public class UploadController {

    private final Logger logger = LoggerFactory.getLogger(UploadController.class);


    @PostMapping("/upload")
    public Result upload(FileUploadDTO fileUploadDTO, MultipartFile file){



        return Result.success("校验成功");
    }














}
