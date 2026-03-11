import java.util.List;

public class Maximo {
    public static <T extends Comparable<T>> T maximo(List<T> lista) {
        if (lista == null || lista.isEmpty()) {
            throw new IllegalArgumentException("La lista no puede ser nula o vacia.");
        }
        T max = lista.get(0);
        for (T elemento : lista) {
            if (elemento.compareTo(max) > 0) {
                max = elemento;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        List<Integer> enteros = List.of(3, 7, 1, 9, 4);
        System.out.println("Maximo enteros: " + maximo(enteros));

        List<Double> doubles = List.of(2.5, 8.1, 3.7, 8.0);
        System.out.println("Maximo doubles: " + maximo(doubles));

        List<String> palabras = List.of("banana", "manzana", "uva", "pera");
        System.out.println("Maximo strings: " + maximo(palabras));
    }
}