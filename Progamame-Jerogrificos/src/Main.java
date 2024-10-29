import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Definimos los valores y sus respectivas iniciales
        int[] valores = {1000000, 100000, 10000, 1000, 100, 10, 1};
        char[] simbolos = {'H', 'R', 'D', 'F', 'C', 'G', 'T'};

        while (true) {
            System.out.print("Introduzca un numero: ");
            int numero = scanner.nextInt();
            if (numero == 0) {
                break; // Fin de la entrada
            }

            StringBuilder resultado = new StringBuilder();

            for (int i = 0; i < valores.length; i++) {
                while (numero >= valores[i]) {
                    resultado.append(simbolos[i]);
                    numero -= valores[i];
                }
            }

            System.out.println(resultado.toString());
        }
    }
}