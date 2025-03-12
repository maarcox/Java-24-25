package Armas;

public class Fuego extends ArmasAtaque{
    int cantidad;
    public Fuego(String nombre, int daño, int cantidad) {
        super(nombre, daño);
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
        return  nombre +
                " cantidad=" + cantidad +
                ", daño=" + daño +

                '}';
    }


}
