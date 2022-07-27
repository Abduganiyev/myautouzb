package uz.digitalone.appgmuzbekistan.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.digitalone.appgmuzbekistan.dto.UserDto;
import uz.digitalone.appgmuzbekistan.entity.Address;
import uz.digitalone.appgmuzbekistan.entity.Role;
import uz.digitalone.appgmuzbekistan.entity.User;
import uz.digitalone.appgmuzbekistan.repository.AddressRepository;
import uz.digitalone.appgmuzbekistan.repository.RoleRepository;
import uz.digitalone.appgmuzbekistan.repository.UserRepository;
import uz.digitalone.appgmuzbekistan.service.UserService;

import java.util.*;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final AddressRepository addressRepository;
    @Override
    public List<User> saveAll(List<UserDto> dto) {
        List<User> users = new ArrayList<>();
        for (UserDto userDto : dto) {
            Set<Role> roleSet = new HashSet<>();
            if (!userRepository.existsByEmail(userDto.getEmail())) {
                // CHECK ROLES
                for (Long roleId : userDto.getRoles()) {
                    Optional<Role> byId = roleRepository.findById(roleId);
                    byId.ifPresent(roleSet::add);
                }
                // CHECK ADDRESS
                Optional<Address> byId = addressRepository.findById(userDto.getAddressId());
                if (byId.isPresent()) {
                    User user = new User(userDto.getFullName(), userDto.getEmail(),byId.get() , roleSet);
                    users.add(user);
                }

            }
        }
        return userRepository.saveAll(users);
    }
}
