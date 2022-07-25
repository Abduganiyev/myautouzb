package uz.digitalone.appgmuzbekistan.controller;

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
public class AddressController {
    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping
    private List<Address> findAll() {
        return null;
    }

    @PostMapping
    private Address saveAll(@RequestBody List<Address> dto) {
        return null;
    }

    @PutMapping("/{id}")
    private Address updateRegion(@PathVariable("id") Long regionId,@RequestBody AddressDto dto) {
        return null;
    }

    @DeleteMapping("/{id}")
    private Address deleteAddress(@PathVariable Long id) {
        return null;
    }

}
