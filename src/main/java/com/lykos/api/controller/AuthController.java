package com.lykos.api.controller;

import com.lykos.application.service.UsuarioService;
import com.lykos.domain.model.Usuario;
import com.lykos.domain.model.enums.UserType;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UsuarioService usuarioService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        Optional<Usuario> usuario = usuarioService.autenticar(
                request.login(), request.senha());

        if (usuario.isPresent()) {
            return ResponseEntity.ok(usuario.get());
        } else {
            return ResponseEntity.status(401).body("Credenciais inválidas");
        }
    }

    @PostMapping("/registro")
    public ResponseEntity<?> registrar(@RequestBody RegistroRequest request) {
        try {
            // Converter String para UserType
            UserType tipoUsuario;
            try {
                tipoUsuario = UserType.valueOf(request.tipoUsuario().toUpperCase());
            } catch (IllegalArgumentException e) {
                return ResponseEntity.badRequest().body("Tipo de usuário inválido: " + request.tipoUsuario());
            }

            Usuario usuario = usuarioService.criarUsuario(
                    request.nomeCompleto(),
                    request.nomeUsuario(),
                    request.email(),
                    request.senha(),
                    tipoUsuario
            );
            return ResponseEntity.ok(usuario);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // Records para os DTOs de request
    public record LoginRequest(String login, String senha) {}

    public record RegistroRequest(
            String nomeCompleto,
            String nomeUsuario,
            String email,
            String senha,
            String tipoUsuario
    ) {}
}