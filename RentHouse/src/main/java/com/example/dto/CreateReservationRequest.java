package com.example.dto;

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
public class CreateReservationRequest {
    private UUID personId;
    public UUID roomId;
    private Date startOfDate;
    private Date finishOfDate;
}

