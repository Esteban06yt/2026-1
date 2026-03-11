import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

public class ArregloAleatorio {
    public static void main(String[] args) {
        int[] numeros = crearArregloAleatorio(10, 1, 10);
        System.out.println(Arrays.toString(numeros));
        ordenarArreglo(numeros);
        System.out.println(Arrays.toString(numeros));
        int objetivo = 7;
        System.out.println(busquedaBinaria(numeros, objetivo));
        LinkedList<Integer> lista = crearListaAleatorio(10, 1, 10);
        System.out.println(lista);
        ordenarLista(lista);
        System.out.println(lista);
    }

    public static int[] crearArregloAleatorio(int tamaño, int min, int max) {
        Random random = new Random();
        int[] arreglo = new int[tamaño];
        for (int i = 0; i < tamaño; i++) {
            arreglo[i] = random.nextInt(max - min + 1) + min;
        }
        return arreglo;
    }

    public static LinkedList<Integer> crearListaAleatorio(int tamaño, int min, int max) {
        Random random = new Random();
        LinkedList<Integer> lista = new LinkedList<>();
        for (int i = 0; i < tamaño; i++) {
            lista.add(random.nextInt(max - min + 1) + min);
        }
        return lista;
    }

    public static void ordenarArreglo(int[] arreglo) {
        Arrays.sort(arreglo);
    }

    public static void ordenarLista(LinkedList<Integer> lista) {
        lista.sort(Integer::compareTo);
    }

    public static int busquedaBinaria(int[] arreglo, int objetivo) {
        return Arrays.binarySearch(arreglo, objetivo);
    }
}