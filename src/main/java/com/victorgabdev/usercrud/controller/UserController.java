package com.victorgabdev.usercrud.controller;

import com.victorgabdev.usercrud.dto.UserRequestDTO;
import com.victorgabdev.usercrud.dto.UserResponseDTO;
import com.victorgabdev.usercrud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping
    public  ResponseEntity<List<UserResponseDTO>> getAllUsers() {
        List<UserResponseDTO> users = service.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable Integer id) {
        UserResponseDTO user = service.getUserById(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody UserRequestDTO user) {
        UserResponseDTO savedUser = service.createUser(user);
        URI location = URI.create("/users/" + savedUser.getId());
        return ResponseEntity.created(location).body(savedUser);
    }

    // UPDATE

    // DELETE

}
