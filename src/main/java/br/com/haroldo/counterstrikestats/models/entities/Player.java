package br.com.haroldo.counterstrikestats.models.entities;

import br.com.haroldo.counterstrikestats.models.enums.StatusPlayer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 150, nullable = false)
    private String name;

    //Atributos de sistema
    @Column(name = "registration_date", updatable = false)
    private LocalDateTime registrationDate;

    @Column(name = "status")
    @Enumerated(value = EnumType.STRING)
    private StatusPlayer status;

}
