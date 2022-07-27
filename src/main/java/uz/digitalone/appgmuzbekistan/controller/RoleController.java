package uz.digitalone.appgmuzbekistan.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.digitalone.appgmuzbekistan.dto.RoleDto;
import uz.digitalone.appgmuzbekistan.entity.Role;
import uz.digitalone.appgmuzbekistan.service.RoleService;

import java.util.List;
import java.util.Set;

/**
 * Author: khamza@nightwell-logistics.com
 * Date: 2/1/2022
 * Time: 7:32 PM
 */

@RestController
@RequestMapping("/api/v1/roles")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;

    @GetMapping
    private List<Role> findAll() {
        return null;
    }

    @PostMapping
    private List<Role> saveAll(@RequestBody Set<RoleDto> roles) {
        return roleService.saveAll(roles);
    }

    @PutMapping("/{id}")
    private Role updateRole(@PathVariable("id") Long roleId,@RequestBody RoleDto role) {
        return null;
    }

    @DeleteMapping("/{id}")
    private Role deleteRole(@PathVariable String id) {
        return null;
    }
}
