import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Ticket implements Comparable<Ticket> {
    private static int contador = 1;
    private static final DateTimeFormatter FMT = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    private final int id;
    private final String descripcion;
    private final Severidad severidad;
    private final LocalDateTime fechaCreacion;

    public Ticket(String descripcion, Severidad severidad) {
        this.id = contador++;
        this.descripcion = descripcion;
        this.severidad = severidad;
        this.fechaCreacion = LocalDateTime.now();
    }

    public Ticket(String descripcion, Severidad severidad, LocalDateTime fechaCreacion) {
        this.id = contador++;
        this.descripcion = descripcion;
        this.severidad = severidad;
        this.fechaCreacion = fechaCreacion;
    }

    @Override
    public int compareTo(Ticket otro) {
        int cmpSeveridad = Integer.compare(otro.severidad.getNivel(), this.severidad.getNivel());
        if (cmpSeveridad != 0) return cmpSeveridad;
        return this.fechaCreacion.compareTo(otro.fechaCreacion);
    }

    public int getId() { return id; }
    public String getDescripcion() { return descripcion; }
    public Severidad getSeveridad() { return severidad; }
    public LocalDateTime getFechaCreacion(){ return fechaCreacion;}

    @Override
    public String toString() {
        return String.format("Ticket#%02d [%-7s] creado: %s | %s",
                id, severidad, fechaCreacion.format(FMT), descripcion);
    }
}