public class Main {
    public static void main(String[] args) {
        ColaParqueadero<String> parqueadero = new ColaParqueadero<>();

        System.out.println("=== SISTEMA DE INGRESO AL PARQUEADERO ===\n");

        // Llegan vehiculos
        parqueadero.agregar("ABC-123");
        parqueadero.agregar("XYZ-456");
        parqueadero.agregar("DEF-789");
        parqueadero.agregar("GHI-012");
        System.out.println();

        parqueadero.mostrar();
        System.out.println("Siguiente en ingresar: " + parqueadero.buscar());
        System.out.println();

        // Ingresan los primeros vehiculos
        parqueadero.eliminar();
        parqueadero.mostrar();
        System.out.println();

        parqueadero.eliminar();
        parqueadero.mostrar();
        System.out.println();

        // Llega un nuevo vehiculo mientras otros esperan
        parqueadero.agregar("JKL-345");
        System.out.println();
        parqueadero.mostrar();
        System.out.println("Siguiente en ingresar: " + parqueadero.buscar());
        System.out.println();

        // Vaciar la fila
        while (!parqueadero.esVacia()) {
            parqueadero.eliminar();
        }
        System.out.println();
        parqueadero.mostrar();

        // Intentar operar con fila vacia — no debe explotar
        parqueadero.eliminar();
        System.out.println("Siguiente en vacia: " + parqueadero.buscar()); // null
    }
}