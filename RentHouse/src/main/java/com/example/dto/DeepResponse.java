package com.example.dto;

import com.example.Country;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeepResponse {
private String nameHotel;
private Country country;
private String room_category;
private Integer freeRoom;
private Integer roomPrice;



}
