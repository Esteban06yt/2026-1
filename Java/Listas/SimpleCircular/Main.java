public class Main {
    public static void main(String[] args) {
        ListaSimpleCircular<String> lista = new ListaSimpleCircular<>();

        System.out.println("Vacia: " + lista.esVacia());
        System.out.println(lista);
        System.out.println();

        lista.insertarFinal("1");
        System.out.println("Insertar '1': " + lista);
        System.out.println("localizar('1'): " + lista.localizar("1"));
        System.out.println();

        lista.insertarFinal("2");
        System.out.println("Insertar '2': " + lista);
        System.out.println("localizar('2'): " + lista.localizar("2"));
        System.out.println();

        lista.insertarInicio("3");
        System.out.println("Insertar '3' al inicio: " + lista);
        System.out.println("Tamanio: " + lista.getTam());
        System.out.println();

        lista.eliminarInicio();
        System.out.println("Eliminar inicio: " + lista);
        System.out.println();

        lista.eliminarFinal();
        System.out.println("Eliminar final: " + lista);
        System.out.println("localizar('1'): " + lista.localizar("1"));
    }
}