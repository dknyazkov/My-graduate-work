package com.example.service;

import com.example.dto.CreateReservationRequest;
import com.example.dto.ReservationDTO;
import com.example.entity.ReservationEntity;
import com.example.repository.ReservationRepository;
import com.example.mapper.BookMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@RequiredArgsConstructor
@Service
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository repository;
    private final BookMapper mapper;
    @Override
    public ReservationDTO createReservation(CreateReservationRequest request) {
        ReservationDTO reservationDTO = ReservationDTO.builder()
                .roomId(request.getRoomId())
                .personId(request.getPersonId())
                .startOfDate(request.getStartOfDate())
                .finishOfDate(request.getFinishOfDate())
                .build();
        return reservationDTO;
    }
    @Transactional
    @Override
    public void saveReservation(ReservationDTO reservationDTO) {
        ReservationEntity entity = mapper.toEntity(reservationDTO);
        repository.save(entity);
    }

    @Override
    public void deleteById(UUID id) {
        Optional<ReservationEntity> byId = repository.findById(id);
        if (byId.isPresent()) {
            repository.deleteById(id);
        }
    }
    @Override
    public ReservationDTO findById(UUID id) {
        return mapper.toDTO(repository.findById(id).orElseThrow(RuntimeException::new));
    }
    @Transactional
    @Override
    public ReservationDTO update(UUID id, ReservationDTO reservationDTO) {
        var byId = repository.findById(id).orElseThrow(RuntimeException::new);
        mapper.update(byId,reservationDTO);
        return mapper.toDTO(byId);
    }

 @Override
    public List<ReservationDTO> getAll() {
     List<ReservationEntity> all = repository.findAll();
     return mapper.toDTO(all);
    }


}
