package com.example.movieticketbooking.repository;

import com.example.movieticketbooking.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Integer> {
//    @Query("select seat from Seat seat where seat.availability = true")
    ArrayList<Seat> findAvailableSeats();
}
