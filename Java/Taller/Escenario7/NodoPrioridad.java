public class NodoPrioridad<T> {
    private final T valor;
    private final int prioridad;
    private NodoPrioridad<T> proximo;

    public NodoPrioridad(T valor, int prioridad) {
        this.valor = valor;
        this.prioridad = prioridad;
        this.proximo = null;
    }

    public T getValor() { return valor; }
    public int getPrioridad() { return prioridad; }
    public NodoPrioridad<T> getProximo() { return proximo; }
    public void setProximo(NodoPrioridad<T> proximo) { this.proximo = proximo; }

    @Override
    public String toString() {
        return valor + "(p" + prioridad + ")";
    }
}