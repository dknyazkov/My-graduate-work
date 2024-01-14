package com.example.mapper;

import com.example.dto.*;
import com.example.entity.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {


    List<HotelDTO> toDTOHotel(List<HotelEntity> entities);
    List<RoomDTO> toDTORoom(List<RoomEntity> entities);
    RoomDTO toDTO(RoomEntity entity);

    HotelEntity toEntity(HotelDTO dto);
    PaymentCardEntity toEntity(PaymentCardDTO dto);

    PersonEntity toEntity(PersonDTO dto);
    ReservationEntity toEntity(ReservationDTO dto);
    RoleEntity toEntity(RoleDTO dto);
    RoomEntity toEntity(RoomDTO dto);

    HotelDTO toDTO(HotelEntity entity);
    PaymentCardDTO toDTO(PaymentCardEntity entity);

    PersonDTO toDTO(PersonEntity entity);
    ReservationDTO toDTO(ReservationEntity entity);
    RoleDTO toDTO(RoleEntity entity);


    List<ReservationDTO> toDTO(List<ReservationEntity> entities);

    void update(@MappingTarget PersonEntity personEntity, PersonDTO personDTO);

    void update(@MappingTarget ReservationEntity reservationEntity, ReservationDTO reservationDTO);
}
