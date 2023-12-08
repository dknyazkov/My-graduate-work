package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "person")
public class PersonEntity {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    private String username;
    private String email;
    private String password;
    private String phoneNumber;
    @OneToOne
    private PaymentCardEntity payment;
    @OneToOne
    private RoleEntity role;
    private Boolean isEnabled;
    /*@OneToMany(mappedBy = "person", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<PermissionsEntity> permissions;*/
    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<ReservationEntity> reservations;

}
