package uz.digitalone.appgmuzbekistan.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.digitalone.appgmuzbekistan.entity.template.AbsEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Attachment extends AbsEntity {
    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String originalName;

    private byte[] data;

    private long size;

    @Column(nullable = false)
    private String contentType;


}
