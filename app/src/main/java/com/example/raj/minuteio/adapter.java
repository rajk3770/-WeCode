package com.example.raj.minuteio;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by raj on 6/10/18.
 */

public class adapter extends RecyclerView.Adapter<RViewHolder> {

Context mContext;

String[] list_of_msg;
public interface OnItemClickListener {
    void onItemClick(View view, int position);
}

    private OnItemClickListener mOnItemClickListener;

    public adapter(Context context, List<String> msg,
                           OnItemClickListener mOnItemClickListener){


        list_of_msg=new String[msg.size()];
        this.mOnItemClickListener=mOnItemClickListener;
        mContext=context.getApplicationContext();
        for(int i=0;i<msg.size();i++){

            list_of_msg[i]=msg.get(i);
        }

    }

    @Override
    public void onBindViewHolder(RViewHolder holder, final int position) {
        //colors=["red","blue","orange"];
        if(position==0 || position== 5 || position==6){
            holder.leftMsgLayout.setBackgroundDrawable(ContextCompat.getDrawable(mContext,R.drawable.new_back));
            //holder.leftMsgLayout.setBackgroundColor(Color.parseColor("#ffffff"));

        }
        holder.message.setText(list_of_msg[position]);


    }

    public RViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        LayoutInflater l=LayoutInflater.from(parent.getContext());
        View v=l.inflate(R.layout.recyler_view_item,parent,false);
        return new RViewHolder(v);
    }

    @Override
    public int getItemCount() {

        return list_of_msg.length;
    }

}
