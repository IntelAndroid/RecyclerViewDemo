package com.example.android.recyclerviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private MyRecyclerAdapter mAdapter;
    private RecyclerView mRecyclerView;
    private ArrayList<beanClass> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRecyclerView = new RecyclerView(this);
        setContentView(mRecyclerView);//设置加载布局为RecyclerView
        initview();
        initData();
    }

    //初始化数据
    private void initData() {
        mList = new ArrayList<>();
        beanClass bean = new beanClass();
        for (int i = 0; i < 100; i++) {
            bean.setTitle("带剑豪");
            bean.setContent("世界者密哒");
            mList.add(bean);
        }
        mAdapter = new MyRecyclerAdapter(mList);//实例化适配器
        mRecyclerView.setAdapter(mAdapter);//mRecyclerView设置设配器

    }

    //初始化视图
    private void initview() {
        //mRecyclerView.setLayoutManager(new LinearLayoutManager(this));//线型布局的设置
        //mRecyclerView.setLayoutManager(new GridLayoutManager(this, 4)); //网格布局的设置
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(4,StaggeredGridLayoutManager.HORIZONTAL));
        mRecyclerView.addItemDecoration(
                new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));//添加分割线的设置
    }


}
