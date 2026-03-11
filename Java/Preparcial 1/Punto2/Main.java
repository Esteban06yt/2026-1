public class Main {
    public static void main(String[] args) {

        PairList<String, Integer> lista = new PairList<>();

        lista.agregar("manzanas", 5);
        lista.agregar("peras", 12);
        lista.agregar("uvas", 8);

        System.out.println("Lista inicial");
        lista.mostrarTodos();

        System.out.println("\nValor de 'peras': " + lista.obtener("peras"));

        lista.eliminar("peras");
        System.out.println("\nDespues de eliminar 'peras'");
        lista.mostrarTodos();

        System.out.println("\nValor de 'peras' tras eliminar: " + lista.obtener("peras"));
    }
}