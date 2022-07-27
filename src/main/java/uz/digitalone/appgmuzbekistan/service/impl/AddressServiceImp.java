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

    @Override
    public Address updateAddress(Long addressId, AddressDto dto) {
        if (!addressRepository.existsById(addressId))
            throw new RuntimeException("Address Not Found");

        if (!districtRepository.existsById(dto.getDistrictId()))
            throw new RuntimeException("District Not Found");

        Optional<District> district = districtRepository.findById(dto.getDistrictId());
        Optional<Address> updateAddress = addressRepository.findById(addressId);
        Address address = updateAddress.get();
        address.setDistrict(district.get());
        address.setHome(dto.getHome());
        address.setStreet(dto.getStreet());

        return address;
    }

    @Override
    public String deleteAddress(Long id) {
        if (addressRepository.existsById(id)) {
            addressRepository.deleteById(id);
            return "Successfully deleted";
        }
        throw new RuntimeException("District Not Found");
    }

}
