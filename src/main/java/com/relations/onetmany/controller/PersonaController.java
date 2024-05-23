package com.relations.onetmany.controller;

import com.relations.onetmany.model.Persona;
import com.relations.onetmany.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @GetMapping("/personas")
    public ResponseEntity<List<Persona>> getAllPersonas(){
        return new ResponseEntity<>(personaService.getPersonas(), HttpStatus.OK);
    }

    @GetMapping("/personas/{idPersona}")
    public ResponseEntity<Object> getAPersona(@PathVariable Long idPersona){
        return new ResponseEntity<>(personaService.getPersona(idPersona), HttpStatus.OK);
    }

    @PostMapping("/personas")
    public ResponseEntity<Object> storePersona(@RequestBody Persona persona){
        return new ResponseEntity<>(personaService.savePersona(persona), HttpStatus.CREATED);
    }

    @PatchMapping("/personas/{idPersona}")
    public ResponseEntity<Object> updateAPersona(@PathVariable Long idPersona, @RequestBody Persona persona){
        return new ResponseEntity<>(personaService.updatePersona(idPersona, persona), HttpStatus.OK);
    }

    @DeleteMapping("/personas/{idPersona}")
    public ResponseEntity<Object> deleteAPersona(@PathVariable Long idPersona){
        return new ResponseEntity<>(personaService.deletePersona(idPersona), HttpStatus.OK);
    }

}
