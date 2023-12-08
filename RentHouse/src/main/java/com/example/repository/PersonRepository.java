package com.example.repository;

import com.example.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface PersonRepository extends JpaRepository<PersonEntity,UUID> {
    Optional<PersonEntity> findByUsername(String username);


    Optional<PersonEntity> findById(UUID id);
}