public class Main {
    public static void main(String[] args) {
        ColaLaboratorio lab = new ColaLaboratorio();

        lab.agregarTurno("Ana Lopez");
        lab.agregarTurno("Carlos Ruiz");
        lab.agregarTurno("Maria Torres");
        lab.agregarTurno("Juan Perez");

        System.out.println("\nEstado actual:");
        lab.mostrarCola();

        System.out.println();
        lab.agregarTurnoPreferencial("Sofia Gomez");
        lab.agregarTurno("Luis Herrera");

        System.out.println("\nEstado tras turno preferencial:");
        lab.mostrarCola();

        System.out.println();
        lab.agregarTurnoPreferencial("Diego Mora");

        System.out.println("\nEstado con dos preferenciales:");
        lab.mostrarCola();

        System.out.println("\nProximo a atender: " + lab.siguienteEnCola());

        System.out.println();
        lab.atenderSiguiente();
        lab.atenderSiguiente();
        lab.atenderSiguiente();

        System.out.println("\nEstado tras atender 3:");
        lab.mostrarCola();

        System.out.println();
        lab.cancelarTurno("Juan Perez");
        lab.cancelarTurno("Pedro Nope");

        System.out.println("\nEstado final:");
        lab.mostrarCola();

        System.out.println("\nCerrando laboratorio");
        while (!lab.estaVacia()) {
            lab.atenderSiguiente();
        }
        lab.atenderSiguiente();
    }
}