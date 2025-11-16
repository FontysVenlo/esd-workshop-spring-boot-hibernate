package com.ESD.steamed.user;

import com.ESD.steamed.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserDTO save(UserCreateDTO userCreateDTO) {
        return userMapper.toDto(userRepository.save(userMapper.toEntity(userCreateDTO)));
    }

    public UserDTO getById(Long id) {
        return userMapper.toDto(
                userRepository.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("User not found."))
        );
    }

}
