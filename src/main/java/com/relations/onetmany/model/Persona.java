package com.relations.onetmany.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idPersona;
    private String name;
    private String edad;

    @OneToMany(mappedBy = "persona" ,cascade = {CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JsonBackReference
    private List<Vehiculo> vehiculoList;

    public void addVehiculo(Vehiculo vehiculo) {
        this.vehiculoList.add(vehiculo);
        vehiculo.setPersona(this);
    }
}
