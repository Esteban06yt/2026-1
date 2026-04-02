public class ColaPrioridad<T> {
    private NodoPrioridad<T> inicio;
    private int tam;

    public ColaPrioridad() {
        inicio = null;
        tam = 0;
    }

    // Inserta en orden según prioridad — O(n)
    public void agregar(T valor, int prioridad) {
        NodoPrioridad<T> nuevo = new NodoPrioridad<>(valor, prioridad);

        // Va al inicio si la lista está vacía o tiene mayor prioridad que el primero
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
    }

    // Elimina el de mayor prioridad (el primero) — O(1)
    public void eliminar() {
        if (inicio == null) return;
        inicio = inicio.getProximo();
        tam--;
    }

    // Ver el de mayor prioridad sin eliminarlo — O(1)
    public T obtenerFrente() {
        if (inicio == null) return null;
        return inicio.getValor();
    }

    public boolean esVacia() {
        return inicio == null;
    }

    public int getTam() {
        return tam;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("ColaPrioridad{ ");
        NodoPrioridad<T> tempo = inicio;
        while (tempo != null) {
            sb.append(tempo);
            if (tempo.getProximo() != null) sb.append(" -> ");
            tempo = tempo.getProximo();
        }
        sb.append(", tam=").append(tam).append(" }");
        return sb.toString();
    }
}