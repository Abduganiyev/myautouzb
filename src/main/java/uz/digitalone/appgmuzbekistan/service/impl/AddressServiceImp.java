package uz.digitalone.appgmuzbekistan.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.digitalone.appgmuzbekistan.dto.AddressDto;
import uz.digitalone.appgmuzbekistan.entity.Address;
import uz.digitalone.appgmuzbekistan.entity.District;
import uz.digitalone.appgmuzbekistan.repository.AddressRepository;
import uz.digitalone.appgmuzbekistan.repository.DistrictRepository;
import uz.digitalone.appgmuzbekistan.service.AddressService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AddressServiceImp implements AddressService {
    private final AddressRepository addressRepository;
    private final DistrictRepository districtRepository;
    @Override
    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    @Override
    public List<Address> saveAll(List<AddressDto> dto) {
        List<Address> addressList = new ArrayList<>();
        for (AddressDto address : dto) {
            if (!addressRepository.existsByStreetAndHome(address.getStreet(), address.getHome())) {
                Optional<District> byId = districtRepository.findById(address.getDistrictId());
                byId.ifPresent(district -> addressList.add(new Address(address.getHome(), address.getStreet(), district)));
            }
        }
        return addressRepository.saveAll(addressList);
    }
}
