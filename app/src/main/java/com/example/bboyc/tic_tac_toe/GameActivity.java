package com.example.bboyc.tic_tac_toe;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;

    Button[] bArray;

     public boolean playerTurn = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.board);

        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);

        bArray = new Button[]{
                button1,
                button2,
                button3,
                button4,
                button5,
                button5,
                button6,
                button7,
                button8,
                button9};

        for (Button turn : bArray) {

            turn.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View view) {
        Button playerTurn = (Button) view;

        buttonClicked(playerTurn);
    }

    public void buttonClicked(Button turn) {

        if (playerTurn) {
            turn.setText("O");
        } else {
            turn.setText("X");
        }
        turn.setClickable(false);

        playerTurn = !playerTurn;

        result();
    }

    private void result() {
        boolean choice = false;

        if (button1.getText() == button2.getText() && button2.getText() == button3.getText())
            choice = true;

        else if (button7.getText() == button5.getText() && button5.getText() == button6.getText())
            choice = true;
        else if (button4.getText() == button8.getText() && button8.getText() == button9.getText())
            choice = true;

        //vertical outcomes

        if (button1.getText() == button7.getText() && button7.getText() == button4.getText())
            choice = true;

        else if (button2.getText() == button5.getText() && button5.getText() == button8.getText())
            choice = true;
        else if (button3.getText() == button6.getText() && button6.getText() == button9.getText())
            choice = true;

            //the diagonals

        else if (button1.getText() == button5.getText() && button5.getText() == button9.getText())
            choice = true;
        else if (button3.getText() == button5.getText() && button5.getText() == button4.getText())
            choice = true;


        if (choice) {
            if (playerTurn) {

                toast("Rebels Win!");

            } else {
                toast("Empire Wins!");
            }
        }
    }

    public void toast(String message) {
        Toast.makeText(GameActivity.this, message, Toast.LENGTH_SHORT).show();
    }
}


