public class Main {
    public static void main(String[] args) {

        // ---- Pruebas Cola ----
        System.out.println("=== COLA ===");
        Cola<String> cola = new Cola<>();

        System.out.println("Vacia: " + cola.isVacia());
        cola.agregar("A");
        cola.agregar("B");
        cola.agregar("C");
        System.out.println(cola);                          // A -> B -> C
        System.out.println("Inicio: " + cola.obtenerInicio()); // A

        cola.eliminar();
        System.out.println("Tras eliminar inicio: " + cola); // B -> C

        cola.eliminar();
        cola.eliminar();
        System.out.println("Tras vaciar: " + cola);           // vacia
        System.out.println("fin es null: " + (cola.fin == null)); // true
        cola.eliminar(); // no debe explotar
        System.out.println("Eliminar en vacia: OK");

        // ---- Pruebas BiCola ----
        System.out.println("\n=== BICOLA ===");
        BiCola<Integer> bicola = new BiCola<>();

        bicola.agregar(2);
        bicola.agregar(3);
        bicola.agregarInicio(1);
        bicola.agregarInicio(0);
        System.out.println(bicola);                        // 0 <-> 1 <-> 2 <-> 3

        bicola.eliminar();
        System.out.println("Tras eliminar inicio: " + bicola); // 1 <-> 2 <-> 3

        bicola.eliminarFinal();
        System.out.println("Tras eliminar final: " + bicola);  // 1 <-> 2

        bicola.eliminarFinal();
        bicola.eliminarFinal();
        System.out.println("Tras vaciar: " + bicola);          // vacia
        System.out.println("fin es null: " + (bicola.fin == null)); // true
        bicola.eliminarFinal(); // no debe explotar
        System.out.println("Eliminar final en vacia: OK");

        // Caso borde: agregarInicio en cola vacia
        BiCola<String> b2 = new BiCola<>();
        b2.agregarInicio("X");
        System.out.println("\nAgregarInicio en vacia: " + b2);
        System.out.println("fin correcto: " + b2.fin.getValor()); // X
    }
}