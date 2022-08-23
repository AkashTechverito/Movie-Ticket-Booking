package com.example.movieticketbooking.controller;


import com.example.movieticketbooking.model.Seat;
import com.example.movieticketbooking.service.SeatService;
import com.example.movieticketbooking.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@WebMvcTest
public class SeatControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;
    @MockBean
    private SeatService seatService;

    @Test
    void shouldInvokeAvailableSeats() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/seats/available"))
                .andExpect(MockMvcResultMatchers.status().isOk());

        verify(seatService).availableSeats();
    }

    @Test
    void shouldReturnListOfAvailableSeats() throws Exception {

        //Arrange
        ArrayList<Integer> availableSeats = new ArrayList<>();
        availableSeats.add(1);
        availableSeats.add(2);

        //Act
        when(seatService.availableSeats()).thenReturn(availableSeats);

        //Assert
        mockMvc.perform(MockMvcRequestBuilders.get("/seats/available"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                        .andExpect(MockMvcResultMatchers.jsonPath("$[0]").value(1))
                        .andExpect(MockMvcResultMatchers.jsonPath("$[1]").value(2));

        verify(seatService).availableSeats();
    }


}
