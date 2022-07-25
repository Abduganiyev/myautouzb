package uz.digitalone.appgmuzbekistan.controller;

import org.springframework.web.bind.annotation.*;
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
public class RegionController {

    private final RegionService regionService;
    public RegionController(RegionService regionService) {
        this.regionService = regionService;
    }

    @GetMapping
    private List<Region> findAll() {
        return null;
    }

    @PostMapping
    private Region saveAll(@RequestBody List<Region> dto) {
        return null;
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
