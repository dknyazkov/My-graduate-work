package com.example.service;

import com.example.dto.CreateReservationRequest;
import com.example.dto.PersonDTO;
import com.example.dto.ReservationDTO;
import com.example.dto.RoomDTO;
import com.example.entity.PersonEntity;
import com.example.entity.ReservationEntity;
import com.example.exception.ParametersWrongException;
import com.example.exception.ReservationErrorException;
import com.example.repository.ReservationRepository;
import com.example.mapper.BookMapper;
import com.example.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@RequiredArgsConstructor
@Service
public class ReservationServiceImpl implements ReservationService {
    private final RoomService roomService;
    private final ReservationRepository repository;
    private final BookMapper mapper;
    private final PersonService personService;
    private final RoomRepository roomRepository;


    @Override
    public ReservationDTO createReservation(UUID id, CreateReservationRequest request) {
        if (request.getFinishOfDate()==null||request.getStartOfDate()==null||request.getNumberOfRooms()==null){
            throw new ReservationErrorException("error reservation create");
        }
        if (request.getStartOfDate().getDate()>=request.getFinishOfDate().getDate())
        {throw new ParametersWrongException("wrong date");}
        PersonEntity principal =(PersonEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        RoomDTO roomDTO = roomService.findById(id);
        if (request.getNumberOfRooms() > roomDTO.getRemain()) {
            throw new ParametersWrongException();
        }
        ReservationDTO reservationDTO = ReservationDTO.builder()
                .room(roomService.findById(id))
                .countOfGuests(request.getCount())
                .numberOfRooms(request.getNumberOfRooms())
                .email(request.getEmail())
                .cost(request.getPrice() * request.getNumberOfRooms())
                .startOfDate(request.getStartOfDate())
                .finishOfDate(request.getFinishOfDate())
                .build();
        ReservationEntity entity = mapper.toEntity(reservationDTO);
        entity.setPerson(principal);
        ReservationEntity save = repository.save(entity);

        roomDTO.setRemain(roomDTO.getRemain() - request.getNumberOfRooms());
        roomRepository.save(mapper.toEntity(roomDTO));
        return mapper.toDTO(save);
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
        return mapper.toDTO(repository.findById(id).orElseThrow(ParametersWrongException::new));
    }


    @Override
    public List<ReservationDTO> findByPersonId(UUID uuid) {
        PersonDTO person = personService.findById(uuid);
        List<ReservationEntity> reservations = person.getReservations();
        return mapper.toDTO(reservations);
    }
 /*    @Override
    public List<ReservationDTO> findByEmail(String email) {
        List<ReservationEntity> byEmail = repository.findByEmail(email);
        return mapper.toDTO(byEmail);

    }
    @Override
    public List<ReservationDTO> findAll() {
        List<ReservationEntity> all = repository.findAll();
        return mapper.toDTO(all);
    }

    @Override
    public PersonDTO getPersonById(UUID id) {
        ReservationDTO byId = findById(id);
        UUID personId = byId.getPersonId();
        return personService.findById(personId);
    }
     @Transactional
    @Override
    public ReservationDTO update(UUID id, ReservationDTO reservationDTO) {
        var byId = repository.findById(id).orElseThrow(ParametersWrongException::new);
        mapper.update(byId, reservationDTO);
        return mapper.toDTO(byId);
    }

   public Specification<StudentEntity> createSearchSpecification(StudentSearchService searchService) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            String name = searchService.getName();
            Integer age = searchService.getAge();
            University university = searchService.getUniversity();
            if (!name.isBlank()) {
                predicates.add(criteriaBuilder.equal(root.get("name"), name));

            }
            if (age != null) {
                predicates.add(criteriaBuilder.equal(root.get("age"), age));

            }

            if (university != null) {
                predicates.add(criteriaBuilder.equal(root.get("university"), university));

            }
            return criteriaBuilder.and(predicates.toArray(Predicate[]::new));
        };

    }*/


}
