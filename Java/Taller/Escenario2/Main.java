public class Main {
    public static void main(String[] args) {
        HistorialNavegacion<String> historial = new HistorialNavegacion<>();

        System.out.println("=== HISTORIAL DE NAVEGACION ===\n");

        // Visitar paginas
        historial.agregar("google.com");
        historial.agregar("github.com");
        historial.agregar("stackoverflow.com");
        historial.mostrar();
        System.out.println("Pagina actual: " + historial.buscar());
        System.out.println();

        // Retroceder
        historial.retroceder();
        historial.mostrar();
        System.out.println();

        historial.retroceder();
        historial.mostrar();
        System.out.println();

        // Intentar retroceder mas alla del inicio
        historial.retroceder();
        System.out.println();

        // Avanzar
        historial.avanzar();
        historial.mostrar();
        System.out.println();

        // Visitar nueva pagina desde la mitad — elimina el futuro
        historial.agregar("youtube.com");
        historial.mostrar(); // stackoverflow desaparece
        System.out.println();

        // Intentar avanzar — no debe haber nada adelante
        historial.avanzar();
        System.out.println();

        // Eliminar pagina actual
        historial.eliminar();
        historial.mostrar();
        System.out.println();

        // Eliminar todo
        while (!historial.esVacia()) {
            historial.eliminar();
        }
        historial.mostrar();
        historial.retroceder();
        historial.avanzar();
    }
}