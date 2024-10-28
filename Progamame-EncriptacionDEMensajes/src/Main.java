import java.util.Scanner;
public class Main {
    private static String decodificar(String mensaje, int desplazamiento) {
        StringBuilder resultado = new StringBuilder();
        for (char c : mensaje.toCharArray()) {
            char decodificado = c;
            // Solo decodificamos letras mayúsculas y minúsculas
            if (Character.isLetter(c)) {
                decodificado = (char) (c - desplazamiento);
                // Manejo del wrap-around para letras
                if (Character.isLowerCase(c) && decodificado < 'a') {
                    decodificado += 26;
                } else if (Character.isUpperCase(c) && decodificado < 'A') {
                    decodificado += 26;
                }
            }
            resultado.append(decodificado);
        }
        return resultado.toString();
    }

    private static int contarVocalesNoAcentuadas(String mensaje) {
        int count = 0;
        for (char c : mensaje.toCharArray()) {
            if ("aeiouAEIOU".indexOf(c) != -1) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String line;

        while (true) {
            line = scanner.nextLine();
            // Decodificar el mensaje si no es "FIN"
            if (line.equals("pFIN")) {
                break;
            }

            // Obtenemos el desplazamiento
            char desplazamientoChar = line.charAt(0);
            int desplazamiento = desplazamientoChar - 'p'; // 'p' es la letra base

            // Mensaje codificado
            String mensajeCodificado = line.substring(1);
            System.out.println("Mensaje codificado: " + mensajeCodificado);

            // Decodificamos el mensaje
            String mensajeDecodificado = decodificar(mensajeCodificado, desplazamiento);

            // Contamos las vocales no acentuadas
            int vocalesCount = contarVocalesNoAcentuadas(mensajeDecodificado);

            // Imprimimos el resultado
            System.out.println("Número de vocales no acentuadas: " + vocalesCount);
        }
        scanner.close();
    }
}