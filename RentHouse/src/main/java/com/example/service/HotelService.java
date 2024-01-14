package com.example.service;

import com.example.dto.*;
import  com.example.entity.Country;
import com.example.entity.HotelEntity;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface HotelService {
    List<HotelDTO> findAll();

    void saveHotel(HotelDTO hotelDTO);
    void deleteById(UUID id);
    List<HotelDTO> findByCountry(Country country);
    public List<RoomDTO> findRoomById(UUID id);
    public HotelDTO findById(UUID id);
   List <HotelDTO> findByNameAndCountry(String name, Country country);
    List<DeepResponse> deepSearch(DeepRequest request);



}
