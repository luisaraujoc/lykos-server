package com.lykos.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
@RequiredArgsConstructor
public class BaseController {

    @GetMapping("/")
    public String index() {
        return "Bem-vindo à API Lykos! Use /api/auth para autenticação e /api/usuarios para gerenciamento de usuários.";
    }
}
