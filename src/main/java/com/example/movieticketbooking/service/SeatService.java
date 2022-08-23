package com.example.movieticketbooking.service;


import com.example.movieticketbooking.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class SeatService {
    @Autowired
    private SeatRepository seatRepository;

    public ArrayList<Integer> availableSeats() {
        return seatRepository.findAvailableSeats();
    }
}
