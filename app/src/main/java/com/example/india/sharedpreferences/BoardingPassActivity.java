package com.example.india.sharedpreferences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.icu.text.BreakIterator;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class BoardingPassActivity extends AppCompatActivity {

    BoardingPassActivity boardingPassBinding;
    private DatabaseReference mDatabase;
    private DatabaseReference mRefBoardingPass;
    com.example.india.sharedpreferences.model.BoardingPass boardingPass;
    SharedPreferences sharedPreferences;
    LocationManager mLocationManager;
    private BreakIterator tvArrivalTime;
    private BreakIterator tvBordingTime,tvBordingInTime,tvDepartureTime,tvTerminal,tvGate,tvSeat,tvOrigin,tvDestination,tvFlightCode;
    private BreakIterator textView3;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.boarding_pass);
        sharedPreferences = getSharedPreferences("SrishtiLogin", MODE_PRIVATE);
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        mDatabase = FirebaseDatabase.getInstance().getReference();
        mRefBoardingPass = mDatabase.child("boardingPass");
        String userId = mRefBoardingPass.push().getKey();
        com.example.india.sharedpreferences.model.BoardingPass pass = new com.example.india.sharedpreferences.model.BoardingPass("10:40 AM", "00:15", "02:10 PM", "02:40 PM", "LAX", "58B", "SFO", "24A", "2","UDA 2465");
        mRefBoardingPass.child(userId).setValue(pass);
        boardingPassBinding.textView3.setText("MR. " + sharedPreferences.getString("userName", null));
        mRefBoardingPass.addValueEventListener(new ValueEventListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot boardingSnapshot : dataSnapshot.getChildren()) {
                    boardingPass = boardingSnapshot.getValue(com.example.india.sharedpreferences.model.BoardingPass.class);
                    boardingPassBinding.tvArrivalTime.setText(boardingPass.getArrival());
                    boardingPassBinding.tvBordingTime.setText(boardingPass.getBoardingTime());
                    boardingPassBinding.tvBordingInTime.setText(boardingPass.getBoardingIn());
                    boardingPassBinding.tvDepartureTime.setText(boardingPass.getDeparture());
                    boardingPassBinding.tvTerminal.setText(boardingPass.getTerminal());
                    boardingPassBinding.tvGate.setText(boardingPass.getGate());
                    boardingPassBinding.tvSeat.setText(boardingPass.getSeat());
                    boardingPassBinding.tvOrigin.setText(boardingPass.getOrigin());
                    boardingPassBinding.tvDestination.setText(boardingPass.getDestination());
                    boardingPassBinding.tvFlightCode.setText(boardingPass.getPlane());
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.i("error", databaseError.toString());
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        setContentView(R.layout.boarding_pass);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.miResPass:
                Intent intent = new Intent(BoardingPassActivity.this, Change.class);
                startActivity(intent);
            case R.id.miUseDet:
                Intent intent1 = new Intent(BoardingPassActivity.this, Details.class);
                startActivity(intent1);
            case R.id.miUserLoc:
                Intent intent2=new Intent(BoardingPassActivity.this,UserLocation.class);
                startActivity(intent2);
        }
        return true;
    }
}