package com.example.entity;

import com.example.Country;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "hotel")
public class HotelEntity {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    private String name;
    private String description;
    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
    private List<RoomEntity> rooms;
    private Integer amountOfStars;
    @Enumerated(EnumType.STRING)
    private Country country;


}
