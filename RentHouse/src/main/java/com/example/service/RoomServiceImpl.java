package com.example.service;

import com.example.dto.RoomDTO;
import com.example.entity.HotelEntity;
import com.example.entity.RoomEntity;
import com.example.exception.ParametersWrongException;
import com.example.mapper.BookMapper;
import com.example.repository.HotelRepository;
import com.example.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {
    private final BookMapper mapper;
    private final HotelRepository hotelRepository;
    private final RoomRepository repository;

    @Override
    public List<RoomDTO> findRoomById(UUID hotelId) {
        Optional<HotelEntity> byId = hotelRepository.findById(hotelId);
        if (!byId.isPresent()) {
            throw new ParametersWrongException();

        }
        Optional<List<RoomEntity>> roomOpt = byId.map(hotelEntity -> hotelEntity.getRooms());
        return mapper.toDTORoom(roomOpt.get());

    }

    @Override
    public RoomDTO findById(UUID roomId) {
        return mapper.toDTO(repository.findById(roomId).orElseThrow(ParametersWrongException::new));
    }
}
