package com.lykos.lykos.domain.model;

import com.lykos.lykos.domain.model.enums.ReportStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "denuncia")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Denuncia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_denuncia")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario_denunciante", nullable = false)
    private Usuario denunciante;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario_denunciado", nullable = false)
    private Usuario denunciado;

    @Column(nullable = false, length = 100)
    private String motivo;

    @Column(nullable = false)
    private String descricao;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_denuncia", nullable = false)
    private ReportStatus statusDenuncia = ReportStatus.pendente;

    @Builder.Default
    @Column(name = "data_denuncia", nullable = false)
    private LocalDateTime dataDenuncia = LocalDateTime.now();
}
