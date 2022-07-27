package uz.digitalone.appgmuzbekistan.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.digitalone.appgmuzbekistan.dto.RoleDto;
import uz.digitalone.appgmuzbekistan.entity.Role;
import uz.digitalone.appgmuzbekistan.repository.RoleRepository;
import uz.digitalone.appgmuzbekistan.service.RoleService;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class RoleServiceImp implements RoleService {

    private final RoleRepository roleRepository;
    @Override
    public List<Role> saveAll(Set<RoleDto> roles) {
        List<Role> roleSet = new ArrayList<>();
        for (RoleDto role : roles) {
            if (!roleRepository.existsByName(role.getName())) {
                roleSet.add(new Role(role.getName(), role.getDescription()));
            }
        }
        return roleRepository.saveAll(roleSet);
    }
}
