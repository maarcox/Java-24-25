public class ExplicaError {
    public static void main(String[] args) {
        int[][] matriz = {
                {1, 2, 3},
                {4, 5, 6}
        };

        System.out.println("Elemento en la posición (2,2): " + matriz[1][2]);
        //Este error se debe a que estas intentando acceder
        //a un indice que no existe dentro de la matriz, que
        // esta fuera de rangos
    }
}
