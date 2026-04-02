public class ListaDobleCircular<T> {
    private NodoDoble<T> inicial;
    private int tam;

    public ListaDobleCircular() {
        inicial = null;
        tam = 0;
    }

    public void insertarFinal(T valor) {
        NodoDoble<T> nuevo = new NodoDoble<>(valor);

        if (inicial == null) {
            inicial = nuevo;
            nuevo.setProximo(inicial);
            nuevo.setAnterior(inicial);
        } else {
            // inicial.getAnterior() ya es el último, sin recorrer
            NodoDoble<T> ultimo = inicial.getAnterior();
            ultimo.setProximo(nuevo);
            nuevo.setAnterior(ultimo);
            nuevo.setProximo(inicial);
            inicial.setAnterior(nuevo);
        }
        tam++;
    }

    public void insertarInicio(T valor) {
        NodoDoble<T> nuevo = new NodoDoble<>(valor);

        if (inicial == null) {
            inicial = nuevo;
            nuevo.setProximo(inicial);
            nuevo.setAnterior(inicial);
        } else {
            // Sin while para encontrar ultimo
            NodoDoble<T> ultimo = inicial.getAnterior();
            nuevo.setProximo(inicial);
            nuevo.setAnterior(ultimo);
            inicial.setAnterior(nuevo);
            ultimo.setProximo(nuevo);
            inicial = nuevo;
        }
        tam++;
    }

    public void eliminarFinal() {
        if (inicial == null) return;

        if (tam == 1) {
            inicial = null;
        } else {
            // Sin while
            NodoDoble<T> ultimo = inicial.getAnterior();
            NodoDoble<T> penultimo = ultimo.getAnterior();
            penultimo.setProximo(inicial);
            inicial.setAnterior(penultimo);
        }
        tam--;
    }

    public void eliminarInicio() {
        if (inicial == null) return;

        if (tam == 1) {
            inicial = null;
        } else {
            // Sin while
            NodoDoble<T> ultimo = inicial.getAnterior();
            NodoDoble<T> nuevoInicio = inicial.getProximo();
            ultimo.setProximo(nuevoInicio);
            nuevoInicio.setAnterior(ultimo);
            inicial = nuevoInicio;
        }
        tam--;
    }

    // Sin && tam == 0
    public boolean esVacia() {
        return inicial == null;
    }

    public int localizar(T valor) {
        if (inicial == null) return -1;

        NodoDoble<T> tempo = inicial;
        int index = 0;

        do {
            if (tempo.getValor().equals(valor)) return index;
            tempo = tempo.getProximo();
            index++;
        } while (tempo != inicial);

        return -1;
    }

    public int localizarHaciaAtras(T valor) {
        if (inicial == null) return -1;

        NodoDoble<T> tempo = inicial.getAnterior();
        int index = tam - 1;

        do {
            if (tempo.getValor().equals(valor)) return index;
            tempo = tempo.getAnterior();
            index--;
        } while (tempo != inicial.getAnterior());

        return -1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("ListaDobleCircular{");
        if (inicial != null) {
            NodoDoble<T> tempo = inicial;
            do {
                sb.append(tempo.getValor());
                tempo = tempo.getProximo();
                if (tempo != inicial) sb.append(" <-> ");
            } while (tempo != inicial);
            sb.append(" (circular)");
        }
        sb.append(", tam=").append(tam).append("}");
        return sb.toString();
    }

    public NodoDoble<T> getInicial() {
        return inicial;
    }

    public int getTam() {
        return tam;
    }
}