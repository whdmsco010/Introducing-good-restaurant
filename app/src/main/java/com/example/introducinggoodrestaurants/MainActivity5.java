package com.example.introducinggoodrestaurants;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity5 extends AppCompatActivity {
    Button cha1,cha2;
    EditText Add1,Add2;
    TextView chongAdd,themoneyleft;
    EditText asset,np;
    int n1=0,n2=0,n3=0,N=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        setTitle("Consumption details");
        cha1 = (Button)findViewById(R.id.cha1);
        cha2 = (Button)findViewById(R.id.cha2);
        Add1 = (EditText) findViewById(R.id.cha1box);
        Add2 = (EditText) findViewById(R.id.cha2box);
        chongAdd = (TextView) findViewById(R.id.add);
        themoneyleft = (TextView)findViewById(R.id.themoneyleft);
        asset = (EditText) findViewById(R.id.asset);
        np = (EditText) findViewById(R.id.nP);
        //총합계를 누르면 점심+저녁의 소비 비용을 나타내줌
        chongAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View A) {
                n1 = Integer.parseInt(Add1.getText().toString());
                n2 = Integer.parseInt(Add2.getText().toString());
                chongAdd.setText("총합계: "+Integer.toString(n1+n2)+"원");
                chongAdd.setTextSize(20);
            }
        });
        //남은 돈을 계산 해줌
        themoneyleft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View t) {
                n3 = Integer.parseInt(asset.getText().toString());
                N = Integer.parseInt(np.getText().toString());
                themoneyleft.setText("남은 돈: "+Integer.toString(n3-(n1+n2)/N)+"원"); //n3:예산,n1:점심비용,n2:저녁비용,N:총인원
                chongAdd.setTextSize(20);
                if (Integer.parseInt(Integer.toString(n3-(n1+n2)/N))>0){ //남은 돈이 0원보다 크면 아래의 메세지를 띄워줌
                    Toast.makeText(getApplicationContext(), "올바른 소비 습관입니다, 잘하셨어요!", Toast.LENGTH_SHORT).show();
                }
                else if (Integer.parseInt(Integer.toString(n3-(n1+n2)/N))<0){ //남은 돈이 0원보다 작으면 아래의 메세지를 띄워줌
                    Toast.makeText(getApplicationContext(), "예산 초과, 조금 더 아껴쓰세요!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        //점심 버튼을 누르면 점심 메뉴 페이지로 이동하여 메뉴를 선택할 수 있다
        cha1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View q) {
                Intent intent = new Intent(MainActivity5.this,MainActivity4.class);
                startActivityForResult(intent,99);
            }
        });
        //저녁 버튼을 누르면 저녁 메뉴 페이지로 이동하여 메뉴를 선택할 수 있다
        cha2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View qq) {
                Intent R_intent = new Intent(MainActivity5.this,MainActivity7.class);
                startActivityForResult(R_intent,100);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode,int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);

        if (resultCode == RESULT_OK){
            //Intent receiveIntent = getIntent();

            if (requestCode ==99){//Activity4에서 전달된 내용을 받아옴
                String receiveMessage = data.getStringExtra("message");
                Add1.setTextSize(25); //25크기로 Add1(textView)에 받아옴
                Add1.setText(receiveMessage);//가져올 데이터명
            }
            else if (requestCode==100) {//Activity7에서 전달된 내용을 받아옴
                String R_receiveMessage = data.getStringExtra("message1");
                Add2.setTextSize(25); //25크기로 Add2(textView)에 받아옴
                Add2.setText(R_receiveMessage);
            }

        }
    }

    public void onResume(){
        super.onResume();
        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_BATTERY_LOW); //필터 적용
        registerReceiver(receiver, filter);
    }
    @Override
    public void onPause(){//방송수신 해제
        super.onPause();
        unregisterReceiver(receiver);
    }
    BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) { //방송이 되었을 때 어떻게 행동할지를 정의해줌
            String action = intent.getAction(); //어떤 action이 방송에 수신 되었는지 받아옴

            if (action.equals(Intent.ACTION_BATTERY_LOW)){ //배터리가 15% 이하로 줄어들면
                final MediaPlayer mymusicPlayer;
                //"배터리가 부족합니다 충전기를 연결해주세요"라는 음성을 출력
                mymusicPlayer = MediaPlayer.create(MainActivity5.this,R.raw.battery);
                mymusicPlayer.start();
            }
        }
    };
}