public class HistorialNavegacion<T> {
    private NodoDoble<T> actual;
    private int tam;

    public HistorialNavegacion() {
        actual = null;
        tam = 0;
    }

    // Visitar nueva pagina — elimina el historial futuro
    public void agregar(T valor) {
        NodoDoble<T> nuevo = new NodoDoble<>(valor);

        if (actual == null) {
            actual = nuevo;
        } else {
            // Eliminar todo lo que estaba adelante del actual
            actual.setProximo(nuevo);
            nuevo.setAnterior(actual);
            actual = nuevo;
        }
        tam++;
    }

    // Retroceder a la pagina anterior
    public void retroceder() {
        if (actual == null || actual.getAnterior() == null) {
            System.out.println("No hay pagina anterior.");
            return;
        }
        actual = actual.getAnterior();
        System.out.println("Retrocediendo a: " + actual.getValor());
    }

    // Avanzar a la pagina siguiente
    public void avanzar() {
        if (actual == null || actual.getProximo() == null) {
            System.out.println("No hay pagina siguiente.");
            return;
        }
        actual = actual.getProximo();
        System.out.println("Avanzando a: " + actual.getValor());
    }

    // Mostrar pagina actual
    public T buscar() {
        if (actual == null) return null;
        return actual.getValor();
    }

    // Mostrar todo el historial marcando la pagina actual
    public void mostrar() {
        if (actual == null) {
            System.out.println("Historial vacio.");
            return;
        }

        // Ir al inicio del historial
        NodoDoble<T> inicio = actual;
        while (inicio.getAnterior() != null) {
            inicio = inicio.getAnterior();
        }

        System.out.print("Historial: ");
        NodoDoble<T> tempo = inicio;
        while (tempo != null) {
            if (tempo == actual) {
                System.out.print("[" + tempo.getValor() + "]"); // pagina actual
            } else {
                System.out.print(tempo.getValor());
            }
            if (tempo.getProximo() != null) System.out.print(" <-> ");
            tempo = tempo.getProximo();
        }
        System.out.println();
    }

    // Eliminar pagina actual y retroceder
    public void eliminar() {
        if (actual == null) {
            System.out.println("Historial vacio.");
            return;
        }

        System.out.println("Eliminando: " + actual.getValor());

        if (actual.getAnterior() != null) {
            actual.getAnterior().setProximo(actual.getProximo());
        }
        if (actual.getProximo() != null) {
            actual.getProximo().setAnterior(actual.getAnterior());
        }

        // Mover actual hacia atras si es posible, si no hacia adelante
        if (actual.getAnterior() != null) {
            actual = actual.getAnterior();
        } else {
            actual = actual.getProximo();
        }
        tam--;
    }

    public boolean esVacia() {
        return actual == null;
    }

    public int getTam() {
        return tam;
    }
}