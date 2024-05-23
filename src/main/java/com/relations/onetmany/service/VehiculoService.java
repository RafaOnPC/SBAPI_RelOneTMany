package com.relations.onetmany.service;

import com.relations.onetmany.model.Vehiculo;

import java.util.List;

public interface VehiculoService {

    public Vehiculo saveVehiculo(Vehiculo vehiculo);

    public Vehiculo getVehiculo(Long idVehiculo);

    public List<Vehiculo> getVehiculos();

    public Vehiculo updateVehiculo(Long idVehiculo, Vehiculo vehiculo);

    public Vehiculo deleteVehiculo(Long idVehiculo);
}
