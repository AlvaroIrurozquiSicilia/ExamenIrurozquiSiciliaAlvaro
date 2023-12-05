package com.example.examenirurozquisiciliaalvaro;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class VueltasRVAdapter extends RecyclerView.Adapter<VueltasRVAdapter.VueltasViewHolder> {

    public List<String> tiempos = new ArrayList<>();

    public void addVuelta(String tiempo) {
        tiempos.add(0,tiempo);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public VueltasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_vueltas, parent, false);
        return new VueltasViewHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull VueltasViewHolder holder, int position) {
        holder.getTvTiempo().setText(tiempos.get(position));
    }

    @Override
    public int getItemCount() {
        return tiempos.size();
    }

    public void reiniciar(){
        tiempos.clear();
        notifyDataSetChanged();
    }
    public static class VueltasViewHolder extends RecyclerView.ViewHolder {

        private TextView tvTiempo;

        public VueltasViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTiempo = itemView.findViewById(R.id.tv_Tiempo);
        }

        public TextView getTvTiempo() {
            return tvTiempo;
        }
    }
}
