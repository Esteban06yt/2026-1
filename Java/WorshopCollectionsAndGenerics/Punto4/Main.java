import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        Repositorio<String> repo = new Repositorio<>();
        repo.agregar("Lunes");
        repo.agregar("Martes");
        repo.agregar("Miercoles");
        repo.agregar("Jueves");
        repo.agregar("Viernes");

        System.out.println("Recorrido normal (for-each)");
        for (String dia : repo) {
            System.out.println(dia);
        }

        System.out.println("\nRecorrido inverso");
        Iterator<String> inverso = repo.iteratorInverso();
        while (inverso.hasNext()) {
            System.out.println(inverso.next());
        }

        System.out.println("\nElemento en indice 2: " + repo.obtener(2));
    }
}