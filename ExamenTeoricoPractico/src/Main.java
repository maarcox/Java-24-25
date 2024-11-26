import java.util.Random;

public class Main {
    //tablero 10 x 10
    private static char tableroMapaJeoGrafico[][] = new char[10][10];
    private static int tableroPuntuaciones[][] = new int[10][12];
    private static char paises[] = new char[]{'E', 'F', 'G', 'I', 'O','L','P','U', 'A', 'W'};
    private static int puntuaciones[] = new int[]{8, 7, 6, 5, 4, 3, 2, 1};
    private static int filaCordenada;
    private static int columnaCordenada;
    private static void inicializarMapaGeografico(){
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                tableroMapaJeoGrafico[i][j] = '-';
            }
        }
    }

    private static void asignarPaisesMapa(){
        Random aleatorio = new Random();
        int filaAleatorio;
        int columnaAleatorio;
        for (int i = 0; i < 10; i++) {
            do {
                filaAleatorio = aleatorio.nextInt(10);
                columnaAleatorio = aleatorio.nextInt(10);
            }while(tableroMapaJeoGrafico[filaAleatorio][columnaAleatorio] != '-');
            tableroMapaJeoGrafico[filaAleatorio][columnaAleatorio] = paises[i];
            tableroPuntuaciones[i][0] = filaAleatorio;
            tableroPuntuaciones[i][1] = columnaAleatorio;
        }
    }

    private static void rellenarTableroPuntuaciones(){
        Random aleatorio = new Random();
        int numeroAleatorio;
        for (int i = 0; i < 10; i++) {
            for (int j = 2; j < 12; j++) {
                numeroAleatorio = aleatorio.nextInt(puntuaciones.length);


                tableroPuntuaciones[i][j] = puntuaciones[numeroAleatorio];
            }
        }
    }

    private static void mostrarTableroPuntuaciones(){
        System.out.println();
        System.out.println("Tablero Puntuaciones");
        System.out.println("X Y E F G I O L P U A W");
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 12; j++) {
                System.out.print(tableroPuntuaciones[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void imprimirMapaGeografico(){
        System.out.println();
        System.out.println("Mapa Geografico: ");
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(tableroMapaJeoGrafico[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        inicializarMapaGeografico();
        asignarPaisesMapa();
        rellenarTableroPuntuaciones();
        imprimirMapaGeografico();
        mostrarTableroPuntuaciones();
    }
}