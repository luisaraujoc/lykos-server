package com.lykos.lykos.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "idioma")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Idioma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_idioma")
    private Integer id;

    @Column(nullable = false, length = 50)
    private String nome;

    @Column(name = "codigo_iso", nullable = false, length = 5)
    private String codigoIso;

    @OneToMany(mappedBy = "idioma", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FreelancerIdioma> freelancers;
}
