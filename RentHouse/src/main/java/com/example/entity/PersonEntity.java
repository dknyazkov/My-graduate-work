package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "person")
public class PersonEntity implements UserDetails {
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

   @OneToMany(mappedBy = "person", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<PermissionsEntity> permissions;
    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    private List<ReservationEntity> reservations;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<PermissionsEntity> list = getPermissions();
        if (list==null||list.size()==0)
        {return new ArrayList<>();}

        List<GrantedAuthority> collect = list.stream()
                .map(PermissionsEntity::getName)
                .map(name -> new GrantedAuthority() {
                    @Override
                    public String getAuthority() {
                        return name;
                    }
                })
                .collect(Collectors.toList());
        return collect;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
