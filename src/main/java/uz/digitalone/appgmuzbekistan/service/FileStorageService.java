package uz.digitalone.appgmuzbekistan.service;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;

@Service
public interface FileStorageService {
    String uploadFile(MultipartFile multipartFile) throws IOException;

    Resource downloadFile(String fileName) throws MalformedURLException, ClassNotFoundException;
}
