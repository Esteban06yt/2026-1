import java.util.Iterator;
import java.util.LinkedList;

public class ColaLaboratorio {
    private final LinkedList<String> cola;

    public ColaLaboratorio() {
        this.cola = new LinkedList<>();
    }

    public void agregarTurno(String estudiante) {
        cola.addLast(estudiante);
        System.out.println("[TURNO NORMAL] " + estudiante + " agregado al final.");
    }

    public void agregarTurnoPreferencial(String estudiante) {
        cola.addFirst(estudiante);
        System.out.println("[TURNO PREFERENCIAL] " + estudiante + " insertado al inicio.");
    }

    public String atenderSiguiente() {
        if (cola.isEmpty()) {
            System.out.println("No hay estudiantes en cola.");
            return null;
        }
        String atendido = cola.removeFirst();
        System.out.println("[ATENDIENDO] " + atendido);
        return atendido;
    }

    public String siguienteEnCola() {
        return cola.peekFirst();
    }

    public boolean cancelarTurno(String estudiante) {
        Iterator<String> it = cola.iterator();
        while (it.hasNext()) {
            if (it.next().equals(estudiante)) {
                it.remove();
                System.out.println("[TURNO CANCELADO] " + estudiante + " removido de la cola.");
                return true;
            }
        }
        System.out.println("[NO ENCONTRADO] " + estudiante + " no esta en la cola.");
        return false;
    }

    public void mostrarCola() {
        if (cola.isEmpty()) {
            System.out.println("(cola vacia)");
            return;
        }
        System.out.println("Cabeza -> " + cola);
    }

    public boolean estaVacia() { return cola.isEmpty(); }
    public int cantidad() { return cola.size(); }
}