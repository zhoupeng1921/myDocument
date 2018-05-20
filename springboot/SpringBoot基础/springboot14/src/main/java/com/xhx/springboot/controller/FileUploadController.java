package com.xhx.springboot.controller;


import com.xhx.springboot.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(value = "file")
public class FileUploadController {

    @Autowired
    private FileService fileService;

    @RequestMapping(value = "upload")
    public String upload(@RequestParam("file")MultipartFile file){
            fileService.upload(file);
            return "success";
    }

    @RequestMapping(value = "download")
    public ResponseEntity<Resource> dowload(){
        Resource file = fileService.download();
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""+file.getFilename()+"\"")
                .body(file);
    }
}