package com.wd.doctor.activity;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.wd.doctor.R;
import com.wd.doctor.adapter.InquiryListAdapter;
import com.wd.doctor.base.BaseActivity;
import com.wd.doctor.bean.wy.InquiryBean;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

/**
 * @author 王阳
 * Class :1708A
 * @description:
 * @date :2020/5/27 19:31
 * @classname :AskProblemActivity
 */
public class AskProblemActivity extends BaseActivity {
    private android.widget.ImageView imgBackAsk;
    private android.widget.ImageView imgMessageBlack;
    private androidx.recyclerview.widget.RecyclerView recyclerAsk;
    private ArrayList<InquiryBean> list;
    private InquiryListAdapter inquiryListAdapter;

    @Override
    public int initLayoutId() {
        return R.layout.activity_ask_problem;
    }
    private void initView() {
        imgBackAsk = (ImageView) findViewById(R.id.imgBackAsk);
        imgMessageBlack = (ImageView) findViewById(R.id.imgMessageBlack);
        recyclerAsk = (RecyclerView) findViewById(R.id.recyclerAsk);
    }
    @Override
    protected void initListener() {
        super.initListener();
        initView();
        imgBackAsk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        //消息
        imgMessageBlack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AskProblemActivity.this, MessageActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void initData() {
        super.initData();
        initView();
        list =new ArrayList<InquiryBean>();
        list.add(new InquiryBean("http://mobile.bwstudent.com/images/movie/stills/dzd6qmwj/dzd6qmwj1.jpg"
                ,"小红","你好",1600704000000l));
        list.add(new InquiryBean("http://mobile.bwstudent.com/images/movie/stills/dzd6qmwj/dzd6qmwj1.jpg"
                ,"小名","嘿嘿",1600704000000l));
        list.add(new InquiryBean("http://mobile.bwstudent.com/images/movie/stills/dzd6qmwj/dzd6qmwj1.jpg"
                ,"小王","嘿嘿",1600704000000l));
        list.add(new InquiryBean("http://mobile.bwstudent.com/images/movie/stills/dzd6qmwj/dzd6qmwj1.jpg"
                ,"小张","嘿嘿",1600704000000l));

        recyclerAsk.setLayoutManager(new LinearLayoutManager(this));
        inquiryListAdapter = new InquiryListAdapter(list,this);
        recyclerAsk.setAdapter(inquiryListAdapter);
    }

    @NotNull
    @Override
    public String getLoggerTag() {
        return null;
    }
}
