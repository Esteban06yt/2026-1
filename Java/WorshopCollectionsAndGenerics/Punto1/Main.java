import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ListaDeTareas<String> lista = new ListaDeTareas<>();

        lista.agregarTarea(new Tarea<>("Entregar informe", 2, new Date(2026 - 1900, 5, 20), "Informe final"));
        lista.agregarTarea(new Tarea<>("Revisar codigo", 1, new Date(2026 - 1900, 3, 10), "Pull request #42"));
        lista.agregarTarea(new Tarea<>("Reunion de equipo", 1, new Date(2026 - 1900, 4, 5), "Sprint planning"));
        lista.agregarTarea(new Tarea<>("Actualizar documentacion", 3, new Date(2026 - 1900, 6, 1), "Wiki del proyecto"));

        System.out.println("Tareas ordenadas por fecha de vencimiento");
        lista.mostrarOrdenadoPorFecha();

        System.out.println("\nTareas con prioridad 1");
        List<Tarea<String>> prioridad1 = lista.obtenerPorPrioridad(1);
        prioridad1.forEach(System.out::println);
    }
}