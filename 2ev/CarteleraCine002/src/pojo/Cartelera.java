package pojo;

import java.util.ArrayList;
import java.util.Comparator;

public class Cartelera {
   ArrayList<Pelicula> listaPeliculas;

   public Cartelera(){
        this.listaPeliculas = new ArrayList<>();

    }

    public void addPelicula(Pelicula pelicula) {
       listaPeliculas.add(pelicula);

    }

    public void deletePelicula(String busquedaPelicula) {
        for (int i = 0; i < listaPeliculas.size(); i++) {
            Pelicula pelicula = listaPeliculas.get(i);
            if (pelicula.titulo == busquedaPelicula){
                listaPeliculas.remove(i);
            }
        }
    }

    public void imprimirCartelera(String busquedaPelicula) {

       for (Pelicula pelicula: listaPeliculas) {

           if (busquedaPelicula == null){
               System.out.println(pelicula);
           } else if (busquedaPelicula == pelicula.genero || busquedaPelicula == pelicula.titulo) {
               System.out.println(pelicula);
           }

       }
    }


}
