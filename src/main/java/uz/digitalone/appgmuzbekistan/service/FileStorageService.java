package uz.digitalone.appgmuzbekistan.service;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import uz.digitalone.appgmuzbekistan.entity.Attachment;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

@Service
public interface FileStorageService {
    String uploadFile(MultipartFile multipartFile) throws IOException;

    Resource downloadFile(String fileName) throws MalformedURLException, ClassNotFoundException;

    /**
     * Upload File To DB
     * @param multipartFile - Input file
     * @return Entity
     */
    Attachment uploadFileToDB(MultipartFile multipartFile) throws IOException;

    Attachment downloadFileById(Long fileId) throws FileNotFoundException;

    List<Attachment> uploadFilesToDB(List<MultipartFile> multipartFiles) throws IOException;
}
