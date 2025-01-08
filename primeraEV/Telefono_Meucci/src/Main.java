import java.util.Scanner;
public class Main {
    private static int countValidPhoneNumbers(String roman, String[] simbolos) {
        int n = roman.length();

        // dp[i] será el número de formas válidas de interpretar la subcadena de longitud i
        int[] dp = new int[n + 1];
        dp[0] = 1; // La cadena vacía tiene una forma válida (interpretación vacía)


        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= 3; j++) {
                if (i >= j && isValidRomanSubstring(roman.substring(i - j, i), simbolos)) {
                    dp[i] += dp[i - j];
                }
            }
        }


        return dp[n];
    }


    private static boolean isValidRomanSubstring(String s, String[] simbolos) {
        for (String simbolo : simbolos) {
            if (simbolo.equals(s)) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String[] simbolos = {"X", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};


        while (scanner.hasNext()) {
            String simbolo = scanner.nextLine().trim();
            System.out.println(countValidPhoneNumbers(simbolo, simbolos));
        }

        scanner.close();
    }
}