package com.example.team_10.seat.seatDB;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "seats")
public class SeatEntity {

    @PrimaryKey
    @NonNull
    private String seatId;
    private String userId;
    private boolean occupied;

    public SeatEntity(String seatId, String userId, boolean occupied) {
        this.seatId = seatId;
        this.userId = userId;
        this.occupied = occupied;
    }

    public String getSeatId() {
        return seatId;
    }

    public void setSeatId(String seatId) {
        this.seatId = seatId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String seatId) {
        this.userId = userId;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }
}