import pojo.Cartelera;
import pojo.Pelicula;

public class Main {
    public static void main(String[] args) {
        Cartelera cartelera = new Cartelera();

        //AÑADIR PELICULAS:
        cartelera.addPelicula(new Pelicula("Avengers", 1999, "Accion"));
        cartelera.addPelicula(new Pelicula("Los enanitos", 2015, "Drama"));
        cartelera.addPelicula(new Pelicula("Jumangi", 2020, "Accion"));
        cartelera.addPelicula(new Pelicula("Culpa tuya", 2024, "Drama"));

        System.out.println("CARTELERA CINE: ");
        cartelera.imprimirCartelera(null); //imprimir todas

        System.out.println();
        System.out.println("Peliculas Accion: ");
        cartelera.imprimirCartelera("Accion"); //Imprimir por genero

        System.out.println();
        System.out.println("Pelicula Los enanitos: ");
        cartelera.imprimirCartelera("Los enanitos"); //imprimir por nombre

        System.out.println();
        System.out.println("ELiminamos la pelicula 'Jumangi': ");
        cartelera.deletePelicula("Jumangi"); //elimninar Pelicula

        System.out.println();
        System.out.println("CARTELERA CINE: ");
        cartelera.imprimirCartelera(null); //imprimir todas


    }
}