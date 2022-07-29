package uz.digitalone.appgmuzbekistan.service.impl;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import uz.digitalone.appgmuzbekistan.entity.Attachment;
import uz.digitalone.appgmuzbekistan.exception.FileStorageException;
import uz.digitalone.appgmuzbekistan.properties.StorageProperties;
import uz.digitalone.appgmuzbekistan.repository.AttachmentRepository;
import uz.digitalone.appgmuzbekistan.service.FileStorageService;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FileStorageServiceImp implements FileStorageService {
    private final Path fileLocation;
    private final AttachmentRepository attachmentRepository;

    public FileStorageServiceImp(StorageProperties storageProperties, AttachmentRepository attachmentRepository) throws IOException {
        this.fileLocation = Paths.get(storageProperties.getUploadFile()).toAbsolutePath().normalize();
        this.attachmentRepository = attachmentRepository;

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

    @Override
    public Resource downloadFile(String fileName) throws MalformedURLException, ClassNotFoundException {
        Path path = this.fileLocation.resolve(fileName);
        Resource resource = new UrlResource(path.toUri());
        if (resource.exists())
            return resource;

        throw new ClassNotFoundException("File Not Found");
    }

    @Override
    public Attachment uploadFileToDB(MultipartFile multipartFile) throws IOException {
        String originalFilename = multipartFile.getOriginalFilename();
        if (originalFilename.contains(".."))
            throw new FileStorageException("Uzur"+originalFilename);

        String uniqueFilename = System.currentTimeMillis() + "_" + originalFilename;

        Attachment attachment = new Attachment(
                uniqueFilename,
                originalFilename,
                multipartFile.getBytes(),
                multipartFile.getSize(),
                multipartFile.getContentType()
        );

        Attachment savedAttachment = attachmentRepository.save(attachment);

        return savedAttachment;
    }

    @Override
    public Attachment downloadFileById(Long fileId) {
        Optional<Attachment> optionalAttachment = attachmentRepository.findById(fileId);
        if (optionalAttachment.isEmpty())
            throw new uz.digitalone.appgmuzbekistan.exception.FileNotFoundException("File Not Found");

        Attachment attachment = optionalAttachment.get();

        return attachment;
    }

    @Override
    public List<Attachment> uploadFilesToDB(List<MultipartFile> multipartFiles) throws IOException {
        List<Attachment> attachmentList = new ArrayList<>();
        for (MultipartFile multipartFile : multipartFiles) {
            attachmentList.add(uploadFileToDB(multipartFile));
        }
        return attachmentList;
    }
}
