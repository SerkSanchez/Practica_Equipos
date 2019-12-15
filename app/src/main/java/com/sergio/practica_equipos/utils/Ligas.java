package com.sergio.practica_equipos.utils;

import java.io.Serializable;
import java.util.ArrayList;

public class Ligas implements Serializable{
    String nombreLiga;
    int logoLiga;
    ArrayList ligasEquipos;

    public Ligas(String nombreLiga, int logoLiga, ArrayList ligasEquipos) {
        this.nombreLiga = nombreLiga;
        this.logoLiga = logoLiga;
        this.ligasEquipos = ligasEquipos;
    }

    public ArrayList getLigasEquipos() {
        return ligasEquipos;
    }

    public void setLigasEquipos(ArrayList ligasEquipos) {
        this.ligasEquipos = ligasEquipos;
    }

    public String getNombreLiga() {
        return nombreLiga;
    }

    public void setNombreLiga(String nombreLiga) {
        this.nombreLiga = nombreLiga;
    }

    public int getLogoLiga() {
        return logoLiga;
    }

    public void setLogoLiga(int logoLiga) {
        this.logoLiga = logoLiga;
    }
}