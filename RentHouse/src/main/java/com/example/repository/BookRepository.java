package com.example.repository;

import com.example.entity.ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BookRepository extends JpaRepository<ReservationEntity, UUID> {



}