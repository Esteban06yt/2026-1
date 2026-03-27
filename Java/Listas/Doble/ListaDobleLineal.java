public class ListaDobleLineal <T> {
    private NodoDoble<T> inicial;
    private NodoDoble<T> ultimo;  // Referencia al último nodo para O(1) operaciones
    private int tam;

    public ListaDobleLineal() {
        inicial = null;
        ultimo = null;
        tam = 0;
    }

    public boolean insertarFinal(T valor) {
        NodoDoble<T> nuevo = new NodoDoble<>(valor);

        if (inicial == null) {
            inicial = nuevo;
            ultimo = nuevo;
        } else {
            ultimo.setProximo(nuevo);
            nuevo.setAnterior(ultimo);
            ultimo = nuevo;
        }
        tam++;
        return true;
    }

    public void insertarInicio(T valor) {
        NodoDoble<T> nuevoNodo = new NodoDoble<>(valor);

        if (inicial == null) {
            inicial = nuevoNodo;
            ultimo = nuevoNodo;
        } else {
            nuevoNodo.setProximo(inicial);
            inicial.setAnterior(nuevoNodo);
            inicial = nuevoNodo;
        }
        tam++;
    }

    public void eliminarFinal() {
        if (inicial == null || tam == 0) {
            return;
        }

        if (tam == 1) {
            inicial = null;
            ultimo = null;
            tam--;
            return;
        }

        NodoDoble<T> nuevoUltimo = ultimo.getAnterior();
        nuevoUltimo.setProximo(null);
        ultimo = nuevoUltimo;
        tam--;
    }

    public void eliminarInicio() {
        if (inicial == null || tam == 0) {
            return;
        }

        if (tam == 1) {
            inicial = null;
            ultimo = null;
            tam--;
            return;
        }

        inicial = inicial.getProximo();
        inicial.setAnterior(null);
        tam--;
    }

    public boolean esVacia() {
        return inicial == null && tam == 0;
    }

    public int localizar(T valor) {
        NodoDoble<T> tempo = inicial;
        int index = 0;

        while (tempo != null) {
            if (tempo.getValor().equals(valor)) {
                return index;
            }
            tempo = tempo.getProximo();
            index++;
        }
        return -1;
    }

    // Ventaja de doble enlace: búsqueda desde el final
    public int localizarDesdeFinal(T valor) {
        if (ultimo == null) {
            return -1;
        }

        NodoDoble<T> tempo = ultimo;
        int index = tam - 1;

        while (tempo != null) {
            if (tempo.getValor().equals(valor)) {
                return index;
            }
            tempo = tempo.getAnterior();
            index--;
        }
        return -1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("ListaDobleLineal{");
        NodoDoble<T> tempo = inicial;
        if (tempo != null) {
            do {
                sb.append(tempo.getValor());
                tempo = tempo.getProximo();
                if (tempo != null) {
                    sb.append(" <-> ");
                }
            } while (tempo != null);
        }
        sb.append(", tam=").append(tam).append("}");
        return sb.toString();
    }

    // Getters y setters
    public NodoDoble<T> getInicial() {
        return inicial;
    }

    public NodoDoble<T> getUltimo() {
        return ultimo;
    }

    public int getTam() {
        return tam;
    }
}