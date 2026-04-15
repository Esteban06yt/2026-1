public class Paciente {
    private final String nombre;
    private final String motivo;
    private final int prioridad; // 1 = critico, 2 = grave, 3 = moderado, 4 = leve

    public Paciente(String nombre, String motivo, int prioridad) {
        this.nombre = nombre;
        this.motivo = motivo;
        this.prioridad = prioridad;
    }

    public String getNombre() { return nombre; }
    public String getMotivo() { return motivo; }
    public int getPrioridad() { return prioridad; }

    public String getNivelTexto() {
        switch (prioridad) {
            case 1: return "CRITICO";
            case 2: return "GRAVE";
            case 3: return "MODERADO";
            case 4: return "LEVE";
            default: return "DESCONOCIDO";
        }
    }

    @Override
    public String toString() {
        return nombre + " [" + getNivelTexto() + " - " + motivo + "]";
    }
}