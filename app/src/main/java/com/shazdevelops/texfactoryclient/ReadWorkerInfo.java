package com.shazdevelops.texfactoryclient;

import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;

public class ReadWorkerInfo extends RecyclerView.Adapter<ReadWorkerInfo.ReadWorkerHolder> {
    TableWorker tableWorker;
    ArrayList<WorkerInfo> allWorkerList;
    int f1,f2,f3,f4,f5,f6,f7,f8;
    int s1,s2,s3,s4,s5,s6,s7,s8;

    public ReadWorkerInfo(TableWorker tableWorker, ArrayList<WorkerInfo> allWorkerList) {
        this.allWorkerList=allWorkerList;
        this.tableWorker=tableWorker;

    }
    @NonNull
    @Override
    public ReadWorkerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ReadWorkerHolder(LayoutInflater.from(tableWorker).inflate(R.layout.item_worker,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ReadWorkerHolder holder, int position) {
        f1=allWorkerList.get(position).getDef1();
        f2=allWorkerList.get(position).getDef2();
        f3=allWorkerList.get(position).getDef3();
        f4=allWorkerList.get(position).getDef4();
        f5=allWorkerList.get(position).getDef5();
        f6=allWorkerList.get(position).getDef6();
        f7=allWorkerList.get(position).getDef7();
        f8=allWorkerList.get(position).getDef8();

        if (f1>0){
            s1=0;
        }
        else{ s1=1;}
        if (f2>0){
            s2=0;
        }
        else{ s2=1;}
        if (f3>0){
            s3=0;
        }
        else{ s3=1;}
        if (f4>0){
            s4=0;
        }
        else{ s4=1;}
        if (f5>0){
            s5=0;
        }
        else{ s5=1;}
        if (f6>0){
            s6=0;
        }
        else{ s6=1;}
        if (f7>0){
            s7=0;
        }
        else{ s7=1;}
        if (f8>0){
            s8=0;
        }
        else{ s8=1;}

        ArrayList<Entry> info=new ArrayList<>();
        info.add(new Entry(0,0));
        info.add(new Entry(1,s1));
        info.add(new Entry(2,s2));
        info.add(new Entry(3,s3));
        info.add(new Entry(4,s4));
        info.add(new Entry(5,s5));
        info.add(new Entry(6,s6));
        info.add(new Entry(7,s7));
        info.add(new Entry(8,s8));

        LineDataSet lineDataSet=new LineDataSet(info,"Status");
        lineDataSet.setColors(Color.BLUE);
        lineDataSet.setValueTextColor(Color.BLACK);
        lineDataSet.setLineWidth(3);

        LineData lineData=new LineData(lineDataSet);

        holder.lineChart.setData(lineData);
        holder.lineChart.animateX(700);



        holder.name.setText(allWorkerList.get(position).getName());
        holder.workerNo.setText(String.valueOf(allWorkerList.get(position).getWorkerNumber()));
        holder.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tableWorker.startActivity(new Intent(tableWorker,WorkerData.class).putExtra("d1",allWorkerList.get(position).getDef1())
                        .putExtra("d2",allWorkerList.get(position).getDef2()).putExtra("d3",allWorkerList.get(position).getDef3())
                        .putExtra("d4",allWorkerList.get(position).getDef4()).putExtra("d5",allWorkerList.get(position).getDef5())
                        .putExtra("d6",allWorkerList.get(position).getDef6()).putExtra("d7",allWorkerList.get(position).getDef7())
                        .putExtra("d8",allWorkerList.get(position).getDef8()).putExtra("nam",holder.name.getText().toString())
                        .putExtra("wDate",tableWorker.wDate));
            }
        });


//        holder.image.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                tableWorker.startActivity(new Intent(tableWorker,UpdateWorkerStatus.class).
//                        putExtra("wkey",allWorkerList.get(position).getWuid()).putExtra("ke",allWorkerList.get(position).getKe()).
//                        putExtra("n",allWorkerList.get(position).getName()).putExtra("worka",allWorkerList.get(position).getWork())
//                        .putExtra("defect",allWorkerList.get(position).getReason()).putExtra("kw5",allWorkerList.get(position).getKw3())
//                        .putExtra("dt",allWorkerList.get(position).getDef()));
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return allWorkerList.size();
    }

    class ReadWorkerHolder extends RecyclerView.ViewHolder {

        TextView name;
        LineChart lineChart;
        TextView workerNo;
        public ReadWorkerHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.workerName);
            lineChart=itemView.findViewById(R.id.lineChart);
            workerNo=itemView.findViewById(R.id.textView4);


        }
    }
}
