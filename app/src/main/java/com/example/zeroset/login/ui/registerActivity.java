package com.example.zeroset.login.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zeroset.R;

public class registerActivity extends AppCompatActivity {
    private ImageButton btn_back;
    public ProgressBar pBar;
    public int pBarnum = 25;
    public String phonenum, certnum;
    public boolean ablecert = false; // 3분 이내면
    registerFragment registerFragment;
    registerCertFragment registerCertFragment;
    registerDetailFragment registerDetailFragment;
    registerResultFragment registerResultFragment;
    private static final int MILLISINFUTURE = 181*1000;
    private static final int COUNT_DOWN_INTERVAL = 1000;
    private int count = 180;
    public String str;
    public CountDownTimer countDownTimer;
    public TextView timetv;
    public int result=0; //1이면 인증성공 0이면 인증 실패( certnum 못받은 경우 포함 )



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        btn_back = findViewById(R.id.btn_back);
        pBar = findViewById(R.id.progress);
        pBar.setProgress(pBarnum);

        registerFragment = new registerFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.container, registerFragment).commit();

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



    }
    public void setTimer(TextView time){
        timetv = time;
        countDownTimer();
        countDownTimer.start();
    }


    public void countDownTimer() {
        countDownTimer = new CountDownTimer(MILLISINFUTURE, COUNT_DOWN_INTERVAL) {
            public void onTick(long millisUntilFinished) {
                ablecert = true;
                str = String.valueOf(count/60) + ":" + String.valueOf((count%60<=9)?"0"+count%60:count%60);
                timetv.setText(str);
                count --;
            }
            public void onFinish() {
                count = 180;
                ablecert = false;
                registerCertFragment registerCertFragment = (registerCertFragment) getSupportFragmentManager().findFragmentById(R.id.container);
                registerCertFragment.resultlistener(result); //인증시간 지났는데 certfrag으로부터 certnum을 받지 못한 경우
            }
        };

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        try{
            countDownTimer.cancel();
        } catch (Exception e) {}
        countDownTimer=null;
    }


    public void changeProgress(int num)
    {
        pBar.setProgress(num);
    }
    public void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment).commit();      // Fragment로 사용할 MainActivity내의 layout공간을 선택합니다.
    }
    public void getphonenum(String phone)
    {
        phonenum = phone;
        Toast.makeText(getApplicationContext(), phonenum, Toast.LENGTH_LONG).show();


    }
    public void getcertnum(String cert)
    {
        certnum = cert;
        if(certnum.equals("123456")&&ablecert==true){
            result = 1;
            registerCertFragment registerCertFragment = (registerCertFragment) getSupportFragmentManager().findFragmentById(R.id.container);
            registerCertFragment.resultlistener(result);
        }
        else{
            result = 0;
        }
    }

}