package com.sergio.practica_equipos.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sergio.practica_equipos.LigasActivity;
import com.sergio.practica_equipos.R;
import com.sergio.practica_equipos.utils.Ligas;

import java.util.ArrayList;

public class AdaptadorLigas extends RecyclerView.Adapter<AdaptadorLigas.HolderAdapterLigas> {

    Context ctx;
    ArrayList<Ligas> listaLigas;
    OnMiRecyclerListener listener;

    public AdaptadorLigas(LigasActivity ligas, ArrayList<Ligas> listaLigas) {
        this.ctx = ligas;
        this.listaLigas = listaLigas;
        listener = (OnMiRecyclerListener) ctx;
    }

    @NonNull
    @Override
    public HolderAdapterLigas onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(ctx).inflate(R.layout.recycler_ligas,
                parent,false);
        HolderAdapterLigas miHolder = new HolderAdapterLigas(view);
        return miHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull HolderAdapterLigas holder, int position) {

        final Ligas actual = listaLigas.get(position);
        holder.getNombreLiga().setText(actual.getNombreLiga());
        holder.getImagenLiga().setImageResource(actual.getLogoLiga()    );
        holder.getNombreLiga().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onMiRecycler(actual);
            }
        });
        holder.getImagenLiga().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onMiRecycler(actual);
            }
        });
    }

    @Override
    public int getItemCount() {return listaLigas.size();}
    class HolderAdapterLigas extends RecyclerView.ViewHolder {
        private ImageView imagenLiga;
        private TextView nombreLiga;
        private LinearLayout layout_Ligas;
        public HolderAdapterLigas(@NonNull View itemView) {
            super(itemView);

            nombreLiga = itemView.findViewById(R.id.nombre_Liga);
            imagenLiga = itemView.findViewById(R.id.imagen_Liga);
            layout_Ligas = itemView.findViewById(R.id.layout_recycler_Ligas);
        }
        public LinearLayout getLayout_Ligas(){return layout_Ligas;}

        public ImageView getImagenLiga(){return imagenLiga;}

        public TextView getNombreLiga(){return nombreLiga;}

    }
    public interface OnMiRecyclerListener{
        public void onMiRecycler(Ligas ligas);
    }
}