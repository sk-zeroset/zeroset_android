package com.example.zeroset.login.ui;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.zeroset.R;

public class registerFragment extends Fragment {
    private ToggleButton toggle1, toggle2;
    private Button btn_next;
    private TextView tv1, tv2;
    private TextView tv3, tv4, tv5, tv6;
    private int togglecnt1, togglecnt2;
    private ViewGroup v;
    private String str =
            "(1) 필수항목과 선택항목의 차이\n\n\n" +
                    "필수항목이란 서비스의 본질적 기능을 수행하기 위해 필요한 정보이며, 선택항목이란 서비스 이용 자체에 영향을 미치지는 않으나 이용자에게 부가적인 가치를 제공하기 위해 추가로 수집하는 정보입니다. " +
                    "필수항목이란 서비스의 본질적 기능을 수행하기 위해 필요한 정보이며, 선택항목이란 서비스 이용 자체에 영향을 미치지는 않으나 이용자에게 부가적인 가치를 제공하기 위해 추가로 수집하는 정보입니다. " +
                    "필수항목이란 서비스의 본질적 기능을 수행하기 위해 필요한 정보이며, 선택항목이란 서비스 이용 자체에 영향을 미치지는 않으나 이용자에게 부가적인 가치를 제공하기 위해 추가로 수집하는 정보입니다. " +
                    "필수항목이란 서비스의 본질적 기능을 수행하기 위해 필요한 정보이며, 선택항목이란 서비스 이용 자체에 영향을 미치지는 않으나 이용자에게 부가적인 가치를 제공하기 위해 추가로 수집하는 정보입니다. " +
                    "회원가입 시에 수집하는 아이디, 비밀번호는 로그인을 위하여 필요한 정보이며 이름, 생년월일, 성별은 회원제 서비스 운영에 따르는";


    public registerFragment() {
    }

    public static registerFragment newInstance() {
        registerFragment fragment = new registerFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup v = (ViewGroup) inflater.inflate(R.layout.fragment_register,
                container, false);

        initUI(v);

        toggle1 = v.findViewById(R.id.toggle1);
        toggle2 = v.findViewById(R.id.toggle2);
        btn_next = v.findViewById(R.id.btn_next);
        tv1 = v.findViewById(R.id.tv1);
        tv2 = v.findViewById(R.id.tv2);
        tv3 = v.findViewById(R.id.textView13);
        tv4 = v.findViewById(R.id.textView14);
        tv5 = v.findViewById(R.id.textView12);
        tv6 = v.findViewById(R.id.textView9);


        tv1.setText(str);
        tv1.setMovementMethod(new ScrollingMovementMethod());
        tv2.setText(str);
        tv2.setMovementMethod(new ScrollingMovementMethod());

        toggle1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    togglecnt1 = 1;
                    enabledNextButton();
                } else {
                    togglecnt1 = 0;
                    enabledNextButton();
                }
            }
        });

        toggle2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    togglecnt2 = 1;
                    enabledNextButton();
                } else {
                    togglecnt2 = 0;
                    enabledNextButton();
                }
            }
        });

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        tv3.setText("서비스 이용약관 동의");
        tv4.setText("필수");
        tv5.setText("개인정보 수집 및 이용 동의");
        tv6.setText("필수");


        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((registerActivity) getActivity()).replaceFragment(registerCertFragment.newInstance());
            }
        });


        return v;
    }

    public void enabledNextButton(){
        if(togglecnt1==1&togglecnt2==1){
            btn_next.setEnabled(true);
        }
        else{
            btn_next.setEnabled(false);
        }
    }

    private void initUI(ViewGroup rootView){
    }
}
