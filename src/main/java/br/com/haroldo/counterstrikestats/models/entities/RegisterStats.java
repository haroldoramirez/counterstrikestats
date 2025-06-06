package br.com.haroldo.counterstrikestats.models.entities;

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
public class RegisterStats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 150, nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer kills;

    @Column(nullable = false)
    private Integer deaths;

    @Column(nullable = false)
    private Integer damage;

    //Atributos de sistema
    @Column(name = "registration_date", updatable = false)
    private LocalDateTime registrationDate;

}