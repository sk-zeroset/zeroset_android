package com.example.zeroset.search.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.zeroset.MainActivity;
import com.example.zeroset.R;
import com.example.zeroset.home.ui.homeFragment;
import com.example.zeroset.search.model.Keyword;
import com.example.zeroset.search.ui.adapter.KeywordAdapter;
import com.example.zeroset.search.ui.adapter.RankAdapter;
import com.example.zeroset.search.ui.adapter.SearchAdapter;

import java.util.ArrayList;
import java.util.List;

public class searchFragment extends Fragment {
    ImageButton btn_back;
    ImageButton btn_search;
    List<String> datalist;          // 데이터를 넣은 리스트변수
    ListView searchdatalistv, ranklistv;          // 검색을 보여줄 리스트변수
    EditText editSearch;        // 검색어를 입력할 Input 창
    SearchAdapter adapter;      // 리스트뷰에 연결할 아답터
    ArrayList<String> arraylist, ranklist;
    LinearLayout rank, keyword;
    RankAdapter adpaterrank;
    RecyclerView keywordlistv;
    String searchword;



    public searchFragment(){
        // Required empty public constructor
    }

    public static searchFragment newInstance(){
        searchFragment fragment = new searchFragment();
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_search, container, false);
        editSearch = v.findViewById(R.id.editText); //검색어받는 에딧창
        searchdatalistv =  v.findViewById(R.id.searchdatalist); //키워드 검색했을 때 뜨는 리스트 뷰
        rank =  v.findViewById(R.id.rankingchart); //랭킹 차트 리니어
        keyword = v.findViewById(R.id.keyword); //최근검색어 리니어
        ranklistv = v.findViewById(R.id.ranklist); //랭킹차트
        keywordlistv = v.findViewById(R.id.keywordview); //최근검색어

        StaggeredGridLayoutManager gridLayoutManager = new StaggeredGridLayoutManager(3, LinearLayoutManager.HORIZONTAL);
        keywordlistv.setLayoutManager(gridLayoutManager);
        KeywordAdapter keywordadapter = new KeywordAdapter();
        keywordadapter.addItem(new Keyword("달걀"));
        keywordadapter.addItem(new Keyword("이채은"));
        keywordadapter.addItem(new Keyword("토마토마토"));
        keywordadapter.addItem(new Keyword("thdefn"));
        keywordadapter.addItem(new Keyword("힘들어"));
        keywordadapter.addItem(new Keyword("커피커피"));
        keywordadapter.addItem(new Keyword("달걀"));
        keywordadapter.addItem(new Keyword("달걀"));
        keywordadapter.addItem(new Keyword("달걀"));
        keywordlistv.setAdapter(keywordadapter);



        ranklist = new ArrayList<String>();
        settingrankList();
        adpaterrank = new RankAdapter(container.getContext(), ranklist);
        ranklistv.setAdapter(adpaterrank);


        datalist = new ArrayList<String>(); //검색어포함데이터리스트
        settingdataList(); //내부데이터세팅
        arraylist = new ArrayList<String>(); //비교대상리스트생성
        arraylist.addAll(datalist);
        datalist.clear();

        adapter = new SearchAdapter(datalist, container.getContext());

        searchdatalistv.setAdapter(adapter);

        editSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String text = editSearch.getText().toString();
                search(text);
            }
        });


        editSearch.setOnFocusChangeListener(new View.OnFocusChangeListener(){

            public void onFocusChange(View v, boolean gainFocus) {

                if (gainFocus) {
                    //검색바 내부 누룰때
                    rank.setVisibility(View.GONE);
                    keyword.setVisibility(View.VISIBLE);
                    searchdatalistv.setVisibility(View.VISIBLE);

                }

                else {
                    //검색바 외부를 누를때
                    rank.setVisibility(View.VISIBLE);
                    keyword.setVisibility(View.GONE);
                    searchdatalistv.setVisibility(View.GONE);
                    //키보드 자동 내림
                    InputMethodManager immhide = (InputMethodManager) getActivity().getSystemService(Activity.INPUT_METHOD_SERVICE);
                    immhide.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);

                }
            }
        });


        searchdatalistv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                searchword = datalist.get(position);
                sendData();

            }
        });

        ranklistv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                searchword = ranklist.get(position);
                sendData();

            }
        });

        btn_search = v.findViewById(R.id.btn_serch);
        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchword = editSearch.getText().toString();
                sendData();

            }
        });



        btn_back = v.findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).replaceFragment(homeFragment.newInstance("a", "a"));
            }
        });

        return v;

    }




    public void search(String charText) {
        // 검색을 수행하는 메소드
        datalist.clear();

        if (charText.length() == 0) {
            //list.addAll(arraylist);
        }
        else
        {
            for(int i = 0;i < arraylist.size(); i++)
            {
                if (arraylist.get(i).toLowerCase().contains(charText))
                {
                    datalist.add(arraylist.get(i));
                }
            }
        }
        adapter.notifyDataSetChanged();
    }


    private void settingdataList(){
        //검색어 내부 데이터 구성
        datalist.add("asdf");
        datalist.add("thdefn");
        datalist.add("gggdsfaf");
        datalist.add("asdfghjk");
        datalist.add("asdfghjkdfsfa");
        datalist.add("asdf5");
        datalist.add("asdf6");

    }

    private void settingrankList(){
        //랭킹차트 내부 데이터 구성
        ranklist.add("샴푸");
        ranklist.add("책상");
        ranklist.add("이쑤시개");
        ranklist.add("칫솔");
        ranklist.add("후라이팬");
        ranklist.add("샴푸");
        ranklist.add("샴푸");
        ranklist.add("샴푸");

    }
    private void sendData()
    {
        //서치결과뷰로 데이터 샌딩
        //INTENT OBJ
        Intent i = new Intent(getActivity().getBaseContext(),
                searchActivity.class);

        //PACK DATA
        i.putExtra("SENDER_KEY", "MyFragment");
        i.putExtra("SEARCHWORD_KEY", searchword);


        getActivity().startActivity(i);
    }

}
