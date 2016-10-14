package com.example.dllo.gift_present_0919.home.search;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.dllo.gift_present_0919.R;
import com.example.dllo.gift_present_0919.baseaty.BaseAty;
import com.example.dllo.gift_present_0919.database.MySqlHelper;

import java.util.ArrayList;

public class SearchActivity extends BaseAty {


    private ListView search_listview;
    private SQLiteDatabase dataBase;
    private EditText editText;
    private TextView textView;
    private ArrayList<String> arrayList;
    private ArrayList<SearchBean>  arrayList1;


    private  FlowLayout flowLayout;
    private  String mName[] = {"生日", "手机壳", "保温杯" , "情侣" , "手表" , "杯子" ,
    "宿舍" ,"钱包" ,"生日", "手机壳", "保温杯" , "情侣" , "手表" , "杯子","生日", "手机壳", "保温杯" , "情侣" , "手表" , "杯子"
    ,"生日", "手机壳", "保温杯" , "情侣" , "手表" , "杯子"};

    @Override
    protected int setLayout() {
        return R.layout.activity_search;
    }

    @Override
    protected void initView() {

        editText = bindView(R.id.home_search_editText);
        textView = bindView(R.id.search_textview);

        search_listview = bindView(R.id.search_listview);
        View view = LayoutInflater.from(this).inflate(R.layout.search_head,null);
        search_listview.addHeaderView(view);

        arrayList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            SearchBean bean = new SearchBean();
            bean.setImage(R.mipmap.ic_launcher);
            bean.setName("哈哈哈哈哈");
            bean.setPic(R.mipmap.ic_launcher);
            arrayList1.add(bean);
        }

//        MySqlHelper myhelper = new MySqlHelper(this,"hotWord.db",null,1);
//        dataBase = myhelper.getWritableDatabase();
    }

    @Override
    protected void initData() {


        flowLayout = (FlowLayout) findViewById(R.id.search_flowLayout);
        ViewGroup.MarginLayoutParams lp  = new ViewGroup.MarginLayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        lp.leftMargin = 5;
        lp.rightMargin = 5;
        lp.bottomMargin = 5;
        lp.topMargin = 5;
        for (int i = 0; i <mName.length ; i++) {

            TextView view1 = new TextView(this);
            view1.setText(mName[i]);
            view1.setTextColor(Color.BLACK);
            flowLayout.addView(view1,lp);


        }




        ArrayList<String> arrayList =new ArrayList<>();

        ContentValues  values = new ContentValues();
        values.put("words", editText.getText().toString());
        dataBase.insert("word",null,values);


        Cursor cursor = dataBase.query("word",null,null,null,null,null,null);
        while (cursor.moveToNext()){
            String words = cursor.getString(cursor.getColumnIndex("words"));
            arrayList.add(words);
        }
          SearchAdapter adapter = new SearchAdapter(this);
//        adapter.setArrayList(arrayList);
        search_listview.setAdapter(adapter);


        dataBase.delete("word",null,null);
    }
}
