package com.example.movieticketbooking.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Seat {

    @Id
    Integer seatNumber;
    boolean availability;

}
