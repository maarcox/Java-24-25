public class Triangulo extends Punto{
    private int z;

    Triangulo(){
        super();
        this.z = z;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    @Override
    public String toString() {
        return "Triangulo(" +
                getX() + ", "+ getY() + ", "+ getZ() +
                ')';
    }

}
