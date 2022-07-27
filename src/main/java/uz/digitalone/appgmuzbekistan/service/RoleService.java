package uz.digitalone.appgmuzbekistan.service;

import org.springframework.stereotype.Service;
import uz.digitalone.appgmuzbekistan.dto.RoleDto;
import uz.digitalone.appgmuzbekistan.entity.Role;

import java.util.List;
import java.util.Set;

@Service
public interface RoleService {
    List<Role> saveAll(Set<RoleDto> roles);

    List<Role> findAll();

    Role updateRole(Long roleId, RoleDto role);

    String deleteRole(Long id);
}
