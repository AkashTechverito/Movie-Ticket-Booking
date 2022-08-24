package com.example.movieticketbooking.controller;

import com.example.movieticketbooking.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class SeatController {

    @Autowired
    private SeatService seatService;

    @GetMapping("/seats/available")
    @ResponseStatus(HttpStatus.OK)
    public ArrayList<Integer> availableSeats() {
        return seatService.availableSeats();
    }
}