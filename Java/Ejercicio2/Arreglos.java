import java.util.Arrays;

public class Arreglos {
    public static <T> void intercambiar(T[] arreglo, int i, int j) {
        if (i < 0 || j < 0 || i >= arreglo.length || j >= arreglo.length) {
            throw new IndexOutOfBoundsException("Indices fuera de rango. Tamaño del arreglo: " + arreglo.length);
        }
        T temporal = arreglo[i];
        arreglo[i] = arreglo[j];
        arreglo[j] = temporal;
    }

    public static void main(String[] args) {
        String[] nombres = {"Ana", "Luis", "Pedro", "Maria"};
        System.out.println("Antes: " + Arrays.toString(nombres));
        intercambiar(nombres, 0, 3);
        System.out.println("Despues: " + Arrays.toString(nombres));

        Integer[] numeros = {10, 20, 30, 40, 50};
        System.out.println("\nAntes: " + Arrays.toString(numeros));
        intercambiar(numeros, 1, 4);
        System.out.println("Despues: " + Arrays.toString(numeros));

        Double[] decimales = {1.1, 2.2, 3.3};
        System.out.println("\nAntes: " + Arrays.toString(decimales));
        intercambiar(decimales, 0, 2);
        System.out.println("Despues: " + Arrays.toString(decimales));
    }
}