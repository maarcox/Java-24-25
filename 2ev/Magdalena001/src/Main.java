import pojo.Magdalena;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        /*
        //Magdalena
        Magdalena magdalena = new Magdalena("Marron", "Chocolate", "Naranja", "Chocolate");
        magdalena.hornear();
        magdalena.mezclar();

        /* Magdalena[] listaMagdalenas = new Magdalena[10]; //Almacenamiento array estatico
        listaMagdalenas[0] = magdalena;
        listaMagdalenas[1] = magdalena; */
        System.out.println(("--------------------------------------"));
        String [] listaMagdalenas = new String[4];
        Magdalena magdalena1 = new Magdalena("1 chocolate");
        Magdalena magdalena2 = new Magdalena("2 Vainilla");
        Magdalena magdalena3 = new Magdalena("3 Platano");
        Magdalena magdalena4 = new Magdalena("4 Naranja");

        magdalena1.mostrar();
        magdalena2.mostrar();
        magdalena3.mostrar();
        magdalena4.mostrar();

        // ArrayList<Magdalena> listaMagDinam = new ArrayList(); //Crece el array segun nuestras necesidades

        /*
        magdalena.vender();
        magdalena.decorar();
        magdalena.establecerSabor();
        magdalena.amasar();
        magdalena.mojar();
        magdalena.anyadirPepitas();
        magdalena.comer();
        magdalena.envolver();
        magdalena.coger();

        */
    }
}