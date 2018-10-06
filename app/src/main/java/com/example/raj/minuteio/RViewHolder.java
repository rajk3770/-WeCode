package com.example.raj.minuteio;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by raj on 11/6/18.
 */

public class RViewHolder extends RecyclerView.ViewHolder {

    LinearLayout leftMsgLayout;



    TextView message;



    public RViewHolder(View itemView){

        super(itemView);

        if(itemView!=null){

           // time=(TextView) itemView.findViewById(R.id.text_message_time);

            message=(TextView)itemView.findViewById(R.id.Message);
            leftMsgLayout=(LinearLayout)itemView.findViewById(R.id.chat_left_msg_layout);



        }

    }
}
