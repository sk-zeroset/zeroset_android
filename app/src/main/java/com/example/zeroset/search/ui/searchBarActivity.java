package com.example.zeroset.search.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zeroset.MainActivity;
import com.example.zeroset.R;
import com.example.zeroset.home.ui.homeFragment;
import com.example.zeroset.login.ui.registerActivity;
import com.example.zeroset.search.model.Keyword;
import com.example.zeroset.search.ui.adapter.KeywordAdapter;
import com.example.zeroset.search.ui.adapter.RankAdapter;
import com.example.zeroset.search.ui.adapter.SearchAdapter;

import java.util.ArrayList;
import java.util.List;

public class searchBarActivity extends AppCompatActivity {
    ImageButton btn_back;
    ImageButton btn_search;
    List<String> datalist;          // 데이터를 넣은 리스트변수
    ListView searchdatalistv, ranklistv;          // 검색을 보여줄 리스트변수
    EditText editSearch;        // 검색어를 입력할 Input 창
    SearchAdapter adapter;      // 리스트뷰에 연결할 아답터
    ArrayList<String> arraylist, ranklist;
    ArrayList<String> searchedlist;
    LinearLayout rank, keyword;
    RankAdapter adpaterrank;
    RecyclerView keywordlistv;
    String searchword;
    int tabnum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_bar);

        editSearch = findViewById(R.id.editText); //검색어받는 에딧창
        searchdatalistv =  findViewById(R.id.searchdatalist); //키워드 검색했을 때 뜨는 리스트 뷰
        rank =  findViewById(R.id.rankingchart); //랭킹 차트 리니어
        keyword = findViewById(R.id.keyword); //최근검색어 리니어
        ranklistv = findViewById(R.id.ranklist); //랭킹차트
        keywordlistv = findViewById(R.id.keywordview); //최근검색어

        searchedlist = new ArrayList<String>();
        StaggeredGridLayoutManager gridLayoutManager = new StaggeredGridLayoutManager(3, LinearLayoutManager.HORIZONTAL);
        keywordlistv.setLayoutManager(gridLayoutManager);
        KeywordAdapter keywordadapter = new KeywordAdapter();
        settinkeywordList(keywordadapter);
        keywordlistv.setAdapter(keywordadapter);
        keywordadapter.setOnItemClickListener(new KeywordAdapter.OnItemClickListener() {
                                                  @Override
                                                  public void onItemClick(View v, int position) {

                                                      if (keywordadapter.section == true) {
                                                          keywordlistv.setAdapter(keywordadapter);
                                                      } else if (keywordadapter.section == false) {
                                                          editSearch.setText(keywordadapter.keyword);
                                                      }
                                                  }
                                              }

            );

        ranklist = new ArrayList<String>();
        settingrankList();
        adpaterrank = new RankAdapter(this, ranklist);
        ranklistv.setAdapter(adpaterrank);


        datalist = new ArrayList<String>(); //검색어포함데이터리스트
        settingdataList(); //내부데이터세팅
        arraylist = new ArrayList<String>(); //비교대상리스트생성
        arraylist.addAll(datalist);
        datalist.clear();

        adapter = new SearchAdapter(datalist, this);

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
                    InputMethodManager immhide = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
                    immhide.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);

                }
            }
        });

        editSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                switch (actionId) {
                    case EditorInfo.IME_ACTION_SEARCH:
                        searchword = editSearch.getText().toString();
                        sendData(keywordadapter);
                        break;
                    default:
                        // 기본 엔터키 동작
                        return false;
                }
                return true;
            }
        });


        searchdatalistv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                searchword = datalist.get(position);
                sendData(keywordadapter);

            }
        });

        ranklistv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                searchword = ranklist.get(position);
                sendData(keywordadapter);

            }
        });

        btn_search = findViewById(R.id.btn_serch);
        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchword = editSearch.getText().toString();
                sendData(keywordadapter);

            }
        });



        btn_back = findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

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

    private void settinkeywordList(KeywordAdapter k){
        //검색어 기록 내부 데이터 구성

            k.addItem(new Keyword("키이워드"));


    }

    private void sendData(KeywordAdapter k)
    {

        searchedlist.add(searchword);
        //서치결과뷰로 데이터 샌딩
        //INTENT OBJ
        Intent i = new Intent(this,
                searchActivity.class);

        //PACK DATA
        i.putExtra("SENDER_KEY", "MyFragment");
        i.putExtra("SEARCHWORD_KEY", searchword);
        i.putExtra("tabnum", tabnum);


        this.startActivity(i);
    }

}