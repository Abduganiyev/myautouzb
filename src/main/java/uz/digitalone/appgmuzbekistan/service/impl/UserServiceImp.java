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

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(Long userId, UserDto dto) {
        Set<Role> roleSet = new HashSet<>();
        for (Long roleId : dto.getRoles()) {
            Optional<Role> byId = roleRepository.findById(roleId);
            byId.ifPresent(roleSet::add);
        }
        if (!userRepository.existsById(userId))
            throw new RuntimeException("User Not Found");

        if (!addressRepository.existsById(dto.getAddressId()))
            throw new RuntimeException("Address Not Found");

        Optional<User> updateUser = userRepository.findById(userId);
        Optional<Address> address = addressRepository.findById(dto.getAddressId());
        User user = updateUser.get();
        user.setAddress(address.get());
        user.setFullName(dto.getFullName());
        user.setRoles(roleSet);

        return userRepository.save(user);
    }

    @Override
    public String deleteRole(Long id) {
        if (userRepository.existsById(id)) {
                userRepository.deleteById(id);
                return "Successfully deleted";
        }
        throw new RuntimeException("Role Not Found");
    }
}
