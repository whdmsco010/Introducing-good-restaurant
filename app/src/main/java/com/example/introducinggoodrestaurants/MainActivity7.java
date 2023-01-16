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
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity7 extends AppCompatActivity {

    ImageView sb,sb2,sb3,sb4;
    Button back76;
    CheckBox chb,chb2,chb3,chb4;
    TextView sbm,sbm2,sbm3,sbm4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        setTitle("Dinner menu");
        chb = (CheckBox)findViewById(R.id.chkb);
        chb2 = (CheckBox)findViewById(R.id.chkb2);
        chb3 = (CheckBox)findViewById(R.id.chkb3);
        chb4 = (CheckBox)findViewById(R.id.chkb4);
        sbm = (TextView)findViewById(R.id.sbm);
        sbm2 = (TextView)findViewById(R.id.sbm2);
        sbm3 = (TextView)findViewById(R.id.sbm3);
        sbm4 = (TextView)findViewById(R.id.sbm4);
        chb.setOnCheckedChangeListener(this::onCheckedChanged); //체크 상태
        chb2.setOnCheckedChangeListener(this::onCheckedChanged);
        chb3.setOnCheckedChangeListener(this::onCheckedChanged);
        chb4.setOnCheckedChangeListener(this::onCheckedChanged);
        //back 버튼을 누르면 그 전 페이지인 점심 소개 페이지로 이동
        back76 = (Button)findViewById(R.id.back76);
        back76.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity7.this,MainActivity6.class);
                startActivityForResult(intent,43);
            }
        });
        //menu 페이지의 음식 사진을 누르면 Toast 메시지로 set 메뉴의 세부 구성을 보여줌
        sb = (ImageView) findViewById(R.id.imageView);
        sb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View s) {
                Toast.makeText(getApplicationContext(), "한우100g + 기본야채(야채3종+버섯3종) + 칼사리 + 죽 또는 볶음밥", Toast.LENGTH_SHORT).show();
            }
        });
        sb2 = (ImageView) findViewById(R.id.imageView2);
        sb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View ss) {
                Toast.makeText(getApplicationContext(), "한우100g + 기본야채(야채3종+버섯3종) + 월남쌈(쌈야채포함) + 칼사리 + 죽 또는 볶음밥", Toast.LENGTH_SHORT).show();
            }
        });
        sb3 = (ImageView) findViewById(R.id.imageView3);
        sb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View sss) {
                Toast.makeText(getApplicationContext(), "한우100g + 기본야채(야채3종+버섯3종) + 해물(낙지+새우+생합) + 칼사리 + 죽 또는 볶음밥", Toast.LENGTH_SHORT).show();
            }
        });
        sb4 = (ImageView) findViewById(R.id.imageView4);
        sb4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View ssss) {
                Toast.makeText(getApplicationContext(), "한우100g + 야채(야채3종+버섯3종) + 월남쌈 + 해물(낙지+새우+생합) + 칼사리 + 죽 또는 볶음밥", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){ //체크 박스를 누르면
        Intent sbintent = getIntent();
        if(chb.isChecked()) {
            sbintent = new Intent(getApplicationContext(), MainActivity5.class); //Activity 5로
            sbintent.putExtra("message1",sbm.getText().toString()); //sbm(음식의 가격)이 전달됨
            //전달할 데이터명, 값
            setResult(Activity.RESULT_OK,sbintent);
            finish();
        }
        else if(chb2.isChecked()) {
            sbintent = new Intent(getApplicationContext(), MainActivity5.class);
            sbintent.putExtra("message1",sbm2.getText().toString());
            //전달할 데이터명, 값
            setResult(Activity.RESULT_OK,sbintent);
            finish();
        }
        else if(chb3.isChecked()) {
            sbintent = new Intent(getApplicationContext(), MainActivity5.class);
            sbintent.putExtra("message1",sbm3.getText().toString());
            //전달할 데이터명, 값
            setResult(Activity.RESULT_OK,sbintent);
            finish();
        }
        else if(chb4.isChecked()) {
            sbintent = new Intent(getApplicationContext(), MainActivity5.class);
            sbintent.putExtra("message1",sbm4.getText().toString());
            //전달할 데이터명, 값
            setResult(Activity.RESULT_OK,sbintent);
            finish();
        }
    }
}