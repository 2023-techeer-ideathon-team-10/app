package com.example.team_10.seat.seatDB;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.team_10.seat.seatDB.SeatEntity;

import java.util.List;

@Dao
public interface SeatDao {

    @Insert
    void insert(SeatEntity seat);

    @Update
    void update(SeatEntity seat);

    @Delete
    void delete(SeatEntity seat);

    @Query("SELECT * FROM seats")
    List<SeatEntity> getAllSeats();
}