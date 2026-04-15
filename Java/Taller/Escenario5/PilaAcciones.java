public class PilaAcciones<T> {
    private Nodo<T> tope;
    private int tam;

    public PilaAcciones() {
        tope = null;
        tam = 0;
    }

    // Registrar nueva accion — O(1)
    public void agregar(T valor) {
        Nodo<T> nuevo = new Nodo<>(valor);
        nuevo.setProximo(tope);
        tope = nuevo;
        tam++;
        System.out.println("Accion registrada: " + valor);
    }

    // Deshacer la accion mas reciente — O(1)
    public void eliminar() {
        if (tope == null) {
            System.out.println("No hay acciones para deshacer.");
            return;
        }
        System.out.println("Deshaciendo: " + tope.getValor());
        tope = tope.getProximo();
        tam--;
    }

    // Consultar la ultima accion sin eliminarla — O(1)
    public T buscar() {
        if (tope == null) return null;
        return tope.getValor();
    }

    // Mostrar historial completo de acciones pendientes de deshacer
    public void mostrar() {
        if (tope == null) {
            System.out.println("Historial vacio.");
            return;
        }
        System.out.print("Historial [tope -> fondo]: ");
        Nodo<T> tempo = tope;
        while (tempo != null) {
            System.out.print(tempo.getValor());
            if (tempo.getProximo() != null) System.out.print(" -> ");
            tempo = tempo.getProximo();
        }
        System.out.println(" | acciones=" + tam);
    }

    public boolean esVacia() {
        return tope == null;
    }

    public int getTam() {
        return tam;
    }
}