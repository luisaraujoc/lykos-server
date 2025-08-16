package com.lykos.lykos.domain.model;

import com.lykos.lykos.domain.model.enums.PaymentStatus;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "contratacao")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Contratacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_contratacao")
    private Integer id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_agendamento", nullable = false)
    private Agendamento agendamento;

    @Column(name = "valor_total", nullable = false, precision = 10, scale = 2)
    private BigDecimal valorTotal;

    @Column(name = "taxa_plataforma", nullable = false, precision = 10, scale = 2)
    private BigDecimal taxaPlataforma;

    @Column(name = "metodo_pagamento", nullable = false, length = 50)
    private String metodoPagamento;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_pagamento", nullable = false)
    private PaymentStatus statusPagamento = PaymentStatus.pendente;

    @Column(name = "data_pagamento")
    private LocalDateTime dataPagamento;

    @Column(name = "confirmado_por_cliente", nullable = false)
    private Boolean confirmadoPorCliente = false;

    @OneToOne(mappedBy = "contratacao", cascade = CascadeType.ALL, orphanRemoval = true)
    private Avaliacao avaliacao;
}
