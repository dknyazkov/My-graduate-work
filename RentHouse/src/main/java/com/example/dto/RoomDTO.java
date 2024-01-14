package com.example.dto;

import com.example.entity.HotelEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomDTO {

    private UUID id;
    private String name;
    private Double price;
    private HotelEntity hotel;
    private Integer remain;
}