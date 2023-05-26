package com.example.team_10;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.room.Room;

import com.example.team_10.qrscanner.QRFragment;
import com.example.team_10.seat.SeatFragment;
import com.example.team_10.seat.seatDB.SeatDao;
import com.example.team_10.seat.seatDB.SeatDatabase;

import com.example.team_10.R;
import com.example.team_10.seat.seatDB.SeatEntity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private SeatDatabase seatDatabase;
    private SeatDao seatDao;
    private static final String DATABASE_NAME = "seats-database";
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ///////

        seatDatabase = Room.databaseBuilder(getApplicationContext(), SeatDatabase.class, DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build();
        seatDao = seatDatabase.seatDao();
        for (int i = 1; i <= 20; i++) {
            String id = String.valueOf(i);
            boolean occupied = false; // Set initial value as required
            SeatEntity seat = new SeatEntity(id, occupied);
            seatDao.update(seat);
        }
        ///////

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(navItemSelectedListener);

        // Set QRFragment as the default fragment
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainer, new QRFragment())
                .commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch (item.getItemId()) {
                        case R.id.nav_qr:
                            selectedFragment = new QRFragment();
                            break;
                        case R.id.nav_seat:
                            selectedFragment = new SeatFragment();
                            break;
                    }

                    if (selectedFragment != null) {
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.fragmentContainer, selectedFragment)
                                .commit();
                        return true;
                    } else {
                        return false;
                    }
                }
            };
}