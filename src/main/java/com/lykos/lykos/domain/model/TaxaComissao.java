package com.lykos.lykos.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "taxa_comissao")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class TaxaComissao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_taxa")
    private Integer id;

    @Column(nullable = false, precision = 5, scale = 2, unique = true)
    private BigDecimal percentual;

    @Builder.Default
    @Column(name = "data_implementacao", nullable = false)
    private LocalDateTime dataImplementacao = LocalDateTime.now();

    @Column(nullable = false)
    private Boolean ativa = true;
}
