package com.example.team_10.seat.seatDB;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.team_10.seat.seatDB.SeatEntity;

@Database(entities = {SeatEntity.class}, version = 1)
public abstract class SeatDatabase extends RoomDatabase {

    public abstract SeatDao seatDao();
}