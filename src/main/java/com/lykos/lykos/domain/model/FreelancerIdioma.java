package com.lykos.lykos.domain.model;

import com.lykos.lykos.domain.model.enums.LanguageLevel;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "freelancer_idioma")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class FreelancerIdioma {

    @EmbeddedId
    private FreelancerIdiomaId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idFreelancer")
    @JoinColumn(name = "id_freelancer")
    private Freelancer freelancer;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idIdioma")
    @JoinColumn(name = "id_idioma")
    private Idioma idioma;

    @Enumerated(EnumType.STRING)
    @Column(name = "nivel_proficiencia", nullable = false)
    private LanguageLevel nivelProficiencia;
}
