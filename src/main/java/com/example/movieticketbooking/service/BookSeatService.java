package com.example.movieticketbooking.service;

import com.example.movieticketbooking.model.Ticket;
import com.example.movieticketbooking.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookSeatService {
    @Autowired
    private SeatRepository seatRepository;
    public Ticket bookSeat(Integer seatNumber) {
        if(seatRepository.checkAvailability(seatNumber)) {
            seatRepository.book(seatNumber);
            return new Ticket(1, seatNumber);
        }
        else
            throw new RuntimeException("Seat not available");
    }

}
