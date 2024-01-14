package com.example.service;

import com.example.dto.PersonDTO;
import com.example.dto.ReservationDTO;
import com.example.entity.PersonEntity;
import com.example.exception.ParametersWrongException;
import com.example.exception.PersonErrorException;
import com.example.repository.PersonRepository;
import com.example.mapper.BookMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {
    private final PersonRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final BookMapper mapper;


    @Transactional
    @Override
    public void savePerson(PersonDTO personDTO) {
        if (personDTO==null||personDTO.getUsername()==null||personDTO.getPassword()==null||personDTO.getPassword().length()<5)
        {throw new PersonErrorException("create person error");}
        PersonEntity person = PersonEntity.builder()
                .username(personDTO.getUsername())
                .phoneNumber(personDTO.getPhoneNumber())
                .password(passwordEncoder.encode(personDTO.getPassword()))
                .email(personDTO.getEmail())
                .isEnabled(true)
                .build();
        repository.save(person);
    }

    @Override
    public PersonDTO findById(UUID id) {
        return mapper.toDTO(repository.findById(id).orElseThrow(ParametersWrongException::new));
    }


    @Override
    public void deleteById(UUID id) {
        Optional<PersonEntity> byId = repository.findById(id);
        if (byId.isPresent()) {
            repository.deleteById(id);
        }
    }

    @Override
    public UUID getPersonId() {
        PersonEntity principal = (PersonEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return principal.getId();
    }

}