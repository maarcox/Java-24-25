import Figuras.Figuras;

public class triangulo extends Figuras {
    public triangulo (String lados) {
        super(lados);
    }

    @Override
    public String toString() {
        return "Esto es un Triángulo con lados: " + "(" + lados + ")";
    }
}
