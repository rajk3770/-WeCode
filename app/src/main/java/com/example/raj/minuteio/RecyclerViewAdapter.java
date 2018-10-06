package com.example.raj.minuteio;

import android.content.Context;
import android.provider.ContactsContract;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

/**
 * Created by raj on 26/5/18.
 */



public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder>  {

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    private OnItemClickListener mOnItemClickListener;


    private static final String TAG = "RecyclerViewAdapter";

    String[] value;
    //String[] details;
    RecyclerView recyclerView;




    Context context;
    public RecyclerViewAdapter(Context context, List<String> value, OnItemClickListener mOnItemClickListener){
        this.mOnItemClickListener=mOnItemClickListener;
        this.value=new String[value.size()];

    }




    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.meetingcard,parent,false);



        //view.setOnClickListener(new MyOnClickListener());
        return new RecyclerViewHolder(view);
    }








    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, final int position)  {

            Log.e("counting",""+position);
            holder.meeting_type.setText(value[position]);

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mOnItemClickListener.onItemClick(view,position);
                }
            });

            if(position==0){
                holder.date.setText("06-10-2018");
            }
            else{
                holder.date.setText("31-09-2018");
            }


    }




    @Override
    public int getItemCount() {
        Log.e("length hai",""+value.length);
        return value.length;
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {



        TextView meeting_type;
        TextView date;
        public LinearLayout l;

        public RecyclerViewHolder(View itemView) {

            super(itemView);
            meeting_type=(TextView)itemView.findViewById(R.id.textView2);
            date=(TextView)itemView.findViewById(R.id.textView);
        }


    }
}

