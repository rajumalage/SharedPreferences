package com.example.india.sharedpreferences;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

public class BoardingPass extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.boarding_pass);
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
                Intent intent = new Intent(BoardingPass.this, Change.class);
                startActivity(intent);
            case R.id.miUseDet:
                Intent intent1 = new Intent(BoardingPass.this, Details.class);
                startActivity(intent1);
            case R.id.miUserLoc:
                Intent intent2=new Intent(BoardingPass.this,UserLocation.class);
                startActivity(intent2);
        }
        return true;
    }
}