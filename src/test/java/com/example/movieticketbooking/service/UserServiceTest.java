package com.example.movieticketbooking.service;

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
    @Autowired
    private UserService userService;
    @MockBean
    private SeatRepository seatRepository;

    @Test
    void shouldInvokeBookSeatNumberWhenSeatIsAvailable(){
        Integer seatNumber = 1;
        when(seatRepository.checkAvailability(seatNumber)).thenReturn(true);

        userService.bookTicket(seatNumber);

        verify(seatRepository).book(seatNumber);
    }
    @Test
    void shouldThrowErrorWhenSeatIsNotAvailable(){
        Integer seatNumber = 1;
        RuntimeException exception = assertThrows(RuntimeException.class, () -> userService.bookTicket(seatNumber));
        assertEquals("Seat not available",exception.getMessage());
    }

}
