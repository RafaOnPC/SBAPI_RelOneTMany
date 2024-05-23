package com.relations.onetmany.service;

import com.relations.onetmany.model.Persona;

import java.util.List;

public interface PersonaService {

    public Persona savePersona(Persona persona);

    public Persona getPersona(Long idPersona);

    public List<Persona> getPersonas();

    public Persona updatePersona(Long idPersona, Persona persona);

    public Persona deletePersona(Long idPersona);
}
