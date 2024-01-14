package com.example.service;

import com.example.dto.RoomDTO;
import com.example.entity.RoomEntity;

import java.util.List;
import java.util.UUID;

public interface RoomService {

    public List<RoomDTO> findRoomById(UUID id);

    public RoomDTO findById(UUID id);
}
