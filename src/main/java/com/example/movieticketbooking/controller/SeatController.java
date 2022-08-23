package com.example.movieticketbooking.controller;

import com.example.movieticketbooking.model.Seat;
import com.example.movieticketbooking.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class SeatController {

    @Autowired
    private SeatService seatService;

    @GetMapping("/seats/available")
    public ResponseEntity<Object> availableSeats() {

        ArrayList<Integer> availableSeats = seatService.availableSeats();

        return ResponseEntity.ok().body(availableSeats);
    }
}