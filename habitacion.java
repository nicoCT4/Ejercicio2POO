public class habitacion {
    private int habitacion;
    private int precio;
    private String tipo;
    private boolean estado;
    private int capacidad;

    public habitacion(int habitacion, int precio, String tipo, boolean estado, int capacidad) {
        this.habitacion = habitacion;
        this.precio = precio;
        this.tipo = tipo;
        this.estado = estado;
        this.capacidad = capacidad;
    }

    public int getHabitacion() {
        return habitacion;
    }
    public void setHabitacion(int habitacion) {
        this.habitacion = habitacion;
    }
    public int getPrecio() {
        return precio;
    }
    public void setPrecio(int precio) {
        this.precio = precio;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo; 
    }
    public boolean Estado() {
        return estado;
    }
    public boolean getEstado() {
        return estado;
    }
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    public int getCapacidad() {
        return capacidad;
    }
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
}
