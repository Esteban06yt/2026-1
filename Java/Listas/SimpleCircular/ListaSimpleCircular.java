public class ListaSimpleCircular<T> {
    private Nodo<T> inicial;
    private Nodo<T> ultimo; // evita recorrer toda la lista
    private int tam;

    public ListaSimpleCircular() {
        inicial = null;
        ultimo = null;
        tam = 0;
    }

    public void insertarFinal(T valor) {
        Nodo<T> nuevo = new Nodo<>(valor);

        if (inicial == null) {
            inicial = nuevo;
            ultimo = nuevo;
            nuevo.setProximo(inicial);
        } else {
            // O(1) gracias a ultimo
            ultimo.setProximo(nuevo);
            nuevo.setProximo(inicial);
            ultimo = nuevo;
        }
        tam++;
    }

    public void insertarInicio(T valor) {
        Nodo<T> nuevo = new Nodo<>(valor);

        if (inicial == null) {
            inicial = nuevo;
            ultimo = nuevo;
            nuevo.setProximo(inicial);
        } else {
            // O(1) gracias a ultimo
            nuevo.setProximo(inicial);
            ultimo.setProximo(nuevo);
            inicial = nuevo;
        }
        tam++;
    }

    public void eliminarFinal() {
        if (inicial == null) return;

        if (tam == 1) {
            inicial = null;
            ultimo = null;
        } else {
            // Sigue siendo O(n): sin enlace anterior no hay otra forma
            Nodo<T> tempo = inicial;
            while (tempo.getProximo() != ultimo) {
                tempo = tempo.getProximo();
            }
            tempo.setProximo(inicial);
            ultimo = tempo;
        }
        tam--;
    }

    public void eliminarInicio() {
        if (inicial == null) return;

        if (tam == 1) {
            inicial = null;
            ultimo = null;
        } else {
            // O(1) gracias a ultimo
            inicial = inicial.getProximo();
            ultimo.setProximo(inicial);
        }
        tam--;
    }

    public boolean esVacia() {
        return inicial == null; // sin && tam == 0
    }

    public int localizar(T valor) {
        if (inicial == null) return -1;

        Nodo<T> tempo = inicial;
        int index = 0;

        do {
            if (tempo.getValor().equals(valor)) return index;
            tempo = tempo.getProximo();
            index++;
        } while (tempo != inicial);

        return -1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("ListaSimpleCircular{");
        if (inicial != null) {
            Nodo<T> tempo = inicial;
            do {
                sb.append(tempo.getValor());
                tempo = tempo.getProximo();
                if (tempo != inicial) sb.append(" -> ");
            } while (tempo != inicial);
            sb.append(" -> (circular)");
        }
        sb.append(", tam=").append(tam).append("}");
        return sb.toString();
    }

    public Nodo<T> getInicial() {
        return inicial;
    }

    public int getTam() {
        return tam;
    }
}