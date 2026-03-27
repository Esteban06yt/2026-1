public class ListaDobleCircular <T> {
    private NodoDoble<T> inicial;
    private int tam;

    public ListaDobleCircular() {
        inicial = null;
        tam = 0;
    }

    public boolean insertarFinal(T valor) {
        NodoDoble<T> nuevo = new NodoDoble<>(valor);

        if (inicial == null) {
            inicial = nuevo;
            nuevo.setProximo(inicial);
            nuevo.setAnterior(inicial);
            tam++;
            return true;
        }

        NodoDoble<T> ultimo = inicial;
        // Recorrer hasta el último nodo
        while (ultimo.getProximo() != inicial) {
            ultimo = ultimo.getProximo();
        }

        ultimo.setProximo(nuevo);
        nuevo.setProximo(inicial);
        nuevo.setAnterior(ultimo);
        inicial.setAnterior(nuevo); // Actualizar anterior del inicial
        tam++;
        return true;
    }

    public void insertarInicio(T valor) {
        NodoDoble<T> nuevoNodo = new NodoDoble<>(valor);

        if (inicial == null) {
            inicial = nuevoNodo;
            nuevoNodo.setProximo(inicial);
            nuevoNodo.setAnterior(inicial);
        } else {
            NodoDoble<T> ultimo = inicial;
            // Encontrar el último nodo
            while (ultimo.getProximo() != inicial) {
                ultimo = ultimo.getProximo();
            }

            nuevoNodo.setProximo(inicial);
            nuevoNodo.setAnterior(ultimo);
            inicial.setAnterior(nuevoNodo);
            ultimo.setProximo(nuevoNodo);
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
            tam--;
            return;
        }

        NodoDoble<T> ultimo = inicial;
        // Ir hasta el último nodo
        while (ultimo.getProximo() != inicial) {
            ultimo = ultimo.getProximo();
        }

        NodoDoble<T> penultimo = ultimo.getAnterior();
        penultimo.setProximo(inicial);
        inicial.setAnterior(penultimo);
        tam--;
    }

    public void eliminarInicio() {
        if (inicial == null || tam == 0) {
            return;
        }

        if (tam == 1) {
            inicial = null;
            tam--;
            return;
        }

        NodoDoble<T> ultimo = inicial;
        // Encontrar el último nodo
        while (ultimo.getProximo() != inicial) {
            ultimo = ultimo.getProximo();
        }

        NodoDoble<T> nuevoInicio = inicial.getProximo();
        ultimo.setProximo(nuevoInicio);
        nuevoInicio.setAnterior(ultimo);
        inicial = nuevoInicio;
        tam--;
    }

    public boolean esVacia() {
        return inicial == null && tam == 0;
    }

    public int localizar(T valor) {
        if (inicial == null) {
            return -1;
        }

        NodoDoble<T> tempo = inicial;
        int index = 0;

        do {
            if (tempo.getValor().equals(valor)) {
                return index;
            }
            tempo = tempo.getProximo();
            index++;
        } while (tempo != inicial);

        return -1;
    }

    // Nuevo método: buscar navegando hacia atrás (ventaja de doble enlace)
    public int localizarHaciaAtras(T valor) {
        if (inicial == null) {
            return -1;
        }

        NodoDoble<T> tempo = inicial.getAnterior();
        int index = tam - 1;

        do {
            if (tempo.getValor().equals(valor)) {
                return index;
            }
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
                if (tempo != inicial) {
                    sb.append(" <-> ");
                }
            } while (tempo != inicial);
            sb.append(" (circular)");
        }
        sb.append(", tam=").append(tam).append("}");
        return sb.toString();
    }

    public NodoDoble<T> getInicial() {
        return inicial;
    }

    public void setInicial(NodoDoble<T> inicial) {
        this.inicial = inicial;
    }

    public int getTam() {
        return tam;
    }

    public void setTam(int tam) {
        this.tam = tam;
    }
}