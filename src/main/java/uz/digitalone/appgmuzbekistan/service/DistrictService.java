package uz.digitalone.appgmuzbekistan.service;

import org.springframework.stereotype.Service;
import uz.digitalone.appgmuzbekistan.dto.DistrictDto;
import uz.digitalone.appgmuzbekistan.entity.District;

import java.util.List;

@Service
public interface DistrictService {
    List<District> findAll();

    List<District> saveAll(List<DistrictDto> districts);


    String deleteRegion(Long id);

    District updateDistrict(Long districtId, DistrictDto dto);
}
