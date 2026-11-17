import java.util.LinkedList;
import java.util.Queue;

public class ColaPosicion {

    /**
     * Inserta un elemento en la posicion N de la cola.
     * Posicion 1 = frente de la cola.
     * Los demas elementos conservan su orden.
     */
    public static void insertarEnPosicion(Queue<Integer> cola, int elemento, int posicion) {
        int tamano = cola.size();

        if (posicion < 1 || posicion > tamano + 1) {
            System.out.println("Posicion invalida. Debe estar entre 1 y " + (tamano + 1));
            return;
        }

        Queue<Integer> auxiliar = new LinkedList<>();

        // Paso 1: mover los primeros (posicion - 1) elementos a la cola auxiliar
        for (int i = 0; i < posicion - 1; i++) {
            auxiliar.add(cola.poll());
        }

        // Paso 2: agregar el nuevo elemento en la posicion correcta
        auxiliar.add(elemento);

        // Paso 3: mover los elementos restantes de la original a la auxiliar
        while (!cola.isEmpty()) {
            auxiliar.add(cola.poll());
        }

        // Paso 4: devolver todos los elementos a la cola original
        while (!auxiliar.isEmpty()) {
            cola.add(auxiliar.poll());
        }
    }

    public static void mostrarCola(Queue<Integer> cola) {
        System.out.println("Cola: " + cola);
        System.out.println("Tamano: " + cola.size());
    }

    public static void main(String[] args) {
        Queue<Integer> cola = new LinkedList<>();
        cola.add(10);
        cola.add(20);
        cola.add(30);
        cola.add(40);
        cola.add(50);

        System.out.println("--- Estado inicial ---");
        mostrarCola(cola);

        // Insertar en el frente (posicion 1)
        System.out.println("\n--- Insertar 5 en posicion 1 (frente) ---");
        insertarEnPosicion(cola, 5, 1);
        mostrarCola(cola);

        // Insertar en el medio
        System.out.println("\n--- Insertar 99 en posicion 4 ---");
        insertarEnPosicion(cola, 99, 4);
        mostrarCola(cola);

        // Insertar al final (posicion = tamano + 1)
        System.out.println("\n--- Insertar 100 en posicion 8 (final) ---");
        insertarEnPosicion(cola, 100, 8);
        mostrarCola(cola);

        // Posicion invalida
        System.out.println("\n--- Posicion invalida ---");
        insertarEnPosicion(cola, 77, 99);
    }
}