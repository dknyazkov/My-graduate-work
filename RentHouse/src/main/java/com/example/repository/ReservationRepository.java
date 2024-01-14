package com.example.repository;

import com.example.entity.Country;
import com.example.entity.HotelEntity;
import com.example.entity.ReservationEntity;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ReservationRepository extends JpaRepository<ReservationEntity, UUID> {
    List<ReservationEntity> findByEmail(String email);

    List<ReservationEntity> findAll();


    List<ReservationEntity> findByPersonId(UUID uuid);

    void deleteById(UUID id);
}
