import Personajes.Enano;
import Personajes.PielVerde;
import Personajes.WarhamerPersonaje;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        WarhamerPersonaje pielverde1 = new PielVerde("PielVerde1", "Pisos Picados");
        WarhamerPersonaje enano1 = new Enano("Enano1", 10000);

        System.out.println(enano1);
        System.out.println(pielverde1);
    }
}