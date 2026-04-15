public class ColaUrgencias<T> {
    private NodoPrioridad<T> inicio;
    private int tam;

    public ColaUrgencias() {
        inicio = null;
        tam = 0;
    }

    // Registrar paciente manteniendo orden por prioridad — O(n)
    public void agregar(T valor, int prioridad) {
        NodoPrioridad<T> nuevo = new NodoPrioridad<>(valor, prioridad);

        if (inicio == null || prioridad < inicio.getPrioridad()) {
            nuevo.setProximo(inicio);
            inicio = nuevo;
        } else {
            NodoPrioridad<T> tempo = inicio;
            while (tempo.getProximo() != null && tempo.getProximo().getPrioridad() <= prioridad) {
                tempo = tempo.getProximo();
            }
            nuevo.setProximo(tempo.getProximo());
            tempo.setProximo(nuevo);
        }
        tam++;
        System.out.println("Paciente registrado: " + valor);
    }

    // Atender al paciente mas grave — O(1)
    public void eliminar() {
        if (inicio == null) {
            System.out.println("No hay pacientes en espera.");
            return;
        }
        System.out.println("Atendiendo a: " + inicio.getValor());
        inicio = inicio.getProximo();
        tam--;
    }

    // Consultar quien es el siguiente sin atenderlo — O(1)
    public T buscar() {
        if (inicio == null) return null;
        return inicio.getValor();
    }

    // Mostrar lista completa de pacientes en espera
    public void mostrar() {
        if (inicio == null) {
            System.out.println("No hay pacientes en espera.");
            return;
        }
        System.out.println("Pacientes en espera (mayor a menor gravedad):");
        NodoPrioridad<T> tempo = inicio;
        int pos = 1;
        while (tempo != null) {
            System.out.println("  " + pos + ". " + tempo.getValor());
            tempo = tempo.getProximo();
            pos++;
        }
        System.out.println("  Total: " + tam);
    }

    public boolean esVacia() {
        return inicio == null;
    }

    public int getTam() {
        return tam;
    }
}