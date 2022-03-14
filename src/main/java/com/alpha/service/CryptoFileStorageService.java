package com.alpha.service;

import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;

import com.alpha.model.FileStorageException;
import com.alpha.model.MyFileNotFoundException;

@Service
public class CryptoFileStorageService {
	@Value("${file.crypto-image-dir}")
    private String cryptoImageDir;
    
    @Autowired
    public CryptoFileStorageService(Environment environment) {

        try {
            Files.createDirectories(Paths.get(environment.getProperty("file.crypto-image-dir")));
        } catch (Exception ex) {
            throw new FileStorageException("Could not create the directory where the uploaded files will be stored.", ex);
        }
    }


    public Resource loadFileAsResource(String fileName,String dirpath) {
        try {
            Path filePath = Paths.get(dirpath).resolve(fileName).normalize();
            Resource resource = new UrlResource(filePath.toUri());
            if(resource.exists()) {
                return resource;
            } else {
            	filePath = Paths.get(dirpath).resolve("0-0.png").normalize();
                resource = new UrlResource(filePath.toUri());
                return resource;
                //throw new MyFileNotFoundException("File not found " + fileName);
            }
        } catch (MalformedURLException ex) {
            throw new MyFileNotFoundException("File not found " + fileName, ex);
        }
    }
    
    public Resource loadTeamImageAsResource(String fileName,String dirpath) {
        try {
            Path filePath = Paths.get(dirpath).resolve(fileName).normalize();
            Resource resource = new UrlResource(filePath.toUri());
            if(resource.exists()) {
                return resource;
            } else {
            	filePath = Paths.get(dirpath).resolve("0-.png").normalize();
                resource = new UrlResource(filePath.toUri());
                return resource;
                //throw new MyFileNotFoundException("File not found " + fileName);
            }
        } catch (MalformedURLException ex) {
            throw new MyFileNotFoundException("File not found " + fileName, ex);
        }
    }
    
}
