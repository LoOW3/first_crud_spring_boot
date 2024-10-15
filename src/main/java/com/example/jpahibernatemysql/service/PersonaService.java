package com.example.jpahibernatemysql.service;

import com.example.jpahibernatemysql.model.Persona;
import com.example.jpahibernatemysql.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaService implements IPersonaService {
    @Autowired
    private PersonaRepository persoRepo;

    @Override
    public List<Persona> listPersona() {
        return persoRepo.findAll();
    }

    @Override
    public Optional<Persona> findPersona(int id) {
        return persoRepo.findById(id);
    }

    @Override
    public void createPersona(Persona persona) {
        persoRepo.save(persona);
    }

    @Override
    public void deletePersona(int id) {
        persoRepo.deleteById(id);
    }

    @Override
    public String updatePersona(int id, String name) {
        Persona editablePersona = persoRepo.findById(id).orElse(null);
        if(editablePersona.equals(null)){
            return "error";
        }else{
            editablePersona.setName(name);
            persoRepo.save(editablePersona);
            return "success";
        }
    }
}
