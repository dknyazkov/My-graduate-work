package com.example.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "reservation")
public class ReservationEntity {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "person_id")
    private PersonEntity person;
    @ManyToOne
    @JoinColumn(name = "room_id")
    private RoomEntity room;
    private String email;
    private Date startOfDate;
    private Date finishOfDate;
    @Enumerated(EnumType.STRING)
    @CreationTimestamp
    @Temporal(TemporalType.DATE)
    private Date created;
    private Integer countOfGuests;
    private Double cost;
    private Integer NumberOfRooms;


}
