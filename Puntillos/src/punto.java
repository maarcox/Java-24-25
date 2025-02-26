import Figuras.Figuras;

public class punto extends Figuras {

    public punto (String lados) {
        super(lados);
    }
    @Override
    public String toString() {
        return "Esto es un Punto con coordenadas: " + "(" + lados + ")";
    }

}
