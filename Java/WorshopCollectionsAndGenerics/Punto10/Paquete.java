public class Paquete implements Comparable<Paquete> {
    private final String id;
    private final String direccion;
    private final int prioridad;

    public Paquete(String id, String direccion, int prioridad) {
        this.id = id;
        this.direccion = direccion;
        this.prioridad = prioridad;
    }

    public String getId() { return id; }
    public String getDireccion() { return direccion; }
    public int getPrioridad() { return prioridad; }

    @Override
    public int compareTo(Paquete otro) {
        return this.id.compareTo(otro.id);
    }

    @Override
    public String toString() {
        return "Paquete{id='" + id + "', direccion='" + direccion + "', prioridad=" + prioridad + "}";
    }
}