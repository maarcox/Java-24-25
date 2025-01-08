import java.util.Random;
import java.util.Scanner;
public class Main {
    private static final int filaTablero = 10;
    private static final int columnaTablero = 10;
    private static char tableroJuego1[][];
    private static char tableroJuego2[][];

    private static int filaYoda;
    private static int columnaYoda;


    public static int vidasjugador1 = 3;

    private static int filaDarthVader;
    private static int  columnaDarthVader;
    public static int vidasjugador2 = 3;

    private static int filaPocima;
    private static int columnaPocima;

    private static void inicializarTablersCasillasLibres() {
        for (int i = 0; i < filaTablero; i++) {
            for (int j = 0; j < columnaTablero; j++) {
                tableroJuego1[i][j] = 'L';  //Rellenamos tablero con casillas libres
                tableroJuego2[i][j] = 'L';
            }
        }
    }

    private static void mostrarTableros() {
        System.out.println("Tablero Jugador 1");
        for (int i = 0; i < filaTablero; i++) {
            for (int j = 0; j < columnaTablero; j++) {
                System.out.print(tableroJuego1[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(" ");
        System.out.println("Tablero Jugador 2");
        for (int i = 0; i < filaTablero; i++) {
            for (int j = 0; j < columnaTablero; j++) {
                System.out.print(tableroJuego2[i][j] + " " );
            }
            System.out.println(" ");
        }
    }

    private static void asignarPersonajesEnCasillasLibresTablero1(char caracter, int numrepeticiones){
        Random alet = new Random();
        int FilaAleatorio = -1;
        int ColumnaAleatorio = -1;
        for (int i = 0; i < numrepeticiones; i++) {
            do {
                FilaAleatorio = alet.nextInt(filaTablero);
                ColumnaAleatorio = alet.nextInt(columnaTablero);
            }while (tableroJuego1[FilaAleatorio][ColumnaAleatorio]!= 'L');
            tableroJuego1[FilaAleatorio][ColumnaAleatorio] = caracter;
        }
        if (caracter == 'Y'){
            filaYoda = FilaAleatorio;
            columnaYoda = ColumnaAleatorio;
        }
    }
    private static void asignarPersonajesEnCasillasLibresTablero2(char caracter, int numrepeticiones){
        Random alet = new Random();
        int FilaAleatorio = -1;
        int ColumnaAleatorio = -1;
        for (int i = 0; i < numrepeticiones; i++) {
            do {
                FilaAleatorio = alet.nextInt(filaTablero);
                ColumnaAleatorio = alet.nextInt(columnaTablero);
            }while (tableroJuego2[FilaAleatorio][ColumnaAleatorio]!= 'L');
            tableroJuego2[FilaAleatorio][ColumnaAleatorio] = caracter;
        }
        if (caracter == 'V'){
            filaDarthVader = FilaAleatorio;
            columnaDarthVader = ColumnaAleatorio;
        }
    }

    public static void main(String[] args) {

        //Tablero 1
        tableroJuego1 = new char[filaTablero][columnaTablero];
        tableroJuego2 = new char[filaTablero][columnaTablero];
        inicializarTablersCasillasLibres();
        asignarPersonajesEnCasillasLibresTablero1('Y', 1);
        asignarPersonajesEnCasillasLibresTablero1('M', 5);
        asignarPersonajesEnCasillasLibresTablero1('D', 5);
        asignarPersonajesEnCasillasLibresTablero1('P', 5);
        asignarPersonajesEnCasillasLibresTablero2('V', 1);
        asignarPersonajesEnCasillasLibresTablero2('M', 5);
        asignarPersonajesEnCasillasLibresTablero2('R', 5);
        asignarPersonajesEnCasillasLibresTablero2('P', 5);
        tableroJuego1[filaTablero-1][columnaTablero-1] = 'F'; //Añadiremos una casilla final para ganar tablero 1
        tableroJuego2[filaTablero-1][columnaTablero-1] = 'F'; //Añadiremos una casilla final para ganar tablero 2
        mostrarTableros();

        Scanner lector = new Scanner(System.in);
        boolean vidas = true;
        do {
            System.out.println("Jugador 1");
            System.out.println("Escriba es desplazamiento que deseas hacer(ADWS)");
            String desplazamiento1 = lector.nextLine();
            int numero;


            switch (desplazamiento1){
                case "A", "a": //izquierda
                    if ((columnaYoda -1 )>=0){
                        columnaYoda = columnaYoda -1;
                        switch (tableroJuego1[filaYoda][columnaYoda]){
                            case 'D':
                                vidasjugador1 = vidasjugador1 - 1;
                                System.out.println("Te quedan " + vidasjugador1 + " vidas");
                                tableroJuego1[filaYoda][columnaYoda] = 'Y';
                                tableroJuego1[filaYoda][columnaYoda + 1] = 'L';
                            case 'M':
                                System.out.println("El muro no te deja Desplazarte a esta casilla");
                                break;
                            case 'P':
                                tableroJuego1[filaYoda][columnaYoda] = 'L';
                                tableroJuego1[filaYoda][columnaYoda + 1] = 'L';
                                do {
                                    System.out.println("Elija la fila a la que deseas desplazarte");
                                    filaPocima = lector.nextInt();
                                    System.out.println("Elija la columna a la que deseas desplazarte");
                                    columnaPocima = lector.nextInt();
                                }while (tableroJuego1[filaPocima][columnaPocima] != 'L');
                                tableroJuego1[filaPocima][columnaPocima] = 'Y';
                            case 'L':
                                tableroJuego1[filaYoda][columnaYoda] = 'Y';
                                tableroJuego1[filaYoda][columnaYoda + 1] = 'L';
                        }
                    }else{
                        System.out.println("Desplazamiento prohibido");
                    }
                    break;
                case "D","d" : //Derecha
                    if ((columnaYoda +1 )>=0 && (columnaYoda + 1 )<=9){
                        columnaYoda= columnaYoda +1;
                        switch (tableroJuego1[filaYoda][columnaYoda]){
                            case 'D':
                                vidasjugador1 = vidasjugador1 - 1;
                                System.out.println("Te quedan " + vidasjugador1+ " vidas");
                                tableroJuego1[filaYoda][columnaYoda] = 'Y';
                                tableroJuego1[filaYoda][columnaYoda - 1] = 'L';
                            case 'M':
                                System.out.println("El muro no te deja Desplazarte a esta casilla");
                                break;
                            case 'P':
                                tableroJuego1[filaYoda][columnaYoda] = 'L';
                                tableroJuego1[filaYoda][columnaYoda - 1] = 'L';
                                do {
                                    System.out.println("Elija la fila a la que deseas desplazarte");
                                    filaPocima = lector.nextInt();
                                    System.out.println("Elija la columna a la que deseas desplazarte");
                                    columnaPocima = lector.nextInt();
                                }while (tableroJuego1[filaPocima][columnaPocima] != 'L');
                                tableroJuego1[filaPocima][columnaPocima] = 'Y';
                            case 'L':
                                tableroJuego1[filaYoda][columnaYoda] = 'Y';
                                tableroJuego1[filaYoda][columnaYoda - 1] = 'L';
                        }
                    }else{
                        System.out.println("Desplazamiento prohibido");
                    }
                    break;
                case "S", "s" : //Abajo
                    if ((filaYoda +1 )>=0){
                        filaYoda = filaYoda + 1;
                        switch (tableroJuego1[filaYoda][columnaYoda]){
                            case 'D':
                                vidasjugador1 = vidasjugador1 - 1;
                                System.out.println("Te quedan " + vidasjugador1 + " vidas");
                                tableroJuego1[filaYoda][columnaYoda] = 'Y';
                                tableroJuego1[filaYoda -1][columnaYoda] = 'L';
                            case 'M':
                                System.out.println("El muro no te deja Desplazarte a esta casilla");
                                break;
                            case 'P':
                                tableroJuego1[filaYoda][columnaYoda] = 'L';
                                tableroJuego1[filaYoda -1][columnaYoda ] = 'L';
                                do {
                                    System.out.println("Elija la fila a la que deseas desplazarte");
                                    filaPocima = lector.nextInt();
                                    System.out.println("Elija la columna a la que deseas desplazarte");
                                    columnaPocima = lector.nextInt();
                                }while (tableroJuego1[filaPocima][columnaPocima] != 'L');
                                tableroJuego1[filaPocima][columnaPocima] = 'Y';
                            case 'L':
                                tableroJuego1[filaYoda][columnaYoda] = 'Y';
                                tableroJuego1[filaYoda -1][columnaYoda] = 'L';
                        }
                    }else{
                        System.out.println("Desplazamiento prohibido");
                    }
                    break;
                case "W", "w" : //Arriba
                    if ((filaYoda -1 )>=0){
                        filaYoda = filaYoda - 1;
                        switch (tableroJuego1[filaYoda][columnaYoda]){
                            case 'D':
                                vidasjugador1 = vidasjugador1 - 1;
                                System.out.println("Te quedan " + vidasjugador1 + " vidas");
                                tableroJuego1[filaYoda][columnaYoda] = 'Y';
                                tableroJuego1[filaYoda + 1][columnaYoda ] = 'L';
                            case 'M':
                                System.out.println("El muro no te deja Desplazarte a esta casilla");
                                break;
                            case 'P':
                                tableroJuego1[filaYoda][columnaYoda] = 'L';
                                tableroJuego1[filaYoda +1][columnaYoda ] = 'L';
                                do {
                                    System.out.println("Elija la fila a la que deseas desplazarte");
                                    filaPocima = lector.nextInt();
                                    System.out.println("Elija la columna a la que deseas desplazarte");
                                    columnaPocima = lector.nextInt();
                                }while (tableroJuego1[filaPocima][columnaPocima] != 'L');
                                tableroJuego1[filaPocima][columnaPocima] = 'Y';
                            case 'L':
                                tableroJuego1[filaYoda][columnaYoda] = 'Y';
                                tableroJuego1[filaYoda +1][columnaYoda] = 'L';
                        }
                    }else{
                        System.out.println("Desplazamiento prohibido");
                    }
                    break;
            }
            mostrarTableros();
            System.out.println("Jugador 2");
            System.out.println("Escriba es desplazamiento que deseas hacer(ADWS)");
            String desplazamiento2 = lector.nextLine();
            switch (desplazamiento2){
                case "A", "a": //izquierda
                    if ((columnaDarthVader -1 )>=0){
                        columnaDarthVader = columnaDarthVader -1;
                        switch (tableroJuego2[filaDarthVader][columnaDarthVader]){
                            case 'D':
                                vidasjugador2 = vidasjugador2 - 1;
                                System.out.println("Te quedan " + vidasjugador2 + " vidas");
                                tableroJuego2[filaDarthVader][columnaDarthVader] = 'V';
                                tableroJuego2[filaDarthVader][columnaDarthVader + 1] = 'L';
                            case 'M':
                                System.out.println("El muro no te deja Desplazarte a esta casilla");
                                break;
                            case 'P':
                                tableroJuego2[filaDarthVader][columnaDarthVader] = 'L';
                                tableroJuego2[filaDarthVader][columnaDarthVader + 1] = 'L';
                                do {
                                    System.out.println("Elija la fila a la que deseas desplazarte");
                                    filaPocima = lector.nextInt();
                                    System.out.println("Elija la columna a la que deseas desplazarte");
                                    columnaPocima = lector.nextInt();
                                }while (tableroJuego2[filaPocima][columnaPocima] != 'L');
                                tableroJuego2[filaPocima][columnaPocima] = 'Y';
                            case 'L':
                                tableroJuego2[filaDarthVader][columnaDarthVader] = 'V';
                                tableroJuego2[filaDarthVader][columnaDarthVader + 1] = 'L';
                        }
                    }else{
                        System.out.println("Desplazamiento prohibido");
                    }
                    break;
                case "D","d" : //Derecha
                    if ((columnaDarthVader +1 )>=0){
                        columnaDarthVader= columnaDarthVader +1;
                        switch (tableroJuego2[filaDarthVader][columnaDarthVader]){
                            case 'D':
                                vidasjugador2 = vidasjugador2 - 1;
                                System.out.println("Te quedan " + vidasjugador2+ " vidas");
                                tableroJuego2[filaDarthVader][columnaDarthVader] = 'V';
                                tableroJuego2[filaDarthVader][columnaDarthVader - 1] = 'L';
                            case 'M':
                                System.out.println("El muro no te deja Desplazarte a esta casilla");
                                break;
                            case 'P':
                                tableroJuego2[filaDarthVader][columnaDarthVader] = 'L';
                                tableroJuego2[filaDarthVader][columnaDarthVader - 1] = 'L';
                                do {
                                    System.out.println("Elija la fila a la que deseas desplazarte");
                                    filaPocima = lector.nextInt();
                                    System.out.println("Elija la columna a la que deseas desplazarte");
                                    columnaPocima = lector.nextInt();
                                }while (tableroJuego2[filaPocima][columnaPocima] != 'L');
                                tableroJuego2[filaPocima][columnaPocima] = 'Y';
                            case 'L':
                                tableroJuego2[filaDarthVader][columnaDarthVader] = 'V';
                                tableroJuego2[filaDarthVader][columnaDarthVader - 1] = 'L';
                        }
                    }else{
                        System.out.println("Desplazamiento prohibido");
                    }
                    break;
                case "S", "s" : //Abajo
                    if ((filaDarthVader +1 )>=0){
                        filaDarthVader = filaDarthVader + 1;
                        switch (tableroJuego2[filaDarthVader][columnaDarthVader]){
                            case 'D':
                                vidasjugador2 = vidasjugador2 - 1;
                                System.out.println("Te quedan " + vidasjugador2 + " vidas");
                                tableroJuego2[filaDarthVader][columnaDarthVader] = 'V';
                                tableroJuego2[filaDarthVader -1][columnaDarthVader] = 'L';
                            case 'M':
                                System.out.println("El muro no te deja Desplazarte a esta casilla");
                                break;
                            case 'P':
                                tableroJuego2[filaDarthVader][columnaDarthVader] = 'L';
                                tableroJuego2[filaDarthVader -1][columnaDarthVader] = 'L';
                                do {
                                    System.out.println("Elija la fila a la que deseas desplazarte");
                                    filaPocima = lector.nextInt();
                                    System.out.println("Elija la columna a la que deseas desplazarte");
                                    columnaPocima = lector.nextInt();
                                }while (tableroJuego2[filaPocima][columnaPocima] != 'L');
                                tableroJuego2[filaPocima][columnaPocima] = 'Y';
                            case 'L':
                                tableroJuego2[filaDarthVader][columnaDarthVader] = 'V';
                                tableroJuego2[filaDarthVader -1][columnaDarthVader] = 'L';
                        }
                    }else{
                        System.out.println("Desplazamiento prohibido");
                    }
                    break;
                case "W", "w" : //Arriba
                    if ((filaDarthVader -1 )>=0){
                        filaDarthVader = filaDarthVader - 1;
                        switch (tableroJuego2[filaDarthVader][columnaDarthVader]){
                            case 'D':
                                vidasjugador2 = vidasjugador2 - 1;
                                System.out.println("Te quedan " + vidasjugador2 + " vidas");
                                tableroJuego2[filaDarthVader][columnaDarthVader] = 'V';
                                tableroJuego2[filaDarthVader + 1][columnaDarthVader ] = 'L';
                            case 'M':
                                System.out.println("El muro no te deja Desplazarte a esta casilla");
                                break;
                            case 'P':
                                tableroJuego2[filaDarthVader][columnaDarthVader] = 'L';
                                tableroJuego2[filaDarthVader +1][columnaDarthVader] = 'L';
                                do {
                                    System.out.println("Elija la fila a la que deseas desplazarte");
                                    filaPocima = lector.nextInt();
                                    System.out.println("Elija la columna a la que deseas desplazarte");
                                    columnaPocima = lector.nextInt();
                                }while (tableroJuego2[filaPocima][columnaPocima] != 'L');
                                tableroJuego2[filaPocima][columnaPocima] = 'Y';
                            case 'L':
                                tableroJuego2[filaDarthVader][columnaDarthVader] = 'V';
                                tableroJuego2[filaDarthVader +1][columnaDarthVader] = 'L';
                        }
                    }else{
                        System.out.println("Desplazamiento prohibido");
                    }
                    break;
            }
            mostrarTableros();

            if (vidasjugador1 <= 0 || vidasjugador2 <= 0){
                vidas = false;
            }
        } while (vidas);

        if (vidasjugador1 <= 0 ){
            System.out.println("Jugador 1 PERDISTE");
        } else if (vidasjugador2 <= 0) {
            System.out.println("Jugador 2 PERDISTE");
        }


        //3 vidas cada jugador se desceunta cuando choca con un D o R
        //Pierde antes el jugador que pierda 3 vidas
        //Gana el primero que llegue casilla final

    }

}