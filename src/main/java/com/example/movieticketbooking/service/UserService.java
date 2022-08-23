package com.example.movieticketbooking.service;

import com.example.movieticketbooking.model.Ticket;
import com.example.movieticketbooking.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {
    @Autowired
    private SeatRepository seatRepository;

    public Ticket bookTicket(Integer seatNumber) {
        ArrayList<Integer> availableSeats = seatRepository.findAvailableSeats();
        if(availableSeats.contains(seatNumber))
        seatRepository.book(seatNumber);
        else
            throw new RuntimeException("Seat not available");
        return new Ticket(1, seatNumber);
    }
}
