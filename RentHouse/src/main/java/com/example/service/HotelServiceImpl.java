package com.example.service;

import com.example.dto.HotelDTO;
import com.example.repository.HotelRepository;
import com.example.mapper.BookMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService {
    private final HotelRepository repository;
    private final BookMapper mapper;


    @Override
    public List<HotelDTO> findAll() {
     return mapper.toDTOHotel(repository.findAll());
    }

    @Override
    public void saveHotel(HotelDTO hotelDTO) {
        repository.save(mapper.toEntity(hotelDTO));
    }

    @Override
    public void deleteById(UUID id) {

    }
}
