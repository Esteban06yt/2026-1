public class Main {
    public static void main(String[] args) {
        GestorPaquetes<Paquete> gestor = new GestorPaquetes<>();

        gestor.agregar(new Paquete("P003", "Calle 45 #12-30", 2));
        gestor.agregar(new Paquete("P001", "Av. Bolivar #5-10", 5));
        gestor.agregar(new Paquete("P004", "Carrera 8 #20-15", 1));
        gestor.agregar(new Paquete("P002", "Calle 10 #3-50",  4));
        gestor.agregar(new Paquete("P005", "Av. Las Palmas #9-88", 3));

        System.out.println("Paquetes en cola (orden interno no garantizado al iterar)");
        gestor.mostrarTodos();

        System.out.println("\nEliminar paquete con id 'P003'");
        boolean eliminado = gestor.eliminarPorId("P003");
        System.out.println("Eliminado: " + eliminado);
        gestor.mostrarTodos();

        System.out.println("\nAtendiendo paquetes por prioridad descendente");
        while (!gestor.estaVacia()) {
            System.out.println(" Atendiendo -> " + gestor.eliminar());
        }
    }
}