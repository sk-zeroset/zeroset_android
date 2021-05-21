package com.example.zeroset.login.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.zeroset.R;

public class registerDetailFragment extends Fragment {
    private TextView valid1, valid2, valid3;
    private Button btn_next;
    private EditText nname, pwd, pwd_check;
    private String nicname;
    private ImageView ic_warn;
    public registerDetailFragment() {
    }

    public static registerDetailFragment newInstance() {
        registerDetailFragment fragment = new registerDetailFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup v = (ViewGroup) inflater.inflate(R.layout.fragment_register_detail,
                container, false);

        ((registerActivity)getActivity()).changeProgress(75);

        valid1 = v.findViewById(R.id.checkvalid);
        valid2 = v.findViewById(R.id.checkvalid2);
        valid3 = v.findViewById(R.id.checkvalid3);
        btn_next = v.findViewById(R.id.btn_next);
        nname = v.findViewById(R.id.nname);
        pwd = v.findViewById(R.id.pwd);
        pwd_check = v.findViewById(R.id.pwdck);
        ic_warn = v.findViewById(R.id.imageView4);

        nname.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                nicname = nname.getText().toString();
            }
        });


        setCorrectbtn();

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((registerActivity) getActivity()).replaceFragment(registerResultFragment.newInstance());

            }
        });


        initUI(v);


        return v;
    }

    private void initUI(ViewGroup rootView){
    }

    public void setWarn(int i)
    {
        if(i==1){
            valid1.setVisibility(View.VISIBLE);
        }
        else if(i==2){
            valid2.setTextColor(Color.parseColor("#FF5151"));
            ic_warn.setVisibility(View.GONE);

        }
        else if(i==3){
            valid3.setVisibility(View.VISIBLE);

        }
    }

    public void setCorrectbtn()
    {
        btn_next.setEnabled(true);
        //warn.setVisibility(View.GONE);
    }
}
