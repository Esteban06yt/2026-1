public class MatrizDiagonalRecursiva {
    public static void recorrerDiagonal(int[][] matriz, int indice) {
        if (indice >= matriz.length || indice >= matriz[0].length) {
            return;
        }
        System.out.println("Elemento diagonal [" + indice + "][" + indice + "]: " + matriz[indice][indice]);
        recorrerDiagonal(matriz, indice + 1);
    }

    public static void recorrerDiagonal(int[][] matriz) {
        recorrerDiagonal(matriz, 0);
    }

    public static void main(String[] args) {
        int[][] matriz = {
            {1,  2,  3,  4},
            {5,  6,  7,  8},
            {9,  10, 11, 12},
            {13, 14, 15, 16}
        };

        System.out.println("Diagonal recorrida:");
        recorrerDiagonal(matriz);
    }
}