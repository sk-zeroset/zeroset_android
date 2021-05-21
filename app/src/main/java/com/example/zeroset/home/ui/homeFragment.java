package com.example.zeroset.home.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.zeroset.MainActivity;
import com.example.zeroset.R;
import com.example.zeroset.home.model.Content;
import com.example.zeroset.home.ui.adapter.ContentBannerAdapter;
import com.example.zeroset.search.ui.searchFragment;
import com.example.zeroset.shop.model.Product;
import com.example.zeroset.search.ui.searchFragment;
import com.example.zeroset.shop.model.eventBanner;
import com.example.zeroset.shop.ui.adapter.GridAdapter;
import com.example.zeroset.shop.ui.adapter.EventBannerAdapter;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.tabs.TabLayout;
import com.example.zeroset.home.ui.adapter.LinearAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link homeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class homeFragment extends Fragment {

    private ImageButton btn_search, btn_down1, btn_up;
    private int MAX_ITEM_COUNT = 10;
    private RecyclerView recycler1, recycler2, recycler3, recyclercontents;
    private TextView txt1, txt2, txt3;
    private LinearAdapter linearAdapter;
    private LinearLayout contentframe;
    private ContentBannerAdapter contentAdapter;
    private ArrayList<Product> Products1, Products2, Products3;
    private ArrayList<Content> Contents;
    private MaterialToolbar bar;
    private ViewGroup view;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public homeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment shopDetailFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static homeFragment newInstance(String param1, String param2) {
        homeFragment fragment = new homeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup v = (ViewGroup) inflater.inflate(R.layout.fragment_home,
                container, false);
        setDummyData();
        recycler1 = v.findViewById(R.id.firstrecycler);
        recycler2 = v.findViewById(R.id.secondrecycler);
        recycler3 = v.findViewById(R.id.thirdrecycler);
        recyclercontents = v.findViewById(R.id.contentrecycler);
        contentframe = v.findViewById(R.id.contentframe);
        //resizeContentList(contentframe,5, getActivity());

        setRecyclerView(recycler1, Products1);
        setRecyclerView(recycler2, Products1);
        setRecyclerView(recycler3, Products1);


        recyclercontents.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        contentAdapter = new ContentBannerAdapter(Contents, 1);
        recyclercontents.setAdapter(contentAdapter);

        btn_search = v.findViewById(R.id.btn_search);
        btn_down1 = v.findViewById(R.id.btn_down1);
        btn_up = v.findViewById(R.id.btn_up1);



        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).replaceFragment(searchFragment.newInstance());
            }
        });

        btn_down1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contentframe.setVisibility(View.VISIBLE);
            }
        });


        btn_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contentframe.setVisibility(View.GONE);
            }
        });

        return v;
    }

    public void setDummyData() {

        Products1 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Products1.add(new Product("공집합", "원주대나무", "20,000"));
        }

        Contents = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Contents.add(new Content("원주대나무칫솔\n참멋지다!", "그게뭐죠", "메인메인메인", 1));
        }
    }

    public void setRecyclerView(RecyclerView recyclerView, ArrayList<Product> products) {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        linearAdapter = new LinearAdapter(products);
        recyclerView.setAdapter(linearAdapter);
    }



}