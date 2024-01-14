package com.example.dto;

import com.example.Country;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateFindHotelRequest {
    private String name;
    //private Integer amountOfStars;
    private Date startOfDate;
    private Date finishOfDate;
    private Country country;
    private Double price;


}
