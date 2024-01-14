package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentCardDTO {

    private UUID id;
    private TypeOfCard type;
    private Date endDate;
    private String nameOfOwner;


}
