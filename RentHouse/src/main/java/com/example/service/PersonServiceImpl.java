package com.example.service;

import com.example.dto.PersonDTO;
import com.example.entity.PersonEntity;
import com.example.repository.PersonRepository;
import com.example.mapper.BookMapper;
import lombok.RequiredArgsConstructor;
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
    /*    PersonEntity person = PersonEntity.builder()
                .username(personDTO.getUsername())
                .password(passwordEncoder.encode(personDTO.getPassword()))
                .isEnabled(true)
                .build();

        String permissions = personDTO.getPermissions();
        String[] split = permissions.split(",");
        List<PermissionsEntity> collect = Arrays.stream(split)
                .map(PermissionsEntity::new)
                .peek(permissionsEntity -> permissionsEntity.setPerson(person))
                .collect(Collectors.toList());

        person.setPermissions(collect);
         repository.save(person);*/
        PersonEntity entity = mapper.toEntity(personDTO);
        PersonEntity save = repository.save(entity);


    }

    @Override
    public PersonDTO findById(UUID id) {
        return mapper.toDTO(repository.findById(id).orElseThrow(RuntimeException::new));
    }


    @Override
    public void deleteById(UUID id) {
        Optional<PersonEntity> byId = repository.findById(id);
        if (byId.isPresent()) {
            repository.deleteById(id);
        }
    }
}