package uz.digitalone.appgmuzbekistan.controller;

import org.springframework.web.bind.annotation.*;
import uz.digitalone.appgmuzbekistan.dto.GMDto;
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
public class CompanyController {
    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    private List<GM> findAll() {
        return null;
    }

    @PostMapping
    private GM saveAll(@RequestBody List<GMDto> dto) {
        return null;
    }

    @PutMapping("/{id}")
    private GM updateGM(@PathVariable("id") Long GMId,@RequestBody GM dto) {
        return null;
    }

    @DeleteMapping("/{id}")
    private GM deleteGM(@PathVariable Long id) {
        return null;
    }
}
