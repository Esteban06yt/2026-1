public class ArregloDivideVenceras {
    public static void recorrerDivideVenceras(int[] arreglo, int inicio, int fin) {
        if (inicio > fin) {
            return;
        }
        if (inicio == fin) {
            System.out.println("Elemento en posicion " + inicio + ": " + arreglo[inicio]);
            return;
        }
        int medio = inicio + (fin - inicio) / 2;
        recorrerDivideVenceras(arreglo, inicio, medio);
        recorrerDivideVenceras(arreglo, medio + 1, fin);
    }

    public static void recorrerDivideVenceras(int[] arreglo) {
        if (arreglo == null || arreglo.length == 0) {
            System.out.println("El arreglo está vacio");
            return;
        }
        recorrerDivideVenceras(arreglo, 0, arreglo.length - 1);
    }

    public static void main(String[] args) {
        int[] numeros = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println("Recorriendo arreglo:");
        recorrerDivideVenceras(numeros);
    }
}