package com.victorgabdev.usercrud.service;

import com.victorgabdev.usercrud.dto.UserRequestDTO;
import com.victorgabdev.usercrud.dto.UserResponseDTO;
import com.victorgabdev.usercrud.entities.UserStatus;
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

    private User findUserById(Integer id) {
        String errorMessage = "Não existe usuário com o id " + id;
        Optional<User> optionalUser = repository.findById(id);
        return optionalUser.orElseThrow(() -> new BusinessException(errorMessage, HttpStatus.NOT_FOUND));
    }

    private Optional<User> findUserByCpf(String cpf) {
         return repository.findByCpf(cpf);
    }

    private void validateCpfNotExists(String cpf) {
        Optional<User> optionalUser = findUserByCpf(cpf);
        if(optionalUser.isPresent()) throw new BusinessException("Usuário já existe", HttpStatus.BAD_REQUEST);
    }

    public UserResponseDTO getUserById(Integer id) {
        User user = findUserById(id);
        return UserMapper.toDTO(user);
    }

    @Transactional
    public UserResponseDTO createUser(UserRequestDTO userRequestDTO) {
        validateCpfNotExists(userRequestDTO.getCpf());

        User user = UserMapper.toUser(userRequestDTO);
        repository.save(user);
        return UserMapper.toDTO(user);
    }

    @Transactional
    public UserResponseDTO updateUser(Integer id, UserRequestDTO userRequestDTO) {
        User user = findUserById(id);

        repository.findByCpf(userRequestDTO.getCpf())
                .filter(u -> !u.getId().equals(id))
                .ifPresent(u -> {
                    throw new BusinessException("CPF já está em uso por outro usuário", HttpStatus.BAD_REQUEST);
                });

        repository.findByEmail(userRequestDTO.getEmail())
                .filter(u -> u.getId().equals(id))
                .ifPresent(u -> {
                    throw new BusinessException("Email já está em uso por outro usuário", HttpStatus.BAD_REQUEST);
                });

        user.setName(userRequestDTO.getName());
        user.setAge(userRequestDTO.getAge());
        user.setCpf(userRequestDTO.getCpf());
        user.setEmail(userRequestDTO.getEmail());
        user.setPassword(userRequestDTO.getPassword());

        repository.save(user);

        return UserMapper.toDTO(user);
    }

    @Transactional
    public void deleteUser(Integer id) {
        User user = findUserById(id);

        if(user.getStatus()  == UserStatus.INACTIVE)
            throw new BusinessException("Usuário já está inativo", HttpStatus.BAD_REQUEST);

        user.setStatus(UserStatus.INACTIVE);
        repository.save(user);
    }
}
