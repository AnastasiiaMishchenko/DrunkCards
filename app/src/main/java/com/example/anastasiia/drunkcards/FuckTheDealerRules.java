package com.example.anastasiia.drunkcards;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class FuckTheDealerRules extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fuck_the_dealer_rules);

        this.setTitle("Fuck the dealer rules");

        Button b = null;
        b = (Button)findViewById(R.id.fuck_the_dealer_rules_back);
        b.setOnClickListener(this);

        TextView tv = (TextView)findViewById(R.id.fuck_the_dealer_rules_text);
        tv.setEnabled(false);
        tv.setTextColor(Color.BLACK);
        tv.setText(
                "\u2022     Someone starts off as the dealer.\n" +
                "\u2022     People get two guesses to guess the value of the top card on the deck. After the first guess, the dealer tells them if the card is higher or lower than their first guess. The dealer is not allowed to lie!\n" +
                "\u2022     Aces are low!\n" +
                "\u2022     If the player guesses correctly on the first guess the dealer takes 4 drinks. If guessed right on the second guess the dealer takes 2 drinks.\n" +
                "\u2022     Cards are then laid out on the table for people to see what’s left in the deck.\n" +
                "\u2022     If the player is still wrong on their second guess the player has to drink the difference between their second guess and the value of the card. E.g. if the player guessed 5 and the card was a 2, they would take 3 drinks.\n" +
                "\u2022     Once the dealer has beaten 3 people IN A ROW, the deck moves on clockwise to the next person.\n" +
                "\u2022     If someone guesses a card and all 4 are on the table they have to take a “dipshit” drink, which is 5 fingers.\n"
        );


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.fuck_the_dealer_rules_back : {
                finish();
            } break;
            default:
                Log.e(MainActivity.Tag, "Error");
        }
    }
}
