package com.shazdevelops.texfactoryclient;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Calendar;

public class WeeklyGraph extends AppCompatActivity {

    String nam;
    FirebaseDatabase db,db2;
    DatabaseReference reference,reference2;
    int c1,c2,c3,c4,c5,c6;
    String currentDate1,currentDate2,currentDate3,currentDate4,currentDate5,currentDate6;
    int[] def= new int[48];
    int[] point = new int[48];
    LineChart lineChart;
    int d1;
    int d2;
    TextView textView;
    String defect1, defect2, defect3, defect4, defect5, defect6, defect7, defect8, defect9, defect10, defect11, defect12,
            defect13, defect14, defect15, defect16, defect17, defect18, defect19, defect20, defect21, defect22, defect23,
            defect24, defect25, defect26, defect27, defect28, defect29, defect30, defect31, defect32, defect33, defect34,
            defect35, defect36, defect37, defect38, defect39, defect40, defect41, defect42, defect43, defect44, defect45,
            defect46, defect47, defect48;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weekly_graph);
        nam=getIntent().getStringExtra("name");
        db=FirebaseDatabase.getInstance();

        lineChart=findViewById(R.id.linecc);
        textView=findViewById(R.id.textView);


        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1; // Note: month is 0-indexed
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        currentDate1 =String.valueOf(day)+String.valueOf(month)+String.valueOf(year);
        c1=Integer.parseInt(currentDate1);
        c2=c1-100000;
        currentDate2=Integer.toString(c2);
        c3=c1-200000;
        currentDate3=Integer.toString(c3);
        c4=c1-300000;
        currentDate4=Integer.toString(c4);
        c5=c1-400000;
        currentDate5=Integer.toString(c5);
        c6=c1-500000;
        currentDate6=Integer.toString(c6);

        reference=db.getReference("Workers").child("Jiyaram");
        db2=FirebaseDatabase.getInstance();
        reference2=db2.getReference("Workers").child(nam);

