package com.victorgabdev.usercrud.service;

import com.victorgabdev.usercrud.dto.UserRequestDTO;
import com.victorgabdev.usercrud.dto.UserResponseDTO;
import com.victorgabdev.usercrud.exception.BusinessException;
import com.victorgabdev.usercrud.mapper.UserMapper;
import com.victorgabdev.usercrud.entities.User;
import com.victorgabdev.usercrud.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository repository;

    public List<UserResponseDTO> getAllUsers() {
        List<User> users = repository.findAll();

        return users.stream()
                .map(UserMapper::toDTO)
                .toList();
    }

    public UserResponseDTO getUserById(Integer id) {
        String errorMessage = "Não existe usuário com o id " + id;
        Optional<User> optionalUser = repository.findById(id);
        User user = optionalUser.orElseThrow(() -> new BusinessException(errorMessage, HttpStatus.NOT_FOUND));
        return UserMapper.toDTO(user);
    }

    private void validateCpfNotExists(String cpf) {
        Optional<User> optionalUser = repository.findByCpf(cpf);
        if(optionalUser.isPresent()) throw new BusinessException("Usuário já existe", HttpStatus.BAD_REQUEST);
    }

    @Transactional
    public UserResponseDTO createUser(UserRequestDTO userRequestDTO) {
        validateCpfNotExists(userRequestDTO.getCpf());

        User user = UserMapper.toUser(userRequestDTO);
        repository.save(user);
        return UserMapper.toDTO(user);
    }
}
