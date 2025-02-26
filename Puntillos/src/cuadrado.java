import Figuras.Figuras;
public class cuadrado extends Figuras{
    public cuadrado (String lados) {
        super(lados);
    }

    @Override
    public String toString() {
        return "Esto es un Cuadrado con lados: " + "("+ lados + ")";
    }

}
