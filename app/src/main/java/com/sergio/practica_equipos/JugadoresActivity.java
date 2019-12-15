package com.sergio.practica_equipos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.sergio.practica_equipos.adaptadores.AdaptadorJugadores;
import com.sergio.practica_equipos.utils.DataSet;
import com.sergio.practica_equipos.utils.Jugadores;

import java.util.ArrayList;

public class JugadoresActivity extends AppCompatActivity {
    AdaptadorJugadores adaptadorJugadores;
    RecyclerView recyclerJugadores;
    ArrayList<Jugadores> listaJugadores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jugadores);
        instancias();
    }

    private void instancias() {
        recyclerJugadores = findViewById(R.id.layout_jugadores);
        listaJugadores = new ArrayList();
        listaJugadores = DataSet.newInstance().jugadoresMadrid();

        adaptadorJugadores = new AdaptadorJugadores(this,listaJugadores);
        recyclerJugadores.setAdapter(adaptadorJugadores);
        adaptadorJugadores.notifyDataSetChanged();
        recyclerJugadores.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));
    }
}





/*
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.sergio.practica_equipos.adapters.AdapterPlayers;
import com.sergio.practica_equipos.utils.DataSet;
import com.sergio.practica_equipos.utils.Jugadores;

import java.util.ArrayList;

public class JugadoresActivity extends AppCompatActivity {

    AdapterPlayers adapterPlayers;
    RecyclerView recyclerJugadores;
    ArrayList<Jugadores> listaJugadores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jugadores);
        instancias();
    }

    private void instancias() {
        recyclerJugadores = findViewById(R.id.layout_jugadores);
        listaJugadores = new ArrayList();
        listaJugadores = DataSet.newInstance().jugadoresMadrid();

        adapterPlayers = new AdapterPlayers(this, listaJugadores);
        recyclerJugadores.setAdapter(adapterPlayers);
        adapterPlayers.notifyDataSetChanged();

        recyclerJugadores.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL,false));
    }
}
*/