package com.relations.onetmany.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idVehiculo;
    private String marca;
    private String modelo;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name="persona_id")
    private Persona persona;
}
