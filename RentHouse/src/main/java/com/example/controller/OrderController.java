package com.example.controller;

import com.example.dto.CreateReservationRequest;
import com.example.dto.DeepRequest;
import com.example.dto.DeepResponse;
import com.example.dto.ReservationDTO;
import com.example.entity.Country;
import com.example.exception.ParametersWrongException;
import com.example.repository.HotelRepository;
import com.example.service.HotelService;
import com.example.service.ReservationService;
import com.example.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@RequiredArgsConstructor
@Controller
@RequestMapping("/order")
public class OrderController {

    private final ReservationService reservationService;
    private final RoomService roomService;
    private final HotelService hotelService;

    @PostMapping("/create")
    public ModelAndView saveOrder(@RequestParam (name = "id")UUID id, CreateReservationRequest request) {

        ModelAndView modelAndView = new ModelAndView("success");
        ReservationDTO reservation = reservationService.createReservation(id, request);
        modelAndView.addObject("reservationId",reservation.getId());
        return modelAndView;
    }

    @GetMapping()
    public ModelAndView getOrder(@RequestParam(name = "id",required = false) UUID id) {
        ModelAndView modelAndView = new ModelAndView("/order");
        modelAndView.addObject("room", roomService.findById(id));
        return modelAndView;
    }

 @GetMapping("/deep")
 public ModelAndView deepSearch(DeepRequest request/*@RequestParam(name = "name",required = false) String name ,@RequestParam(name = "location",required = false)Country location,@RequestParam(name = "start",required = false) Date start, @RequestParam(name = "finish",required = false) Date finish */){
        ModelAndView modelAndView=new ModelAndView("/deep");
    List<DeepResponse> deepResponses = hotelService.deepSearch(request);
     return modelAndView.addObject("free", deepResponses);
 }



    @GetMapping("/delete")
    public String deleteOrder(@RequestParam(name = "id") UUID uuid) {

            reservationService.deleteById(uuid);

        return "redirect:/orders";
    }

    @GetMapping("/invoice")
    public ModelAndView getInvoice() {
        ModelAndView modelAndView = new ModelAndView("/invoice");

        return modelAndView;

    }


}