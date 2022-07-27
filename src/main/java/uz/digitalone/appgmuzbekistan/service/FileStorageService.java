package uz.digitalone.appgmuzbekistan.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public interface FileStorageService {
    String uploadFile(MultipartFile multipartFile) throws IOException;
}
