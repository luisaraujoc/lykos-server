package com.lykos.lykos.domain.model;

import com.lykos.lykos.domain.model.enums.MediaType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "portfolio")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_portfolio")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_freelancer", nullable = false)
    private Freelancer freelancer;

    @Column(nullable = false, length = 100)
    private String titulo;

    @Column
    private String descricao;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_midia", nullable = false)
    private MediaType tipoMidia;

    @Column(name = "url_midia", nullable = false, length = 255)
    private String urlMidia;

    @Builder.Default
    @Column(name = "data_upload", nullable = false)
    private LocalDateTime dataUpload = LocalDateTime.now();
}
