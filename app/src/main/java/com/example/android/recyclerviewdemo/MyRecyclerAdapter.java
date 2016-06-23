package com.example.android.recyclerviewdemo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Android on 2016/6/23.
 */
public class MyRecyclerAdapter extends RecyclerView.Adapter {
    private ArrayList<beanClass> mList;//创建Arraylist对象集合
    private ViewHolder mViewHolder;

    //创建构造函数接受传来的数据
    public MyRecyclerAdapter(ArrayList<beanClass> list) {
        mList = list;

    }

    /**
     * 创建viewHolder
     * @param parent
     * @param viewType
     * @return
     */

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //创建布局文件加载到Recyclerview中
        mViewHolder = new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.view_recycler, null));
//并返回viewholder
        return mViewHolder;
    }

    /**
     * 绑定viewHolder
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder vh = (ViewHolder) holder;//自己创建的viewholder要等于Recyclerview.viewholder;
        beanClass bean = new beanClass();//集合中的beanclass实例化
        vh.getMtitle().setText(bean.title);//添加数据
        vh.getMcontent().setText(bean.content);

    }

    /**
     * 获取项目的大小
     * @return
     */
    @Override
    public int getItemCount() {
        return mList.size();
    }

    /**
     * 自己创建的viewHolder
     */
    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mtitle;//初始化view中的控件
        private TextView mcontent;


        public TextView getMtitle() { //获取控件的值
            return mtitle;
        }

        public TextView getMcontent() {
            return mcontent;
        }


        public ViewHolder(View itemView) {
            super(itemView);
            mtitle = (TextView) itemView.findViewById(R.id.textView);//查找id
            mcontent = (TextView) itemView.findViewById(R.id.textView2);


        }
    }
}
