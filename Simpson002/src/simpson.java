import java.util.Random;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class simpson {
    private static final int MAX_FILA_TABLERO = 10;
    private static final int MAX_COLUMNA_TABLERO = 10;

    private static char[][] tablero;

    public static void imprimirtablero(){
        // Imprimir tablero
        for (int i = 0; i < MAX_FILA_TABLERO; i++) {
            for (int j = 0; j < MAX_COLUMNA_TABLERO; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println("");
        }
    }
    private static void asignarcasillasLibres(char caracter){
        // Rellenar el tablero de caracter "-"
        for (int i = 0; i < MAX_FILA_TABLERO; i++) {
            for (int j = 0; j < MAX_COLUMNA_TABLERO; j++) {
                tablero[i][j] = caracter;
            }
        }
    }

    private static void asignarPersonajesencasillaLibre(char caracter, int numrepeticiones){
        Random aleatorio = new Random();
        int FilaAleatorio;
        int columnaAleatorio;
        for (int i = 0; i < numrepeticiones; i++) {
            do {
                FilaAleatorio = aleatorio.nextInt(MAX_FILA_TABLERO);
                columnaAleatorio = aleatorio.nextInt(MAX_COLUMNA_TABLERO);
            }while (tablero[FilaAleatorio][columnaAleatorio]!='-');
            tablero[FilaAleatorio][columnaAleatorio] = caracter;
        }
            
        }
    public static void main(String[] args) {
        //1º) Inicializo mi matriz tablero
        tablero = new char[MAX_FILA_TABLERO][MAX_COLUMNA_TABLERO];

        //2º) Asignar casillas libres
        asignarcasillasLibres('-');

        //3º) Asignar a Bart
        asignarPersonajesencasillaLibre('B',1);

        //4º) Asignar 10 hommers
        asignarPersonajesencasillaLibre('H',10);

        //5º) Repartir 10 MUROS dentro del tablero
        asignarPersonajesencasillaLibre('M', 10);

        //6º) Casilla Final
        tablero[MAX_FILA_TABLERO-1] [MAX_COLUMNA_TABLERO -1] = 'F';

        //7ºImprimirtablero;
        imprimirtablero();

       

        //FIN
    }
}