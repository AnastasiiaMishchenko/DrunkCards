package com.example.anastasiia.drunkcards;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class FuckTheDealer extends AppCompatActivity implements View.OnClickListener{

    ArrayList<String> array = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fuck_the_dealer);

        this.setTitle("Fuck the dealer");

        Button b = null;
        b = (Button)findViewById(R.id.fuck_the_dealer_back);
        b.setOnClickListener(this);
        b = (Button)findViewById(R.id.fuck_the_dealer_rules);
        b.setOnClickListener(this);
    }


    @Override
    protected void onResume() {
        super.onResume();
        Intent i = getIntent();
        Bundle bu = i.getExtras();
        array = bu.getStringArrayList("Array");
        Log.e("Names fuck the dealer: ", array.toString());

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.fuck_the_dealer_back: {
                finish();
            } break;
            case R.id.fuck_the_dealer_rules: {
                Intent i = new Intent(this, FuckTheDealerRules.class);
                startActivity(i);
            } break;
            default:
                Log.e(MainActivity.Tag, "Error");
        }
    }
}
