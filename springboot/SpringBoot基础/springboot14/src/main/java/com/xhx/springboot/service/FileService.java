package com.xhx.springboot.service;

import com.xhx.springboot.config.FileConfig;
import com.xhx.springboot.exception.StorageException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * xuhaixing
 * 2018/5/19 11:08
 */
@Service
public class FileService {

    @Autowired
    private FileConfig fileConfig;

    private final Path rootLocation;

    @Autowired
    public FileService(FileConfig fileConfig){
        this.rootLocation= Paths.get(fileConfig.getUploadLocation());
    }

    public void upload(MultipartFile file){
        try {
            if(file.isEmpty()){
                throw new StorageException("空文件"+file.getOriginalFilename());
            }
            System.out.println("文件："+file.getOriginalFilename());
            Files.copy(file.getInputStream(),rootLocation.resolve(file.getOriginalFilename()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Resource download(){
        try {
            Path path = rootLocation.resolve("pom.xml");
            UrlResource urlResource = new UrlResource(path.toUri());
            if(urlResource.exists()&&urlResource.isReadable()){
                return urlResource;
            }else {
                throw  new StorageException("不能读取文件");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
