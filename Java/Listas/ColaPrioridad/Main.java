public class Main {
    public static void main(String[] args) {
        ColaPrioridad<String> cola = new ColaPrioridad<>();

        System.out.println("=== COLA DE PRIORIDAD ===");
        System.out.println("Vacia: " + cola.esVacia());
        System.out.println();

        cola.agregar("Tarea baja",    5);
        cola.agregar("Tarea urgente", 1);
        cola.agregar("Tarea media",   3);
        cola.agregar("Tarea critica", 1); // misma prioridad que urgente
        cola.agregar("Tarea normal",  3);
        System.out.println("Tras insertar: " + cola);
        System.out.println("Frente: " + cola.obtenerFrente()); // Tarea urgente
        System.out.println();

        cola.eliminar();
        System.out.println("Tras eliminar frente: " + cola);
        System.out.println("Nuevo frente: " + cola.obtenerFrente()); // Tarea critica
        System.out.println();

        // Vaciar
        while (!cola.esVacia()) {
            System.out.println("Procesando: " + cola.obtenerFrente());
            cola.eliminar();
        }
        System.out.println();
        System.out.println("Vacia: " + cola.esVacia());
        cola.eliminar(); // no debe explotar
        System.out.println("Eliminar en vacia: OK");
    }
}