package uz.digitalone.appgmuzbekistan.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import uz.digitalone.appgmuzbekistan.rest.response.UploadFileResponse;
import uz.digitalone.appgmuzbekistan.service.FileStorageService;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/attachments")
@RequiredArgsConstructor
public class AttachmentController {
    private final FileStorageService fileStorageService;

    @PostMapping("/upload_file")
    private UploadFileResponse uploadFile(@RequestParam("file") MultipartFile multipartFile) throws IOException {
        String uploadFile = fileStorageService.uploadFile(multipartFile);

        String downloadUrl = ServletUriComponentsBuilder.fromCurrentContextPath().path("/download_file").path(uploadFile).toUriString();
        return new UploadFileResponse(uploadFile, downloadUrl, multipartFile.getContentType(), multipartFile.getSize());
    }
}
