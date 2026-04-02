public class NodoDoble<T> {
    private final T valor;
    private NodoDoble<T> proximo;
    private NodoDoble<T> anterior;

    public NodoDoble(T valor) {
        this.valor = valor;
        this.proximo = null;
        this.anterior = null;
    }

    public T getValor() { return valor; }
    public NodoDoble<T> getProximo() { return proximo; }
    public NodoDoble<T> getAnterior() { return anterior; }
    public void setProximo(NodoDoble<T> proximo) { this.proximo = proximo; }
    public void setAnterior(NodoDoble<T> anterior) { this.anterior = anterior; }

    @Override
    public String toString() {
        return "NodoDoble{ valor=" + valor + " }";
    }
}