public class Main {

    public static <T> String describir(T a, T b, Comparador<T> comp) {
        int resultado = comp.comparar(a, b);
        if (resultado < 0) return a + " < " + b;
        if (resultado > 0) return a + " > " + b;
        return a + " == " + b;
    }

    public static void main(String[] args) {
        ComparadorEnteros compInt = new ComparadorEnteros();
        System.out.println("Enteros");
        System.out.println(describir(10, 20, compInt));
        System.out.println(describir(50, 30, compInt));
        System.out.println(describir(7, 7, compInt));

        ComparadorCadenas compStr = new ComparadorCadenas();
        System.out.println("\nCadenas");
        System.out.println(describir("apple", "banana", compStr));
        System.out.println(describir("mango", "kiwi", compStr));
        System.out.println(describir("cafe", "cafe", compStr));

        ComparadorGenerico<Double> compDouble = new ComparadorGenerico<>();
        System.out.println("\nDoubles (generico)");
        System.out.println(describir(3.14, 2.71, compDouble));
        System.out.println(describir(1.0, 1.0, compDouble));
    }
}