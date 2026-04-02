public class Nodo<T> {
    private final T valor;
    private Nodo<T> proximo;

    public Nodo(T valor) {
        this.valor = valor;
        this.proximo = null;
    }

    public T getValor() { return valor; }
    public Nodo<T> getProximo() { return proximo; }
    public void setProximo(Nodo<T> proximo) { this.proximo = proximo; }

    @Override
    public String toString() {
        return "Nodo{ valor=" + valor + " }";
    }
}