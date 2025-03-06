package Personajes;

import java.util.ArrayList;

public class Enano extends WharhammerPersonaje{
    int riqueza;
    private static ArrayList<Enano> lstEnanos = new ArrayList<>();
    public Enano(String nombre, int energia,  int riqueza) {
        super(nombre, energia);
        this.riqueza = riqueza;
    }

    public static void añadirEnanosArray(Enano enano){
        lstEnanos.add(enano);
    }



    public static void imprimirEnanosArray(){

            System.out.println(lstEnanos);

    }


}
