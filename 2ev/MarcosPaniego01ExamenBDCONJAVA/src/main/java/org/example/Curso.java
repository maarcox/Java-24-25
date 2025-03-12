package org.example;

import java.util.ArrayList;

public class Curso {
    private int id_curso;
    private String nombre_curso;
    private String descripcion;
    private int id_categoria;

    private ArrayList<Categorias> categorias = new ArrayList();

    public Curso(int id_curso, String nombre_curso, String descripcion, int id_categoria) {
        this.id_curso = id_curso;
        this.nombre_curso = nombre_curso;
        this.descripcion = descripcion;
        this.id_categoria = id_categoria;
    }

    public int getId() {
        return id_curso;
    }

    public String getTitulo() {
        return nombre_curso;
    }

    public String getDirector() {
        return descripcion;
    }

    public int getAnio() {
        return id_categoria;
    }


    @Override
    public String toString() {
        return " ID: " + id_curso + " |  " + nombre_curso + " |  " + descripcion + " |  " + id_categoria + " | ";
    }
}
