public class ListaSimpleCircular <T> {
    private Nodo<T> inicial;
    private int tam;

    public ListaSimpleCircular() {
        inicial = null;
        tam = 0;
    }

    public boolean insertarFinal(T valor) {
        Nodo<T> nuevo = new Nodo<>(valor);

        if (inicial == null) {
            inicial = nuevo;
            nuevo.setProximo(inicial); // Se apunta a sí mismo (circular)
            tam++;
            return true;
        }

        Nodo<T> tempo = inicial;
        // Recorrer hasta el último nodo (el que apunta a inicial)
        while (tempo.getProximo() != inicial) {
            tempo = tempo.getProximo();
        }
        tempo.setProximo(nuevo);
        nuevo.setProximo(inicial); // Conectar con el inicio
        tam++;
        return true;
    }

    public void insertarInicio(T valor) {
        Nodo<T> nuevoNodo = new Nodo<>(valor);

        if (inicial == null) {
            inicial = nuevoNodo;
            nuevoNodo.setProximo(inicial);
        } else {
            Nodo<T> ultimo = inicial;
            // Encontrar el último nodo
            while (ultimo.getProximo() != inicial) {
                ultimo = ultimo.getProximo();
            }
            nuevoNodo.setProximo(inicial);
            inicial = nuevoNodo;
            ultimo.setProximo(inicial); // Actualizar referencia del último
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

        Nodo<T> tempo = inicial;
        // Ir hasta el penúltimo nodo
        while (tempo.getProximo().getProximo() != inicial) {
            tempo = tempo.getProximo();
        }

        tempo.setProximo(inicial); // Penúltimo apunta al primero
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

        Nodo<T> ultimo = inicial;
        // Encontrar el último nodo
        while (ultimo.getProximo() != inicial) {
            ultimo = ultimo.getProximo();
        }

        inicial = inicial.getProximo();
        ultimo.setProximo(inicial); // Último apunta al nuevo inicio
        tam--;
    }

    public boolean esVacia() {
        return inicial == null && tam == 0;
    }

    public int localizar(T valor) {
        if (inicial == null) {
            return -1;
        }

        Nodo<T> tempo = inicial;
        int index = 0;

        do {
            if (tempo.getValor().equals(valor)) {
                return index;
            }
            tempo = tempo.getProximo();
            index++;
        } while (tempo != inicial); // Condición circular

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
                if (tempo != inicial) {
                    sb.append(" -> ");
                }
            } while (tempo != inicial);
            sb.append(" -> (circular)");
        }
        sb.append(", tam=").append(tam).append("}");
        return sb.toString();
    }

    public Nodo<T> getInicial() {
        return inicial;
    }

    public void setInicial(Nodo<T> inicial) {
        this.inicial = inicial;
    }

    public int getTam() {
        return tam;
    }

    public void setTam(int tam) {
        this.tam = tam;
    }
}