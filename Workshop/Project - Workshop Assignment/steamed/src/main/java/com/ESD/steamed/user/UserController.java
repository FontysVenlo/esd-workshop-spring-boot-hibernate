package com.ESD.steamed.user;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserDTO> save(@RequestBody UserCreateDTO userCreateDTO){
        return ResponseEntity.ok(userService.save(userCreateDTO));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<UserDTO> getById(@PathVariable Long id){
        return ResponseEntity.ok(userService.getById(id));
    }
}
