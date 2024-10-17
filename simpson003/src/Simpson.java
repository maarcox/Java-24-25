import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;
import java.util.Scanner;

public class Simpson {
    //Juego Creado por Marcos Paniego López :)
    private static final int Fila_Tablero = 10;
    private static final int Columna_tablero = 10;
    private static char[][] tablero;
    private static int filaBart;
    private static int columnaBart;
    public static int vidas = 10;
    public static void imprimirtablero(){
        //En esta funcion vamos a imprimir el tablero
        for (int i = 0; i < Fila_Tablero; i++) {
            for (int j = 0; j < Columna_tablero; j++) {
                System.out.print(tablero[i][j]+ " ");
            }
            System.out.println("");
        }
    }
    private static void asignarPersonajesEnCasillasLibres(char caracter, int numrepeticiones){
        Random alet = new Random();
        int FilaAleatorio = -1;
        int ColumnaAleatorio = -1;
        for (int i = 0; i < numrepeticiones; i++) {
            do {
                FilaAleatorio = alet.nextInt(Fila_Tablero);
                ColumnaAleatorio = alet.nextInt(Columna_tablero);
            }while (tablero[FilaAleatorio][ColumnaAleatorio]!='-');
                tablero[FilaAleatorio][ColumnaAleatorio] = caracter;
            }
            if (caracter == 'B'){
                filaBart = FilaAleatorio;
                columnaBart = ColumnaAleatorio;
            }
        }
    private static void asignarcasillaslibres(char caracter){
        //Rerrenar tablero de caracter "-"
        for (int i = 0; i < Fila_Tablero; i++) {
            for (int j = 0; j < Columna_tablero; j++) {
                tablero[i][j] = caracter;
            }
        }
    }
    //Marcos PAniego López
    //Lo que vamos a hacer es crear una ventana para que registre los movimientos de las letras

    public static void main(String[] args) {
        //Juego Simpson
        //Marcos Paniego López
        tablero = new char[Fila_Tablero][Columna_tablero];
        asignarcasillaslibres('-');
        asignarPersonajesEnCasillasLibres('B', 1); //Asignamos personaje Bar simpson
        asignarPersonajesEnCasillasLibres('H', 10); //Asignamos personaje hommer Simpson
        asignarPersonajesEnCasillasLibres('|', 10); //Asignamos muros en el tablero
        tablero[Fila_Tablero-1][Columna_tablero-1] = 'F'; //Añadiremos una casilla final para cuando llegue Bart gane el juego
        imprimirtablero(); //imprimimos tablero
        Scanner lector = new Scanner(System.in);
        do {
            System.out.println("Escriba es desplazamiento que deseas hacer(ADWS)");
            String desplazamiento = lector.nextLine();
            switch (desplazamiento){
                case "A": //izquierda
                    if ((columnaBart -1 )>=0){
                        columnaBart = columnaBart -1;
                        switch (tablero[filaBart][columnaBart]){
                            case 'H':
                                vidas = vidas - 1;
                                System.out.println("Te quedan " + vidas + " vidas");
                                tablero[filaBart][columnaBart] = 'B';
                                tablero[filaBart][columnaBart + 1] = '-';
                            case '|':
                                System.out.println("El muro no te deja Desplazarte a esta casilla");
                                break;
                        }
                        tablero[filaBart][columnaBart] = 'B';
                        tablero[filaBart][columnaBart + 1] = '-';
                    }else{
                        System.out.println("Desplazamiento prohibido");
                    }
                    break;
                case "D": //Derecha
                    if ((columnaBart +1 )>=0){
                        columnaBart = columnaBart +1;
                        switch (tablero[filaBart][columnaBart]){
                            case 'H':
                                vidas = vidas - 1;
                                System.out.println("Te quedan " + vidas + " vidas");
                                tablero[filaBart][columnaBart] = 'B';
                                tablero[filaBart][columnaBart - 1] = '-';
                            case '|':
                                System.out.println("El muro no te deja Desplazarte a esta casilla");
                                break;
                        }
                        tablero[filaBart][columnaBart] = 'B';
                        tablero[filaBart][columnaBart - 1] = '-';
                    }else{
                        System.out.println("Desplazamiento prohibido");
                    }
                    break;
                case "S": //Abajo
                    if ((filaBart +1 )>=0){
                        filaBart = filaBart + 1;
                        switch (tablero[filaBart][columnaBart]){
                            case 'H':
                                vidas = vidas - 1;
                                System.out.println("Te quedan " + vidas + " vidas");
                                tablero[filaBart][columnaBart] = 'B';
                                tablero[filaBart][columnaBart - 1] = '-';
                            case '|':
                                System.out.println("El muro no te deja Desplazarte a esta casilla");
                                break;
                        }
                        tablero[filaBart][columnaBart] = 'B';
                        tablero[filaBart][columnaBart - 1] = '-';
                    }else{
                        System.out.println("Desplazamiento prohibido");
                    }
                    break;
                case "W": //Arriba
                    if ((filaBart -1 )>=0){
                        filaBart = filaBart - 1;
                        switch (tablero[filaBart][columnaBart]){
                            case 'H':
                                vidas = vidas - 1;
                                System.out.println("Te quedan " + vidas + " vidas");
                                tablero[filaBart][columnaBart] = 'B';
                                tablero[filaBart][columnaBart + 1] = '-';
                            case '|':
                                System.out.println("El muro no te deja Desplazarte a esta casilla");
                                break;
                        }
                        tablero[filaBart][columnaBart] = 'B';
                        tablero[filaBart][columnaBart + 1] = '-';
                    }else{
                        System.out.println("Desplazamiento prohibido");
                    }
                    break;
            }
            imprimirtablero();
        } while (vidas > 0);

        //Final
    }
}