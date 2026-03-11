import java.util.Date;

public class Tarea<T> {
    private final String descripcion;
    private final int prioridad;
    private final Date fechaVencimiento;
    private final T dato;

    public Tarea(String descripcion, int prioridad, Date fechaVencimiento, T dato) {
        this.descripcion = descripcion;
        this.prioridad = prioridad;
        this.fechaVencimiento = fechaVencimiento;
        this.dato = dato;
    }

    public String getDescripcion() { return descripcion; }
    public int getPrioridad() { return prioridad; }
    public Date getFechaVencimiento() { return fechaVencimiento; }
    public T getDato() { return dato; }

    @Override
    public String toString() {
        return "Tarea{descripcion='" + descripcion + "', prioridad=" + prioridad + ", fechaVencimiento=" + fechaVencimiento + ", dato=" + dato + "}";
    }
}