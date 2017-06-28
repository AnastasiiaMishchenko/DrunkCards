package com.example.anastasiia.drunkcards;

import android.content.Context;
import android.content.Intent;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    public static final String Tag = "Drunk cards";
    public static final int key = 1;
    ArrayList<String> nameArray = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b = null;
        b = (Button)findViewById(R.id.start_game);
        b.setOnClickListener(this);



        ((EditText)findViewById(R.id.number_of_players)).setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
                if(actionId == EditorInfo.IME_ACTION_DONE || textView.getText().length() > 0) {
                    createTextFields(Integer.parseInt(textView.getText().toString()));
                    InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(textView.getWindowToken(), 0);
                } else if (textView.getText().length() == 0 ){
                    Toast.makeText(getApplicationContext(), "Invalid input", Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        });

    }

    private void createTextFields(int count) {
        for(int i = 0; i < count; ++i) {
            EditText textField = new EditText(this);
            textField.setId(i);
            ((LinearLayout)findViewById(R.id.users_layout)).addView(textField);
        }
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.start_game : {
                if (((EditText)findViewById(R.id.number_of_players)).getText().length() == 0 ){
                    Toast.makeText(getApplicationContext(), "Invalid input", Toast.LENGTH_SHORT).show();
                } else {
                    printNames();
                    Intent i = new Intent(MainActivity.this, ChooseGameActivity.class);
                    i.putExtra("Array", nameArray);
                    startActivity(i);
                }

            } break;
            default: Log.e(Tag, "Invalid type");
        }
    }

    public void printNames(){
        int count = Integer.parseInt(((EditText)findViewById(R.id.number_of_players)).getText().toString());
        for(int i = 0; i < count; i++){
            nameArray.add(((EditText)findViewById(i)).getText().toString());
        }
    }
}
