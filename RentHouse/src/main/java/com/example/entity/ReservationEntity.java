package com.example.entity;

import com.example.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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
    private RoomEntity room;
    private Date startOfDate;
    private Date finishOfDate;
    @Enumerated(EnumType.STRING)
    private  Status status;
    @Temporal(TemporalType.DATE)
    private Date created;
    private Integer countOfGuests;


}
