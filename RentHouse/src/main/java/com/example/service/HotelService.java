package com.example.service;

import com.example.dto.HotelDTO;

import java.util.List;
import java.util.UUID;

public interface HotelService {
    List<HotelDTO> findAll();

    void saveHotel(HotelDTO hotelDTO);
    void deleteById(UUID id);

}
