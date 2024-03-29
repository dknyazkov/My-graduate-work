package com.example.repository;

import com.example.entity.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface RoomRepository extends JpaRepository<RoomEntity,UUID> {

    Optional<RoomEntity> findById(UUID id);
}
