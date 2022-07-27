package uz.digitalone.appgmuzbekistan.service;

import org.springframework.stereotype.Service;
import uz.digitalone.appgmuzbekistan.dto.CompanyDto;
import uz.digitalone.appgmuzbekistan.entity.GM;

import java.util.List;

@Service
public interface CompanyService {
    List<GM> findAll();

    List<GM> saveAll(List<CompanyDto> dto);

    GM updateCompany(Long gmId, CompanyDto dto);

    String delete(Long id);
}
