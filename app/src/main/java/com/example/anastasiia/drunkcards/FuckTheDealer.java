package com.example.anastasiia.drunkcards;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FuckTheDealer extends AppCompatActivity implements View.OnClickListener{

    ArrayList<String> array = new ArrayList<String>();
    String[] names = new String[array.size()];

    public static final String Tag = "Fuck the dealer";
    int [] cards = {R.drawable.clubs_ace, R.drawable.clubs_king, R.drawable.clubs_queen, R.drawable.clubs_jack , R.drawable.clubs_ten, R.drawable.clubs_nine, R.drawable.clubs_eight, R.drawable.clubs_seven, R.drawable.clubs_six, R.drawable.clubs_five, R.drawable.clubs_four, R.drawable.clubs_three, R.drawable.clubs_two,
            R.drawable.diamonds_ace, R.drawable.diamonds_king, R.drawable.diamonds_queen, R.drawable.diamonds_jack, R.drawable.diamonds_ten, R.drawable.diamonds_nine, R.drawable.diamonds_eight, R.drawable.diamonds_seven, R.drawable.diamonds_six, R.drawable.diamonds_five, R.drawable.diamonds_four, R.drawable.diamonds_three, R.drawable.diamonds_two,
            R.drawable.hearts_ace, R.drawable.hearts_king, R.drawable.hearts_queen, R.drawable.hearts_jack, R.drawable.hearts_ten, R.drawable.hearts_nine, R.drawable.hearts_eight, R.drawable.hearts_seven, R.drawable.hearts_six, R.drawable.hearts_five, R.drawable.hearts_four, R.drawable.hearts_three, R.drawable.hearts_two,
            R.drawable.spades_ace, R.drawable.spades_king, R.drawable.spades_queen, R.drawable.spades_jack, R.drawable.spades_ten, R.drawable.spades_nine, R.drawable.spades_eight, R.drawable.spades_seven, R.drawable.spades_six, R.drawable.spades_five, R.drawable.spades_four, R.drawable.spades_three, R.drawable.spades_two};

    List<Integer> numlist = new ArrayList<Integer>();
    Random rand;
    int turn = 0;
    TextView tv;

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
        b = (Button)findViewById(R.id.get_card);
        b.setOnClickListener(this);

        tv = (TextView)findViewById(R.id.set_player_name);

        for(int i = 0; i < cards.length; i ++){
            numlist.add(cards[i]);
        }

    }


    @Override
    protected void onResume() {
        super.onResume();
        Intent i = getIntent();
        Bundle bu = i.getExtras();
        array = bu.getStringArrayList("Array");
        Log.e("Names fuck the dealer: ", array.toString());
        names = array.toArray(names);

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
            case R.id.get_card : {
                rand = new Random();
                Integer randEl = numlist.get(rand.nextInt(numlist.size()));
                ImageView iv;
                iv = (ImageView)findViewById(R.id.set_card);
                iv.setImageResource(randEl);
                numlist.remove(randEl);
                int temp = numlist.size();
                Log.e(Tag, "Size of new array is " + String.valueOf(temp));
                if(temp == 0){
                    Toast.makeText(getApplicationContext(), "Game is over", Toast.LENGTH_SHORT).show();
                    Intent intent = getIntent();
                    finish();
                    startActivity(intent);
                }
                turn++;
                Log.e(Tag, "Now it is " + String.valueOf(turn) + " turn");
                String setName = names[turn%array.size()];
                tv.setText("Now it is " + setName + "'s turn!");
            } break;
        }
    }
}
