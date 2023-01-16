package com.example.introducinggoodrestaurants;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity2 extends AppCompatActivity {

    RadioGroup rGroup;
    RadioButton rdo1, rdo2;
    Button btnOK, next1;
    ImageView imgmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        setTitle("Select");
        rGroup = (RadioGroup) findViewById(R.id.radioGroup);
        rdo1 = (RadioButton) findViewById(R.id.radioButton);
        rdo2 = (RadioButton) findViewById(R.id.radioButton2);
        imgmap = (ImageView) findViewById(R.id.imgmap);
        btnOK = (Button) findViewById(R.id.BtnOK);
        next1 = (Button) findViewById(R.id.next1);
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (rGroup.getCheckedRadioButtonId()){
                    case R.id.radioButton: //라디오 버튼 중 점심을 누르고 select 버튼을 누르면
                        imgmap.setImageResource(R.drawable.map); //map 사진을 보여주고
                        next1.setOnClickListener(new View.OnClickListener() { //next 버튼을 누르면 점심 소개 페이지로 이동
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(MainActivity2.this,MainActivity3.class);
                                startActivityForResult(intent,21);
                            }
                        });
                        break;
                    case R.id.radioButton2: //라디오 버튼 중 저녁을 누르고 select 버튼을 누르면
                        imgmap.setImageResource(R.drawable.map2); //map2 사진을 보여주고
                        next1.setOnClickListener(new View.OnClickListener() { //next 버튼을 누르면 저녁 소개 페이지로 이동
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(MainActivity2.this,MainActivity6.class);
                                startActivityForResult(intent,22);
                            }
                        });
                        break;
                }
            }
        });



    }
}