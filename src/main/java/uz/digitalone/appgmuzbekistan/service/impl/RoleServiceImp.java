package uz.digitalone.appgmuzbekistan.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.digitalone.appgmuzbekistan.dto.RoleDto;
import uz.digitalone.appgmuzbekistan.entity.Role;
import uz.digitalone.appgmuzbekistan.repository.RoleRepository;
import uz.digitalone.appgmuzbekistan.service.RoleService;

import javax.xml.ws.http.HTTPException;
import java.sql.Array;
import java.sql.SQLException;
import java.util.*;

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

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public Role updateRole(Long roleId, RoleDto role) {
        if (!roleRepository.existsById(roleId))
            throw new RuntimeException("Role Not Found By Id {"+ roleId +"}");

        Optional<Role> byId = roleRepository.findById(roleId);
        Role updatedRole = byId.get();
        updatedRole.setName(role.getName());
        updatedRole.setDescription(role.getDescription());

        return roleRepository.save(updatedRole);
    }

    @Override
    public String deleteRole(Long id) {
        if (roleRepository.existsById(id)) {
            try {
                roleRepository.deleteById(id);
            } catch (Exception e) {
                return "Bu Role Userga Bog'langan";
            }
            return "Successfully deleted";
        }
        throw new RuntimeException("Role Not Found");
    }
}
