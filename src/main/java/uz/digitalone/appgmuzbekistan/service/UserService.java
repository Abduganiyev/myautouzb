package uz.digitalone.appgmuzbekistan.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.digitalone.appgmuzbekistan.dto.UserDto;
import uz.digitalone.appgmuzbekistan.entity.User;

import java.util.List;

@Service
public interface UserService {
    List<User> saveAll(List<UserDto> dto);
}
