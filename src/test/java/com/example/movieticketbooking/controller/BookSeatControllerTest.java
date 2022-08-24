package com.example.movieticketbooking.controller;

import com.example.movieticketbooking.model.Ticket;
import com.example.movieticketbooking.service.BookSeatService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@WebMvcTest(controllers = BookSeatController.class)
public class BookSeatControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookSeatService bookSeatService;

    @Test
    void shouldInvokeBookSeat() throws Exception {
        Integer seatNumber = 1;
        mockMvc.perform(MockMvcRequestBuilders.post("/book/{seatNumber}", seatNumber)
                .contentType(MediaType.APPLICATION_JSON)
                .content(String.valueOf(seatNumber))).andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    void shouldReturnTicketWithSeatNumber_1_WhenSeatIsBooked() throws Exception {
        Integer seatNumber = 1;
        when(bookSeatService.bookSeat(seatNumber)).thenReturn(new Ticket(1, seatNumber));
        mockMvc.perform(MockMvcRequestBuilders.post("/book/{seatNumber}", seatNumber)
                .contentType(MediaType.APPLICATION_JSON)
                .content(String.valueOf(seatNumber))).andExpect(MockMvcResultMatchers.jsonPath("$.seatNumber").value("1"));

        verify(bookSeatService).bookSeat(seatNumber);
    }

    @Test
    void shouldReturnTicketWithSeatNumber_2_WhenSeatIsBooked() throws Exception {
        Integer seatNumber = 2;
        when(bookSeatService.bookSeat(seatNumber)).thenReturn(new Ticket(1, seatNumber));
        mockMvc.perform(MockMvcRequestBuilders.post("/book/{seatNumber}", seatNumber)
                .contentType(MediaType.APPLICATION_JSON)
                .content(String.valueOf(seatNumber))).andExpect(MockMvcResultMatchers.jsonPath("$.seatNumber").value("2"));

        verify(bookSeatService).bookSeat(seatNumber);
    }
}
