package com.example.anastasiia.drunkcards;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.content.res.TypedArrayUtils;
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

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Kings extends AppCompatActivity implements View.OnClickListener{

    ArrayList<String> array = new ArrayList<String>();
    String[] names = new String[array.size()];
    public static final String Tag = "Kings";
    int [] cards = {R.drawable.clubs_ace, R.drawable.clubs_king, R.drawable.clubs_queen, R.drawable.clubs_jack , R.drawable.clubs_ten, R.drawable.clubs_nine, R.drawable.clubs_eight, R.drawable.clubs_seven, R.drawable.clubs_six, R.drawable.clubs_five, R.drawable.clubs_four, R.drawable.clubs_three, R.drawable.clubs_two,
            R.drawable.diamonds_ace, R.drawable.diamonds_king, R.drawable.diamonds_queen, R.drawable.diamonds_jack, R.drawable.diamonds_ten, R.drawable.diamonds_nine, R.drawable.diamonds_eight, R.drawable.diamonds_seven, R.drawable.diamonds_six, R.drawable.diamonds_five, R.drawable.diamonds_four, R.drawable.diamonds_three, R.drawable.diamonds_two,
            R.drawable.hearts_ace, R.drawable.hearts_king, R.drawable.hearts_queen, R.drawable.hearts_jack, R.drawable.hearts_ten, R.drawable.hearts_nine, R.drawable.hearts_eight, R.drawable.hearts_seven, R.drawable.hearts_six, R.drawable.hearts_five, R.drawable.hearts_four, R.drawable.hearts_three, R.drawable.hearts_two,
            R.drawable.spades_ace, R.drawable.spades_king, R.drawable.spades_queen, R.drawable.spades_jack, R.drawable.spades_ten, R.drawable.spades_nine, R.drawable.spades_eight, R.drawable.spades_seven, R.drawable.spades_six, R.drawable.spades_five, R.drawable.spades_four, R.drawable.spades_three, R.drawable.spades_two};

    List<Integer> numlist = new ArrayList<Integer>();
    Random rand;
    int turn = 0;
    TextView tv;
    ListView lv;
    ArrayList<String> listItems = new ArrayList<String>();
    ArrayAdapter<String> adapter;
    EditText txt;
    String getRule = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kings);

        tv = (TextView)findViewById(R.id.set_name);

        for(int i = 0; i < cards.length; i ++){
            numlist.add(cards[i]);
        }


        lv = (ListView) findViewById(R.id.rule_set);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listItems);
        lv.setAdapter(adapter);

        this.setTitle("Kings");
        Button b = null;
        b = (Button)findViewById(R.id.kings_back);
        b.setOnClickListener(this);
        b = (Button)findViewById(R.id.kings_rules);
        b.setOnClickListener(this);
        b = (Button) findViewById(R.id.get_card_button);
        b.setOnClickListener(this);

    }

    @Override
    protected void onResume() {
        super.onResume();
        Intent i = getIntent();
        Bundle bu = i.getExtras();
        array = bu.getStringArrayList("Array");
        Log.e("Names in Kings: ", array.toString());
        names = array.toArray(names);

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
            case R.id.get_card_button : {
                int getTenClubs = R.drawable.clubs_ten;
                int getTenDiamonds = R.drawable.diamonds_ten;
                int getTenSpades = R.drawable.spades_ten;
                int getTenHearts = R.drawable.hearts_ten;

                int getEightClubs = R.drawable.clubs_eight;
                int getEightDiamonds = R.drawable.diamonds_eight;
                int getEightSpades = R.drawable.spades_eight;
                int getEightHearts = R.drawable.hearts_eight;

                int getKingClubs = R.drawable.clubs_king;
                int getKingDiamonds = R.drawable.diamonds_king;
                int getKingSpades = R.drawable.spades_king;
                int getKingHearts = R.drawable.hearts_king;

                int getNineClubs = R.drawable.clubs_nine;
                int getNineDiamonds = R.drawable.diamonds_nine;
                int getNineSpades = R.drawable.spades_nine;
                int getNineHearts = R.drawable.hearts_nine;

                rand = new Random();
                Integer randEl = numlist.get(rand.nextInt(numlist.size()));
                ImageView iv;
                iv = (ImageView)findViewById(R.id.card_view);
                iv.setImageResource(randEl);
                if(randEl == getTenClubs || randEl == getTenDiamonds || randEl == getTenHearts || randEl == getTenSpades){
                    txt  = new EditText(this);
                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
                    alertDialog.setTitle("Categories");
                    alertDialog.setMessage("Pick a category, and say something from that category");
                    alertDialog.setView(txt);
                    alertDialog.setPositiveButton("Add", new DialogInterface.OnClickListener(){

                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            getRule = txt.getText().toString();
                            listItems.add(getRule);
                        }
                    });
                    alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });

                    AlertDialog ad = alertDialog.show();
                    adapter.notifyDataSetChanged();
                } else if (randEl == getEightClubs || randEl == getEightDiamonds || randEl == getEightHearts || randEl == getEightSpades){
                    txt  = new EditText(this);
                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
                    alertDialog.setTitle("Mate");
                    alertDialog.setMessage("Pick a person to drink with");
                    alertDialog.setView(txt);
                    alertDialog.setPositiveButton("Add", new DialogInterface.OnClickListener(){
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            getRule = txt.getText().toString();
                            listItems.add(getRule);
                        }
                    });
                    alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });

                    AlertDialog ad = alertDialog.show();
                    adapter.notifyDataSetChanged();
                } else if (randEl == getNineClubs || randEl == getNineDiamonds || randEl == getNineHearts || randEl == getNineSpades){
                    txt  = new EditText(this);
                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
                    alertDialog.setTitle("Rhyme");
                    alertDialog.setMessage("Say a phrase, and everyone else must say phrases that rhyme");
                    alertDialog.setView(txt);
                    alertDialog.setPositiveButton("Add", new DialogInterface.OnClickListener(){
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            getRule = txt.getText().toString();
                            listItems.add(getRule);
                        }
                    });
                    alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });

                    AlertDialog ad = alertDialog.show();
                    adapter.notifyDataSetChanged();
                } else if (randEl == getKingClubs || randEl == getKingDiamonds || randEl == getKingHearts || randEl == getKingSpades){
                    txt  = new EditText(this);
                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
                    alertDialog.setTitle("Ruler");
                    alertDialog.setMessage("Make a rule that everyone must follow until the next King is drawn");
                    alertDialog.setView(txt);
                    alertDialog.setPositiveButton("Add", new DialogInterface.OnClickListener(){
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            getRule = txt.getText().toString();
                            listItems.add(getRule);
                        }
                    });
                    alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });

                    AlertDialog ad = alertDialog.show();
                    adapter.notifyDataSetChanged();
                }
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
            }
        }
    }

}
