package com.relations.onetmany.service;

import com.relations.onetmany.model.Vehiculo;
import com.relations.onetmany.repository.VehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehiculoServiceImple implements VehiculoService{

    @Autowired
    private VehiculoRepository vehiculoRepository;

    @Override
    public Vehiculo saveVehiculo(Vehiculo vehiculo) {
        return vehiculoRepository.save(vehiculo);
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
        Vehiculo vt = vehiculoRepository.findById(idVehiculo).get();
        vt.setIdVehiculo(vehiculo.getIdVehiculo());
        vt.setMarca(vehiculo.getMarca());
        vt.setModelo(vehiculo.getModelo());
        return vehiculoRepository.save(vt);
    }

    @Override
    public Vehiculo deleteVehiculo(Long idVehiculo) {
        Vehiculo vt = vehiculoRepository.findById(idVehiculo).get();
        vehiculoRepository.deleteById(idVehiculo);
        return vt;
    }
}
