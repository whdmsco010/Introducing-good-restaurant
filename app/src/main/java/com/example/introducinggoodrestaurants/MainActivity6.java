package com.example.introducinggoodrestaurants;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity6 extends AppCompatActivity {

    Button gomenu,gonext,gohome2,btnDial2,btnAddress2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        setTitle("Dinner");
        //현재 시각을 보여줌
        long now = System.currentTimeMillis();
        Date mDate = new Date(now);
        SimpleDateFormat simpleDate = new SimpleDateFormat("hh:mm:ss a");
        String getTime = simpleDate.format(mDate);
        //listView
        final String[] time = {"  현재 시각: "+ getTime, "  영업중 \n      오전 11:00-오후 09:30", "  라스트 오더 \n      오후 09:30", "  영업종료"};
        Spinner spinner2 = (Spinner)findViewById(R.id.spinner2);
        ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<String>(this,R.layout.my_selected_item,time); //listView의 커스텀을 my_selected_item.xml에서 사용
        adapter.setDropDownViewResource(R.layout.my_dropdown_item); //listView의 아래 화살표 눌렀을 때의 커스텀을 my_dropdown_item.xml에서 사용
        spinner2.setAdapter(adapter);
        //menu 버튼 클릭 시 메뉴 페이지로 이동함
        gomenu = (Button) findViewById(R.id.button);
        gomenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity6.this,MainActivity7.class); //Activity6->Activity7
                startActivityForResult(intent,67);
            }
        });
        //next 버튼 클릭 시 소비내역로 이동
        gonext = (Button) findViewById(R.id.finish);
        gonext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vv) {
                Intent intent = new Intent(MainActivity6.this,MainActivity5.class); //Activity6->Activity5
                startActivityForResult(intent,65);
            }
        });
        //home 버튼을 누르면 점심과 저녁 중 하나를 선택할 수 있는 페이지로 이동
        gohome2 = (Button) findViewById(R.id.gohome2);
        gohome2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vvv) {
                Intent intent = new Intent(MainActivity6.this,MainActivity2.class); //Activity6->Activity2
                startActivityForResult(intent,62);
            }
        });
        //phone 버튼을 누르면 전화창으로 이동
        btnDial2 = (Button) findViewById(R.id.btnDial2);
        btnDial2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View DD) {
                Uri uri = Uri.parse("tel:0516120010");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        //Address 버튼을 누르면 지도가 웹사이트에 띄워짐
        btnAddress2 = (Button) findViewById(R.id.btnAddress2);
        btnAddress2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View AA) {
                Uri uri = Uri.parse("http://maps.google.co.kr/maps?q="
                        + 35.13732623305548 + "," + 129.10240071435433); //TODO 위도, 경도값 입력
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                //다른 웹 사이트를 사용하기 때문에 배경음악이 끊기는데 이를 방지하기 위함
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_USER_ACTION);
                startActivity(intent);
            }
        });
    }
}