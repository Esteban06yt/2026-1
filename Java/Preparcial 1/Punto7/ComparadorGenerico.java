public class ComparadorGenerico<T extends Comparable<T>> implements Comparador<T> {
    @Override
    public int comparar(T a, T b) {
        return a.compareTo(b);
    }
}