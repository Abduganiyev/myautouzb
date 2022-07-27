package uz.digitalone.appgmuzbekistan.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.digitalone.appgmuzbekistan.dto.DistrictDto;
import uz.digitalone.appgmuzbekistan.entity.District;
import uz.digitalone.appgmuzbekistan.entity.Region;
import uz.digitalone.appgmuzbekistan.repository.DistrictRepository;
import uz.digitalone.appgmuzbekistan.service.DistrictService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DistrictServiceImp implements DistrictService {
    private final DistrictRepository districtRepository;
    @Override
    public List<District> findAll() {
        return districtRepository.findAll();
    }

    @Override
    public List<District> saveAll(List<DistrictDto> districts) {
/*        List<District> districtList = new ArrayList<>();
        for (DistrictDto district : districts) {
            districtList.add(new District(district.getName(),district.getArea(),
                    district.getPopulation(),)
        }
        return districtRepository.saveAll(districts);*/
        return null;
    }

    @Override
    public String deleteRegion(Long id) {
        if (districtRepository.existsById(id)) {
            districtRepository.deleteById(id);
            return "Successfully deleted";
        }
        throw new RuntimeException("District Not Found");
    }

    @Override
    public District updateDistrict(Long districtId, DistrictDto dto) {
        if (!districtRepository.existsById(districtId))
            throw new RuntimeException("Region Not Found");

        Optional<District> updateDistrict = districtRepository.findById(districtId);
        District district = updateDistrict.get();
        district.setArea(dto.getArea());
        district.setName(dto.getName());
        district.setPopulation(dto.getPopulation());

        return district;
    }
}
