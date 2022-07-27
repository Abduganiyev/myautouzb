package uz.digitalone.appgmuzbekistan.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import uz.digitalone.appgmuzbekistan.rest.response.UploadFileResponse;
import uz.digitalone.appgmuzbekistan.service.FileStorageService;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.MalformedURLException;

@RestController
@RequestMapping("/api/v1/attachments")
@RequiredArgsConstructor
public class AttachmentController {
    private final FileStorageService fileStorageService;

    @PostMapping("/upload_file")
    private UploadFileResponse uploadFile(@RequestParam("file") MultipartFile multipartFile) throws IOException {
        String uploadFile = fileStorageService.uploadFile(multipartFile);

        String downloadUrl = ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/v1/attachments/download_file/").path(uploadFile).toUriString();
        return new UploadFileResponse(uploadFile, downloadUrl, multipartFile.getContentType(), multipartFile.getSize());

    }

    @GetMapping("/download_file/{fileName:.+}")
    private ResponseEntity<Resource> downloadByFileName(@PathVariable String fileName, HttpServletRequest request) throws IOException, ClassNotFoundException {
        Resource resource = fileStorageService.downloadFile(fileName);

        String type = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(type))
                .body(resource);
    }
}
