package Armas;

public class TelaAraña extends ArmasDefensa{
    int cantidad;
    public TelaAraña(String nombre, int cantidad) {
        super(nombre);
        this.cantidad = cantidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return  nombre + '\'' +
                ", cantidad=" + cantidad +
                '}';
    }
}
