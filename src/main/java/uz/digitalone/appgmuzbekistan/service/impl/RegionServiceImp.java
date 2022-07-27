package uz.digitalone.appgmuzbekistan.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.digitalone.appgmuzbekistan.dto.RegionDto;
import uz.digitalone.appgmuzbekistan.entity.Region;
import uz.digitalone.appgmuzbekistan.repository.RegionRepository;
import uz.digitalone.appgmuzbekistan.service.RegionService;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RegionServiceImp implements RegionService {
    private final RegionRepository regionRepository;
    @Override
    public List<Region> findAll() {
        return regionRepository.findAll();
    }

    @Override
    public List<Region> saveAll(List<RegionDto> dto) {
        List<Region> regionList = new ArrayList<>();
        for (RegionDto regionDto : dto) {
            regionList.add(new Region(regionDto.getName(), regionDto.getArea(), regionDto.getPopulation()));
        }
        return regionRepository.saveAll(regionList);
    }
}
