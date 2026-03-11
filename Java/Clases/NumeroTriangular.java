public class NumeroTriangular {
    public static boolean numeroTriangular (int numero, int cont){
        int triangular = (cont*(cont+1))/2;
        if(numero == triangular) return true;
        if(triangular > numero) return false;
        return numeroTriangular (numero, cont+1);
    }

    public static boolean numeroTriangular(int numero) {
        return numeroTriangular(numero, 1);
    }

    public static void main(String[] args) {
        int[] numeros = {1, 3, 5, 6, 7, 10, 15, 21, 28};
        System.out.println("Verificando numeros triangulares:");
        for (int num : numeros) {
            boolean esTriangular = numeroTriangular(num);
            System.out.println(num + " es triangular: " + esTriangular);
        }
    }
}