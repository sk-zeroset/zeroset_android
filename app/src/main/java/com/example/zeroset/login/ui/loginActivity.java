package com.example.zeroset.login.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.text.InputType;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.zeroset.R;
import com.google.android.material.textfield.TextInputLayout;

public class loginActivity extends AppCompatActivity {
    private EditText user_num, user_pwd;
    private Button btn_login;
    private TextView tv_findid, tv_findpwd, tv_join, show;
    private ConstraintLayout login;
    private TextInputLayout idf, pwdf;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        user_num = findViewById(R.id.number);
        user_pwd = findViewById(R.id.pwd);
        tv_findid = findViewById(R.id.findid);
        tv_findpwd = findViewById(R.id.findpwd);
        tv_join = findViewById(R.id.join);
        btn_login = findViewById(R.id.loginbutton);
        login = findViewById(R.id.view2);


        user_num.setInputType(android.text.InputType.TYPE_CLASS_PHONE);
        user_num.addTextChangedListener(new PhoneNumberFormattingTextWatcher());
        user_num.setOnFocusChangeListener(new View.OnFocusChangeListener(){

            public void onFocusChange(View v, boolean gainFocus) {

                if (!gainFocus) {

                    InputMethodManager immhide = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
                    immhide.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);

                }

            }
        });

        user_pwd.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        user_pwd.setOnFocusChangeListener(new View.OnFocusChangeListener(){

            public void onFocusChange(View v, boolean gainFocus) {

                if (!gainFocus) {

                    InputMethodManager immhide = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
                    immhide.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);

                }

            }
        });



        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });


        tv_join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                //startActivity(intent);
                sendData();
            }
        });
        tv_findpwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                //startActivity(intent);
            }
        });
        tv_findid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                //startActivity(intent);
            }
        });


    }
    private void sendData()
    {
        //INTENT OBJ
        Intent i = new Intent(this,
                registerActivity.class);

        this.startActivity(i);
    }

    public void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment).commit();      // Fragment로 사용할 MainActivity내의 layout공간을 선택합니다.
    }
}
