import Figuras.Figuras;
import java.util.ArrayList;



public class ImpresoraFiguras {
    public void imprimirFiguras(ArrayList<Figuras> figuras) {
        for (Figuras figura : figuras) {
            System.out.println(figura);
        }
    }
}
