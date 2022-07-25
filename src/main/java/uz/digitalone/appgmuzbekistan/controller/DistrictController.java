package uz.digitalone.appgmuzbekistan.controller;

import org.springframework.web.bind.annotation.*;
import uz.digitalone.appgmuzbekistan.dto.DistrictDto;
import uz.digitalone.appgmuzbekistan.entity.District;
import uz.digitalone.appgmuzbekistan.entity.Region;
import uz.digitalone.appgmuzbekistan.service.DistrictService;

import java.util.List;

/**
 * Author: khamza@nightwell-logistics.com
 * Date: 2/1/2022
 * Time: 7:29 PM
 */

@RestController
@RequestMapping("/api/v1/districts")
public class DistrictController {
    private final DistrictService districtService;

    public DistrictController(DistrictService districtService) {
        this.districtService = districtService;
    }

    @GetMapping
    private List<District> findAll() {
        return null;
    }

    @PostMapping
    private District saveAll(@RequestBody List<DistrictDto> dto) {
        return null;
    }

    @PutMapping("/{id}")
    private District updateRole(@PathVariable("id") Long districtId,@RequestBody District dto) {
        return null;
    }

    @DeleteMapping("/{id}")
    private Region deleteDistrict(@PathVariable Long id) {
        return null;
    }

}
