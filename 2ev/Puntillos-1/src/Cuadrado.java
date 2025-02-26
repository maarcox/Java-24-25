public class Cuadrado extends Triangulo{
    private int v;

    Cuadrado(){
        super();
        this.v = v;
    }

    public int getV() {
        return v;
    }

    public void setV(int z) {
        this.v = z;
    }

    @Override
    public String toString() {
        return "Cuadrado(" +
                getX() +", "+ getY() + ", "+ getZ() + ", "+ getV() +
                ')';
    }
}
