package uz.digitalone.appgmuzbekistan.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.digitalone.appgmuzbekistan.dto.AddressDto;
import uz.digitalone.appgmuzbekistan.entity.Address;
import uz.digitalone.appgmuzbekistan.service.AddressService;

import java.util.List;

/**
 * Author: khamza@nightwell-logistics.com
 * Date: 2/1/2022
 * Time: 7:29 PM
 */

@RestController
@RequestMapping("/api/v1/addresses")
@RequiredArgsConstructor
public class AddressController {
    private final AddressService addressService;
    @GetMapping
    private List<Address> findAll() {
        return addressService.findAll();
    }

    @PostMapping
    private List<Address> saveAll(@RequestBody List<AddressDto> dto) {
        return addressService.saveAll(dto);
    }

    @PutMapping("/{id}")
    private Address updateRole(@PathVariable("id") Long addressId, @RequestBody AddressDto dto) {
        return addressService.updateAddress(addressId, dto);
    }

    @DeleteMapping("/{id}")
    private String  deleteDistrict(@PathVariable Long id) {
        return addressService.deleteAddress(id);
    }

}
