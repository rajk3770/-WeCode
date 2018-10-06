package com.example.raj.minuteio;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class Chat_Window extends AppCompatActivity {
    List<String> messages = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat__window);

        RecyclerView list = (RecyclerView) findViewById(R.id.list_chat);


        messages.add("Each of you has received the agenda. I will entertain a motion that the agenda be approved.");
        messages.add("So moved.");
        messages.add("Seconded");
        messages.add("It has been moved and seconded that the agenda be approved as received by the members.");
        messages.add("Mister Chairman, my name has been omitted from the Special Committee on Indigent Care.");
        messages.add("Thank you. If there are no objections, the minutes will be corrected to include the name of Commissioner McCroskey.");
        messages.add("Will the clerk please make this correction. Any further corrections? Seeing none, without objection the minutes will stand approved as read.");
        messages.add("Commissioner Adkins, the first item on the agenda is yours.");
        messages.add(" Mister Chairman, I would like to make a motion to approve the resolution taking money from the Data Processing Reserve Account in the County Clerk's office and moving it to the equipment line to purchase a laptop computer.");
        //messages.add("");

        list.setLayoutManager(new LinearLayoutManager(this));

        list.setAdapter(new adapter(this,messages,new adapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                Log.e("Hello", "Item Click");

            }
        }));
    }
}

