package com.example.dto;

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
    private RoomDTO room;
    private Date startOfDate;
    private Date finishOfDate;
    private Date created;
    private String email;
    private Integer countOfGuests;
    private Double cost;
    private Integer numberOfRooms;

}