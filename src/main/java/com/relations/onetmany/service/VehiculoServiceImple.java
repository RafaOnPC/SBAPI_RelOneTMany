package com.relations.onetmany.service;

import com.relations.onetmany.model.Persona;
import com.relations.onetmany.model.Vehiculo;
import com.relations.onetmany.repository.PersonaRepository;
import com.relations.onetmany.repository.VehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VehiculoServiceImple implements VehiculoService{

    @Autowired
    private VehiculoRepository vehiculoRepository;

    @Autowired
    private PersonaRepository personaRepository;

    @Override
    public Vehiculo saveVehiculo(Vehiculo vehiculo) {
        /*
        * 1.Crear el vehiculo
        * 2.Persistir vehiculo
        * 3.Crear persona
        * 4.Persistir persona
        * 5.Establecer relacion bidireccional entre persona y vehiculo
        * 6.Guardar cambios
        * */

        //Creando lista
        List<Vehiculo> vehiculoList = new ArrayList<>();

        //Creamos el vehiculo
        Vehiculo vt = new Vehiculo();
        vt.setIdVehiculo(vehiculo.getIdVehiculo());
        vt.setModelo(vehiculo.getModelo());
        vt.setMarca(vehiculo.getMarca());
        vt.setPersona(null);

        //Persistimos el vehiculo sin relacion
        Vehiculo vh = vehiculoRepository.save(vt);


        //Creamos una persona
        Persona pt = new Persona();
        pt.setIdPersona(vehiculo.getPersona().getIdPersona());
        pt.setName(vehiculo.getPersona().getName());
        pt.setEdad(vehiculo.getPersona().getEdad());

        //Persistimos la persona sin relacion
        Persona person = personaRepository.save(pt);

        //Establecemos relacion entre vehiculo y persona
        vh.setPersona(person);

        //Actualizamos el vehiculo
        Vehiculo vts = vehiculoRepository.save(vh);


        //Guardamos el vehiculo en una lista
        vehiculoList.add(vts);

        //Establecemos relacion entre persona y vehiculo
        pt.setVehiculoList(vehiculoList);

        //Actualizamos la persona
        personaRepository.save(pt);

        //Mostramos el vehiculo
        return vts;


    }

    @Override
    public Vehiculo getVehiculo(Long idVehiculo) {
        return vehiculoRepository.findById(idVehiculo).get();
    }

    @Override
    public List<Vehiculo> getVehiculos() {
        List<Vehiculo> vehiculoList = vehiculoRepository.findAll();
        return vehiculoList;
    }

    @Override
    public Vehiculo updateVehiculo(Long idVehiculo, Vehiculo vehiculo) {
        /*
        * 1.Recuperamos el vehiculo
        * 2.Seteamos datos a la persona
        * 3.Seteamos datos al vehiculo
        * 4.Actualizamos el vehiculo
        * 5.Retornamos el vehiculo con su persona
        * */

        //Recuperamos el vehiculo
        Vehiculo vt = vehiculoRepository.findById(idVehiculo).get();

        //Seteamos los nuevos valores al vehiculo
        vt.setIdVehiculo(vehiculo.getIdVehiculo());
        vt.setMarca(vehiculo.getMarca());
        vt.setModelo(vehiculo.getModelo());
        vt.setPersona(vehiculo.getPersona());

        Vehiculo vts = vehiculoRepository.save(vt);

        return vts;
    }

    @Override
    public Vehiculo deleteVehiculo(Long idVehiculo) {
        Vehiculo vt = vehiculoRepository.findById(idVehiculo).get();
        vehiculoRepository.deleteById(idVehiculo);
        return vt;
    }
}
