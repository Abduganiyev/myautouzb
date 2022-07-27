package uz.digitalone.appgmuzbekistan.service;

import org.springframework.stereotype.Service;
import uz.digitalone.appgmuzbekistan.dto.RegionDto;
import uz.digitalone.appgmuzbekistan.entity.Region;

import java.util.List;

@Service
public interface RegionService {
    List<Region> findAll();

    List<Region> saveAll(List<RegionDto> dto);
}
