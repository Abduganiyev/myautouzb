package uz.digitalone.appgmuzbekistan.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import uz.digitalone.appgmuzbekistan.entity.Attachment;
import uz.digitalone.appgmuzbekistan.rest.response.UploadFileResponse;
import uz.digitalone.appgmuzbekistan.service.FileStorageService;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/attachments")
@RequiredArgsConstructor
public class AttachmentController {
    private final FileStorageService fileStorageService;

    @PostMapping(value = "/database/upload_file", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    private UploadFileResponse uploadFileToDB(@RequestParam("file") MultipartFile multipartFile) throws IOException {
        Attachment uploadFile = fileStorageService.uploadFileToDB(multipartFile);

        String downloadUrl = ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/v1/attachments/database/download_file/").path(uploadFile.getId().toString()).toUriString();
        return new UploadFileResponse(uploadFile.getOriginalName(), downloadUrl, multipartFile.getContentType(), multipartFile.getSize());
    }

    @PostMapping(value = "/database/upload_files", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    private List<UploadFileResponse> uploadFilesToDB(@RequestParam("files") List<MultipartFile> multipartFiles) throws IOException {
/*        List<Attachment> uploadFiles = fileStorageService.uploadFilesToDB(multipartFiles);

        List<UploadFileResponse> responseList = new ArrayList<>();
        for (Attachment uploadFile : uploadFiles) {
            String downloadUrl = ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/v1/attachments/database/download_file/").path(uploadFile.getId().toString()).toUriString();
            UploadFileResponse response = new UploadFileResponse(uploadFile.getOriginalName(), downloadUrl, uploadFile.getContentType(), uploadFile.getSize());
            responseList.add(response);
        }
        return responseList;*/

        List<UploadFileResponse> uploadFileResponseList = new ArrayList<>();
        for (MultipartFile multipartFile : multipartFiles) {
            uploadFileResponseList.add(uploadFileToDB(multipartFile));
        }
        return uploadFileResponseList;
    }
    @GetMapping("/database/download_file/{id}")
    private ResponseEntity<Resource> downloadFileFromDB(@PathVariable("id") Long fileId, HttpServletRequest request) throws IOException {
        Attachment attachment = fileStorageService.downloadFileById(fileId);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(attachment.getContentType()))
                .body(new ByteArrayResource(attachment.getData()));
    }


    // Upload To File System
    @PostMapping(value = "/file_system/upload_file", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    private UploadFileResponse uploadFile(@RequestParam("file") MultipartFile multipartFile) throws IOException {
        String uploadFile = fileStorageService.uploadFile(multipartFile);

        String downloadUrl = ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/v1/attachments/file_system/download_file/").path(uploadFile).toUriString();
        return new UploadFileResponse(uploadFile, downloadUrl, multipartFile.getContentType(), multipartFile.getSize());

    }

    @GetMapping("/file_system/download_file/{fileName:.+}")
    private ResponseEntity<Resource> downloadByFileName(@PathVariable String fileName, HttpServletRequest request) throws IOException, ClassNotFoundException {
        Resource resource = fileStorageService.downloadFile(fileName);

        String type = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(type))
                .body(resource);
    }
}
