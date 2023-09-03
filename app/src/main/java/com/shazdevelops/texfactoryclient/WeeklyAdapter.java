package com.shazdevelops.texfactoryclient;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class WeeklyAdapter extends RecyclerView.Adapter<WeeklyAdapter.ViewHolder> {
    Weekly weekly;
    ArrayList<WorkerModel> workerModel;

    public WeeklyAdapter(Weekly weekly, ArrayList<WorkerModel> workerModel) {
        this.weekly=weekly;
        this.workerModel=workerModel;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(weekly).inflate(R.layout.item_weeklyname,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.weekname.setText(workerModel.get(position).getWname());
        holder.weekname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                weekly.startActivity(new Intent(weekly,WeeklyGraph.class).putExtra("name",holder.weekname.getText().toString()));
            }
        });
    }


    @Override
    public int getItemCount() {
        return workerModel.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView weekname;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            weekname=itemView.findViewById(R.id.weekname);
        }
    }

}

