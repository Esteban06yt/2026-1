public class BiCola<T> extends Cola<T> {

    // Agregar al inicio
    public void agregarInicio(T valor) {
        Nodo<T> nuevo = new Nodo<>(valor);
        if (inicio == null) {
            // Lista vacia: fin también apunta al nuevo nodo
            inicio = nuevo;
            fin = nuevo;
        } else {
            nuevo.setProximo(inicio);
            inicio = nuevo;
        }
        tam++;
    }

    // Eliminar al final
    public void eliminarFinal() {
        if (inicio == null) return;

        if (inicio == fin) {
            inicio = null;
            fin = null;
        } else {
            Nodo<T> temp = inicio;
            while (temp.getProximo() != fin) {
                temp = temp.getProximo();
            }
            temp.setProximo(null);
            fin = temp;
        }
        tam--;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("BiCola{ ");
        Nodo<T> temp = inicio;
        while (temp != null) {
            sb.append(temp.getValor());
            if (temp.getProximo() != null) sb.append(" <-> ");
            temp = temp.getProximo();
        }
        sb.append(", tam=").append(tam).append(" }");
        return sb.toString();
    }
}