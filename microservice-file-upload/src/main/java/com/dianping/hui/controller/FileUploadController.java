package com.dianping.hui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author: lanxinyu@meituan.com  2018-11-22 1:16 PM
 * @Description:
 */
@Controller
public class FileUploadController {

    @PostMapping("/upload")
    public @ResponseBody String handleFileUpload(@RequestParam MultipartFile file) throws IOException {
        byte[] bytes = file.getBytes();
        File save = new File(file.getOriginalFilename());
        FileCopyUtils.copy(bytes, save);
        file.transferTo(save);
        return save.getAbsolutePath();
    }
}
