public class ResultadoA {
    public static void main(String[] args) {
        int a = 5;
        int b = 5;
        int c = 8;

        a = b++ + ++c;
        System.out.println(a);
        //14
    }
}
