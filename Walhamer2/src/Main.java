import Personajes.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        PielVerde globin1 = new Globin("Globin1", 20, "Alejandria");
        PielVerde globin2 = new Globin("Globin2", 20, "Alejandria");
        PielVerde.añadirPielverdesArray(globin1);
        PielVerde.añadirPielverdesArray(globin2);
        PielVerde.imprimirPielVerdesArray();

        Enano rompeHierros1 = new RompeHierros("rompehierros1", 10, 2000);
        Enano rompeHierros2 = new RompeHierros("rompehierros2", 20, 2000);
        Enano.añadirEnanosArray(rompeHierros1);
        Enano.añadirEnanosArray(rompeHierros2);
        Enano.imprimirEnanosArray();


    }
}