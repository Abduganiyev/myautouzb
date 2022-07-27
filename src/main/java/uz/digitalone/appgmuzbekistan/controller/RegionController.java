package uz.digitalone.appgmuzbekistan.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.digitalone.appgmuzbekistan.dto.RegionDto;
import uz.digitalone.appgmuzbekistan.entity.Region;
import uz.digitalone.appgmuzbekistan.service.RegionService;

import java.util.List;

/**
 * Author: khamza@nightwell-logistics.com
 * Date: 2/1/2022
 * Time: 7:29 PM
 */

@RestController
@RequestMapping("/api/v1/regions")
@RequiredArgsConstructor
public class RegionController {

    private final RegionService regionService;

    @GetMapping
    private List<Region> findAll() {
        return regionService.findAll();
    }

    @PostMapping
    private List<Region> saveAll(@RequestBody List<RegionDto> dto) {
        return regionService.saveAll(dto);
    }

    @PutMapping("/{id}")
    private Region updateRegion(@PathVariable("id") Long regionId,@RequestBody Region dto) {
        return null;
    }

    @DeleteMapping("/{id}")
    private Region deleteRegion(@PathVariable Long id) {
        return null;
    }

}
