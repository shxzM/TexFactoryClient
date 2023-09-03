package com.shazdevelops.texfactoryclient;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class MainScreen extends AppCompatActivity {

    FirebaseFirestore db;
    ArrayList<TableInfo> allDataList;
    RecyclerView rcv;
    String wDate;

    String du;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        wDate=getIntent().getStringExtra("wDate");
        rcv = findViewById(R.id.rcv);

        du=getIntent().getStringExtra("du");

        db=FirebaseFirestore.getInstance();

        getAllData();



    }

    public void getAllData(){

        allDataList = new ArrayList<>();
        allDataList.clear();
        db.collection("Date").document(du).collection("Table").orderBy("tableNumber").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                if (error == null) {
                    List<TableInfo> data= value.toObjects(TableInfo.class);
                    if(!data.isEmpty()){
                        allDataList.clear();
                    }

                    allDataList.addAll(data);
                    rcv.setLayoutManager(new GridLayoutManager(MainScreen.this,3));
                    rcv.setAdapter(new ReadTableInfo(MainScreen.this,allDataList));
                }
            }
        });
    }
}