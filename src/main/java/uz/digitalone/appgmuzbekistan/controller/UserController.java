package uz.digitalone.appgmuzbekistan.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.digitalone.appgmuzbekistan.dto.UserDto;
import uz.digitalone.appgmuzbekistan.entity.User;
import uz.digitalone.appgmuzbekistan.service.UserService;

import java.util.List;

/**
 * Author: khamza@nightwell-logistics.com
 * Date: 2/1/2022
 * Time: 7:29 PM
 */

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @GetMapping
    private List<User> findAll() {
        return userService.findAll();
    }

    @PostMapping
    private List<User> saveAll(@RequestBody List<UserDto> dto) {
        return userService.saveAll(dto);
    }

    @PutMapping("/{id}")
    private User updateUser(@PathVariable("id") Long userId,@RequestBody UserDto dto) {
        return userService.updateUser(userId, dto);
    }

    @DeleteMapping("/{id}")
    private String deleteRole(@PathVariable Long id) {
        return userService.deleteRole(id);
    }
}
