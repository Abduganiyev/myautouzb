package uz.digitalone.appgmuzbekistan.controller;

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
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    private List<User> findAll() {
        return null;
    }

    @PostMapping
    private User saveAll(@RequestBody List<UserDto> dto) {
        return null;
    }

    @PutMapping("/{id}")
    private User updateRole(@PathVariable("id") Long roleId,@RequestBody UserDto dto) {
        return null;
    }

    @DeleteMapping("/{id}")
    private User deleteRole(@PathVariable Long id) {
        return null;
    }
}
