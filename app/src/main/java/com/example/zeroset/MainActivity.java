package com.example.zeroset;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.zeroset.contents.ui.contentsFragment;
import com.example.zeroset.shop.ui.ShopFragment;
import com.example.zeroset.home.ui.homeFragment;
import com.example.zeroset.mypage.ui.myPageFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.jetbrains.annotations.NotNull;

public class MainActivity extends AppCompatActivity {

    homeFragment homeFragment;
    ShopFragment detailFragment;
    contentsFragment contentsFragment;
    myPageFragment myPageFragment;

    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    BottomNavigationView bottomNavigationView;

    //Menu menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.bottom_home:
                        setFrag(0);
                        break;
                    case R.id.bottom_shop:
                        setFrag(1);
                        break;
                    case R.id.bottom_contents:
                        setFrag(2);
                        break;
                    case R.id.bottom_mypage:
                        setFrag(3);
                        break;
                }
                return false;
            }
        });

        homeFragment = new homeFragment();
        detailFragment = new ShopFragment();
        contentsFragment = new contentsFragment();
        myPageFragment = new myPageFragment();

        setFrag(0); //첫 프래그먼트 화면을 무엇으로 지정해줄 것인지 결정
    }

    //프래그먼트 교체가 일어나는 실행문이다.
    private void setFrag(int n) {
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        switch (n) {
            case 0:
                fragmentTransaction.replace(R.id.container, homeFragment);
                fragmentTransaction.commit();
                break;
            case 1:
                fragmentTransaction.replace(R.id.container, detailFragment);
                fragmentTransaction.commit();
                break;
            case 2:
                fragmentTransaction.replace(R.id.container, contentsFragment);
                fragmentTransaction.commit();
                break;
            case 3:
                fragmentTransaction.replace(R.id.container, myPageFragment);
                fragmentTransaction.commit();
                break;
        }
    }

    public void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment).commit();      // Fragment로 사용할 MainActivity내의 layout공간을 선택합니다.
    }
}