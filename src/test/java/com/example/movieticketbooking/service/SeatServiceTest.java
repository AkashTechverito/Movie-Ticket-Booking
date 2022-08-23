package com.example.movieticketbooking.service;

import com.example.movieticketbooking.model.Seat;
import com.example.movieticketbooking.repository.SeatRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;

import static org.mockito.Mockito.when;

@SpringBootTest
class SeatServiceTest {

    @MockBean
    private SeatRepository seatRepository;
    @Autowired
    private SeatService seatService;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void shouldReturnAvailableSeats() {
        Seat seat = new Seat(1, true);
        Seat anotherSeat = new Seat(2, true);
        ArrayList<Seat> availableSeats = new ArrayList<>();
        availableSeats.add(seat);
        availableSeats.add(anotherSeat);

        seatRepository.save(seat);
        seatRepository.save(anotherSeat);

        when(seatRepository.findAvailableSeats()).thenReturn((availableSeats));

        ArrayList<Seat> expectedAvailableSeats = seatService.availableSeats();


        Assertions.assertEquals(expectedAvailableSeats, availableSeats);

    }

    @Test
    void shouldNotReturnBookedSeats() {
        Seat seat = new Seat(1, false);
        Seat anotherSeat = new Seat(2, true);
        ArrayList<Seat> availableSeats = new ArrayList<>();
        availableSeats.add(anotherSeat);

        seatRepository.save(seat);
        seatRepository.save(anotherSeat);

        when(seatRepository.findAvailableSeats()).thenReturn((availableSeats));

        ArrayList<Seat> expectedAvailableSeats = seatService.availableSeats();

        Assertions.assertEquals(availableSeats, expectedAvailableSeats);

    }

}