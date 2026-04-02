public class Cola<T> {
    protected Nodo<T> inicio;
    protected Nodo<T> fin;
    protected int tam;

    public Cola() {
        inicio = null;
        fin = null;
        tam = 0;
    }

    // Agregar al final
    public void agregar(T valor) {
        Nodo<T> nuevo = new Nodo<>(valor);
        if (inicio == null) {
            inicio = nuevo;
            fin = nuevo;
        } else {
            fin.setProximo(nuevo);
            fin = nuevo;
        }
        tam++;
    }

    // Quitar inicio
    public void eliminar() {
        if (inicio == null) return;

        inicio = inicio.getProximo();
        // Si quedó vacia, fin también debe ser null
        if (inicio == null) {
            fin = null;
        }
        tam--;
    }

    // Sin flag innecesario
    public boolean isVacia() {
        return inicio == null;
    }

    // Protegido contra lista vacia
    public T obtenerInicio() {
        if (inicio == null) return null;
        return inicio.getValor();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Cola{ ");
        Nodo<T> temp = inicio;
        while (temp != null) {
            sb.append(temp.getValor());
            if (temp.getProximo() != null) sb.append(" -> ");
            temp = temp.getProximo();
        }
        sb.append(", tam=").append(tam).append(" }");
        return sb.toString();
    }
}