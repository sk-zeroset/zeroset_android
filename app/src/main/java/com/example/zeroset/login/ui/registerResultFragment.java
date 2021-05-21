package com.example.zeroset.login.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.zeroset.R;

public class registerResultFragment extends Fragment {
    public registerResultFragment() {
    }

    public static registerResultFragment newInstance() {
        registerResultFragment fragment = new registerResultFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup v = (ViewGroup) inflater.inflate(R.layout.fragment_register_result,
                container, false);

        ((registerActivity)getActivity()).changeProgress(100);




        initUI(v);


        return v;
    }

    private void initUI(ViewGroup rootView){
    }
}
