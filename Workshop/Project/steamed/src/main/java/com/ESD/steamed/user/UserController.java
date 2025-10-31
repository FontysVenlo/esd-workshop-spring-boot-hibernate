package com.ESD.steamed.user;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("User")
public class UserController {
    private UserService userService;
    @PostMapping
    public ResponseEntity<UserDTO> save(@RequestBody UserCreateDTO userCreateDTO){
        return userService.save(userCreateDTO);
    }
}
