package com.example.controller;


import com.example.dto.*;
import com.example.entity.Country;
import com.example.entity.PersonEntity;
import com.example.service.HotelService;
import com.example.service.PersonService;
import com.example.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Controller
@RequestMapping
public class BookController {
    private final PersonService personService;
    private final HotelService hotelService;
    private final ReservationService reservationService;


    @GetMapping("/index")
    public String getIndex() {
        return "index";
    }

    @GetMapping("/orders")
    public ModelAndView getOrders() {
        ModelAndView modelAndView = new ModelAndView("/orders");
        UUID personId = personService.getPersonId();
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        modelAndView.addObject("name", name);
        List<ReservationDTO> byPersonId = reservationService.findByPersonId(personId);
        return modelAndView.addObject("reservations", byPersonId);

    }

    @GetMapping("/error_page")
    public String getError() {


        return "error_page";

    }

    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }

    @GetMapping("/test")
    public String getTestPage() {
        return "test";
    }
    @PostMapping("/login")
    public String postLogin(PersonDTO personDTO) {

        personService.savePerson(personDTO);

        return "login";
    }


    @GetMapping("/search")
    public ModelAndView getHotels(@RequestParam(name = "place") Country country, @RequestParam(name = "hotel", required = false) String hotelName) {
        ModelAndView modelAndView = new ModelAndView("result");
        modelAndView.addObject("country", country);
        if (hotelName != null && !hotelName.isBlank()) {
            modelAndView.addObject("byCountry", hotelService.findByNameAndCountry(hotelName.toUpperCase(), country));
        } else {
            modelAndView.addObject("byCountry", hotelService.findByCountry(country));
        }
        return modelAndView;

    }

    @GetMapping("/invoice")
    public ModelAndView getInvoice(@RequestParam("id") UUID id) {
        ModelAndView modelAndView = new ModelAndView("/invoice");
        ReservationDTO byId = reservationService.findById(id);
        modelAndView.addObject("reservation", byId);
        modelAndView.addObject("personName", SecurityContextHolder.getContext().getAuthentication().getName());
        return modelAndView;

    }
    @GetMapping("/deep")
    public ModelAndView deepSearch(@RequestParam(name = "start",required = false)Date start,@RequestParam(name = "finish",required = false)Date finish,@RequestParam(name = "location",required = false)Country country){
        ModelAndView modelAndView=new ModelAndView("/test");
        // List<DeepResponse> deepResponses = hotelService.deepSearch(/*startOfDate,finishOfDate,country,hotelName*/);
        return null;//modelAndView.addObject("free", deepResponses);
    }




    @GetMapping("/about")
    public String getAboutPage() {
        return "about";
    }

    @GetMapping("/blog")
    public String getBlogPage() {
        return "blog";
    }

    @GetMapping("/hotel")
    public String getHotelPage() {
        return "hotel";
    }

    @GetMapping("/blog-Barcelona")
    public String getTourPage() {
        return "blog-single-barcelona";
    }

    @GetMapping("/contact")
    public String getContactPage() {
        return "contact";
    }

    @GetMapping("/hotel-single")
    public String getHotelSinglePage() {
        return "hotel-single";
    }

    @GetMapping("/hotel-Barcelona")
    public String getHotelBarcelonaPage() {
        return "BARCELONA";
    }

    @GetMapping("/blog-single")
    public String getBlogSinglePage() {
        return "blog-single";
    }



    @GetMapping("/RoomHiltonBarcelona")
    public String getRoomHiltonBarcelona() {
        return "room-Hilton";
    }

    @GetMapping("/error_person_page")
    public String errorPersonPage() {
return "error_person_page";
    }
    @GetMapping("/error_reservation_page")
    public String errorReservationPage() {
        return "error_reservations_page";
    }

    @GetMapping("/hilton")
    public ModelAndView getHiltonPage(@RequestParam(name = "id") UUID id) {
        ModelAndView modelAndView = new ModelAndView("hotel-single");
        List<RoomDTO> roomById = hotelService.findRoomById(id);
        modelAndView.addObject("rooms", roomById);
        modelAndView.addObject("name", hotelService.findById(id).getName());
        return modelAndView;
    }




}
