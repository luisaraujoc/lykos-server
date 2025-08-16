package com.lykos.lykos.domain.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "freelancer_habilidade")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class FreelancerHabilidade {

    @EmbeddedId
    private FreelancerHabilidadeId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idFreelancer")
    @JoinColumn(name = "id_freelancer")
    private Freelancer freelancer;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idHabilidade")
    @JoinColumn(name = "id_habilidade")
    private Habilidade habilidade;
}
