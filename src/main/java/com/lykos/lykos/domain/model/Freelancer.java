package com.lykos.lykos.domain.model;

import com.lykos.lykos.domain.model.enums.ProfileStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "freelancer")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Freelancer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_freelancer")
    private Integer id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", nullable = false, unique = true)
    private Usuario usuario;

    @Column(name = "nome_exibicao", nullable = false, length = 50)
    private String nomeExibicao;

    @Column(name = "descricao_perfil")
    private String descricaoPerfil;

    @Column(name = "foto_perfil_url", length = 255)
    private String fotoPerfilUrl;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_perfil", nullable = false)
    private ProfileStatus statusPerfil = ProfileStatus.ativo;

    @Builder.Default
    @Column(name = "data_inicio_na_plataforma", nullable = false)
    private LocalDateTime dataInicioNaPlataforma = LocalDateTime.now();

    @OneToMany(mappedBy = "freelancer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PacoteServico> pacotes;
}
