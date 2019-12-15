package com.sergio.practica_equipos.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sergio.practica_equipos.LigasActivity;
import com.sergio.practica_equipos.R;
import com.sergio.practica_equipos.utils.Equipos;

import java.util.ArrayList;

public class AdaptadorEquipos extends RecyclerView.Adapter<AdaptadorEquipos.HolderAdapterEquipos> {

    Context ctx;
    ArrayList<Equipos> listaEquipos;
    OnMiRecyclerListener listener;

    public AdaptadorEquipos(LigasActivity equipos, ArrayList<Equipos> listaEquipos) {
        this.ctx = equipos;
        this.listaEquipos = listaEquipos;
        listener = (OnMiRecyclerListener) ctx;
    }
    @NonNull
    @Override
    public HolderAdapterEquipos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(ctx).inflate(R.layout.recycler_equipos,
                parent,false);
        HolderAdapterEquipos miHolder = new HolderAdapterEquipos(view);
        return miHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull HolderAdapterEquipos holder, int position) {
        final Equipos actual = listaEquipos.get(position);

        holder.getNombreEquipo().setText(actual.getNombreEquipos());
        holder.getImagenEquipo().setImageResource(actual.getEscudo() );
        holder.getNombreEstadio().setText(actual.getEstadio());
        holder.getNombreEquipo().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onMiRecycler(actual);
            }
        });
    }

    @Override
    public int getItemCount() { return listaEquipos.size(); }

    class HolderAdapterEquipos extends RecyclerView.ViewHolder {
        private ImageView imagenEquipo;
        private TextView nombreEquipo,nombreEstadio;
        private LinearLayout layout_Equipos;

        public HolderAdapterEquipos(@NonNull View itemView) {
            super(itemView);

            nombreEquipo = itemView.findViewById(R.id.nombreEquipo);
            nombreEstadio = itemView.findViewById(R.id.nombreEstadio);
            imagenEquipo = itemView.findViewById(R.id.imagenEquipo);
            layout_Equipos = itemView.findViewById(R.id.layout_Equipos);
        }

        public ImageView getImagenEquipo() {
            return imagenEquipo;
        }

        public TextView getNombreEquipo() {
            return nombreEquipo;
        }

        public TextView getNombreEstadio() {
            return nombreEstadio;
        }

        public LinearLayout getLayout_Equipos() {
            return layout_Equipos;
        }
    }
    public interface OnMiRecyclerListener {
        public void onMiRecycler(Equipos equipos);
    }
}