public class ArregloDivisionBinaria {
    public static void recorrerDivisionBinaria(int[] arreglo, int inicio, int fin) {
        if (inicio > fin) {
            return;
        }
        int medio = inicio + (fin - inicio) / 2;
        System.out.println("Elemento en posicion " + medio + ": " + arreglo[medio]);
        recorrerDivisionBinaria(arreglo, inicio, medio - 1);
        recorrerDivisionBinaria(arreglo, medio + 1, fin);
    }

    public static void recorrerDivisionBinaria(int[] arreglo) {
        if (arreglo == null || arreglo.length == 0) {
            System.out.println("El arreglo está vacio");
            return;
        }
        recorrerDivisionBinaria(arreglo, 0, arreglo.length - 1);
    }

    public static void main(String[] args) {
        int[] numeros = {1, 2, 3, 4, 5, 6, 7, 8};
        recorrerDivisionBinaria(numeros);
    }
}