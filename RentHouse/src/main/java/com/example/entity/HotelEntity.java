package com.example.entity;


import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.awt.*;
import java.sql.Blob;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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
    @ToString.Exclude
    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
    private List<RoomEntity> rooms;
    private Integer amountOfStars;
    @Enumerated(EnumType.STRING)
    private Country country;
    private Double price;



}
