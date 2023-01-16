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

public class MainActivity3 extends AppCompatActivity {

    Button gom,next36,gohome,btnDial,btnAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        setTitle("Lunch");
        //현재 시각을 보여줌
        long now = System.currentTimeMillis();
        Date mDate = new Date(now);
        SimpleDateFormat simpleDate = new SimpleDateFormat("HH:mm:ss");
        String getTime = simpleDate.format(mDate);
        //listView
        final String[] time = {"  현재 시각: "+ getTime, "  영업중 \n      11:30-22:00", "  브레이크타임 \n      15:00-16:00", "  라스트 오더 \n      21:30"};
        Spinner spinner = (Spinner)findViewById(R.id.spinner);
        ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<String>(this,R.layout.my_selected_item,time); //listView의 커스텀을 my_selected_item.xml에서 사용
        adapter.setDropDownViewResource(R.layout.my_dropdown_item); //listView의 아래 화살표 눌렀을 때의 커스텀을 my_dropdown_item.xml에서 사용
        spinner.setAdapter(adapter);
        //menu 버튼 클릭 시 메뉴 페이지로 이동함
        gom = (Button) findViewById(R.id.goMenu);
        gom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity3.this,MainActivity4.class); //Activity3->Activity4
                startActivityForResult(intent,34);
            }
        });
        //next 버튼 클릭 시 저녁 소개 페이지로 이동
        next36 = (Button) findViewById(R.id.next36);
        next36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vv) {
                Intent intent = new Intent(MainActivity3.this,MainActivity6.class); //Activity3->Activity6
                startActivityForResult(intent,36);
            }
        });
        //home 버튼을 누르면 점심과 저녁 중 하나를 선택할 수 있는 페이지로 이동
        gohome = (Button) findViewById(R.id.gohome);
        gohome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vvv) {
                Intent intent = new Intent(MainActivity3.this,MainActivity2.class); //Activity3->Activity2
                startActivityForResult(intent,32);
            }
        });
        //phone 버튼을 누르면 전화창으로 이동
        btnDial = (Button) findViewById(R.id.btnDial);
        btnDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View D) {
                Uri uri = Uri.parse("tel:050713265086");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        //Address 버튼을 누르면 지도가 웹사이트에 띄워짐
        btnAddress = (Button) findViewById(R.id.btnAddress);
        btnAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View A) {
                Uri uri = Uri.parse("http://maps.google.co.kr/maps?q="
                        + 35.1376466 + "," + 129.1015352); //TODO 위도, 경도값 입력
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                //다른 웹 사이트를 사용하기 때문에 배경음악이 끊기는데 이를 방지하기 위함
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_USER_ACTION);
                startActivity(intent);
            }
        });
    }

}