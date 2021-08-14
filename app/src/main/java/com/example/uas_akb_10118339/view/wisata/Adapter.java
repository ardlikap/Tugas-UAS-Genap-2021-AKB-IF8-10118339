package com.example.uas_akb_10118339.view.wisata;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uas_akb_10118339.R;
import com.example.uas_akb_10118339.model.Model;

import java.util.ArrayList;

//12 Agustus 2021, 10118060, Muhammad Al Ardlika Prihasiswana, IF-8
public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    Context context;
    ArrayList<Model> list;

    public Adapter(Context context, ArrayList<Model> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        return  new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Model model = list.get(position);
        holder.nama.setText(model.getNama());
        holder.kota.setText(model.getKota());
        holder.jam.setText(model.getJam());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView nama, kota, jam;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            nama = itemView.findViewById(R.id.tvNama);
            kota = itemView.findViewById(R.id.tvKota);
            jam = itemView.findViewById(R.id.tvJam);
        }
    }
}
