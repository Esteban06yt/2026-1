public abstract class Operacion {
    private final  String nombre;
    @SuppressWarnings("unused")
    private final long timestamp;

    public Operacion(String nombre) {
        this.nombre = nombre;
        this.timestamp = System.currentTimeMillis();
    }

    public String getNombre() { return nombre; }

    public abstract String describir();

    @Override
    public String toString() {
        return "[" + nombre + "] " + describir();
    }
}