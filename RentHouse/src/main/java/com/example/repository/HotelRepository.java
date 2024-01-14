package com.example.repository;

import com.example.dto.CreateFindHotelRequest;
import com.example.dto.DeepRequest;
import com.example.dto.DeepResponse;
import com.example.entity.Country;
import com.example.entity.HotelEntity;
import com.example.entity.ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface HotelRepository extends JpaRepository<HotelEntity, UUID> {

    @Query(nativeQuery = true, value = "select * from (\n" +
            "select hh.\"name\", hh.country, ro.name as room_category, coalesce( hr.room_count - sum(number_of_rooms), sum(number_of_rooms) ) as free, room_price\t  \n" +
            "from reservation r,  hotel hh, room ro\n" +
            "left join lateral (\n" +
            "select * from hotel_room hr where hr.hotel_id = hh.id and hr.room_category = ro.\"name\"\n" +
            ") hr on true   \n" +
            "where  hh.id = ro.hotel_id\n" +
            "and r.room_id = ro.id\n" +
            "and (?2 is null or ?2 >= r.start_of_date ) \n" +
            "and (?3 is null or ?3 < r.finish_of_date )\n" +
            "group by 1,2,3, hr.room_count, hr.room_price \n" +
            ") res \n" +
            "where res.free > 0\n" +
            "and (?1 is null or upper(res.name) = upper(?1))\n" +
            "and (?4   is null or upper(res.country) = upper(?4) )")
    List<DeepResponse> findByOther(String hotelName,LocalDate startDate,LocalDate finishDate,String location);

    List<HotelEntity> findAll();


    List<HotelEntity> findByCountry(Country country);

    List<HotelEntity> findByNameAndCountry(String name, Country country);



}
