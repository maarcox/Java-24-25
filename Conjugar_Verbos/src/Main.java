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
        boolean bucle = true;
        while (bucle){
            System.out.println(" ");
            System.out.print("Introduce un verbo y (a,b,c): ");
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
                case "Saltar B", "saltar b", "SALTAR B":
                    for (int i = 0; i < pronombres.length; i++) {
                        System.out.println(pronombres[i] + " " +  preteritoPerfectoSimple[i]);
                    }
                    break;
                case "Comer B", "comer b", "COMER B":
                    for (int i = 0; i < pronombres.length; i++) {
                        System.out.println(pronombres[i] + " " +  preteritoPerfectoSimple[i + 6]);
                    }
                    break;
                case "Vivir B", "vivir b", "VIVIR B":
                    for (int i = 0; i < pronombres.length; i++) {
                        System.out.println(pronombres[i] + " " +  preteritoPerfectoSimple[i + 12]);
                    }
                    break;
                case "Saltar C", "saltar c", "SALTAR C":
                    for (int i = 0; i < pronombres.length; i++) {
                        System.out.println(pronombres[i] + " " +  futuro[i]);
                    }
                    break;
                case "Comer C", "comer c", "COMER C":
                    for (int i = 0; i < pronombres.length; i++) {
                        System.out.println(pronombres[i] + " " +  futuro[i + 6]);
                    }
                    break;
                case "Vivir C", "vivir c", "VIVIR C":
                    for (int i = 0; i < pronombres.length; i++) {
                        System.out.println(pronombres[i] + " " +  futuro[i + 12]);
                    }
                    break;

                default:
                    System.out.println(" ");
                    System.out.println("Verbos disponibles: Saltar, Comer y Vivir");
                    break;
                case "0":
                    bucle = false;
                    break;

            }
        }
    }
}