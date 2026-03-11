import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ListaDeTareas<T> {
    private final List<Tarea<T>> tareas;

    public ListaDeTareas() {
        this.tareas = new ArrayList<>();
    }

    public void agregarTarea(Tarea<T> tarea) {
        tareas.add(tarea);
    }

    public List<Tarea<T>> obtenerPorPrioridad(int prioridad) {
        return tareas.stream()
                .filter(t -> t.getPrioridad() == prioridad)
                .collect(Collectors.toList());
    }

    public void mostrarOrdenadoPorFecha() {
        tareas.stream()
                .sorted(Comparator.comparing(Tarea::getFechaVencimiento))
                .forEach(System.out::println);
    }
}