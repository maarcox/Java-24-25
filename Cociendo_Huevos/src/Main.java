import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Leer los valores de h (huevos) y c (capacidad de la olla)
            int h = scanner.nextInt();
            int c = scanner.nextInt();

            // Si ambos son 0, terminamos la entrada
            if (h == 0 && c == 0) {
                break;
            }

            // Calcular el número de rondas necesarias
            int rondas = (h + c - 1) / c; 

            // El tiempo total es el número de rondas multiplicado por 10 minutos
            System.out.println(rondas * 10);
        }

        scanner.close();
    }
}