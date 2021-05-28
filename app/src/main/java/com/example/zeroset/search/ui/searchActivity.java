package com.example.zeroset.search.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zeroset.R;
import com.example.zeroset.home.model.Content;
import com.example.zeroset.login.ui.loginActivity;
import com.example.zeroset.search.model.Shop;
import com.example.zeroset.search.ui.adapter.SearchPagerAdapter;
import com.example.zeroset.shop.model.Product;
import com.example.zeroset.shop.ui.shopDetailFragment;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class searchActivity extends AppCompatActivity {
    ViewPager viewPager;
    private NestedScrollView nestedScrollView;
    private searchResulttotalFragment totalFragment;
    private searchResultcontentFragment contentFragment;
    private searchResultproductFragment productFragment;
    private searchResultshopFragment shopFragment;
    private com.example.zeroset.shop.ui.shopDetailFragment shopDetailFragment;
    TabLayout tabLayout;
    private TextView searchword;
    String searchtxt;
    private ImageButton btn_back, btn_search;
    private TabItem total, product, shop, content;
    private TabLayout searchtab;
    ArrayList<Shop> Shops;
    ArrayList<Product> Products, Productshops; //db에서 product list 액티비티로 가져옴 각 프래그먼트에서 이거 참조
    ArrayList<Content> Contents, Contents2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        tabLayout = findViewById(R.id.search_tablayout);
        viewPager = findViewById(R.id.pager);
        searchword = findViewById(R.id.searchword);
        btn_back = findViewById(R.id.btn_back);
        btn_search = findViewById(R.id.btn_search);

        tabLayout.addTab(tabLayout.newTab().setText("통합"));
        tabLayout.addTab(tabLayout.newTab().setText("상품"));
        tabLayout.addTab(tabLayout.newTab().setText("상점"));
        tabLayout.addTab(tabLayout.newTab().setText("콘텐츠"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);



        totalFragment = new searchResulttotalFragment();
        SearchPagerAdapter pagerAdapter = new SearchPagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pagerAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));



        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                // TODO : tab의 상태가 선택되지 않음으로 변경.
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                // TODO : 이미 선택된 tab이 다시
            }
        });

        viewPager.addOnPageChangeListener(new TabLayout
                .TabLayoutOnPageChangeListener(tabLayout));

        setDummyData();



        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendData();
            }
        });



    }
    public void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.pager, fragment).commit();      // Fragment로 사용할 MainActivity내의 layout공간을 선택합니다.
    }

    @Override
    protected void onResume() {
        super.onResume();

        //DETERMINE WHO STARTED THIS ACTIVITY
        final String sender=this.getIntent().getExtras().getString("SENDER_KEY");

        //IF ITS THE FRAGMENT THEN RECEIVE DATA
        if(sender != null)
        {
            this.receiveData();
            Toast.makeText(this, "Received", Toast.LENGTH_SHORT).show();

        }
    }

    /*
  RECEIVE DATA FROM FRAGMENT
   */

    private void receiveData()
    {
        //RECEIVE DATA VIA INTENT
        Intent i = getIntent();
        String word = i.getStringExtra("SEARCHWORD_KEY");

        //SET DATA TO TEXTVIEWS
        searchword.setText(word);
        searchtxt = word ;
    }

    private void sendData()
    {
        //서치결과뷰로 데이터 샌딩
        //INTENT OBJ
        Intent i = new Intent(this,
                loginActivity.class);

        this.startActivity(i);
    }

    public void setDummyData() {

        Products = new ArrayList<>();
        for (int i = 0; i < 23; i++) {
            Products.add(new Product("공집합", "원주대나무", "20,000"));
        }

        Productshops = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Productshops.add(new Product("클린티", "원주대나무", "20,000"));
        }

        Contents = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Contents.add(new Content("원주대나무칫솔\n참멋지다!", "그게뭐죠", "메인메인메인", true,true,true));
        }
        Contents.add(new Content("원주대나무칫솔\n참멋지다!", "그게뭐죠", "메인메인메인", false,false,true));

        Contents2 = new ArrayList<>();
        Contents2.add(new Content("시험기간\n이네요!", "그게뭐죠", "메인메인메인", true,true,true));
        Contents2.add(new Content("클린티\n참멋지다!", "그게뭐죠", "메인메인메인", true,true,true));
        Contents2.add(new Content("원주대나무칫솔\n참멋지다!", "그게뭐죠", "메인메인메인", true,false,false));
        Contents2.add(new Content("잘들어가나확인", "그게뭐죠", "메인메인메인", false,false,true));
        Contents2.add(new Content("만약 안되면 어떡하지", "그게뭐죠", "메인메인메인", true,true,true));
        Contents2.add(new Content("원주대나무칫솔\n참멋지다!", "그게뭐죠", "메인메인메인", false,true,true));

        Shops = new ArrayList<>();
        Shops.add(new Shop("시험기간","성북구 어딘가","그게뭐죠",Productshops));
        Shops.add(new Shop("시험기간","양주시","그게뭐죠", Productshops));
        Shops.add(new Shop("시험기간","그렇다","그게뭐죠", Productshops));
        Shops.add(new Shop("간식","덕정동","그게뭐죠", Productshops));
        Shops.add(new Shop("비온다","성북구 어딘가","그게뭐죠", Productshops));
        Shops.add(new Shop("시험기간","성북구 어딘가","그게뭐죠", Productshops));


    }

}