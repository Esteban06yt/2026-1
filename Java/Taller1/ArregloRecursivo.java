public class ArregloRecursivo {
    public static void recorrerArreglo(int[] arreglo, int indice) {
        if (indice >= arreglo.length) {
            return;
        }
        System.out.println("Elemento en posicion " + indice + ": " + arreglo[indice]);
        recorrerArreglo(arreglo, indice + 1);
    }

    public static void recorrerArreglo(int[] arreglo) {
        recorrerArreglo(arreglo, 0);
    }

    public static void main(String[] args) {
        int[] numeros = {1, 2, 3, 4, 5};

        System.out.println("Arreglo recorrido:");
        recorrerArreglo(numeros);
    }
}