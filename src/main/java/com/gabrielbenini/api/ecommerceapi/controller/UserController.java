package com.gabrielbenini.api.ecommerceapi.controller;

import com.gabrielbenini.api.ecommerceapi.dtos.UserRequestDTO;
import com.gabrielbenini.api.ecommerceapi.dtos.UserResponseDTO;
import com.gabrielbenini.api.ecommerceapi.service.UserService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponseDTO> criarUsuario(@RequestBody UserRequestDTO userRequestDTO) {
        UserResponseDTO usuarioCriado = userService.criarUsuario(userRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioCriado);
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> listarUsuario() {
        List<UserResponseDTO> usuarios = userService.listarUsuarios();
        return ResponseEntity.status(HttpStatus.OK).body(usuarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> buscarPorId(@PathVariable Long id) {
        UserResponseDTO usuario = userService.buscarPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(usuario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDTO> atualizarUsuario(@PathVariable Long id, @RequestBody UserRequestDTO userRequestDTO) {
        UserResponseDTO usuarioAtualizado = userService.atualizarUsuario(id, userRequestDTO);
        return ResponseEntity.status(HttpStatus.OK).body(usuarioAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable Long id) {
        userService.deletarUsuario(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
