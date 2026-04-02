public class ListaSimplementeEnlazada<T> {
    private Nodo<T> inicial;
    private int tam;

    public ListaSimplementeEnlazada() {
        inicial = null;
        tam = 0;
    }

    public void insertarFinal(T valor) {
        Nodo<T> nuevo = new Nodo<>(valor);
        if (inicial == null) {
            inicial = nuevo;
        } else {
            Nodo<T> tempo = inicial;
            while (tempo.getProximo() != null) {
                tempo = tempo.getProximo();
            }
            tempo.setProximo(nuevo);
        }
        tam++;
    }

    public void insertarInicio(T valor) {
        Nodo<T> nuevo = new Nodo<>(valor);
        nuevo.setProximo(inicial);
        inicial = nuevo;
        tam++;
    }

    public void eliminarFinal() {
        if (inicial == null) return;
        if (inicial.getProximo() == null) {
            inicial = null;
        } else {
            Nodo<T> tempo = inicial;
            while (tempo.getProximo().getProximo() != null) {
                tempo = tempo.getProximo();
            }
            tempo.setProximo(null);
        }
        tam--;
    }

    public void eliminarInicio() {
        if (inicial == null) return;
        inicial = inicial.getProximo();
        tam--;
    }

    public boolean esVacia() {
        return inicial == null;
    }

    public int localizar(T valor) {
        Nodo<T> tempo = inicial;
        int index = 0;
        while (tempo != null) {
            if (tempo.getValor().equals(valor)) return index;
            tempo = tempo.getProximo();
            index++;
        }
        return -1;
    }

    public int getTam() { return tam; }
    public Nodo<T> getInicial() { return inicial; }

    @Override
    public String toString() {
        return "ListaSimplementeEnlazada{ inicial = " + inicial + " }";
    }
}