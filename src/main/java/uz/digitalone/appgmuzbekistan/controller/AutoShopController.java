package uz.digitalone.appgmuzbekistan.controller;

import org.springframework.web.bind.annotation.*;
import uz.digitalone.appgmuzbekistan.dto.AutoShopDto;
import uz.digitalone.appgmuzbekistan.dto.RoleDto;
import uz.digitalone.appgmuzbekistan.entity.AutoShop;
import uz.digitalone.appgmuzbekistan.entity.Role;
import uz.digitalone.appgmuzbekistan.service.AutoShopService;

import java.util.List;

/**
 * Author: khamza@nightwell-logistics.com
 * Date: 2/1/2022
 * Time: 7:31 PM
 */

@RestController
@RequestMapping("/api/v1/auto_shops")
public class AutoShopController {
    private final AutoShopService autoShopService;
    public AutoShopController(AutoShopService autoShopService) {
        this.autoShopService = autoShopService;
    }

    @GetMapping("/{company_id}/list")
    private List<AutoShop> findAllByCompanyId(@PathVariable(value = "company_id") Long companyId,
                                              @RequestParam(value = "company_name") String name) {
        //return autoShopService.selectAllByCompanyIdNative(companyId);
        //return autoShopService.selectAllByCompanyId(companyId,name);
        return autoShopService.findAutoShopsByCompany_IdAndCompany_Name(companyId, name);
    }

    @GetMapping
    private List<AutoShop> findAll() {
        return null;
    }

    @PostMapping
    private AutoShop saveAll(@RequestBody List<AutoShopDto> dto) {
        return null;
    }

    @PutMapping("/{id}")
    private AutoShop updateRole(@PathVariable("id") Long autoShopId,@RequestBody AutoShopDto dto) {
        return null;
    }

    @DeleteMapping("/{id}")
    private AutoShop deleteRole(@PathVariable String id) {
        return new AutoShop();
    }
}
