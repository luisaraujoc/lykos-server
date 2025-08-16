package com.lykos.lykos.domain.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "pacote_categoria")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class PacoteCategoria {

    @EmbeddedId
    private PacoteCategoriaId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idPacote")
    @JoinColumn(name = "id_pacote")
    private PacoteServico pacote;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idSubcategoria")
    @JoinColumn(name = "id_subcategoria")
    private Subcategoria subcategoria;
}
