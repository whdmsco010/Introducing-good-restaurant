package com.example.introducinggoodrestaurants;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start = (Button) findViewById(R.id.Start);
        //start 버튼을 누르면
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final MediaPlayer mymusicPlayer;
                mymusicPlayer = MediaPlayer.create(MainActivity.this,R.raw.coatcheck); //coatcheck라는 노래를 재생함
                mymusicPlayer.start();
                Intent intent = new Intent(MainActivity.this,MainActivity2.class); //Activity->Activity2
                startActivityForResult(intent,1);
            }
        });

    }
}