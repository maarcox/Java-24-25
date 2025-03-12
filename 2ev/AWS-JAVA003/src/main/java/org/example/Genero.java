package org.example;

import java.util.ArrayList;

public class Genero {
    private String id;
    private String genero;

    //traer y guardar generos desde la base de datos
    private ArrayList<Pelicula> pelicula = new ArrayList();

    public Genero(String id, String genero){
        this.id = id;
        this.genero = genero;
    }



}
