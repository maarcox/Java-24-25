import java.util.Scanner;
public class AlturaPiramides {
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

            long bloques = scanner.nextLong();

            if (bloques == 0) {
                break; // Termina la entrada al recibir un 0
            }
            if (bloques < 0 || bloques >2000000000) {
                System.out.println("Numero invalido");
                break;
            }
            if (bloques > 0 || bloques < 2000000000) {
                System.out.println(maxNiveles(bloques));
            }
        }

        scanner.close();

    }
}