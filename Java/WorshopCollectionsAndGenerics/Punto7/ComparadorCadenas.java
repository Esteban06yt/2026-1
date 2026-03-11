public class ComparadorCadenas implements Comparador<String> {
    @Override
    public int comparar(String a, String b) {
        return a.compareTo(b);
    }
}