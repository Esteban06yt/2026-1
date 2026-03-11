import java.util.ArrayList;
import java.util.List;

public class PairList<K, V> {
    private final List<Par<K, V>> pares;

    public PairList() {
        this.pares = new ArrayList<>();
    }

    public void agregar(K clave, V valor) {
        pares.add(new Par<>(clave, valor));
    }

    public boolean eliminar(K clave) {
        return pares.removeIf(p -> p.getClave().equals(clave));
    }

    public V obtener(K clave) {
        for (Par<K, V> par : pares) {
            if (par.getClave().equals(clave)) {
                return par.getValor();
            }
        }
        return null;
    }

    public void mostrarTodos() {
        if (pares.isEmpty()) {
            System.out.println("La lista está vacia.");
            return;
        }
        for (Par<K, V> par : pares) {
            System.out.println(par);
        }
    }
}