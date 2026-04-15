public class ColaParqueadero<T> {
    private Nodo<T> inicio;
    private Nodo<T> fin;
    private int tam;

    public ColaParqueadero() {
        inicio = null;
        fin = null;
        tam = 0;
    }

    // Registrar vehiculo al final de la fila — O(1)
    public void agregar(T valor) {
        Nodo<T> nuevo = new Nodo<>(valor);
        if (inicio == null) {
            inicio = nuevo;
            fin = nuevo;
        } else {
            fin.setProximo(nuevo);
            fin = nuevo;
        }
        tam++;
        System.out.println("Vehiculo registrado: " + valor);
    }

    // Dejar pasar al primer vehiculo en espera — O(1)
    public void eliminar() {
        if (inicio == null) {
            System.out.println("No hay vehiculos en espera.");
            return;
        }
        System.out.println("Vehiculo ingresando al parqueadero: " + inicio.getValor());
        inicio = inicio.getProximo();
        if (inicio == null) {
            fin = null;
        }
        tam--;
    }

    // Consultar cual vehiculo sigue sin retirarlo — O(1)
    public T buscar() {
        if (inicio == null) return null;
        return inicio.getValor();
    }

    // Mostrar la fila completa de espera
    public void mostrar() {
        if (inicio == null) {
            System.out.println("No hay vehiculos en espera.");
            return;
        }
        System.out.print("Fila de espera: ");
        Nodo<T> tempo = inicio;
        while (tempo != null) {
            System.out.print(tempo.getValor());
            if (tempo.getProximo() != null) System.out.print(" -> ");
            tempo = tempo.getProximo();
        }
        System.out.println(" | vehiculos=" + tam);
    }

    public boolean esVacia() {
        return inicio == null;
    }

    public int getTam() {
        return tam;
    }
}