//        reference.child(currentDate6).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
//            @Override
//            public void onComplete(@NonNull Task<DataSnapshot> task) {
//                if (task.isSuccessful()){
//                    DataSnapshot dataSnapshot= task.getResult();
//                    if (dataSnapshot.hasChild("def1")){
//                        String defect1= String.valueOf(dataSnapshot.child("def1").getValue());
//                        def[0]=Integer.parseInt(defect1);
//                        //d2=def[0];
////                        info.add(new Entry(1,def[0]));
//                       // textView.setText(defect1);
//
//                    }
//                        //textView.setText(String.valueOf(def[0]));
//                    d2=def[0];
//                    //info.add(new Entry(1,4));
//                    if (dataSnapshot.hasChild("def2")){
//                        String defect1= String.valueOf(dataSnapshot.child("def2").getValue());
//                        def[1]=Integer.parseInt(defect1);
//                        //textView.setText(String.valueOf(def[1]));
//                    }
//                    if (dataSnapshot.hasChild("def3")){
//                        String defect1= String.valueOf(dataSnapshot.child("def3").getValue());
//                        def[2]=Integer.parseInt(defect1);
//                        //textView.setText(String.valueOf(d1));
//                    }
//                    if (dataSnapshot.hasChild("def4")){
//                        String defect1= String.valueOf(dataSnapshot.child("def4").getValue());
//                        def[3]=Integer.parseInt(defect1);
//                        //textView.setText(String.valueOf(d1));
//                    }
//                    if (dataSnapshot.hasChild("def5")){
//                        String defect1= String.valueOf(dataSnapshot.child("def5").getValue());
//                        def[4]=Integer.parseInt(defect1);
//                        //textView.setText(String.valueOf(d1));
//                    }
//                    if (dataSnapshot.hasChild("def6")){
//                        String defect1= String.valueOf(dataSnapshot.child("def6").getValue());
//                        def[5]=Integer.parseInt(defect1);
//                        //textView.setText(String.valueOf(d1));
//                    }
//                    if (dataSnapshot.hasChild("def7")){
//                        String defect1= String.valueOf(dataSnapshot.child("def7").getValue());
//                        def[6]=Integer.parseInt(defect1);
//                        //textView.setText(String.valueOf(d1));
//                    }
//                    if (dataSnapshot.hasChild("def8")){
//                        String defect1= String.valueOf(dataSnapshot.child("def8").getValue());
//                        def[7]=Integer.parseInt(defect1);
//                        //textView.setText(String.valueOf(d1));
//                    }
////                    String defect1= String.valueOf(dataSnapshot.child("def2").getValue());
////                    d1=Integer.parseInt(defect1);
//
//                }
//                else{
//                    d1=3;
//                }
//
//
//
//
//            }
//        });
//
////        reference.child(currentDate6).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
////           @Override
////           public void onComplete(@NonNull Task<DataSnapshot> task) {
////               if (task.isSuccessful()){
////
////                    if (task.getResult().exists()){
////                        DataSnapshot dataSnapshot= task.getResult();
////                        def[0]= (int) dataSnapshot.child("def1").getValue();
////                        def[1]= (int) dataSnapshot.child("def2").getValue();
////                        def[2]= (int) dataSnapshot.child("def3").getValue();
////                        def[3]= (int) dataSnapshot.child("def4").getValue();
////                        def[4]= (int) dataSnapshot.child("def5").getValue();
////                        def[5]= (int) dataSnapshot.child("def6").getValue();
////                        def[6]= (int) dataSnapshot.child("def7").getValue();
////                        def[7]= (int) dataSnapshot.child("def8").getValue();
////                    }
////                    else{
////                        def[0]= 0;
////                        def[1]= 0;
////                        def[2]= 0;
////                        def[3]= 0;
////                        def[4]= 0;
////                        def[5]= 0;
////                        def[6]= 0;
////                        def[7]= 0;
////                    }
////                }
////            }
////        });
////
//        reference.child(currentDate5).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
//            @Override
//            public void onComplete(@NonNull Task<DataSnapshot> task) {
//                if (task.isSuccessful()){
//
//                    if (task.isSuccessful()){
//                        DataSnapshot dataSnapshot= task.getResult();
//                        if (dataSnapshot.hasChild("def1")){
//                            String defect1= String.valueOf(dataSnapshot.child("def1").getValue());
//                            def[8]=Integer.parseInt(defect1);
//                            //textView.setText(String.valueOf(d1));
//                        }
//
//                        if (dataSnapshot.hasChild("def2")){
//                            String defect1= String.valueOf(dataSnapshot.child("def2").getValue());
//                            def[9]=Integer.parseInt(defect1);
//                            //textView.setText(String.valueOf(d1));
//                        }
//                        if (dataSnapshot.hasChild("def3")){
//                            String defect1= String.valueOf(dataSnapshot.child("def3").getValue());
//                            def[10]=Integer.parseInt(defect1);
//                            //textView.setText(String.valueOf(d1));
//                        }
//                        if (dataSnapshot.hasChild("def4")){
//                            String defect1= String.valueOf(dataSnapshot.child("def4").getValue());
//                            def[11]=Integer.parseInt(defect1);
//                            //textView.setText(String.valueOf(d1));
//                        }
//                        if (dataSnapshot.hasChild("def5")){
//                            String defect1= String.valueOf(dataSnapshot.child("def5").getValue());
//                            def[12]=Integer.parseInt(defect1);
//                            //textView.setText(String.valueOf(d1));
//                        }
//                        if (dataSnapshot.hasChild("def6")){
//                            String defect1= String.valueOf(dataSnapshot.child("def6").getValue());
//                            def[13]=Integer.parseInt(defect1);
//                            //textView.setText(String.valueOf(d1));
//                        }
//                        if (dataSnapshot.hasChild("def7")){
//                            String defect1= String.valueOf(dataSnapshot.child("def7").getValue());
//                            def[14]=Integer.parseInt(defect1);
//                            //textView.setText(String.valueOf(d1));
//                        }
//                        if (dataSnapshot.hasChild("def8")){
//                            String defect1= String.valueOf(dataSnapshot.child("def8").getValue());
//                            def[15]=Integer.parseInt(defect1);
//                            //textView.setText(String.valueOf(d1));
//                        }
////                    String defect1= String.valueOf(dataSnapshot.child("def2").getValue());
////                    d1=Integer.parseInt(defect1);
//
//                    }
//                    else{
//                        d1=3;
//                    }}
//            }
//        });
////
//        reference.child(currentDate4).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
//            @Override
//            public void onComplete(@NonNull Task<DataSnapshot> task) {
//                if (task.isSuccessful()){
//                    DataSnapshot dataSnapshot= task.getResult();
//                    if (dataSnapshot.hasChild("def1")){
//                        String defect1= String.valueOf(dataSnapshot.child("def1").getValue());
//                        def[16]=Integer.parseInt(defect1);
//                        //textView.setText(String.valueOf(d1));
//                    }
//
//                    if (dataSnapshot.hasChild("def2")){
//                        String defect1= String.valueOf(dataSnapshot.child("def2").getValue());
//                        def[17]=Integer.parseInt(defect1);
//                        //textView.setText(String.valueOf(d1));
//                    }
//                    if (dataSnapshot.hasChild("def3")){
//                        String defect1= String.valueOf(dataSnapshot.child("def3").getValue());
//                        def[18]=Integer.parseInt(defect1);
//                        //textView.setText(String.valueOf(d1));
//                    }
//                    if (dataSnapshot.hasChild("def4")){
//                        String defect1= String.valueOf(dataSnapshot.child("def4").getValue());
//                        def[19]=Integer.parseInt(defect1);
//                        //textView.setText(String.valueOf(d1));
//                    }
//                    if (dataSnapshot.hasChild("def5")){
//                        String defect1= String.valueOf(dataSnapshot.child("def5").getValue());
//                        def[20]=Integer.parseInt(defect1);
//                        //textView.setText(String.valueOf(d1));
//                    }
//                    if (dataSnapshot.hasChild("def6")){
//                        String defect1= String.valueOf(dataSnapshot.child("def6").getValue());
//                        def[21]=Integer.parseInt(defect1);
//                        //textView.setText(String.valueOf(d1));
//                    }
//                    if (dataSnapshot.hasChild("def7")){
//                        String defect1= String.valueOf(dataSnapshot.child("def7").getValue());
//                        def[22]=Integer.parseInt(defect1);
//                        //textView.setText(String.valueOf(d1));
//                    }
//                    if (dataSnapshot.hasChild("def8")){
//                        String defect1= String.valueOf(dataSnapshot.child("def8").getValue());
//                        def[23]=Integer.parseInt(defect1);
//                        //textView.setText(String.valueOf(d1));
//                    }
////                    String defect1= String.valueOf(dataSnapshot.child("def2").getValue());
////                    d1=Integer.parseInt(defect1);
//
//                }
//                else{
//                    d1=3;
//                }
//            }
//        });
////
//        reference.child(currentDate3).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
//            @Override
//            public void onComplete(@NonNull Task<DataSnapshot> task) {
//                if (task.isSuccessful()){
//                    DataSnapshot dataSnapshot= task.getResult();
//                    if (dataSnapshot.hasChild("def1")){
//                        String defect1= String.valueOf(dataSnapshot.child("def1").getValue());
//                        def[24]=Integer.parseInt(defect1);
//                        //textView.setText(String.valueOf(d1));
//                    }
//
//                    if (dataSnapshot.hasChild("def2")){
//                        String defect1= String.valueOf(dataSnapshot.child("def2").getValue());
//                        def[25]=Integer.parseInt(defect1);
//                        //textView.setText(String.valueOf(d1));
//                    }
//                    if (dataSnapshot.hasChild("def3")){
//                        String defect1= String.valueOf(dataSnapshot.child("def3").getValue());
//                        def[26]=Integer.parseInt(defect1);
//                        //textView.setText(String.valueOf(d1));
//                    }
//                    if (dataSnapshot.hasChild("def4")){
//                        String defect1= String.valueOf(dataSnapshot.child("def4").getValue());
//                        def[27]=Integer.parseInt(defect1);
//                        //textView.setText(String.valueOf(d1));
//                    }
//                    if (dataSnapshot.hasChild("def5")){
//                        String defect1= String.valueOf(dataSnapshot.child("def5").getValue());
//                        def[28]=Integer.parseInt(defect1);
//                        //textView.setText(String.valueOf(d1));
//                    }
//                    if (dataSnapshot.hasChild("def6")){
//                        String defect1= String.valueOf(dataSnapshot.child("def6").getValue());
//                        def[29]=Integer.parseInt(defect1);
//                        //textView.setText(String.valueOf(d1));
//                    }
//                    if (dataSnapshot.hasChild("def7")){
//                        String defect1= String.valueOf(dataSnapshot.child("def7").getValue());
//                        def[30]=Integer.parseInt(defect1);
//                        //textView.setText(String.valueOf(d1));
//                    }
//                    if (dataSnapshot.hasChild("def8")){
//                        String defect1= String.valueOf(dataSnapshot.child("def8").getValue());
//                        def[31]=Integer.parseInt(defect1);
//                        //textView.setText(String.valueOf(d1));
//                    }
////                    String defect1= String.valueOf(dataSnapshot.child("def2").getValue());
////                    d1=Integer.parseInt(defect1);
//
//                }
//                else{
//                    d1=3;
//                }
//            }
//        });
//
//        reference.child(currentDate2).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
//            @Override
//            public void onComplete(@NonNull Task<DataSnapshot> task) {
//                if (task.isSuccessful()){
//                    DataSnapshot dataSnapshot= task.getResult();
//                    if (dataSnapshot.hasChild("def1")){
//                        String defect1= String.valueOf(dataSnapshot.child("def1").getValue());
//                        def[32]=Integer.parseInt(defect1);
//                        //textView.setText(String.valueOf(d1));
//                    }
//
//                    if (dataSnapshot.hasChild("def2")){
//                        String defect1= String.valueOf(dataSnapshot.child("def2").getValue());
//                        def[33]=Integer.parseInt(defect1);
//                        //textView.setText(String.valueOf(d1));
//                    }
//                    if (dataSnapshot.hasChild("def3")){
//                        String defect1= String.valueOf(dataSnapshot.child("def3").getValue());
//                        def[34]=Integer.parseInt(defect1);
//                        //textView.setText(String.valueOf(d1));
//                    }
//                    if (dataSnapshot.hasChild("def4")){
//                        String defect1= String.valueOf(dataSnapshot.child("def4").getValue());
//                        def[35]=Integer.parseInt(defect1);
//                        //textView.setText(String.valueOf(d1));
//                    }
//                    if (dataSnapshot.hasChild("def5")){
//                        String defect1= String.valueOf(dataSnapshot.child("def5").getValue());
//                        def[36]=Integer.parseInt(defect1);
//                        //textView.setText(String.valueOf(d1));
//                    }
//                    if (dataSnapshot.hasChild("def6")){
//                        String defect1= String.valueOf(dataSnapshot.child("def6").getValue());
//                        def[37]=Integer.parseInt(defect1);
//                        //textView.setText(String.valueOf(d1));
//                    }
//                    if (dataSnapshot.hasChild("def7")){
//                        String defect1= String.valueOf(dataSnapshot.child("def7").getValue());
//                        def[38]=Integer.parseInt(defect1);
//                        //textView.setText(String.valueOf(d1));
//                    }
//                    if (dataSnapshot.hasChild("def8")){
//                        String defect1= String.valueOf(dataSnapshot.child("def8").getValue());
//                        def[39]=Integer.parseInt(defect1);
//                        //textView.setText(String.valueOf(d1));
//                    }
////                    String defect1= String.valueOf(dataSnapshot.child("def2").getValue());
////                    d1=Integer.parseInt(defect1);
//
//                }
//                else{
//                    d1=3;
//                }
//            }
//        });
////
//        reference.child(currentDate1).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
//            @Override
//            public void onComplete(@NonNull Task<DataSnapshot> task) {
//                if (task.isSuccessful()){
//                    DataSnapshot dataSnapshot= task.getResult();
//                    if (dataSnapshot.hasChild("def1")){
//                        String defect1= String.valueOf(dataSnapshot.child("def1").getValue());
//                        def[40]=Integer.parseInt(defect1);
//                        //textView.setText(String.valueOf(d1));
//                    }
//
//                    if (dataSnapshot.hasChild("def2")){
//                        String defect1= String.valueOf(dataSnapshot.child("def2").getValue());
//                        def[41]=Integer.parseInt(defect1);
//                        //textView.setText(String.valueOf(d1));
//                    }
//                    if (dataSnapshot.hasChild("def3")){
//                        String defect1= String.valueOf(dataSnapshot.child("def3").getValue());
//                        def[42]=Integer.parseInt(defect1);
//                        //textView.setText(String.valueOf(d1));
//                    }
//                    if (dataSnapshot.hasChild("def4")){
//                        String defect1= String.valueOf(dataSnapshot.child("def4").getValue());
//                        def[43]=Integer.parseInt(defect1);
//                        //textView.setText(String.valueOf(d1));
//                    }
//                    if (dataSnapshot.hasChild("def5")){
//                        String defect1= String.valueOf(dataSnapshot.child("def5").getValue());
//                        def[44]=Integer.parseInt(defect1);
//                        //textView.setText(String.valueOf(d1));
//                    }
//                    if (dataSnapshot.hasChild("def6")){
//                        String defect1= String.valueOf(dataSnapshot.child("def6").getValue());
//                        def[45]=Integer.parseInt(defect1);
//                        //textView.setText(String.valueOf(d1));
//                    }
//                    if (dataSnapshot.hasChild("def7")){
//                        String defect1= String.valueOf(dataSnapshot.child("def7").getValue());
//                        def[46]=Integer.parseInt(defect1);
//                        //textView.setText(String.valueOf(d1));
//                    }
//                    if (dataSnapshot.hasChild("def8")){
//                        String defect1= String.valueOf(dataSnapshot.child("def8").getValue());
//                        def[47]=Integer.parseInt(defect1);
//                        //textView.setText(String.valueOf(d1));
//                    }
////                    String defect1= String.valueOf(dataSnapshot.child("def2").getValue());
////                    d1=Integer.parseInt(defect1);
//
//                }
//                else{
//                    d1=3;
//                }
//            }
//        });

