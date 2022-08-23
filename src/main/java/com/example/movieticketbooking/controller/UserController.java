package com.example.movieticketbooking.controller;

import com.example.movieticketbooking.model.Ticket;
import com.example.movieticketbooking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/book/{seatNumber}")
    @ResponseStatus(HttpStatus.OK)
    public Ticket bookTicket(@PathVariable Integer seatNumber) {
     return userService.bookTicket(seatNumber);
    }
}
