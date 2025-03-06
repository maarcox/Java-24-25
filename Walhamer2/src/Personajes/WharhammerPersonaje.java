package Personajes;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class WharhammerPersonaje {
    String nombre;
    int energia;


    public WharhammerPersonaje(String nombre, int energia) {
        this.nombre = nombre;
        this.energia = energia;

    }


    @Override
    public String toString() {
        return "WharhammerPersonaje{" +
                "nombre='" + nombre + '\'' +
                ", energia=" + energia +
                '}';
    }
}
