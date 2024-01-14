package com.example.dto;

import com.example.entity.ReservationEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {

    private UUID id;
    private String username;
    private String email;
    private String phoneNumber;
    private PaymentCardDTO payment;
    private String password;
    private List<ReservationEntity> reservations;


}
