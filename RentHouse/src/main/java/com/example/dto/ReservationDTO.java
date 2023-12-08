package com.example.dto;

import com.example.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ReservationDTO {

    private UUID id;
    private UUID personId;
    private UUID roomId;
    private Date startOfDate;
    private Date finishOfDate;
    private Status status;
    private Date created;


}