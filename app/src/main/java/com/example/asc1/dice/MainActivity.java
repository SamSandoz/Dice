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
    Button clear;
    EditText guessedNum;
    TextView mTextView;
    TextView wrong;
    TextView right;
    int g;
    String result;
    int countR=0;
    int countW =0;


    OnClickListener buttonListener = new OnClickListener() {
        @Override
        public void onClick(View v) {

             int num = ((int)(Math.random()*6)+1);
             guessedNum =(EditText) findViewById(R.id.guess);
             g = Integer.parseInt(guessedNum.getText().toString());
       // if(!guessedNum.equals(null)) {
            switch (num) {
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

            if (num == g) {
                result = "correct";
                countR++;

            } else {
                result = "incorrect";
                countW++;
            }

            mTextView.setText(result);
            wrong.setText(""+countW);
            right.setText(""+countR);
       // }
        //    else
      //  {
       //     mTextView.setText("Hey put a number in");
      //  }




        }
    };
    OnClickListener clearListener = new OnClickListener() {
        @Override
        public void onClick(View v) {

            countR =0;
            countW =0;
            wrong.setText("" +countW);
            right.setText("" +countR);
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
        wrong = (TextView) findViewById(R.id.wrong);
        right = (TextView) findViewById(R.id.right);
        clear = (Button) findViewById(R.id.clear);

        rollButton.setOnClickListener(buttonListener);
        clear.setOnClickListener(clearListener);



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
