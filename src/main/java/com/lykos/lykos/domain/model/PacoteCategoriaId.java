package com.lykos.lykos.domain.model;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Embeddable
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @EqualsAndHashCode
public class PacoteCategoriaId implements Serializable {
    private Integer idPacote;
    private Integer idSubcategoria;
}
