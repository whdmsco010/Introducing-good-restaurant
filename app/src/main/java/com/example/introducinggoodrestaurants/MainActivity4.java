package com.example.introducinggoodrestaurants;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity4 extends AppCompatActivity {
    Button back43;
    TextView M,M2,M3,M4;
    CheckBox chk,chk2,chk3,chk4;
    ImageView hcs,hcs2,hcs3,hcs4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        setTitle("Lunch menu");
        M = (TextView) findViewById(R.id.m);
        M2 = (TextView) findViewById(R.id.m2);
        M3 = (TextView) findViewById(R.id.m3);
        M4 = (TextView) findViewById(R.id.m4);
        chk = (CheckBox) findViewById(R.id.chk);
        chk2 = (CheckBox) findViewById(R.id.chk2);
        chk3 = (CheckBox) findViewById(R.id.chk3);
        chk4 = (CheckBox) findViewById(R.id.chk4);
        back43 = (Button) findViewById(R.id.back1cha);
        chk.setOnCheckedChangeListener(this::onCheckedChanged); //체크 상태
        chk2.setOnCheckedChangeListener(this::onCheckedChanged);
        chk3.setOnCheckedChangeListener(this::onCheckedChanged);
        chk4.setOnCheckedChangeListener(this::onCheckedChanged);
        //back 버튼을 누르면 그 전 페이지인 점심 소개 페이지로 이동
        back43.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity4.this,MainActivity3.class);
                startActivityForResult(intent,43);
            }
        });
        //menu 페이지의 음식 사진을 누르면 Toast 메시지로 set 메뉴의 세부 구성을 보여줌
        hcs = (ImageView)findViewById(R.id.hcs);
        hcs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View h) {
                Toast.makeText(getApplicationContext(), "청양크림볶이 1, 돈까스 1, 음료 1, 새우튀김/감자칩 택 1", Toast.LENGTH_SHORT).show();
            }
        });
        hcs2 = (ImageView)findViewById(R.id.hcs2);
        hcs2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View hh) {
                Toast.makeText(getApplicationContext(), "떡볶이 1, 모둠튀김 1, 치즈고로케 2, 돈까스 1, 모짜렐라 핫도그 1, 음료 1", Toast.LENGTH_SHORT).show();
            }
        });
        hcs3 = (ImageView)findViewById(R.id.hcs3);
        hcs3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View hhh) {
                Toast.makeText(getApplicationContext(), "떡볶이 1, 모둠튀김 1, 돈까스1, 음료 1", Toast.LENGTH_SHORT).show();
            }
        });
        hcs4 = (ImageView)findViewById(R.id.hcs4);
        hcs4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View hhhh) {
                Toast.makeText(getApplicationContext(), "청양크림볶이 1, 새우리조또 1, 새우샐러드1, 음료 1", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){ //체크 박스를 누르면
        Intent myintent = getIntent();
        if(chk.isChecked()) {
            myintent = new Intent(getApplicationContext(), MainActivity5.class); //Activity 5로
            myintent.putExtra("message",M.getText().toString()); //M(음식의 가격)이 전달됨
            //전달할 데이터명, 값
            setResult(Activity.RESULT_OK,myintent);
            finish();
        }
        else if(chk2.isChecked()) {
            myintent = new Intent(getApplicationContext(), MainActivity5.class);
            myintent.putExtra("message",M2.getText().toString());
            //전달할 데이터명, 값
            setResult(Activity.RESULT_OK,myintent);
            finish();
        }
        else if(chk3.isChecked()) {
            myintent = new Intent(getApplicationContext(), MainActivity5.class);
            myintent.putExtra("message",M3.getText().toString());
            //전달할 데이터명, 값
            setResult(Activity.RESULT_OK,myintent);
            finish();
        }
        else if(chk4.isChecked()) {
            myintent = new Intent(getApplicationContext(), MainActivity5.class);
            myintent.putExtra("message",M4.getText().toString());
            //전달할 데이터명, 값
            setResult(Activity.RESULT_OK,myintent);
            finish();
        }
    }
}