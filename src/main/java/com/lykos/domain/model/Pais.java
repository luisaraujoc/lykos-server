package com.lykos.domain.model;


import lombok.*;
import jakarta.persistence.*;
import java.util.*


@Getter
@Setter
@Entity
@Table(name = "pais")
public class Pais {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPais;

    @Column(nullable = false, unique = true, length = 5)
    private String codigoIso;

    @Column(nullable = false, unique = true, length = 100)
    private String nome;

    @OneToMany(mappedBy = "pais", cascade = CascadeType.ALL)
    private List<Estado> estados;
}
