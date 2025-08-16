package com.lykos.lykos.domain.model

import jakarta.persistence.Embeddable
import lombok.*
import java.io.Serializable

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
class FreelancerHabilidadeId : Serializable {
    private var idFreelancer: Int? = null
    private var idHabilidade: Int? = null
}