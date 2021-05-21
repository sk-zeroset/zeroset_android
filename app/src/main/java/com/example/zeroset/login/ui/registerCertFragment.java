package com.example.zeroset.login.ui;

import android.app.Activity;
import android.os.Bundle;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.zeroset.R;

public class registerCertFragment extends Fragment {
    private EditText user_num, cert_num;
    private Button btn_next, btn_retry;
    private ImageButton btn_cert, btn_check;
    private LinearLayout warn;
    private TextView time;
    private FrameLayout certf;
    public int len = 6;

    public registerCertFragment() {
    }

    public static registerCertFragment newInstance() {
        registerCertFragment fragment = new registerCertFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup v = (ViewGroup) inflater.inflate(R.layout.fragment_register_cert,
                container, false);

        ((registerActivity)getActivity()).changeProgress(50);
        user_num = v.findViewById(R.id.phonenum);
        cert_num = v.findViewById(R.id.certnum);
        btn_cert = v.findViewById(R.id.btn_cert);
        btn_retry = v.findViewById(R.id.btn_retry);
        btn_next = v.findViewById(R.id.btn_next);
        btn_check = v.findViewById(R.id.ic_check);
        warn = v.findViewById(R.id.validview);
        certf = v.findViewById(R.id.frameLayout2);
        time = v.findViewById(R.id.time);


        user_num.setInputType(android.text.InputType.TYPE_CLASS_PHONE);
        user_num.addTextChangedListener(new PhoneNumberFormattingTextWatcher());
        user_num.setOnFocusChangeListener(new View.OnFocusChangeListener(){

            public void onFocusChange(View v, boolean gainFocus) {

                if (!gainFocus) {

                    InputMethodManager immhide = (InputMethodManager) getActivity().getSystemService(Activity.INPUT_METHOD_SERVICE);
                    immhide.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);

                }

            }
        });

        btn_cert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                btn_cert.setSelected(true);
                btn_cert.setVisibility(View.GONE);
                btn_check.setVisibility(View.VISIBLE);
                loadtimer();

            }
        });

        cert_num.setOnFocusChangeListener(new View.OnFocusChangeListener(){

            public void onFocusChange(View v, boolean gainFocus) {

                if (!gainFocus) {

                    InputMethodManager immhide = (InputMethodManager) getActivity().getSystemService(Activity.INPUT_METHOD_SERVICE);
                    immhide.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);

                }

            }
        });

        cert_num.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(cert_num.getText().toString().length() == len){
                    ((registerActivity)getActivity()).getcertnum(cert_num.getText().toString());
                }
            }
        });

        btn_retry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                loadtimer();
            }
        });

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((registerActivity) getActivity()).replaceFragment(registerDetailFragment.newInstance());

            }
        });



        initUI(v);


        return v;
    }

    private void initUI(ViewGroup rootView){
    }

    public void resultlistener(int result){
        if(result==1){
            setCorrectbtn();
        }
        else{
            setWarn();
        }
    }

    public void setWarn()
    {
        warn.setVisibility(View.VISIBLE);
    }

    public void setCorrectbtn()
    {
        btn_next.setEnabled(true);
        warn.setVisibility(View.GONE);
    }

    public void loadtimer(){
        ((registerActivity)getActivity()).getphonenum(user_num.getText().toString());
        ((registerActivity)getActivity()).setTimer(time);
        certf.setVisibility(View.VISIBLE);
    }

}
