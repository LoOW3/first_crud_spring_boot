package com.example.jpahibernatemysql.controller;

import com.example.jpahibernatemysql.model.Persona;
import com.example.jpahibernatemysql.service.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AppController {
    @Autowired
    private IPersonaService Ipersona;

    @PostMapping("/create-person")
    public String createPersona(@RequestBody Persona persona){
        Ipersona.createPersona(persona);
        return "successfully created";
    }

    @DeleteMapping("/delete")
    public String deletePersona(@RequestParam(required = true) int id){
        Ipersona.deletePersona(id);
        return "successfully deleted. ID: " + id;
    }

    @GetMapping("/list-persons")
    public List<Persona> listPersonas(){
        return Ipersona.listPersona();
    }

    @GetMapping("/get-person")
    public Persona getPerson(@RequestParam int id){
        return Ipersona.findPersona(id).orElse(null);
    }

    @PutMapping("/update-person/{id}")
    public String updatePerson(@PathVariable int id,
                               @RequestParam String name){
        return Ipersona.updatePersona(id, name);
    }
}
