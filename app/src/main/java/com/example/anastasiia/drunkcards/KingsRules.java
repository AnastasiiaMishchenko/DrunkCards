package com.example.anastasiia.drunkcards;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;

public class KingsRules extends AppCompatActivity implements View.OnClickListener{

    public static final String Tag = "Kings rules ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kings_rules);
        this.setTitle("Kings rules");


        Button b = null;
        b = (Button)findViewById(R.id.kings_rules_back);
        b.setOnClickListener(this);



        TextView tv = (TextView)findViewById(R.id.kings_rules_text);
        tv.setEnabled(false);
        tv.setTextColor(Color.BLACK);
        tv.setText(
                "\u2022     Ace:Waterfall - Every player begins drinking, and no one can stop until the player before them does\n" +
                "\u2022     2: You - Whoever drew the card assigns a drink\n" +
                "\u2022     3: Me - Whoever drew the card drinks\n" +
                "\u2022     4: Floor - Everyone races to touch the floor, last person to do so drinks\n" +
                "\u2022     5: Guys - All guys drink\n" +
                "\u2022     6: Chicks - All girls drink\n" +
                "\u2022     7: Heaven - All players point towards the sky, last player to do so drinks\n" +
                "\u2022     8: Mate - Pick a person to drink with\n" +
                "\u2022     9: Rhyme - Say a phrase, and everyone else must say phrases that rhyme\n" +
                "\u2022     10: Categories - Pick a category, and say something from that category (i.e. if \"drinking games\" was the category, \"kings\" would be a viable answer.\n" +
                "\u2022     Jack: Never have I ever - Each player puts up 3 fingers, then starting with the person who drew the card, each player says \"never have I ever «something»\". If you've done it, you put a finger down, until someone loses\n" +
                "\u2022     Queen: Questions - The person who drew the card asks a random person a question, and they then turn and ask a random person a question, until someone loses by either failing to ask a question or by responding to the person who just asked them a question\n" +
                "\u2022     King: Ruler - Make a rule that everyone must follow until the next King is drawn (i.e. force everyone to drink after each turn)\n"
        );


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.kings_rules_back : {
                finish();
            } break;
            default: Log.e(Tag, "Error invalid button");
        }

    }
}
