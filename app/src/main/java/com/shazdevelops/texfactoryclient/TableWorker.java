package com.shazdevelops.texfactoryclient;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class TableWorker extends AppCompatActivity {

    String key;
    String keyy;
    RecyclerView wrcv;
    String kw21;
    String kw22;
    ArrayList<WorkerInfo> allWorkerList;
    FirebaseFirestore db1;
    String wDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_worker);
        db1=FirebaseFirestore.getInstance();
        wrcv=findViewById(R.id.wrcv);
        key=getIntent().getStringExtra("key");
        kw21=getIntent().getStringExtra("kw2");
        wDate=getIntent().getStringExtra("wDate");

        getAllWorkerInfo();

    }

    public void getAllWorkerInfo(){
        allWorkerList = new ArrayList<>();
        allWorkerList.clear();
        kw22=getIntent().getStringExtra("kw2");

        keyy = getIntent().getStringExtra("key");
        db1.collection("Date").document(kw22).collection("Table")
                .document(keyy).collection("Workers information").orderBy("workerNumber").addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                        if(error == null){
                            List<WorkerInfo> dat = value.toObjects(WorkerInfo.class);
                            if(!dat.isEmpty()){
                                allWorkerList.clear();
                            }
                            allWorkerList.addAll(dat);
                            wrcv.setLayoutManager(new LinearLayoutManager(TableWorker.this));
                            wrcv.setAdapter(new ReadWorkerInfo(TableWorker.this,allWorkerList));
                        }
                    }
                });

    }
}