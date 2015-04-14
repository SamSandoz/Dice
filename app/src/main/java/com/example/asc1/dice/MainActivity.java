package com.example.asc1.dice;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;
import android.content.Intent;
import android.widget.ImageView;
import android.widget.ImageButton;



public class MainActivity extends ActionBarActivity {

    ImageView dice;
    ImageButton rollButton;
    EditText guessedNum;
    TextView mTextView;
    int g;
    String result;



    OnClickListener buttonListener = new OnClickListener() {
        @Override
        public void onClick(View v) {

             int num = ((int)(Math.random()*6)+1);
             guessedNum =(EditText) findViewById(R.id.guess);
             g = Integer.parseInt(guessedNum.getText().toString());


            switch(num){
                case 1:
                    dice.setImageResource(R.mipmap.dice1);
                    break;
                case 2:
                    dice.setImageResource(R.mipmap.dice2);
                    break;
                case 3:
                    dice.setImageResource(R.mipmap.dice3);
                    break;
                case 4:
                    dice.setImageResource(R.mipmap.dice4);
                    break;
                case 5:
                    dice.setImageResource(R.mipmap.dice5);
                    break;
                case 6:
                    dice.setImageResource(R.mipmap.dice6);
                    break;
            }

            if(num== g){
                result = "correct";

            }
            else
                result = "incorrect";

            mTextView.setText(result);




        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rollButton = (ImageButton) findViewById(R.id.button);
        dice = (ImageView) findViewById(R.id.result);
        mTextView = (TextView) findViewById(R.id.textView);
        guessedNum = (EditText) findViewById(R.id.guess);
        rollButton.setOnClickListener(buttonListener);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
