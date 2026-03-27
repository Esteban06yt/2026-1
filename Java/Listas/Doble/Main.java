public class Main {
    public static void main(String[] args) {
        ListaDobleLineal<String> lista = new ListaDobleLineal<>();

        System.out.println("Vacia: " + lista.esVacia());
        System.out.println(lista);
        System.out.println();

        lista.insertarFinal("1");
        System.out.println("Insertar '1': " + lista);
        System.out.println("localizar('1'): " + lista.localizar("1"));
        System.out.println();

        lista.insertarFinal("2");
        lista.insertarFinal("3");
        System.out.println("Insertar '2', '3': " + lista);
        System.out.println("Tamanio: " + lista.getTam());
        System.out.println("localizar('3'): " + lista.localizar("3"));
        System.out.println("localizarDesdeFinal('1'): " + lista.localizarDesdeFinal("1"));
        System.out.println();

        lista.insertarInicio("0");
        System.out.println("Insertar '0' al inicio: " + lista);
        System.out.println();

        lista.eliminarInicio();
        System.out.println("Eliminar inicio: " + lista);
        System.out.println();

        lista.eliminarFinal();
        System.out.println("Eliminar final: " + lista);
        System.out.println("Estado final - Ultimo: " + lista.getUltimo().getValor());
    }
}