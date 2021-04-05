package com.example.zeroset.shop.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.zeroset.R;
import com.google.android.material.tabs.TabLayout;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RecycleMainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RecycleMainFragment extends Fragment {

    TextView recycle_des; // 리사이클 뱃지 설명

    private FragmentPagerAdapter fragmentPagerAdapter; // 탭 레이아웃에서 사용하는 어댑터
    public RecycleMainFragment() {
        // Required empty public constructor
    }

    public static RecycleMainFragment newInstance() {
        RecycleMainFragment fragment = new RecycleMainFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_recycle_main, container, false);

        recycle_des = (TextView)v.findViewById(R.id.recycle_des);
        recycle_des.setText("3개월간 제자리걸음을 걷고 있는 르노삼성차 노사는 내년1\n월에 본교섭을 재개할 예정이어서 새해에도 당분간 진통을 \n겪을 것으로 보인다.");

        // 탭레이아웃웃 페이저
        ViewPager viewPager = v.findViewById(R.id.recycle_tabfragment);
        //fragmentPagerAdapter = new RecycleTabAdapter(getChildFragmentManager());

        TabLayout tabLayout = v.findViewById(R.id.recycle_tablayout);
        viewPager.setAdapter(fragmentPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

        return v;
    }
}