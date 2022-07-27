package uz.digitalone.appgmuzbekistan.service;

import org.springframework.stereotype.Service;
import uz.digitalone.appgmuzbekistan.dto.AddressDto;
import uz.digitalone.appgmuzbekistan.entity.Address;

import java.util.List;

@Service
public interface AddressService {
    List<Address> findAll();

    List<Address> saveAll(List<AddressDto> dto);

    Address updateAddress(Long addressId, AddressDto dto);

    String deleteAddress(Long id);
}
