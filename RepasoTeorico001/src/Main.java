import java.util.Random;

public class Main {
    private static int[][] matriz = new int[3][9];

    private static void rellenarColumnasDependiendoRango() {
        Random random = new Random();

        // Llenar la matriz de acuerdo al rango en cada columna
        for (int col = 0; col < matriz[0].length; col++) {
            int min = 10 + (col * 10); // valor mínimo para la columna actual
            int max = min + 9;         // valor máximo para la columna actual


            for (int row = 0; row < matriz.length; row++) {
                matriz[row][col] = random.nextInt(max - min + 1) + min;
            }

            //ordenar columna
            for (int i = 0; i < matriz.length - 1; i++) {
                for (int j = i + 1; j < matriz.length; j++) {
                    if (matriz[i][col] > matriz[j][col]) {
                        int temp = matriz[i][col];
                        matriz[i][col] = matriz[j][col];
                        matriz[j][col] = temp;
                    }
                }
            }
        }
    }
    
    private static void imprimirmatriz() {
        // Imprimir la matriz
        for (int row = 0; row < matriz.length; row++) {
            for (int col = 0; col < matriz[0].length; col++) {
                System.out.print(matriz[row][col] + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        rellenarColumnasDependiendoRango();
        imprimirmatriz();
    }
}
