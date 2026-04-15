public class Main {
    public static void main(String[] args) {
        PilaAcciones<String> editor = new PilaAcciones<>();

        System.out.println("=== EDITOR DE DIBUJO - HISTORIAL DE ACCIONES ===\n");

        // Realizar acciones
        editor.agregar("Trazar linea diagonal");
        editor.agregar("Insertar circulo");
        editor.agregar("Cambiar color a rojo");
        editor.agregar("Insertar rectangulo");
        editor.agregar("Borrar esquina superior");
        System.out.println();

        editor.mostrar();
        System.out.println("Ultima accion: " + editor.buscar());
        System.out.println();

        // Deshacer una accion
        editor.eliminar();
        System.out.println("Ultima accion ahora: " + editor.buscar());
        editor.mostrar();
        System.out.println();

        // Deshacer varias acciones seguidas
        editor.eliminar();
        editor.eliminar();
        editor.mostrar();
        System.out.println();

        // Realizar nuevas acciones tras deshacer
        editor.agregar("Cambiar color a azul");
        editor.agregar("Insertar triangulo");
        editor.mostrar();
        System.out.println();

        // Deshacer todo
        while (!editor.esVacia()) {
            editor.eliminar();
        }
        System.out.println();
        editor.mostrar();

        // Deshacer en pila vacia — no debe explotar
        editor.eliminar();
        System.out.println("Ultima accion en vacia: " + editor.buscar()); // null
    }
}