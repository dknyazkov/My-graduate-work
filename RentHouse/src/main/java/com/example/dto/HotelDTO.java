package com.example.dto;

import com.example.Country;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotelDTO {

    private UUID id;
    private String name;
    private String description;
    private List<RoomDTO> rooms;
    private Integer amountOfStars;
    private Country country;

}
