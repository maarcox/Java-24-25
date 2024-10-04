public class Simpson {
    //visible a nivel de la clase simpson
    static char[][] tablero = new char[10][10]; // De 0 a N-1
    // FIN

    // Software de gestión de venta ONLINE
    public static void rellenarTablero(char pers){
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                tablero[i][j] = pers;
            }
        }
    }
    public static void main(String[] args) {
        System.out.println("Hello world!");
        //int contador =0;
        char personaje = '#';
        rellenarTablero(personaje);
        //contador = 10;
        rellenarTablero(personaje);
    }

}