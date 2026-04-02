public class Pila<T> {
    private Nodo<T> tope;
    private int tam;

    public Pila() {
        tope = null;
        tam = 0;
    }

    // Apilar — O(1)
    public void apilar(T valor) {
        Nodo<T> nuevo = new Nodo<>(valor);
        nuevo.setProximo(tope);
        tope = nuevo;
        tam++;
    }

    // Desapilar — O(1)
    public void desapilar() {
        if (tope == null) return;
        tope = tope.getProximo();
        tam--;
    }

    // Ver tope sin eliminar — O(1)
    public T obtenerTope() {
        if (tope == null) return null;
        return tope.getValor();
    }

    public boolean esVacia() {
        return tope == null;
    }

    public int getTam() {
        return tam;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Pila{ [tope] ");
        Nodo<T> tempo = tope;
        while (tempo != null) {
            sb.append(tempo.getValor());
            if (tempo.getProximo() != null) sb.append(" -> ");
            tempo = tempo.getProximo();
        }
        sb.append(", tam=").append(tam).append(" }");
        return sb.toString();
    }
}