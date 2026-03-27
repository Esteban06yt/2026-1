public class ListaSimplementeEnlazada <T> {
    private Nodo<T> inicial;
    private int tam;

    public ListaSimplementeEnlazada() {
        inicial = null;
        tam = 0;
    }

    public boolean insertarFinal(T valor) {
        Nodo<T> nuevo = new Nodo<>(valor);

        if(inicial == null && tam == 0) {
            inicial = nuevo;
            tam++;
            return true;
        }
            Nodo<T> tempo = inicial;
            while(tempo.getProximo() != null) {
                tempo = tempo.getProximo();
            }
            tempo.setProximo(nuevo);
            tam++;
            return true;

    }

    public void insertarInicio(T valor) {
        Nodo<T> nuevoNodo = new Nodo<>(valor);

        nuevoNodo.setProximo(inicial);
        inicial = nuevoNodo;
        tam++;
    }

    public void eliminarFinal() {
        if(inicial != null && inicial.getProximo() == null && tam == 1) {
            inicial = null;
            tam--;
            return;
        }

        Nodo<T> tempo = inicial;
        while(tempo.getProximo().getProximo() != null) {
            tempo = tempo.getProximo();
        }
        tempo.setProximo(null);
        tam--;
    }

    public void eliminarInicio() {
        if(inicial != null && tam > 0){
            inicial = inicial.getProximo();
            tam--;
        }
    }

    public boolean esVacia(){
        return inicial == null && tam == 0;
    }

    public int localizar(T valor) {
        Nodo<T> tempo = inicial;
        int index = 0;

        do {
            if(tempo.getValor().equals(valor)) {
                return index;
            }
            tempo = tempo.getProximo();
            index++;
        }while(tempo != null);

        return -1;
    }

    @Override
    public String toString() {
        return "ListaSimplementeEnlazada{" +
                "inicial = " + inicial +
                '}';
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