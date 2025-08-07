package com.victorgabdev.usercrud.mapper;

import com.victorgabdev.usercrud.dto.UserRequestDTO;
import com.victorgabdev.usercrud.dto.UserResponseDTO;
import com.victorgabdev.usercrud.entities.User;

public class UserMapper {

    public static UserResponseDTO toDTO(User user) {
        return new UserResponseDTO(user.getId(),
                user.getName(),
                user.getAge(),
                user.getCpf(),
                user.getEmail(),
                user.getStatus());
    }

    public static User toUser(UserRequestDTO userRequestDTO) {
        return new User(userRequestDTO.getName(),
                userRequestDTO.getAge(),
                userRequestDTO.getCpf(),
                userRequestDTO.getEmail(),
                userRequestDTO.getPassword(),
                userRequestDTO.getStatus());
    }

}
