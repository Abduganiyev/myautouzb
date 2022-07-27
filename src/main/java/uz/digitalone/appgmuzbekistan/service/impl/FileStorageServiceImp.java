package uz.digitalone.appgmuzbekistan.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import uz.digitalone.appgmuzbekistan.exception.FileStorageException;
import uz.digitalone.appgmuzbekistan.properties.StorageProperties;
import uz.digitalone.appgmuzbekistan.service.FileStorageService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileStorageServiceImp implements FileStorageService {
    private final Path fileLocation;

    public FileStorageServiceImp(StorageProperties storageProperties) throws IOException {
        this.fileLocation = Paths.get(storageProperties.getUploadFile()).toAbsolutePath().normalize();

        Files.createDirectories(this.fileLocation);
    }

    @Override
    public String uploadFile(MultipartFile multipartFile) throws IOException {
        String filename = multipartFile.getOriginalFilename();
        if (filename.contains(".."))
            throw new FileStorageException("Uzur"+filename);

        // my_icon.jpeg
        Path path = this.fileLocation.resolve(filename);

        // File sistemaga Nusxalandi
        Files.copy(multipartFile.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

        return filename;
    }
}
