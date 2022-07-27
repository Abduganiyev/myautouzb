package uz.digitalone.appgmuzbekistan.rest.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UploadFileResponse {
    private String fileName;
    private String downloadUrl;
    private String type;
    private Long size;
}
