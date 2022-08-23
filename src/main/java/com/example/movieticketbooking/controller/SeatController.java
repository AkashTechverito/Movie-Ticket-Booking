package com.example.movieticketbooking.controller;

import com.example.movieticketbooking.model.Seat;
import com.example.movieticketbooking.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class SeatController {

    @Autowired
    private SeatService seatService;

    @GetMapping("/seats/available")
    public ResponseEntity<Object> availableSeats() {

        ArrayList<Seat> availableSeats = seatService.availableSeats();

        return ResponseEntity.ok().body(availableSeats);
    }
}