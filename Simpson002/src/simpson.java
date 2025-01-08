import java.util.Random;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class simpson {
    private static final int MAX_FILA_TABLERO = 10;
    private static final int MAX_COLUMNA_TABLERO = 10;
    private static char[][] tablero;
    private static int filaBart;
    private static int columnaBart;

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
        int FilaAleatorio =-1;
        int columnaAleatorio =-1;
        for (int i = 0; i < numrepeticiones; i++) {
            do {
                FilaAleatorio = aleatorio.nextInt(MAX_FILA_TABLERO);
                columnaAleatorio = aleatorio.nextInt(MAX_COLUMNA_TABLERO);
            }while (tablero[FilaAleatorio][columnaAleatorio]!='-');
            tablero[FilaAleatorio][columnaAleatorio] = caracter;
        }
        if (caracter == 'B') {
            filaBart = FilaAleatorio;
            columnaBart = columnaAleatorio;
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

        /* DESPLAZAMIENTO DE BART */
            /*A----izquierda*/
            /*D----derecha*/
            /*W----arriba*/
            /*S----abajo*/
        Scanner lector = new Scanner(System.in);
        /* ***************************************************************************** */
        /*                                   JUGAR                                       */
        /* ***************************************************************************** */
        int vidas  = 10;
       do {
           System.out.println("Diga es desplazamiento que deseas realizar");
           System.out.println("A---> Izquierda, D---> Derecha, W---> Arriba, S---> Abajo");
           String desplazamiento = lector.nextLine();
           System.out.println("Desplazamiento=" + desplazamiento);

           switch (desplazamiento){
               case "A": //izquierda
                   if ((columnaBart - 1 )>=0 ){
                       columnaBart = columnaBart -1;
                       switch (tablero[filaBart][columnaBart]){
                           case 'H':
                               vidas = vidas-1;
                               System.out.println("Te quedan "+vidas+ " vidas");
                               tablero[filaBart][columnaBart] = 'B';
                               tablero[filaBart][columnaBart+1] = '-';
                               break;
                           case 'M':
                                System.out.println("El muro no te deja desplazarte a esta casilla");
                                break;

                       }
                       tablero[filaBart][columnaBart] = 'B';
                       tablero[filaBart][columnaBart+1] = '-';
                   }else{
                       System.out.println("Desplazamiento prohibido. Límite de tablero.");
                   }

                   break;
               case "D":
                   break;
               case "W":
                   break;
               case "S":
                   break;
               default:
                   break;
           }

           imprimirtablero();
       }while (vidas>0);
        //FIN
    }
}