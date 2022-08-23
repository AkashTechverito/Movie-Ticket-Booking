package com.example.movieticketbooking.service;

import com.example.movieticketbooking.controller.SeatController;
import com.example.movieticketbooking.controller.UserController;
import com.example.movieticketbooking.repository.SeatRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;


@SpringBootTest
public class UserServiceTest {

    @MockBean
    private SeatController seatController;
    @MockBean
    private UserController userController;
    @Autowired
    private UserService userService;
    @MockBean
    private SeatRepository seatRepository;
    @MockBean
    private SeatService seatService;

    @Test
    void shouldInvokeBookSeatNumberWhenSeatIsAvailable(){
        ArrayList<Integer> seats = new ArrayList<>();
        seats.add(1);
        when(seatRepository.findAvailableSeats()).thenReturn(seats);
        Integer seatNumber = 1;
        userService.bookTicket(seatNumber);
        verify(seatRepository,times(1)).book(seatNumber);
    }
    @Test
    void shouldThrowErrorWhenSeatIsNotAvailable(){
        Integer seatNumber = 1;
        RuntimeException exception = assertThrows(RuntimeException.class, () -> userService.bookTicket(seatNumber));
        assertEquals("Seat not available",exception.getMessage());

    }

}
