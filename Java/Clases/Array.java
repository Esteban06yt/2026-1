import java.util.ArrayList;

public class Array {
    public static void main(String[] args) {
    // Crear un ArrayList
    ArrayList<String> list = new ArrayList<>();

    // Agregar elementos
    list.add("Java"); list.add("Python"); list.add("C++"); list.add("JavaScript");

    // Obtener un elemento
    System.out.println("Elemento en indice 1: " + list.get(1)); // Python

    // Modificar un elemento
    list.set(2, "C#");

    // Eliminar por índice
    list.remove(3);

    // Obtener el último índice de un elemento repetido
    list.add("Python");
    int lastIndex = list.lastIndexOf("Python");
    System.out.println("Ultimo indice de Python: " + lastIndex);

    // Verificar si está vacía
    System.out.println("La lista esta vacia? " + list.isEmpty()); // true

    System.out.println(list);
    }
}