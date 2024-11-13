import java.util.Scanner;

public class Main {
    private static String pronombres[] = new String[]{"Yo", "Tú", "Él", "Nosotros", "Vosotros" ,"Ellos"};

    private static String presente[] = new String[]{
            "salto", "saltas", "salta", "saltamos", "saltáis", "saltan",
            "como", "comes", "come", "comemos", "coméis", "comen",
            "vivo", "vives", "vive", "vivimos", "vivís", "viven"};


    private static String preteritoPerfectoSimple[] = new String[]{
            "salté", "saltaste", "saltó", "saltamos", "saltásteis", "saltaron",
            "comí", "comiste", "comió", "comimos", "comísteis", "comieron",
            "viví", "viviste", "vivió", "vivimos", "vivísteis", "vivieron"};


    private static String futuro[] = new String[]{
            "saltaré", "saltarás", "saltará", "saltaremos", "saltaréis", "saltarán",
            "comeré", "comerás", "comerá", "comeremos", "comeréis", "comerán",
            "viviré", "vivirás", "vivirá", "viviremos", "viviréis", "vivirán"};


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true){
            String verbo = sc.nextLine();
            switch (verbo){
                case "Saltar A", "saltar a", "SALTAR A":
                    for (int i = 0; i < pronombres.length; i++) {
                        System.out.println(pronombres[i] + " " +  presente[i]);
                    }
                    break;
                case "Comer A", "comer a", "COMER A":
                    for (int i = 0; i < pronombres.length; i++) {
                        System.out.println(pronombres[i] + " " +  presente[i + 6]);
                    }
                    break;
                case "Vivir A", "vivir a", "VIVIR A":
                    for (int i = 0; i < pronombres.length; i++) {
                        System.out.println(pronombres[i] + " " +  presente[i + 12]);
                    }
                    break;
            }

        }
    }
}