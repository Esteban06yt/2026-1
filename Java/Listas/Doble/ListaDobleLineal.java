public class ListaDobleLineal<T> {
    private NodoDoble<T> inicial;
    private NodoDoble<T> ultimo;
    private int tam;

    public ListaDobleLineal() {
        inicial = null;
        ultimo = null;
        tam = 0;
    }

    public void insertarFinal(T valor) {
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
    }

    public void insertarInicio(T valor) {
        NodoDoble<T> nuevo = new NodoDoble<>(valor);

        if (inicial == null) {
            inicial = nuevo;
            ultimo = nuevo;
        } else {
            nuevo.setProximo(inicial);
            inicial.setAnterior(nuevo);
            inicial = nuevo;
        }
        tam++;
    }

    public void eliminarFinal() {
        if (ultimo == null) return;

        ultimo = ultimo.getAnterior();
        if (ultimo != null) {
            ultimo.setProximo(null);
        } else {
            inicial = null; // la lista quedó vacía
        }
        tam--;
    }

    public void eliminarInicio() {
        if (inicial == null) return;

        inicial = inicial.getProximo();
        if (inicial != null) {
            inicial.setAnterior(null);
        } else {
            ultimo = null; // la lista quedó vacía
        }
        tam--;
    }

    public boolean esVacia() {
        return inicial == null;
    }

    public int localizar(T valor) {
        NodoDoble<T> tempo = inicial;
        int index = 0;

        while (tempo != null) {
            if (tempo.getValor().equals(valor)) return index;
            tempo = tempo.getProximo();
            index++;
        }
        return -1;
    }

    public int localizarDesdeFinal(T valor) {
        NodoDoble<T> tempo = ultimo;
        int index = tam - 1;

        while (tempo != null) {
            if (tempo.getValor().equals(valor)) return index;
            tempo = tempo.getAnterior();
            index--;
        }
        return -1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("ListaDobleLineal{ ");
        NodoDoble<T> tempo = inicial;

        while (tempo != null) {
            sb.append(tempo.getValor());
            tempo = tempo.getProximo();
            if (tempo != null) sb.append(" <-> ");
        }

        sb.append(", tam=").append(tam).append(" }");
        return sb.toString();
    }

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