package com.lykos.lykos.domain.model;

import com.lykos.lykos.domain.model.enums.PackageStatus;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "pacote_servico")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class PacoteServico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pacote")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_freelancer", nullable = false)
    private Freelancer freelancer;

    @Column(nullable = false, length = 100)
    private String titulo;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal preco;

    @Column(name = "prazo_entrega_dias", nullable = false)
    private Integer prazoEntregaDias;

    @Column(name = "numero_revisoes")
    private Integer numeroRevisoes = 0;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_pacote", nullable = false)
    private PackageStatus statusPacote = PackageStatus.ativo;

    @Builder.Default
    @Column(name = "data_criacao", nullable = false)
    private LocalDateTime dataCriacao = LocalDateTime.now();

    @OneToMany(mappedBy = "pacote", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Agendamento> agendamentos;

    @OneToMany(mappedBy = "pacote", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PacoteCategoria> categorias;
}
