public class Main {
    public static void main(String[] args) {

        EditorImagenes editor = new EditorImagenes("foto_vacaciones.jpg");
        System.out.println("Editor de imagenes: " + editor.getImagen() + "\n");

        System.out.println("Aplicando operaciones");
        editor.aplicar(new OpBrillo(20));
        editor.aplicar(new OpRotar(90));
        editor.aplicar(new OpRecortar(10, 10, 800, 600));
        editor.aplicar(new OpFiltro("Sepia"));
        editor.aplicar(new OpEscala(1.5));
        editor.aplicar(new OpFiltro("Vinieta"));

        System.out.println("\nEstado del historial");
        editor.mostrarHistorial();

        System.out.println("\nUltima operacion activa");
        editor.verUltima();

        System.out.println("\nRealizando 3 UNDO");
        editor.undo();
        editor.undo();
        editor.undo();

        System.out.println("\nEstado tras 3 UNDO");
        editor.mostrarHistorial();

        System.out.println("\nUltima operacion activa");
        editor.verUltima();

        System.out.println("\nDeshaciendo todo");
        while (!editor.historialVacio()) {
            editor.undo();
        }
        editor.undo();
    }
}