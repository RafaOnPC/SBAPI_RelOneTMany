package com.relations.onetmany.service;

import com.relations.onetmany.model.Persona;
import com.relations.onetmany.model.Vehiculo;
import com.relations.onetmany.repository.PersonaRepository;
import com.relations.onetmany.repository.VehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaServiceImple implements PersonaService{

    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private VehiculoRepository vehiculoRepository;

    @Override
    public Persona savePersona(Persona persona) {
        List<Vehiculo> vehiculoList = persona.getVehiculoList();
        if (vehiculoList != null) {
            for (Vehiculo vehiculo : vehiculoList) {
                Optional<Vehiculo> existingVehiculo = vehiculoRepository.findById(vehiculo.getIdVehiculo());
                if (existingVehiculo.isPresent()) {
                    Vehiculo vehiculoEntity = existingVehiculo.get();
                    vehiculoEntity.setPersona(persona); // Establecer la relación bidireccional
                }
            }
        }
        return personaRepository.save(persona);
    }

    @Override
    public Persona getPersona(Long idPersona) {
        return personaRepository.findById(idPersona).get();
    }

    @Override
    public List<Persona> getPersonas() {
        List<Persona> personaList = personaRepository.findAll();
        return personaList;
    }

    @Override
    public Persona updatePersona(Long idPersona, Persona persona) {
        Optional<Persona> personaExistente = personaRepository.findById(idPersona);
        if (personaExistente.isPresent()) {
            Persona person = personaExistente.get();
            person.setName(persona.getName());
            person.setEdad(persona.getEdad());
            actualizarVehiculos(persona.getVehiculoList(), person);
            return personaRepository.save(person);
        }
        return null;
    }

    private void actualizarVehiculos(List<Vehiculo> vehiculoList, Persona persona) {
        if (vehiculoList != null) {
            for (Vehiculo vehiculo : vehiculoList) {
                Optional<Vehiculo> vehiculoExistente = vehiculoRepository.findById(vehiculo.getIdVehiculo());
                vehiculoExistente.ifPresent(vehiculoEntity -> {
                    vehiculoEntity.setPersona(persona);
                });
            }
        }
    }

    @Override
    public Persona deletePersona(Long idPersona) {
        Persona persona = personaRepository.findById(idPersona).get();
        personaRepository.deleteById(idPersona);
        return persona;
    }
}
