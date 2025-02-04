public class Cancion {
    private int id;
    private String title;

    public Cancion(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public int getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Cancion{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
