package com.example.service;

import com.example.dto.*;
import com.example.entity.Country;
import com.example.entity.HotelEntity;
import com.example.entity.RoomEntity;
import com.example.exception.ParametersWrongException;
import com.example.repository.HotelRepository;
import com.example.mapper.BookMapper;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService {
    private final HotelRepository repository;
    private final BookMapper mapper;


    @Override
    public List<HotelDTO> findAll() {

        return mapper.toDTOHotel(repository.findAll());
    }

    @Override
    public void saveHotel(HotelDTO hotelDTO) {
        repository.save(mapper.toEntity(hotelDTO));
    }

    @Override
    public void deleteById(UUID id) {
    }

    @Override
    public List<HotelDTO> findByCountry(Country country) {
        List<HotelEntity> byCountry = repository.findByCountry(country);
        return mapper.toDTOHotel(byCountry);
    }

    @Override
    public List<RoomDTO> findRoomById(UUID id) {
        Optional<HotelEntity> byId = repository.findById(id);
        if (!byId.isPresent()) {
            throw new ParametersWrongException();

        }
        Optional<List<RoomEntity>> roomOpt = byId.map(hotelEntity -> hotelEntity.getRooms());
        List<RoomEntity> roomEntities = roomOpt.get();
        return mapper.toDTORoom(roomEntities);

    }

    @Override
    public HotelDTO findById(UUID id) {
        return mapper.toDTO(repository.findById(id).orElseThrow(ParametersWrongException::new));
    }

    @Override
    public List<HotelDTO> findByNameAndCountry(String name, Country country) {
        List<HotelEntity> byCountry = repository.findByNameAndCountry(name, country);
        return mapper.toDTOHotel(byCountry);
    }

    @Override
    public List<DeepResponse> deepSearch(DeepRequest request) {
        String start = request.getStart();
        LocalDate startDate = null;
        try {
            startDate= LocalDate.parse(start,DateTimeFormatter.ofPattern("yyyy-MM-dd"));;
        } catch ( Exception exception ){

        }

        String finish = request.getFinish();
        LocalDate finishDate = null;
        try {
            finishDate= LocalDate.parse(finish,DateTimeFormatter.ofPattern("yyyy-MM-dd"));;
        } catch ( Exception exception ){

        }
        String name = request.getName();
        Country location = request.getLocation();

        return repository.findByOther(name,startDate,finishDate,location.toString());


    }

}
