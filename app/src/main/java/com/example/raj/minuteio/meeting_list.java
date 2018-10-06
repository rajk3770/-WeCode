package com.example.raj.minuteio;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class meeting_list extends AppCompatActivity {
    private DatabaseReference mDatabase;
    private static final String MyPREFERENCES = "MyAndroidFCMIIDService";
    List<String> key_list = new ArrayList<String>();
    List<String> value_list = new ArrayList<String>();
    SnapHelper snapHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view);



        SharedPreferences sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        final String uid=sharedpreferences.getString("uid","");
        Log.e("Uid is",uid);
        mDatabase= FirebaseDatabase.getInstance().getReference().child("KJBDbjwdbn13464").child("Meetings");
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //Log.e("Uid",uid.toString());
                Log.e("UID",uid.toString());
                Log.e("Response is",dataSnapshot.toString());
                for (DataSnapshot d:dataSnapshot.getChildren()){

                    String key=d.getKey();
                    String value=d.getValue().toString();
                    key_list.add(key);
                    value_list.add(value);
                    Log.e("Value list",value_list.toString());

                }


                make_recycler_view();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });



    }

    // create an action bar button
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    // handle button activities
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.mybutton) {
            // do something here
            Intent i=new Intent(meeting_list.this,new_recording.class);
            startActivity(i);


        }
        return super.onOptionsItemSelected(item);
    }

    public void make_recycler_view(){
        snapHelper=new PagerSnapHelper();

        RecyclerView list = (RecyclerView) findViewById(R.id.list2);
        snapHelper.attachToRecyclerView(list);
        list.setLayoutManager(new LinearLayoutManager(this));

        list.setAdapter(new RecyclerViewAdapter(this,value_list,new RecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                Intent i = new Intent(meeting_list.this, Chat_Window.class);

                startActivity(i);

            }
        }));

    }

}


