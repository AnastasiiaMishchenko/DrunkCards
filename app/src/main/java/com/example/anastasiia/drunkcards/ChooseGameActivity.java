package com.example.anastasiia.drunkcards;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class ChooseGameActivity extends AppCompatActivity implements View.OnClickListener{

    ArrayList<String> array = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_game);

        this.setTitle("Choose your game");

        Button b = null;
        b = (Button)findViewById(R.id.button_back);
        b.setOnClickListener(this);
        b = (Button)findViewById(R.id.fuck_the_dealer);
        b.setOnClickListener(this);
        b = (Button)findViewById(R.id.kings);
        b.setOnClickListener(this);

        Intent i = getIntent();
        Bundle bu = i.getExtras();
        if (bu!= null) {
            array = bu.getStringArrayList("Array");
        }
        Log.e("Names in choose game: ", array.toString());
    }


    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button_back: {
                Intent i = new Intent(ChooseGameActivity.this, MainActivity.class);
                startActivity(i);
            } break;
            case R.id.fuck_the_dealer: {
                Intent i = new Intent(ChooseGameActivity.this, FuckTheDealer.class);
                i.putExtra("Array", array);
                startActivity(i);
            } break;
            case R.id.kings: {
                Intent i = new Intent(ChooseGameActivity.this, Kings.class);
                i.putExtra("Array", array);
                startActivity(i);
            } break;
            default:
                Log.e(MainActivity.Tag, "Error");
        }
    }
}
