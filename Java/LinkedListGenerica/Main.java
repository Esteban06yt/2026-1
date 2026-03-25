public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> lista = new LinkedList<>();

        lista.add(10);
        lista.add(20);
        lista.add(30);
        lista.addFirst(5);
        lista.add(2, 15);  // inserta 15 en índice 2

        System.out.println("Lista: " + lista);        // [5 -> 10 -> 15 -> 20 -> 30]
        System.out.println("Tamanio: " + lista.size()); // 5
        System.out.println("get(2): " + lista.get(2)); // 15
        System.out.println("indexOf(20): " + lista.indexOf(20)); // 3

        lista.remove(2);         // elimina índice 2 (valor 15)
        lista.remove(Integer.valueOf(30)); // elimina por valor
        System.out.println("Tras removes: " + lista); // [5 -> 10 -> 20]

        // Con Strings
        LinkedList<String> palabras = new LinkedList<>();
        palabras.add("hola");
        palabras.add("mundo");
        System.out.println("Strings: " + palabras); // [hola -> mundo]
    }
}