package com.example.movieticketbooking.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="seats")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Seat {
    @Id
    private int seatNo;
    private boolean availability;
}
