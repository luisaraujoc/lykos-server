package com.lykos.lykos.domain.model;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Embeddable
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @EqualsAndHashCode
public class FreelancerIdiomaId implements Serializable {
    private Integer idFreelancer;
    private Integer idIdioma;
}
