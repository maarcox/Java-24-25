import java.util.Scanner;
public class Memoriza {

    // Lista de palabras a memorizar
    private static String[] palabras = {"sol", "luna", "estrella", "cielo", "mar", "montaña", "rio", "nube", "flor", "arbol"};
    private static  String[] respuestas = new String[10];

    private static void juegoMemoriza(){
        Scanner scanner = new Scanner(System.in);


        // Mostrar palabras y pedir al usuario que repita las anteriores en orden
        for (int i = 0; i < palabras.length; i++) {
            System.out.println("Palabra a memorizar: " + palabras[i]);
            respuestas[i] = palabras[i];

            System.out.print("Escribe todas las palabras memorizadas hasta ahora: ");
            String entrada = scanner.nextLine();

            // Verificar si la respuesta es correcta
            StringBuilder correctas = new StringBuilder();
            for (int j = 0; j <= i; j++) {
                correctas.append(respuestas[j]).append(" ");
            }

            if (!entrada.equals(correctas.toString().trim())) {
                System.out.println("¡Incorrecto! La secuencia era: " + correctas.toString().trim());
                System.out.println("Intenta de nuevo desde el inicio.");
                i = -1; // Reiniciar el juego
            } else {
                System.out.println("¡Correcto! Sigue a la siguiente palabra.\n");
            }
        }

        System.out.println("¡Felicidades! Has memorizado todas las palabras correctamente.");
        scanner.close();
    }
    public static void main(String[] args) {
        juegoMemoriza();
    }
}

