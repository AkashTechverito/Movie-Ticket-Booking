package com.example.movieticketbooking.repository;

import com.example.movieticketbooking.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Integer> {
    @Query("select seat.seatNumber from Seat seat where seat.availability=true")
    ArrayList<Integer> findAvailableSeats();

    @Query("Update Seat SET Seat.availability = false where Seat.seatNumber=?1")
    void book(Integer seatNumber);

}
