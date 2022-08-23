package com.example.movieticketbooking.repository;

import com.example.movieticketbooking.model.Seat;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class SeatRepositoryTest {

    Seat seat1,seat2,seat3,seat4,seat5;

    @MockBean
    private SeatRepository seatRepository;


    @BeforeEach
    void setUp() {
        seat1 = new Seat(1, true);
        seat2 = new Seat(2, true);
        seat3 = new Seat(3, false);
        seat4 = new Seat(4, true);
        seat5 = new Seat(5, false);

       seatRepository.save(seat1);
       seatRepository.save(seat2);
       seatRepository.save(seat3);
       seatRepository.save(seat4);
       seatRepository.save(seat5);

    }

    @AfterEach
    void tearDown() {
        seatRepository.delete(seat1);
        seatRepository.delete(seat2);
        seatRepository.delete(seat3);
        seatRepository.delete(seat4);
        seatRepository.delete(seat5);
    }

    @Test
    void findAvailableSeats() {

        ArrayList<Integer> availableSeats = seatRepository.findAvailableSeats();

        Assertions.assertEquals(1,availableSeats.get(0));
        Assertions.assertEquals(2,availableSeats.get(1));
        Assertions.assertEquals(4,availableSeats.get(2));
}
}