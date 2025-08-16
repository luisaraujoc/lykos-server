package com.lykos.lykos.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "habilidade")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Habilidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_habilidade")
    private Integer id;

    @Column(nullable = false, length = 50)
    private String nome;

    @Column
    private String descricao;

    @OneToMany(mappedBy = "habilidade", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FreelancerHabilidade> freelancers;
}
