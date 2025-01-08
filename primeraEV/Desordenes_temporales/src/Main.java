import java.util.Scanner;
public class Main {
    // Función principal para contar los desórdenes utilizando el ordenamiento por mezcla
    private static int ordenarYContarDesorden(int[] arreglo, int[] arregloTemporal, int izquierda, int derecha) {
        int contadorDesorden = 0;
        if (izquierda < derecha) {
            int medio = (izquierda + derecha) / 2;

            // Contar los desórdenes en la parte izquierda
            contadorDesorden += ordenarYContarDesorden(arreglo, arregloTemporal, izquierda, medio);

            // Contar los desórdenes en la parte derecha
            contadorDesorden += ordenarYContarDesorden(arreglo, arregloTemporal, medio + 1, derecha);

            // Contar los desórdenes mientras fusionamos las dos partes
            contadorDesorden += fusionarYContarDesorden(arreglo, arregloTemporal, izquierda, medio, derecha);
        }
        return contadorDesorden;
    }

    // Función para fusionar dos subarreglos y contar los desórdenes
    private static int fusionarYContarDesorden(int[] arreglo, int[] arregloTemporal, int izquierda, int medio, int derecha) {
        int i = izquierda, j = medio + 1, k = izquierda, contadorDesorden = 0;

        while (i <= medio && j <= derecha) {
            if (arreglo[i] <= arreglo[j]) {
                arregloTemporal[k++] = arreglo[i++];
            } else {
                arregloTemporal[k++] = arreglo[j++];
                contadorDesorden += (medio - i + 1); // Todos los elementos en arreglo[i..medio] son mayores que arreglo[j]
            }
        }

        // Copiar los elementos restantes de la primera mitad (si hay)
        while (i <= medio) {
            arregloTemporal[k++] = arreglo[i++];
        }

        // Copiar los elementos restantes de la segunda mitad (si hay)
        while (j <= derecha) {
            arregloTemporal[k++] = arreglo[j++];
        }

        // Copiar los elementos del arreglo temporal al original
        for (i = izquierda; i <= derecha; i++) {
            arreglo[i] = arregloTemporal[i];
        }

        return contadorDesorden;
    }

    // Función para procesar la entrada y mostrar el resultado
    private static void procesarCasos() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int n = scanner.nextInt(); // Número de personas
            if (n == 0) {
                break; // Termina cuando leemos un '0'
            }

            int[] arreglo = new int[n];
            for (int i = 0; i < n; i++) {
                arreglo[i] = scanner.nextInt(); // Edad de cada persona en días vividos
            }

            // Arreglo temporal para la fusión
            int[] arregloTemporal = new int[n];

            // Llamamos a la función ordenarYContarDesorden para obtener el número de desórdenes
            int desordenTotal = ordenarYContarDesorden(arreglo, arregloTemporal, 0, n - 1);

            // Imprimir el desorden total para este caso de prueba
            System.out.println(desordenTotal);
        }

        scanner.close();
    }
    public static void main(String[] args) {
        procesarCasos();
    }
}