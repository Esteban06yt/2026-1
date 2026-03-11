import java.util.PriorityQueue;

public class MesaDeAyuda {
    private final PriorityQueue<Ticket> cola;

    public MesaDeAyuda() {
        this.cola = new PriorityQueue<>();
    }

    public void registrar(Ticket ticket) {
        cola.offer(ticket);
        System.out.println("  + Registrado : " + ticket);
    }

    public Ticket atender() {
        if (cola.isEmpty()) {
            System.out.println("No hay tickets pendientes.");
            return null;
        }
        Ticket t = cola.poll();
        System.out.println("Atendiendo : " + t);
        return t;
    }

    public void verSiguiente() {
        Ticket t = cola.peek();
        if (t == null) System.out.println(" Cola vacia.");
        else System.out.println("  Siguiente   : " + t);
    }

    public void mostrarPendientes() {
        if (cola.isEmpty()) {
            System.out.println("(sin tickets pendientes)");
            return;
        }
        PriorityQueue<Ticket> copia = new PriorityQueue<>(cola);
        System.out.println("  Tickets pendientes en orden de atencion:");
        int pos = 1;
        while (!copia.isEmpty()) {
            System.out.println("    " + pos++ + ". " + copia.poll());
        }
    }

    public boolean estaVacia() { return cola.isEmpty(); }
    public int cantidad() { return cola.size(); }
}