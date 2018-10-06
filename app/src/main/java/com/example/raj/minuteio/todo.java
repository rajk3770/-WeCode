package bhumil.test.minutes;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bhumil on 6/10/18.
 */

public class todo extends AppCompatActivity {

    private RecyclerView todo_list;
    private summary_adapter adapter;
    private List<helper> listItems;
    private DatabaseReference root;
    private List<String> tasks;
    private List<String> values;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.summary);


        tasks = new ArrayList<>();
        tasks.add("Report to the GM");
        tasks.add("Set the interview");
        tasks.add("Pay the clients");
        tasks.add("Attend the function");
        tasks.add("Agenda for next meet");
        tasks.add("Finalize the offer");
        tasks.add("Final the share %");
        listItems = new ArrayList<>();

        todo_list = findViewById(R.id.todo_list);
        todo_list.setHasFixedSize(true);
        todo_list.setLayoutManager(new LinearLayoutManager(this));

//        root = FirebaseDatabase.getInstance().getReference().child("KJBDbjwdbn13464").child("To_Do").child("bh34");
//        root.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                for(DataSnapshot ds: dataSnapshot.getChildren()) {
//                    String task = dataSnapshot.getKey();
//                    String val = dataSnapshot.getValue().toString();
//                    tasks.add(task);
//                    values.add(val);
//                }
//
//                populate();
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });

        for(int i=0;i<tasks.size();i++) {
            String place_name = tasks.get(i);
            helper listItem = new helper(place_name);
            listItems.add(listItem);
        }

        adapter = new summary_adapter(listItems,getApplicationContext());
        todo_list.setAdapter(adapter);


    }

    void populate(){

    }
}
