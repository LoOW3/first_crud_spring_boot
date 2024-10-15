package com.example.jpahibernatemysql.service;

import com.example.jpahibernatemysql.model.Persona;

import java.util.List;
import java.util.Optional;

public interface IPersonaService {
    public List<Persona> listPersona();
    public Optional<Persona> findPersona(int id);
    public void createPersona(Persona persona);
    public void deletePersona(int id);
    public String updatePersona(int id, String name);
}
