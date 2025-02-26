public class Punto {
    private int x = 0;
    private int y = 0;
    public void Punto(){
        x = 0;
        y = 0;
    }


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Punto(" +
                getX() + ", "+  getY() +
                ')';
    }
}
