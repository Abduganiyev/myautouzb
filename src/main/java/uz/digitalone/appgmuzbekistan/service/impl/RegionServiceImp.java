package uz.digitalone.appgmuzbekistan.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.digitalone.appgmuzbekistan.dto.RegionDto;
import uz.digitalone.appgmuzbekistan.entity.Region;
import uz.digitalone.appgmuzbekistan.repository.RegionRepository;
import uz.digitalone.appgmuzbekistan.service.RegionService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @Override
    public Region updateRegion(Long regionId, RegionDto dto) {
        if (!regionRepository.existsById(regionId))
            throw new RuntimeException("Region Not Found");

        Optional<Region> updateRegion = regionRepository.findById(regionId);
        Region region = updateRegion.get();
        region.setArea(dto.getArea());
        region.setName(dto.getName());
        region.setPopulation(dto.getPopulation());

        return region;
    }

    @Override
    public String deleteRegion(Long id) {
        if (regionRepository.existsById(id)) {
            regionRepository.deleteById(id);
            return "Successfully deleted";
        }
        throw new RuntimeException("Region Not Found");
    }
}
