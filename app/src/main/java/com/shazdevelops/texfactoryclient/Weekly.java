package com.shazdevelops.texfactoryclient;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Weekly extends AppCompatActivity {

    RecyclerView wercv;
    FirebaseDatabase database;
    DatabaseReference reference;
    ArrayList<WorkerModel> workerModel;
    WeeklyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weekly);
        wercv=findViewById(R.id.wercv);
        database = FirebaseDatabase.getInstance();



        workerModel = new ArrayList<>();
        workerModel.clear();
        reference=database.getReference().child("Workers");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot:snapshot.getChildren()){

                    WorkerModel workerModel1=dataSnapshot.getValue(WorkerModel.class);
                    workerModel.add(workerModel1);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        adapter=new WeeklyAdapter(Weekly.this,workerModel);
        wercv.setLayoutManager(new LinearLayoutManager(this));
        wercv.setAdapter(adapter);


    }
}