package com.example.team_10.seat.seatDB;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.team_10.seat.seatDB.SeatEntity;

import java.util.List;

@Dao
public interface SeatDao {

    @Insert
    void insert(SeatEntity seat);

    @Query("SELECT * FROM seats")
    List<SeatEntity> getAllSeats();
}