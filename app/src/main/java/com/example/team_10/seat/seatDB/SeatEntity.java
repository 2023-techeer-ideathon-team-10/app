package com.example.team_10.seat.seatDB;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "seats")
public class SeatEntity {

    @PrimaryKey
    @NonNull
    private String id;
    private boolean occupied;

    public SeatEntity(String id, boolean occupied) {
        this.id = id;
        this.occupied = occupied;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }
}