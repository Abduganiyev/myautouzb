package uz.digitalone.appgmuzbekistan.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.digitalone.appgmuzbekistan.dto.CompanyDto;
import uz.digitalone.appgmuzbekistan.entity.GM;
import uz.digitalone.appgmuzbekistan.service.CompanyService;

import java.util.List;

/**
 * Author: khamza@nightwell-logistics.com
 * Date: 2/1/2022
 * Time: 7:31 PM
 */

@RestController
@RequestMapping("/api/v1/companies")
@RequiredArgsConstructor
public class CompanyController {
    private final CompanyService companyService;
    @GetMapping
    private List<GM> findAll() {
        return companyService.findAll();
    }

    @PostMapping
    private List<GM> saveAll(@RequestBody List<CompanyDto> dto) {
        return companyService.saveAll(dto);
    }

    @PutMapping("/{id}")
    private GM updateGM(@PathVariable("id") Long GMId,@RequestBody CompanyDto dto) {
        return companyService.updateCompany(GMId,dto);
    }

    @DeleteMapping("/{id}")
    private String deleteGM(@PathVariable Long id) {
        return companyService.delete(id);
    }
}
