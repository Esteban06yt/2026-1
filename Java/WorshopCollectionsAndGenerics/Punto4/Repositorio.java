import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class Repositorio<T> implements Iterable<T> {
    private final List<T> lista;

    public Repositorio() {
        this.lista = new ArrayList<>();
    }

    public void agregar(T elemento) {
        lista.add(elemento);
    }

    public T obtener(int indice) {
        return lista.get(indice);
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int posicion = 0;

            @Override
            public boolean hasNext() {
                return posicion < lista.size();
            }

            @Override
            public T next() {
                if (!hasNext()) throw new NoSuchElementException();
                return lista.get(posicion++);
            }
        };
    }

    public Iterator<T> iteratorInverso() {
        return new Iterator<T>() {
            private int posicion = lista.size() - 1;

            @Override
            public boolean hasNext() {
                return posicion >= 0;
            }

            @Override
            public T next() {
                if (!hasNext()) throw new NoSuchElementException();
                return lista.get(posicion--);
            }
        };
    }
}