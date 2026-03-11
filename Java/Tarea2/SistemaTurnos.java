import java.util.LinkedList;
import java.util.Queue;

public class SistemaTurnos {
    private final Queue<String> filaTurnos;
    private int contadorTurnos;

    public SistemaTurnos() {
        this.filaTurnos = new LinkedList<>();
        this.contadorTurnos = 0;
    }

    public void registrarCliente(String nombreCliente) {
        contadorTurnos++;
        String turno = "Turno #" + contadorTurnos + " - " + nombreCliente;
        filaTurnos.offer(turno);
        System.out.println("Cliente registrado: " + turno);
    }

    public void atenderSiguiente() {
        if (filaVacia()) {
            System.out.println("No hay clientes en espera. La fila esta vacia.");
            return;
        }
        String clienteAtendido = filaTurnos.poll();
        System.out.println("Atendiendo a: " + clienteAtendido);
    }

    public void mostrarProximoCliente() {
        if (filaVacia()) {
            System.out.println("No hay clientes en espera. La fila esta vacia.");
            return;
        }
        String proximo = filaTurnos.peek();
        System.out.println("Proximo a ser atendido: " + proximo);
    }

    public void mostrarClientesEnEspera() {
        int cantidad = filaTurnos.size();
        System.out.println("Clientes en espera: " + cantidad);
    }

    public boolean filaVacia() {
        return filaTurnos.isEmpty();
    }

    public void mostrarEstadoFila() {
        if (filaVacia()) {
            System.out.println("Estado de la fila: VACiA");
        } else {
            System.out.println("Estado de la fila: " + filaTurnos.toString());
        }
    }

    public static void main(String[] args) {
        SistemaTurnos sistema = new SistemaTurnos();

        System.out.println("--- Verificacion inicial ---");
        System.out.println("Fila vacia? " + sistema.filaVacia());
        sistema.atenderSiguiente();

        System.out.println("\n--- Registrando clientes ---");
        sistema.registrarCliente("Ana Garcia");
        sistema.registrarCliente("Luis Perez");
        sistema.registrarCliente("Maria Torres");
        sistema.registrarCliente("Carlos Ruiz");

        System.out.println("\n--- Estado actual ---");
        sistema.mostrarClientesEnEspera();
        sistema.mostrarProximoCliente();
        sistema.mostrarEstadoFila();

        System.out.println("\n--- Atendiendo clientes ---");
        sistema.atenderSiguiente();
        sistema.atenderSiguiente();

        System.out.println("\n--- Estado tras atender 2 clientes ---");
        sistema.mostrarClientesEnEspera();
        sistema.mostrarProximoCliente();

        System.out.println("\n--- Nuevo cliente llega ---");
        sistema.registrarCliente("Sofia Medina");
        sistema.mostrarClientesEnEspera();
        sistema.mostrarEstadoFila();

        System.out.println("\n--- Vaciando la fila ---");
        sistema.atenderSiguiente();
        sistema.atenderSiguiente();
        sistema.atenderSiguiente();
        sistema.atenderSiguiente();

        System.out.println("\n--- Verificacion final ---");
        System.out.println("Fila vacia? " + sistema.filaVacia());
    }
}