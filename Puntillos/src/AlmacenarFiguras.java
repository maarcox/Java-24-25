import Figuras.Figuras;
import java.util.ArrayList;

public class AlmacenarFiguras {
    private ArrayList<Figuras> listaFiguras;

    public AlmacenarFiguras() {
        listaFiguras = new ArrayList<>();
    }

    public void agregarFigura(Figuras figura) {
        listaFiguras.add(figura);
    }

    public ArrayList<Figuras> obtenerFiguras() {
        return listaFiguras;
    }
}
