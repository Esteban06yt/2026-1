public class Main {
    public static void main(String[] args) {
        ListaSimplementeEnlazada<String> lista = new ListaSimplementeEnlazada<>();

        lista.insertarFinal("1");
        lista.insertarFinal("2");
        lista.insertarInicio("3");

        System.out.println(lista.localizar("1"));

        System.out.println(lista);
        lista.eliminarInicio();
        System.out.println(lista);
        lista.eliminarFinal();
        System.out.println(lista);

        System.out.println(lista.localizar("1"));

    }
}