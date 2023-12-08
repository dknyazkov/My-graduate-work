package com.example.service;


import com.example.dto.PersonDTO;

import java.util.UUID;

public interface PersonService  {
    void savePerson(PersonDTO personDTO);
    PersonDTO findById(UUID id);
    void deleteById(UUID id);
}
