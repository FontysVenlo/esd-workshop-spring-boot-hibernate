package com.ESD.steamed.user;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;
    private UserMapper userMapper;

    public ResponseEntity<UserDTO> save(UserCreateDTO userCreateDTO){
        return ResponseEntity.ok(userMapper.toDto(userRepository.save(userMapper.toEntity(userCreateDTO))));
    }

}
