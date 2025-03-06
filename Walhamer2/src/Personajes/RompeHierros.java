package Personajes;

public class RompeHierros extends  Enano{
    public RompeHierros(String nombre, int energia, int riqueza) {
        super(nombre, energia, riqueza);
    }

    @Override
    public String toString() {
        return "RompeHierros{" +
                "riqueza=" + riqueza +
                ", nombre='" + nombre + '\'' +
                ", energia=" + energia +
                '}';
    }
}
