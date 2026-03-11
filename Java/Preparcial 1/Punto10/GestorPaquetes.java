import java.util.Iterator;
import java.util.PriorityQueue;

public class GestorPaquetes<T extends Paquete> {
    private final PriorityQueue<T> cola;

    public GestorPaquetes() {
        this.cola = new PriorityQueue<>(new ComparadorPrioridad());
    }

    public void agregar(T paquete) {
        cola.offer(paquete);
    }

    public T eliminar() {
        return cola.poll();
    }

    public boolean eliminarPorId(String id) {
        Iterator<T> it = cola.iterator();
        while (it.hasNext()) {
            if (it.next().getId().equals(id)) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    public void mostrarTodos() {
        if (cola.isEmpty()) {
            System.out.println("No hay paquetes en la cola.");
            return;
        }
        Iterator<T> it = cola.iterator();
        while (it.hasNext()) {
            System.out.println("  " + it.next());
        }
    }

    public boolean estaVacia() {
        return cola.isEmpty();
    }

    public int cantidad() {
        return cola.size();
    }
}