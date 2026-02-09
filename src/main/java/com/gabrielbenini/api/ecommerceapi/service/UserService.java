package com.gabrielbenini.api.ecommerceapi.service;

import com.gabrielbenini.api.ecommerceapi.dtos.UserRequestDTO;
import com.gabrielbenini.api.ecommerceapi.dtos.UserResponseDTO;
import com.gabrielbenini.api.ecommerceapi.model.User;
import com.gabrielbenini.api.ecommerceapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserResponseDTO criarUsuario(UserRequestDTO userRequestDTO) {

        User user = new User();
        user.setEmail(userRequestDTO.email());
        user.setName(userRequestDTO.nome());
        user.setPassword(userRequestDTO.senha());

        User userSalvo = userRepository.save(user);

        return new UserResponseDTO(
                user.getId(),
                user.getEmail(),
                user.getName(),
                user.getPassword()
        );
    }

    public List<UserResponseDTO> listarUsuarios(){

        return userRepository.findAll()
                .stream()
                .map(user -> new UserResponseDTO(
                        user.getId(),
                        user.getName(),
                        user.getEmail(),
                        user.getPassword()
                ))
                .toList();
    }

    public UserResponseDTO buscarPorId(Long id){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        return new UserResponseDTO(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getPassword()
        );
    }

    public UserResponseDTO atualizarUsuario(Long id, UserRequestDTO userRequestDTO){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        user.setName(userRequestDTO.nome());
        user.setEmail(userRequestDTO.email());
        user.setPassword(userRequestDTO.senha());

        User userAtualizado = userRepository.save(user);

        return new UserResponseDTO(
                userAtualizado.getId(),
                userAtualizado.getName(),
                userAtualizado.getEmail(),
                userAtualizado.getPassword()
        );
    }

    public void deletarUsuario(Long id){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        userRepository.delete(user);
    }
}
