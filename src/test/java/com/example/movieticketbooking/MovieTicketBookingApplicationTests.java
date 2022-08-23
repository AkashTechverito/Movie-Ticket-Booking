package com.example.movieticketbooking;

import com.example.movieticketbooking.controller.SeatController;
import com.example.movieticketbooking.repository.SeatRepository;
import com.example.movieticketbooking.service.SeatService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
class MovieTicketBookingApplicationTests {

    @MockBean
    private SeatController seatController;

    @MockBean
    private SeatService seatService;

    @MockBean
    private SeatRepository seatRepository;

    @Test
    void contextLoads() {
    }

}
