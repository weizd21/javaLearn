package top.oldwei.fileupload.controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import top.oldwei.common.constant.StrConstant;
import top.oldwei.common.core.Result;
import top.oldwei.common.dto.FileUploadDTO;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @Author:weizd
 * @Date:20-1-16
 *
 * 分块上传
 *
 *
 */
@CrossOrigin
@RestController
@RequestMapping("/chunk")
@Slf4j
public class UploadController {

//    private final Logger logger = LoggerFactory.getLogger(UploadController.class);

    @Autowired
    private HttpServletRequest request;

    @Value("${oldwei.location.chunkFile}")
    private String prePath;

    @PostMapping("/upload")
    public Result upload(FileUploadDTO fileUploadDTO,MultipartFile file) throws Exception{
        if(StringUtils.isEmpty(file)){
            return Result.fail("参数错误");
        }

        log.info("fileUploadDTO : {}",fileUploadDTO);

        // 讲文件保存到对应的目录下

        // 生成文件名

        String fileName = IdUtil.simpleUUID() + StrConstant.DOT + FileUtil.extName(file.getOriginalFilename());


        log.info("随机名字:{}",fileName);


        Files.write(Paths.get(prePath,fileName),file.getBytes());




        return Result.success("校验成功");
    }













}
