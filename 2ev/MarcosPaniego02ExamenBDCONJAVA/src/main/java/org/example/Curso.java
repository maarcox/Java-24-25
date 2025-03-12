package org.example;

import java.util.ArrayList;

public class Curso {
    private int id_curso;
    private String nombre_curso;
    private String descripcion;
    private int id_categoria;

    private ArrayList<Categorias> categorias = new ArrayList();

    public Curso(int id_curso, String nombre_curso, String descripcion, Categorias categorias) {
        this.id_curso = id_curso;
        this.nombre_curso = nombre_curso;
        this.descripcion = descripcion;
        this.id_categoria = Integer.parseInt(categorias.getId_categoria()); // Extraer el ID de la categoría
    }


    public int getId_curso() {
        return id_curso;
    }

    public void setId_curso(int id_curso) {
        this.id_curso = id_curso;
    }

    public String getNombre_curso() {
        return nombre_curso;
    }

    public void setNombre_curso(String nombre_curso) {
        this.nombre_curso = nombre_curso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public ArrayList<Categorias> getCategorias() {
        return categorias;
    }

    public void setCategorias(ArrayList<Categorias> categorias) {
        this.categorias = categorias;
    }

    @Override
    public String toString() {
        return " ID: " + id_curso + " |  " + nombre_curso + " |  " + descripcion + " |  " + id_categoria + " | ";
    }
}
