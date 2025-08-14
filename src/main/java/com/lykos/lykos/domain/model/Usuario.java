package com.lykos.lykos.domain.model;


import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Setter;
import lombok.ToString;
import lombok.Getter;

import com.lykos.lykos.domain.enums.TipoUsuario;
import com.lykos.lykos.domain.enums.StatusConta;


@Entity
@Table(name = "usuarios")
@Getter
@Setter
@ToString
public class Usuario {

    private Long id;
    private String nome;
    private String email;
    private String senhaHash;
    private Date dataNascimento;
    private String telefone;
    private TipoUsuario tipo;
    private StatusConta status;

    Usuario(){}

    Usuario(Long id, String nome, String email, String senhaHash, Date dataNascimento, String telefone, TipoUsuario tipo, StatusConta status) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senhaHash = senhaHash;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.tipo = tipo;
        this.status = status;
    }
}