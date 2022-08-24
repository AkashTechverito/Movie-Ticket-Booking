package com.example.movieticketbooking.controller;

import com.example.movieticketbooking.model.Ticket;
import com.example.movieticketbooking.repository.SeatRepository;
import com.example.movieticketbooking.service.SeatService;
import com.example.movieticketbooking.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.*;

@WebMvcTest(controllers = UserController.class)
public class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    void shouldInvokeBookTicket() throws Exception {
        Integer seatNumber = 1;
        mockMvc.perform(MockMvcRequestBuilders.post("/book/{seatNumber}", seatNumber)
                .contentType(MediaType.APPLICATION_JSON)
                .content(String.valueOf(seatNumber))).andExpect(MockMvcResultMatchers.status().isOk());

        verify(userService).bookTicket(seatNumber);
    }

    @Test
    void shouldReturnTicketWithSeatNumber_1_WhenItIsBooked() throws Exception {
        Integer seatNumber = 1;
        when(userService.bookTicket(seatNumber)).thenReturn(new Ticket(1, seatNumber));
        mockMvc.perform(MockMvcRequestBuilders.post("/book/{seatNumber}", seatNumber)
                .contentType(MediaType.APPLICATION_JSON)
                .content(String.valueOf(seatNumber))).andExpect(MockMvcResultMatchers.jsonPath("$.seatNumber").value("1"));

    }

    @Test
    void shouldReturnTicketWithSeatNumber_2_WhenItIsBooked() throws Exception {
        Integer seatNumber = 2;
        when(userService.bookTicket(seatNumber)).thenReturn(new Ticket(1, seatNumber));
        mockMvc.perform(MockMvcRequestBuilders.post("/book/{seatNumber}", seatNumber)
                .contentType(MediaType.APPLICATION_JSON)
                .content(String.valueOf(seatNumber))).andExpect(MockMvcResultMatchers.jsonPath("$.seatNumber").value("2"));
    }
}
