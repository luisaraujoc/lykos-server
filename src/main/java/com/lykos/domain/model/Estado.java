package com.lykos.domain.model;

import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "estado")
public class Estado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEstado;

    @Column(nullable = false, unique = true, length = 2)
    private String sigla;

    @Column(nullable = false, length = 50)
    private String nome;

    @ManyToOne
    @JoinColumn(name = "id_pais", nullable = false)
    private Pais pais;

    @OneToMany(mappedBy = "estado", cascade = CascadeType.ALL)
    private List<Cidade> cidades;
}