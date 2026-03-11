import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class CatalogoLibros {
    private final ArrayList<Libro> libros;

    public CatalogoLibros() {
        this.libros = new ArrayList<>();
    }

    public void agregar(Libro libro) {
        libros.add(libro);
    }

    public boolean eliminarPorISBN(String isbn) {
        Iterator<Libro> it = libros.iterator();
        while (it.hasNext()) {
            if (it.next().getIsbn().equals(isbn)) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    public List<Libro> buscarPorAutor(String autor) {
        List<Libro> resultado = new ArrayList<>();
        Iterator<Libro> it = libros.iterator();
        while (it.hasNext()) {
            Libro l = it.next();
            if (l.getAutor().equalsIgnoreCase(autor)) {
                resultado.add(l);
            }
        }
        return resultado;
    }

    public List<Libro> listarPorAnioAscendente() {
        List<Libro> ordenados = new ArrayList<>(libros);
        ordenados.sort(Comparator.comparingInt(Libro::getAnio));
        return ordenados;
    }

    public List<Libro> cincoMasRecientes() {
        List<Libro> ordenados = new ArrayList<>(libros);
        ordenados.sort(Comparator.comparingInt(Libro::getAnio).reversed());
        return ordenados.subList(0, Math.min(5, ordenados.size()));
    }

    public int cantidad() { return libros.size(); }
}