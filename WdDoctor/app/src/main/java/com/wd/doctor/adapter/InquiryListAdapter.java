package com.wd.doctor.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wd.doctor.R;
import com.wd.doctor.activity.UserChatActivity;
import com.wd.doctor.bean.wy.InquiryBean;
import com.wd.doctor.net.NetManager;
import com.wd.doctor.util.TimeStampUtil;

import java.util.ArrayList;

//聊天   好友
public class InquiryListAdapter extends RecyclerView.Adapter<InquiryListAdapter.InquiryListHolder> {
     private ArrayList<InquiryBean> list=new ArrayList<>();
     private Context context;
     private InquiryListHolder inquiryListHolder;

  public InquiryListAdapter(ArrayList<InquiryBean> list, Context context) {
      this.list.addAll(list);
      this.context = context;
  }

  @NonNull
  @Override
  public InquiryListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view= LayoutInflater.from(context).inflate(R.layout.inquirylist_item,parent,false);
    inquiryListHolder = new InquiryListHolder(view);
    return inquiryListHolder;
  }

  @Override
  public void onBindViewHolder(@NonNull InquiryListHolder holder, int position) {
    inquiryListHolder.message_username.setText(list.get(position).getUsername());
    inquiryListHolder.message_usertime.setText(TimeStampUtil.INSTANCE.transToString(list.get(position).getUsertime()));
    inquiryListHolder.message_usercontent.setText(list.get(position).getUsermessage());
    inquiryListHolder.message_contentcount.setText("1");
    NetManager.Companion.getNetManager().getCirclePhoto(list.get(position).getUserheadpic(),inquiryListHolder.message_userimg);
    inquiryListHolder.itemView.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
          Intent intent=new Intent(context, UserChatActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("name",list.get(position).getUsername());
        intent.putExtras(bundle);
        context.startActivity(intent);
      }
    });

  }

  @Override
  public int getItemCount() {
    return list.size();
  }

  class  InquiryListHolder extends RecyclerView.ViewHolder{
    ImageView message_userimg;
    TextView message_username, message_usertime, message_usercontent, message_contentcount;
    public InquiryListHolder(@NonNull View itemView) {
      super(itemView);
      message_userimg = itemView.findViewById(R.id.message_userimg);
      message_username = itemView.findViewById(R.id.message_username);
      message_usertime = itemView.findViewById(R.id.message_usertime);
      message_usercontent = itemView.findViewById(R.id.message_usercontent);
      message_contentcount = itemView.findViewById(R.id.message_contentcount);
    }
  }
}
