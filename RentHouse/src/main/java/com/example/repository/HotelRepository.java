package com.example.repository;

import com.example.entity.HotelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface HotelRepository extends JpaRepository<HotelEntity, UUID> {

    List<HotelEntity> findAll();
}
