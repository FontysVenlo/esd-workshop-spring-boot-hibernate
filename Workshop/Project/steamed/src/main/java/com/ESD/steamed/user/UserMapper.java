package com.ESD.steamed.user;

public class UserMapper {

    public UserDTO toDto(User user){
        return new UserDTO(user.getId(), user.getUsername(), user.getEmail());
    }

    //TODO: Think about actually hashing the password?
    public User toEntity(UserCreateDTO userCreateDTO){
        return new User(userCreateDTO.getUsername(), userCreateDTO.getEmail(), userCreateDTO.getPassword());
    }

}
