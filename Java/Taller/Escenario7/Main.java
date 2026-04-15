public class Main {
    public static void main(String[] args) {
        ColaUrgencias<Paciente> urgencias = new ColaUrgencias<>();

        System.out.println("=== SISTEMA DE URGENCIAS ===\n");

        // Llegan pacientes en distintos momentos con distintas gravedades
        urgencias.agregar(new Paciente("Carlos Ruiz",   "Dolor de cabeza leve",       4), 4);
        urgencias.agregar(new Paciente("Maria Lopez",   "Fractura de brazo",           3), 3);
        urgencias.agregar(new Paciente("Jorge Perez",   "Infarto cardiaco",            1), 1);
        urgencias.agregar(new Paciente("Ana Torres",    "Dificultad para respirar",    2), 2);
        System.out.println();

        urgencias.mostrar();
        System.out.println("Siguiente en ser atendido: " + urgencias.buscar());
        System.out.println();

        // Llega un nuevo critico despues de los anteriores
        urgencias.agregar(new Paciente("Luis Mora", "Convulsiones severas", 1), 1);
        System.out.println();
        urgencias.mostrar();
        System.out.println();

        // Atender pacientes en orden de gravedad
        urgencias.eliminar(); // Jorge o Luis (ambos criticos, FIFO entre iguales)
        urgencias.eliminar(); // el otro critico
        urgencias.mostrar();
        System.out.println();

        // Consultar siguiente
        System.out.println("Siguiente: " + urgencias.buscar());
        System.out.println();

        // Atender el resto
        while (!urgencias.esVacia()) {
            urgencias.eliminar();
        }
        System.out.println();
        urgencias.mostrar();

        // Operar con cola vacia — no debe explotar
        urgencias.eliminar();
        System.out.println("Siguiente en vacia: " + urgencias.buscar()); // null
    }
}