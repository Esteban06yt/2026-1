public class ComparadorEnteros implements Comparador<Integer> {
    @Override
    public int comparar(Integer a, Integer b) {
        return Integer.compare(a, b);
    }
}