public class NodoDoble <T> {
    private T valor;
    private NodoDoble<T> proximo;
    private NodoDoble<T> anterior;

    public NodoDoble(T valor) {
        this.valor = valor;
        this.proximo = null;
        this.anterior = null;
    }

    @Override
    public String toString() {
        return String.format("NodoDoble{valor=%s}", valor);
    }

    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public NodoDoble<T> getProximo() {
        return proximo;
    }

    public void setProximo(NodoDoble<T> proximo) {
        this.proximo = proximo;
    }

    public NodoDoble<T> getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoDoble<T> anterior) {
        this.anterior = anterior;
    }
}