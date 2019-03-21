package com.zyc.springbootfile.controller;

import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

/**
 * @author <a href="zhuyichen">Zhu Yichen</a>
 * @version 1.0
 * @date 2019年03月21日 17:05
 * @desc FileController
 */
@RestController
public class FileController {

    @PostMapping("/upload")
    public String upload(MultipartFile file){
        try {
            String path = ClassUtils.getDefaultClassLoader().getResource("").getPath()+"static/";
            File dir = new File(path);
            if (!dir.exists()){dir.mkdir();}
            String originalFilename = file.getOriginalFilename();
            String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
            StringBuffer fileName = new StringBuffer();
            fileName.append(UUID.randomUUID().toString());
            fileName.append(suffix);
            File saveFile = new File(dir+"/"+fileName);
            file.transferTo(saveFile);
        }catch (Exception e){
            e.printStackTrace();
            return "上传失败";
        }
        return "上传成功";
    }


    @PostMapping("/uploads")
    public String uploads(MultipartFile[] files){
        try {
            String path = ClassUtils.getDefaultClassLoader().getResource("").getPath()+"static/";
            File dir = new File(path);
            if (!dir.exists()){dir.mkdir();}
            for (MultipartFile file:files){
                String originalFilename = file.getOriginalFilename();
                String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
                StringBuffer fileName = new StringBuffer();
                fileName.append(UUID.randomUUID().toString());
                fileName.append(suffix);
                File saveFile = new File(dir+"/"+fileName);
                file.transferTo(saveFile);
            }
        }catch (Exception e){
            e.printStackTrace();
            return "上传失败";
        }
        return "上传成功";
    }
}
