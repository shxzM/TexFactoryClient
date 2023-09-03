package com.shazdevelops.texfactoryclient;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView rcv2;
    ArrayList<DateModel> dateList;
    FirebaseFirestore db,db1;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db=FirebaseFirestore.getInstance();
        db1=FirebaseFirestore.getInstance();
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Weekly.class);
                startActivity(intent);
            }
        });

        rcv2=findViewById(R.id.rcv2);
        getDates();


    }

    private void getDates() {
        dateList = new ArrayList<>();
        dateList.clear();
        db1.collection("Date").orderBy("day").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                if(error==null){
                    List<DateModel> dateModelList = value.toObjects(DateModel.class);
                    if(!dateModelList.isEmpty()){
                        dateList.clear();
                    }
                    dateList.addAll(dateModelList);
                    rcv2.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                    rcv2.setAdapter(new ReadDate(MainActivity.this,dateList));
                }
            }
        });
    }
}