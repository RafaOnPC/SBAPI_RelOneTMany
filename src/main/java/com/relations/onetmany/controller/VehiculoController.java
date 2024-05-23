package com.relations.onetmany.controller;

import com.relations.onetmany.model.Vehiculo;
import com.relations.onetmany.service.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class VehiculoController {

    @Autowired
    private VehiculoService vehiculoService;

    @GetMapping("/vehiculos")
    public ResponseEntity<List<Vehiculo>> getAllVehiculos(){
        return new ResponseEntity<>(vehiculoService.getVehiculos(), HttpStatus.OK);
    }

    @GetMapping("/vehiculos/{idVehiculo}")
    public ResponseEntity<Object> getVehiculo(@PathVariable Long idVehiculo){
        return new ResponseEntity<>(vehiculoService.getVehiculo(idVehiculo), HttpStatus.OK);
    }

    @PostMapping("/vehiculos")
    public ResponseEntity<Object> storeVehiculo(@RequestBody Vehiculo vehiculo){
        return new ResponseEntity<>(vehiculoService.saveVehiculo(vehiculo), HttpStatus.CREATED);
    }

    @PutMapping("/vehiculos/{idVehiculo}")
    public ResponseEntity<Object> updateVehiculo(@PathVariable Long idVehiculo, @RequestBody Vehiculo vehiculo){
        return new ResponseEntity<>(vehiculoService.updateVehiculo(idVehiculo, vehiculo), HttpStatus.OK);
    }

    @DeleteMapping("/vehiculos/{idVehiculo}")
    public ResponseEntity<Object> deleteVehiculo(@PathVariable Long idVehiculo){
        return new ResponseEntity<>(vehiculoService.deleteVehiculo(idVehiculo), HttpStatus.OK);
    }
}
