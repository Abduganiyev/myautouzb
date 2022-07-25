package uz.digitalone.appgmuzbekistan.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GMDto {

    private String name;

    private Long addressId;

    private Long directorId;

    private Long parentId;      // parent - Filialning Asosiy Companyasi
}
