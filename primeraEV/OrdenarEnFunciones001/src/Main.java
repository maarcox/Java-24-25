import java.util.Random;

public class Main {
    private static final int filas = 10;
    private static final int columnas = 9;
    private static int[][] tablero;
    private static void rellenarTablero() {
        Random random = new Random();
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                //int numAleatorio= random.nextInt(10)+10*(j+1); //10 - 19

                int numAleatorio = random.nextInt(10*(j+1),(10*(j+1)+10));

                tablero[i][j] = numAleatorio;
            }
        }
    }

    private static void imprimirTablero() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++){
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void ordenarTablero() {
        for (int columna = 0; columna < 9; columna++) {
            for (int i = 0; i < filas - 1; i++) {
                for (int j = i; j < filas; j++) {
                    if (tablero[i][columna] > tablero[j][columna]) {
                        int aux = tablero[i][columna];
                        tablero[i][columna] = tablero[j][columna];
                        tablero[j][columna] = aux;
                    }
                }
            }

        }
    }
    public static void main(String[] args) {
        tablero = new int[filas][columnas];
        rellenarTablero();
        ordenarTablero();
        imprimirTablero();
    }
}