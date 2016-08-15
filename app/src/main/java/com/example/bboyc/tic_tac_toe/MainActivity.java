package com.example.bboyc.tic_tac_toe;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public ImageButton startGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startGame = (ImageButton) findViewById(R.id.imageButton);
        startGame.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                toast("May The Force Be With You...");

                Intent intent = new Intent(MainActivity.this, GameActivity.class);
                startActivity(intent);
            }
        });
    }

        public void toast(String message){
            Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();

        }
    }



