import java.util.Scanner;
public class Main {

    private static int calcularDigitoControl(String codigo, boolean esEAN13) {
        int sumaPar = 0, sumaImpar = 0;

        for (int i = 0; i < (esEAN13 ? 12 : 7); i++) {
            int digit = Character.getNumericValue(codigo.charAt(i));
            if (i % 2 == 0) {
                sumaImpar += digit; // Posiciones impares
            } else {
                sumaPar += digit; // Posiciones pares
            }
        }
        int total = sumaImpar + (esEAN13 ? 3 * sumaPar : sumaPar);
        return (10 - (total % 10)) % 10;
    }

    private static String pais = "Desconocidco";
    private static String obtenerPais(String codigo) {
        String prefijo = codigo.substring(0, Math.min(3, codigo.length()));
        if (prefijo.equals("0")) {
            pais = "EEUU";
        } else if (prefijo.equals("539")) {
            pais = "Irlanda";
        } else if (prefijo.equals("759")) {
            pais = "Venezuela";
        } else if (prefijo.equals("380")) {
            pais = "Bulgaria";
        } else if (prefijo.equals("560")) {
            pais = "Portugal";
        } else if (prefijo.equals("850")) {
            pais = "Cuba";
        } else if (prefijo.equals("50")) {
            pais = "Inglaterra";
        } else if (prefijo.equals("70")) {
            pais = "Noruega";
        } else if (prefijo.equals("890")) {
            pais = "India";
        }
        return pais;
    }
        public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String entrada = scanner.nextLine().trim();
            if (entrada.equals("0")) break;

            String codigo = String.format("%013d", Long.parseLong(entrada));
            boolean esEAN13 = codigo.length() == 13;
            int digitoControlCalculado = calcularDigitoControl(codigo, esEAN13);

            if (digitoControlCalculado == Character.getNumericValue(codigo.charAt(codigo.length() - 1))) {
                obtenerPais(codigo);
                System.out.println("SI" + " " + pais);
            } else {
                System.out.println("NO");
            }
        }

    }
}