//        reference.child(currentDate6).addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                String g=snapshot.child("def1").getValue().toString();
//                def[0]=Integer.parseInt(g);
//                //textView.setText(g);
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });

        //textView.setText(String.valueOf(def[0]));
        //textView.setText(String.valueOf(d2));

        reference2.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (task.isSuccessful()){
                    DataSnapshot snapshot=task.getResult();
                    ArrayList<Entry> info=new ArrayList<>();
                    if (snapshot.hasChild("1042023")){
                        defect1= String.valueOf(snapshot.child("1042023").child("def1").getValue());
                        defect2=String.valueOf(snapshot.child("1042023").child("def2").getValue());
                        defect3=String.valueOf(snapshot.child("1042023").child("def3").getValue());
                        defect4=String.valueOf(snapshot.child("1042023").child("def4").getValue());
                        defect5=String.valueOf(snapshot.child("1042023").child("def5").getValue());
                        defect6=String.valueOf(snapshot.child("1042023").child("def6").getValue());
                        defect7=String.valueOf(snapshot.child("1042023").child("def7").getValue());
                        defect8=String.valueOf(snapshot.child("1042023").child("def8").getValue());
                        def[0] = Integer.parseInt(defect1);
                        def[1] = Integer.parseInt(defect2);
                        def[2] = Integer.parseInt(defect3);
                        def[3] = Integer.parseInt(defect4);
                        def[4] = Integer.parseInt(defect5);
                        def[5] = Integer.parseInt(defect6);
                        def[6] = Integer.parseInt(defect7);
                        def[7] = Integer.parseInt(defect8);
                    }
                    if (snapshot.hasChild("1142023")){
                        defect9= String.valueOf(snapshot.child("1142023").child("def1").getValue());
                        defect10= String.valueOf(snapshot.child("1142023").child("def2").getValue());
                        defect11= String.valueOf(snapshot.child("1142023").child("def3").getValue());
                        defect12= String.valueOf(snapshot.child("1142023").child("def4").getValue());
                        defect13= String.valueOf(snapshot.child("1142023").child("def5").getValue());
                        defect14= String.valueOf(snapshot.child("1142023").child("def6").getValue());
                        defect15= String.valueOf(snapshot.child("1142023").child("def7").getValue());
                        defect16= String.valueOf(snapshot.child("1142023").child("def8").getValue());
                        def[8] = Integer.parseInt(defect9);
                        def[9] = Integer.parseInt(defect10);
                        def[10] = Integer.parseInt(defect11);
                        def[11] = Integer.parseInt(defect12);
                        def[12] = Integer.parseInt(defect13);
                        def[13] = Integer.parseInt(defect14);
                        def[14] = Integer.parseInt(defect15);
                        def[15] = Integer.parseInt(defect16);

                    }
                    if (snapshot.hasChild("1242023")){
                        defect17=String.valueOf(snapshot.child("1242023").child("def1").getValue());
                        defect18=String.valueOf(snapshot.child("1242023").child("def2").getValue());
                        defect19=String.valueOf(snapshot.child("1242023").child("def3").getValue());
                        defect20=String.valueOf(snapshot.child("1242023").child("def4").getValue());
                        defect21=String.valueOf(snapshot.child("1242023").child("def5").getValue());
                        defect22=String.valueOf(snapshot.child("1242023").child("def6").getValue());
                        defect23=String.valueOf(snapshot.child("1242023").child("def7").getValue());
                        defect24=String.valueOf(snapshot.child("1242023").child("def8").getValue());
                        def[16] = Integer.parseInt(defect17);
                        def[17] = Integer.parseInt(defect18);
                        def[18] = Integer.parseInt(defect19);
                        def[19] = Integer.parseInt(defect20);
                        def[20] = Integer.parseInt(defect21);
                        def[21] = Integer.parseInt(defect22);
                        def[22] = Integer.parseInt(defect23);
                        def[23] = Integer.parseInt(defect24);

                    }

                    if (snapshot.hasChild("1342023")){
                        defect25=String.valueOf(snapshot.child("1342023").child("def1").getValue());
                        defect26=String.valueOf(snapshot.child("1342023").child("def2").getValue());
                        defect27=String.valueOf(snapshot.child("1342023").child("def3").getValue());
                        defect28=String.valueOf(snapshot.child("1342023").child("def4").getValue());
                        defect29=String.valueOf(snapshot.child("1342023").child("def5").getValue());
                        defect30=String.valueOf(snapshot.child("1342023").child("def6").getValue());
                        defect31=String.valueOf(snapshot.child("1342023").child("def7").getValue());
                        defect32=String.valueOf(snapshot.child("1342023").child("def8").getValue());
                        def[24] = Integer.parseInt(defect25);
                        def[25] = Integer.parseInt(defect26);
                        def[26] = Integer.parseInt(defect27);
                        def[27] = Integer.parseInt(defect28);
                        def[28] = Integer.parseInt(defect29);
                        def[29] = Integer.parseInt(defect30);
                        def[30] = Integer.parseInt(defect31);
                        def[31] = Integer.parseInt(defect32);
                    }
                    if (snapshot.hasChild("1442023")){
                        defect33=String.valueOf(snapshot.child("1442023").child("def1").getValue());
                        defect34=String.valueOf(snapshot.child("1442023").child("def1").getValue());
                        defect35=String.valueOf(snapshot.child("1442023").child("def1").getValue());
                        defect36=String.valueOf(snapshot.child("1442023").child("def1").getValue());
                        defect37=String.valueOf(snapshot.child("1442023").child("def1").getValue());
                        defect38=String.valueOf(snapshot.child("1442023").child("def1").getValue());
                        defect39=String.valueOf(snapshot.child("1442023").child("def1").getValue());
                        defect40=String.valueOf(snapshot.child("1442023").child("def1").getValue());
                        def[32] = Integer.parseInt(defect33);
                        def[33] = Integer.parseInt(defect34);
                        def[34] = Integer.parseInt(defect35);
                        def[35] = Integer.parseInt(defect36);
                        def[36] = Integer.parseInt(defect37);
                        def[37] = Integer.parseInt(defect38);
                        def[38] = Integer.parseInt(defect39);
                        def[39] = Integer.parseInt(defect40);

                    }
                    if (snapshot.hasChild("1542023")){
                        defect41=String.valueOf(snapshot.child("1542023").child("def1").getValue());
                        defect42=String.valueOf(snapshot.child("1542023").child("def2").getValue());
                        defect43=String.valueOf(snapshot.child("1542023").child("def3").getValue());
                        defect44=String.valueOf(snapshot.child("1542023").child("def4").getValue());
                        defect45=String.valueOf(snapshot.child("1542023").child("def5").getValue());
                        defect46=String.valueOf(snapshot.child("1542023").child("def6").getValue());
                        defect47=String.valueOf(snapshot.child("1542023").child("def7").getValue());
                        defect48=String.valueOf(snapshot.child("1542023").child("def8").getValue());
                        def[40] = Integer.parseInt(defect41);
                        def[41] = Integer.parseInt(defect42);
                        def[42] = Integer.parseInt(defect43);
                        def[43] = Integer.parseInt(defect44);
                        def[44] = Integer.parseInt(defect45);
                        def[45] = Integer.parseInt(defect46);
                        def[46] = Integer.parseInt(defect47);
                        def[47] = Integer.parseInt(defect48);
                    }
                    String wwname=String.valueOf(snapshot.child("wname").getValue());
                    textView.setText(wwname);

                    if (def[0]<3){
                        point[0]=1;
                    }
                    else{
                        point[0]=-1;
                    }

                    for (int i=1;i<48;i++){
                        if (def[i]<3){
                            point[i]=point[i-1]+1;
                        }
                        else{
                            point[i]=point[i-1]-1;
                        }
                    }

                    info.add(new Entry(0,0));

                    for (int j=0;j<48;j++){
                        info.add(new Entry(j+1,point[j]));
                    }


                    LineDataSet lineDataSet = new LineDataSet(info,"Weekly Data");
                    lineDataSet.setColors(Color.BLUE);
                    lineDataSet.setValueTextColor(Color.BLACK);
                    lineDataSet.setLineWidth(3);
                    lineDataSet.setDrawCircles(false);
                    lineDataSet.setDrawValues(false);
                    LineData lineData=new LineData(lineDataSet);

                    lineChart.setData(lineData);
                    lineChart.animateX(700);

                }
            }
        });

