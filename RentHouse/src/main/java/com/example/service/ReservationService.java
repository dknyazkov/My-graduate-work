package com.example.service;

import com.example.dto.CreateReservationRequest;
import com.example.dto.ReservationDTO;

import java.util.List;
import java.util.UUID;

public interface ReservationService {

    ReservationDTO createReservation(CreateReservationRequest request);

    void saveReservation(ReservationDTO reservationDTO);

    public void deleteById(UUID id);

    ReservationDTO findById(UUID id);

    ReservationDTO update(UUID id, ReservationDTO reservationDTO);

    List<ReservationDTO> getAll();

}
