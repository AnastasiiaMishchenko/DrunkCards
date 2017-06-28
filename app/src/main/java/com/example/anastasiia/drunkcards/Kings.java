package com.example.anastasiia.drunkcards;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Kings extends AppCompatActivity implements View.OnClickListener{

    ArrayList<String> array = new ArrayList<String>();
    public static final String Tag = "Kings";
    Map<String, String> cards = new HashMap<String, String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kings);

        this.setTitle("Kings");
        Button b = null;
        b = (Button)findViewById(R.id.kings_back);
        b.setOnClickListener(this);
        b = (Button)findViewById(R.id.kings_rules);
        b.setOnClickListener(this);

        setCards();

    }

    @Override
    protected void onResume() {
        super.onResume();
        Intent i = getIntent();
        Bundle bu = i.getExtras();
        array = bu.getStringArrayList("Array");
        Log.e("Names in Kings: ", array.toString());

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.kings_back : {
                finish();
            } break;
            case R.id.kings_rules : {
                Intent i = new Intent(this, KingsRules.class);
                startActivity(i);
            } break;
            default:
                Log.e(Tag, "Error, invalid button");
        }
    }


    public void setCards(){
        cards.put("clubs_ace", "Ace clubs");
        cards.put("clubs_king", "King clubs");
        cards.put("clubs_queen", "Queen clubs");
        cards.put("clubs_jack", "Jack clubs");
        cards.put("clubs_ten", "Ten clubs");
        cards.put("clubs_nine", "Nine clubs");
        cards.put("clubs_eight", "Eight clubs");
        cards.put("clubs_seven", "Seven clubs");
        cards.put("clubs_six", "Six clubs");
        cards.put("clubs_five", "Five clubs");
        cards.put("clubs_four", "Four clubs");
        cards.put("clubs_three", "Three clubs");
        cards.put("clubs_two", "Two clubs");

        cards.put("diamonds_ace", "Ace diamonds");
        cards.put("diamonds_king", "King diamonds");
        cards.put("diamonds_queen", "Queen diamonds");
        cards.put("diamonds_jack", "Jack diamonds");
        cards.put("diamonds_ten", "Ten diamonds");
        cards.put("diamonds_nine", "Nine diamonds");
        cards.put("diamonds_eight", "Eight diamonds");
        cards.put("diamonds_seven", "Seven diamonds");
        cards.put("diamonds_six", "Six diamonds");
        cards.put("diamonds_five", "Five diamonds");
        cards.put("diamonds_four", "Four diamonds");
        cards.put("diamonds_three", "Three diamonds");
        cards.put("diamonds_two", "Two diamonds");

        cards.put("hearts_ace", "Ace hearts");
        cards.put("hearts_king", "King hearts");
        cards.put("hearts_queen", "Queen hearts");
        cards.put("hearts_jack", "Jack hearts");
        cards.put("hearts_ten", "Ten hearts");
        cards.put("hearts_nine", "Nine hearts");
        cards.put("hearts_eight", "Eight hearts");
        cards.put("hearts_seven", "Seven hearts");
        cards.put("hearts_six", "Six hearts");
        cards.put("hearts_five", "Five hearts");
        cards.put("hearts_four", "Four hearts");
        cards.put("hearts_three", "Three hearts");
        cards.put("hearts_two", "Two hearts");

        cards.put("spades_ace", "Ace spades");
        cards.put("spades_king", "King spades");
        cards.put("spades_queen", "Queen spades");
        cards.put("spades_jack", "Jack spades");
        cards.put("spades_ten", "Ten spades");
        cards.put("spades_nine", "Nine spades");
        cards.put("spades_eight", "Eight spades");
        cards.put("spades_seven", "Seven spades");
        cards.put("spades_six", "Six spades");
        cards.put("spades_five", "Five spades");
        cards.put("spades_four", "Four spades");
        cards.put("spades_three", "Three spades");
        cards.put("spades_two", "Two spades");
    }
}