//        info.add(new Entry(0,0));
//        //info.add(new Entry(1,def[0]));
//        info.add(new Entry(2,4));
//        info.add(new Entry(3,0));
//        info.add(new Entry(4,0));
//        info.add(new Entry(5,0));
//        info.add(new Entry(6,0));
//        info.add(new Entry(7,0));
//        info.add(new Entry(8,0));


//        for(int i=0;i<48;i++)
//        {
//            info.add(new Entry(i+1,def[i]));
//        }

//        LineDataSet lineDataSet = new LineDataSet(info,"Weekly Data");
//        lineDataSet.setColors(Color.BLUE);
//        lineDataSet.setValueTextColor(Color.BLACK);
//        lineDataSet.setLineWidth(3);
//
//        LineData lineData=new LineData(lineDataSet);
//
//        lineChart.setData(lineData);
//        lineChart.animateX(700);

//        readWeekData(new FirebaseCallback() {
//            @Override
//            public void onCallback(int[] defe) {
//                textView.setText(String.valueOf(defe[4]));
//            }
//        });


    }

//    private void readWeekData(FirebaseCallback firebaseCallback){
//
//
//        reference.child("2642023").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
//            @Override
//            public void onComplete(@NonNull Task<DataSnapshot> task) {
//                if (task.isSuccessful()){
//                    DataSnapshot dataSnapshot= task.getResult();
//                    if (dataSnapshot.hasChild("def1")){
//                        String defect1= String.valueOf(dataSnapshot.child("def1").getValue());
//                        def[0]=Integer.parseInt(defect1);
//                        //d2=def[0];
////                        info.add(new Entry(1,def[0]));
//                        // textView.setText(defect1);
//
//                    }
//                    //textView.setText(String.valueOf(def[0]));
//                   // d2=def[0];
//                    //info.add(new Entry(1,4));
//                    if (dataSnapshot.hasChild("def2")){
//                        String defect1= String.valueOf(dataSnapshot.child("def2").getValue());
//                        def[1]=Integer.parseInt(defect1);
//                        //textView.setText(String.valueOf(def[1]));
//                    }
//                    if (dataSnapshot.hasChild("def3")){
//                        String defect1= String.valueOf(dataSnapshot.child("def3").getValue());
//                        def[2]=Integer.parseInt(defect1);
//                        //textView.setText(String.valueOf(d1));
//                    }
//                    if (dataSnapshot.hasChild("def4")){
//                        String defect1= String.valueOf(dataSnapshot.child("def4").getValue());
//                        def[3]=Integer.parseInt(defect1);
//                        //textView.setText(String.valueOf(d1));
//                    }
//                    if (dataSnapshot.hasChild("def5")){
//                        String defect1= String.valueOf(dataSnapshot.child("def5").getValue());
//                        def[4]=Integer.parseInt(defect1);
//                        //textView.setText(String.valueOf(d1));
//                    }
//                    if (dataSnapshot.hasChild("def6")){
//                        String defect1= String.valueOf(dataSnapshot.child("def6").getValue());
//                        def[5]=Integer.parseInt(defect1);
//                        //textView.setText(String.valueOf(d1));
//                    }
//                    if (dataSnapshot.hasChild("def7")){
//                        String defect1= String.valueOf(dataSnapshot.child("def7").getValue());
//                        def[6]=Integer.parseInt(defect1);
//                        //textView.setText(String.valueOf(d1));
//                    }
//                    if (dataSnapshot.hasChild("def8")){
//                        String defect1= String.valueOf(dataSnapshot.child("def8").getValue());
//                        def[7]=Integer.parseInt(defect1);
//                        //textView.setText(String.valueOf(d1));
//                    }
////                    String defect1= String.valueOf(dataSnapshot.child("def2").getValue());
////                    d1=Integer.parseInt(defect1);
//
//                }
//                else{
//                    d1=3;
//                }
//
//                firebaseCallback.onCallback(def);
//
//
//            }
//        });
//
//    }
//
//    private interface FirebaseCallback{
//        void onCallback(int[] defe);
//    }

}