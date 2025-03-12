import Armas.Armas;
import personajes.*;
import Armas.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //Crear Armas
        Armas TelaAraña = new TelaAraña("TelaAraña Super", 5);
        Armas Fuego = new Fuego("Fuego Magnum", 5, 10);

        //Creamos los personajes Malos y buenos
        personajes spiderman1 = new Spiderman("Spiderman", 100, "ROJO", TelaAraña);
        personajes venom1 = new Venom("Venom", 100, 20, Fuego);

        //Creamos dos arrayslist uno para malos y otro para buenos
        ArrayList<personajes> lstMalos = new ArrayList<>();
        ArrayList<personajes> lstbuenos = new ArrayList<>();

        //añadimos los personajes malos y buenos a su array
        lstbuenos.add(spiderman1);
        lstMalos.add(venom1);


        //imprimimos los superheroes y villanos y sus armas
        for (int i = 0; i < lstbuenos.size(); i++) {
            System.out.println("Super Heroes: ");
            System.out.println(lstbuenos);
        }
        System.out.println();
        for (int i = 0; i < lstMalos.size(); i++) {
            System.out.println("Villanos: ");
            System.out.println(lstMalos);
        }

        System.out.println();
        venom1.ataque(spiderman1);
        spiderman1.ataque(venom1);
        System.out.println("El número de personajes creados es: " + (lstMalos.size() + lstbuenos.size()));

    }


}