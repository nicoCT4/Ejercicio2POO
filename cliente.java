public class cliente {
    private String nombre;
    private int visitasHotel;
    private int acompañantes;

    public cliente(String nombre, int visitasHotel, int acompañantes) {
        this.nombre = nombre;
        this.visitasHotel = visitasHotel;
        this.acompañantes = acompañantes;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre; 
    }
    public int getVisitasHotel() {
        return visitasHotel;
    }
    public void setVisitasHotel(int visitasHotel) {
        this.visitasHotel = visitasHotel;
    }
    public int getAcompañantes() {
        return acompañantes;
    }
    public void setAcompañantes(int acompañantes) {
        this.acompañantes = acompañantes;
    }
}
