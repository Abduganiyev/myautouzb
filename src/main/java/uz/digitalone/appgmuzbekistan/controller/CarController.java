package uz.digitalone.appgmuzbekistan.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.digitalone.appgmuzbekistan.dto.CarDto;
import uz.digitalone.appgmuzbekistan.dto.GMDto;
import uz.digitalone.appgmuzbekistan.entity.Car;
import uz.digitalone.appgmuzbekistan.entity.GM;
import uz.digitalone.appgmuzbekistan.service.CompanyService;

import java.util.List;

/**
 * Author: khamza@nightwell-logistics.com
 * Date: 2/1/2022
 * Time: 7:29 PM
 */

@RestController
@RequestMapping("/api/v1/cars")
@RequiredArgsConstructor
public class CarController {

    @GetMapping
    private List<Car> findAll() {
        return null;
    }

    @PostMapping
    private Car saveAll(@RequestBody List<CarDto> dto) {
        return null;
    }

    @PutMapping("/{id}")
    private CarDto updateGM(@PathVariable("id") Long carId,@RequestBody CarDto dto) {
        return null;
    }

    @DeleteMapping("/{id}")
    private Car deleteGM(@PathVariable Long id) {
        return null;
    }

}
