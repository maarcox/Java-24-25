public class Tableros {

    //Dar dimension al tablero
    static char[][] tablero = new char[10][10]; // De 0 a N-1
    // FIN
    public static void rellenarTablero(char pers){
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                tablero[i][j] = pers;
            }
        }
    }
    public static void imprimirTablero(){
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {

                System.out.print(tablero[i][j]);
            }
            System.out.println("");
        }
    }
    public static void main(String[] args) {
        System.out.println("Hello world!");

        char personaje = '#';

        System.out.println("Tablero1:");
        personaje = 'H'; //personaje es igual a esta letra
        rellenarTablero(personaje); //rellena el tablero con esta letra
        imprimirTablero(); //muestra el tablero
        System.out.println("");

        System.out.println("Tablero2:");
        personaje = 'L';//personaje es igual a esta letra
        rellenarTablero(personaje); //rellena el tablero con esta letra
        imprimirTablero();//muestra el tablero

    }

}