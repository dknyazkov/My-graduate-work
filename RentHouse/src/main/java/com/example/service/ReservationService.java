package com.example.service;

import com.example.dto.CreateReservationRequest;
import com.example.dto.PersonDTO;
import com.example.dto.ReservationDTO;
import com.example.entity.Country;
import com.example.entity.HotelEntity;
import com.example.entity.ReservationEntity;

import java.util.List;
import java.util.UUID;

public interface ReservationService {

    ReservationDTO createReservation(UUID id,CreateReservationRequest request);


    void deleteById(UUID id);

    ReservationDTO findById(UUID id);

    List<ReservationDTO> findByPersonId(UUID uuid);
   /*  ReservationDTO update(UUID id, ReservationDTO reservationDTO);

   List<ReservationDTO> findAll();

    PersonDTO getPersonById(UUID id);

    List<ReservationDTO> findByEmail(String email);*/

}
