package com.example.controller;

import com.example.dto.PersonDTO;
import com.example.service.HotelService;
import com.example.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
@RequestMapping
public class BookController {
    private final PersonService personService;
    private final HotelService hotelService;

    @GetMapping
    public String getMainPage() {
   /*     ModelAndView modelAndView = new ModelAndView("StartPage");
        return modelAndView.addObject("hotels", hotelService.findAll());*/
        return "index";
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

    @GetMapping("/tour")
    public String getTourPage() {
        return "tour";
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
        return "hotel-Barcelona";
    }

    @GetMapping("/hotel-London")
    public String getHotelLondonPage() {
        return "hotel-London";
    }

    @GetMapping("/hotel-San_Francisco")
    public String getHotelSanPage() {
        return "hotel-San_Francisco";
    }

    @GetMapping("/hotel-Berlin")
    public String getHotelBerlinPage() {
        return "hotel-Berlin";
    }

    @GetMapping("/hotel-Paris")
    public String getHotelParisPage() {
        return "hotel-Paris";
    }

    @GetMapping("/RoomHiltonBarcelona")
    public String getRoomHiltonBarcelona() {
        return "room-HiltonBarcelona";
    }

    @PostMapping("/reg")
    public void create() {

    }

    @PostMapping("/public")
    public String save(PersonDTO personDTO) {
        personService.savePerson(personDTO);
        return "public";

    }

}
