public class MatrizRecursiva {
    public static void recorrerMatriz(int[][] matriz, int fila, int columna) {
        if (fila >= matriz.length) {
            return;
        }
        if (columna >= matriz[fila].length) {
            recorrerMatriz(matriz, fila + 1, 0);
            return;
        }
        System.out.println("Elemento en [" + fila + "][" + columna + "]: " + matriz[fila][columna]);
        recorrerMatriz(matriz, fila, columna + 1);
    }

    public static void recorrerMatriz(int[][] matriz) {
        recorrerMatriz(matriz, 0, 0);
    }

    public static void main(String[] args) {
        int[][] matriz = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        System.out.println("Matriz recorrida:");
        recorrerMatriz(matriz);
    }
}