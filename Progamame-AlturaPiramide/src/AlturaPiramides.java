import java.util.Scanner;

public class AlturaPiramides {

    //Nivel 1 mas alto piramide = 1 bloque
    //nivel 2 Penultimo 3x3 = 9 bloques
    //nivel 3 Antepenultimo 5x5 = 25 bloques
    //nivel 4 7x7 = 49 bloques
    //...


    private static int maxNiveles(long bloques) {
        int n = 0;
        long totalBloques = 0;

        while (true) {
            n++;
            totalBloques += (2 * n - 1) * (1 * n - 1); //segun el numero de bloques que ingresemos nos dice en que nivel desde mas arriba de la piramide hasta abajo correponderan
            if (totalBloques > bloques) {
                return n - 1;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Altura De La Piramide");
        Scanner scanner = new Scanner(System.in); //Creamos un scanner
        while (true) {

            long bloques = scanner.nextLong(); //falta poner limite al usuario numero de bloques comprendido entre 0 y 2.000.000.000

            if (bloques == 0) {
                break; // Termina la entrada al recibir un 0
            }
            System.out.println(maxNiveles(bloques));
        }

        scanner.close();

    }
}