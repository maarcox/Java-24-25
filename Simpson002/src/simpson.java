import java.util.Random;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class simpson {
    private static final int MAX_FILA_TABLERO = 10;
    private static final int MAX_COLUMNA_TABLERO = 10;

    private static char[][] tablero;

    public static void imprimirtablero(){
        //4º) Imprimir tablero
        for (int i = 0; i < MAX_FILA_TABLERO; i++) {
            for (int j = 0; j < MAX_COLUMNA_TABLERO; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        //1º) Inicializo mi matriz tablero
        tablero = new char[MAX_FILA_TABLERO][MAX_COLUMNA_TABLERO];

        //2º) Rellenar el tablero de caracter "L"
        for (int i = 0; i < MAX_FILA_TABLERO; i++) {
            for (int j = 0; j < MAX_COLUMNA_TABLERO; j++) {
                tablero[i][j] = '-';
            }
        }

        //3º) Asignar a Bart
        Random aleatorio = new Random();
        int FilaAleatorio = aleatorio.nextInt(MAX_FILA_TABLERO);
        int columnaAleatorio = aleatorio.nextInt(MAX_COLUMNA_TABLERO);
        //fin

        tablero[FilaAleatorio][columnaAleatorio] = 'B';


        //4º)Repartir 10 HOMMER dentro del tablero
        int FilaAleatorioHommer;
        int columnaAleatorioHommer;
        for (int i = 0; i < 10; i++) {
            do {
                FilaAleatorioHommer = aleatorio.nextInt(MAX_FILA_TABLERO);
                columnaAleatorioHommer = aleatorio.nextInt(MAX_COLUMNA_TABLERO);
            }while (tablero[FilaAleatorioHommer][columnaAleatorioHommer]!='-');
            tablero[FilaAleatorioHommer][columnaAleatorioHommer] = 'H';
        }
        //4º)Repartir 10 MUROS dentro del tablero
        int FilaAleatorioMuro;
        int columnaAleatorioMuro;
        for (int i = 0; i < 10; i++) {
            do {
                FilaAleatorioMuro = aleatorio.nextInt(MAX_FILA_TABLERO);
                columnaAleatorioMuro = aleatorio.nextInt(MAX_COLUMNA_TABLERO);
            }while (tablero[FilaAleatorioMuro][columnaAleatorioMuro]!='-');
            tablero[FilaAleatorioMuro][columnaAleatorioMuro] = 'M';
        }

        tablero[MAX_FILA_TABLERO-1] [MAX_COLUMNA_TABLERO -1] = 'F';
        //5ºImprimirtablero;
        imprimirtablero();

       

        //FIN
    }
}