public class Main {
    public static void main(String[] args) {
        Pila<String> pila = new Pila<>();

        System.out.println("=== PILA ===");
        System.out.println("Vacia: " + pila.esVacia());
        System.out.println();

        pila.apilar("A");
        pila.apilar("B");
        pila.apilar("C");
        System.out.println("Tras apilar A, B, C: " + pila);
        System.out.println("Tope: " + pila.obtenerTope()); // C
        System.out.println();

        pila.desapilar();
        System.out.println("Tras desapilar: " + pila);
        System.out.println("Nuevo tope: " + pila.obtenerTope()); // B
        System.out.println();

        // Vaciar
        while (!pila.esVacia()) {
            System.out.println("Desapilando: " + pila.obtenerTope());
            pila.desapilar();
        }
        System.out.println();
        System.out.println("Vacia: " + pila.esVacia());
        pila.desapilar(); // no debe explotar
        System.out.println("Desapilar en vacia: OK");
        System.out.println("Tope en vacia: " + pila.obtenerTope()); // null
    }
}