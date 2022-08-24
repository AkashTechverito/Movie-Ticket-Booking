package com.example.movieticketbooking.repository;

import com.example.movieticketbooking.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Integer> {
    @Query("select seat.seatNumber from Seat seat where seat.availability=true")
    ArrayList<Integer> findAvailableSeats();

    @Modifying
    @Query("Update Seat seat SET seat.availability = false where seat.seatNumber=?1")
    void book(Integer seatNumber);

    @Query("Select seat.availability from Seat seat where seat.seatNumber=?1")
    boolean checkAvailability(Integer seatNumber);

}
