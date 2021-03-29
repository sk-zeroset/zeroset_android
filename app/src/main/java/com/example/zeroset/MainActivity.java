package com.example.zeroset;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.zeroset.shop.ui.contentsFragment;
import com.example.zeroset.shop.ui.detailFragment;
import com.example.zeroset.shop.ui.homeFragment;
import com.example.zeroset.shop.ui.myPageFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    homeFragment homeFragment;
    detailFragment detailFragment;
    contentsFragment contentsFragment;
    myPageFragment myPageFragment;

    BottomNavigationView bottomNavigationView;
    Menu menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        homeFragment = new homeFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.container, homeFragment).commit();


        bottomNavigationView = findViewById(R.id.bottom_navigation);
        menu = bottomNavigationView.getMenu();

        bottomNavigationView.setOnNavigationItemSelectedListener(new ItemSelectedListener());
        bottomNavigationView.setSelectedItemId(R.id.bottom_home);
    }


    /* 바텀바 선택시 아이콘 토글 */
    class ItemSelectedListener implements BottomNavigationView.OnNavigationItemSelectedListener {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.bottom_home:
                    if (homeFragment != null)  getSupportFragmentManager().beginTransaction().show(homeFragment).commit();
                    if (detailFragment != null) getSupportFragmentManager().beginTransaction().hide(detailFragment).commit();
                    if (contentsFragment != null) getSupportFragmentManager().beginTransaction().hide(contentsFragment).commit();
                    if (myPageFragment != null) getSupportFragmentManager().beginTransaction().hide(myPageFragment).commit();
                    item.setIcon(R.drawable.btn_bottombar_home_selected);
                    menu.findItem(R.id.bottom_shop).setIcon(R.drawable.btn_bottombar_shop_unselected);
                    menu.findItem(R.id.bottom_contents).setIcon(R.drawable.btn_bottombar_contents_unselected);
                    menu.findItem(R.id.bottom_mypage).setIcon(R.drawable.btn_bottombar_mypage_unselected);
                    break;
                case R.id.bottom_shop:
                    if (detailFragment == null) {
                       detailFragment = new detailFragment();
                        getSupportFragmentManager().beginTransaction().add(R.id.container, detailFragment).commit();
                    }
                    if (detailFragment != null) getSupportFragmentManager().beginTransaction().show(detailFragment).commit();
                    if (homeFragment != null) getSupportFragmentManager().beginTransaction().hide(homeFragment).commit();
                    if (contentsFragment != null) getSupportFragmentManager().beginTransaction().hide(contentsFragment).commit();
                    if (myPageFragment != null) getSupportFragmentManager().beginTransaction().hide(myPageFragment).commit();
                    item.setIcon(R.drawable.btn_bottombar_shop_selected);
                    menu.findItem(R.id.bottom_home).setIcon(R.drawable.btn_bottombar_home_unselected);
                    menu.findItem(R.id.bottom_contents).setIcon(R.drawable.btn_bottombar_contents_unselected);
                    menu.findItem(R.id.bottom_mypage).setIcon(R.drawable.btn_bottombar_mypage_unselected);
                    break;
                case R.id.bottom_contents:
                    if (contentsFragment == null) {
                        contentsFragment = new contentsFragment();
                        getSupportFragmentManager().beginTransaction().add(R.id.container, contentsFragment).commit();
                    }
                    if (contentsFragment != null) getSupportFragmentManager().beginTransaction().show(contentsFragment).commit();
                    if (detailFragment != null) getSupportFragmentManager().beginTransaction().hide(detailFragment).commit();
                    if (homeFragment != null) getSupportFragmentManager().beginTransaction().hide(homeFragment).commit();
                    if (myPageFragment != null) getSupportFragmentManager().beginTransaction().hide(myPageFragment).commit();
                    item.setIcon(R.drawable.btn_bottombar_shop_selected);
                    item.setIcon(R.drawable.btn_bottombar_contents_selected);
                    menu.findItem(R.id.bottom_shop).setIcon(R.drawable.btn_bottombar_shop_unselected);
                    menu.findItem(R.id.bottom_home).setIcon(R.drawable.btn_bottombar_home_unselected);
                    menu.findItem(R.id.bottom_mypage).setIcon(R.drawable.btn_bottombar_mypage_unselected);
                    break;
                case R.id.bottom_mypage:
                    if (myPageFragment == null) {
                        myPageFragment = new myPageFragment();
                        getSupportFragmentManager().beginTransaction().add(R.id.container, myPageFragment).commit();
                    }
                    if (myPageFragment != null) getSupportFragmentManager().beginTransaction().show(myPageFragment).commit();
                    if (homeFragment != null) getSupportFragmentManager().beginTransaction().hide(homeFragment).commit();
                    if (contentsFragment != null) getSupportFragmentManager().beginTransaction().hide(contentsFragment).commit();
                    if (detailFragment != null) getSupportFragmentManager().beginTransaction().hide(detailFragment).commit();
                    item.setIcon(R.drawable.btn_bottombar_shop_selected);
                    item.setIcon(R.drawable.btn_bottombar_mypage_selected);
                    menu.findItem(R.id.bottom_shop).setIcon(R.drawable.btn_bottombar_shop_unselected);
                    menu.findItem(R.id.bottom_contents).setIcon(R.drawable.btn_bottombar_contents_unselected);
                    menu.findItem(R.id.bottom_home).setIcon(R.drawable.btn_bottombar_home_unselected);
                    break;
            }
            return true;
        }
    }
}