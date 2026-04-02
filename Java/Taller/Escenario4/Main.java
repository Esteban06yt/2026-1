public class Main {
    public static void main(String[] args) {
        JuegoTurnos<String> juego = new JuegoTurnos<>();

        System.out.println("=== JUEGO POR TURNOS ===\n");

        // Registrar jugadores
        juego.agregar("Alice");
        juego.agregar("Bob");
        juego.agregar("Carlos");
        juego.agregar("Diana");
        juego.mostrar();
        System.out.println();

        // Consultar estado inicial
        juego.buscar();
        System.out.println();

        // Avanzar turnos
        juego.avanzar();
        juego.avanzar();
        juego.mostrar();
        System.out.println();

        // Consultar anterior y siguiente del actual
        juego.buscar();
        System.out.println();

        // Retroceder
        juego.retroceder();
        juego.mostrar();
        System.out.println();

        // Dar varias vueltas completas para verificar circularidad
        System.out.println("--- Tres turnos mas ---");
        juego.avanzar();
        juego.avanzar();
        juego.avanzar(); // debe volver al inicio del ciclo
        juego.mostrar();
        System.out.println();

        // Expulsar jugador que no es el actual
        juego.eliminar("Bob");
        juego.mostrar();
        System.out.println();

        // Expulsar jugador actual — debe pasar el turno al siguiente
        System.out.println("Actual antes de expulsar: " + juego.getActual());
        juego.eliminar(juego.getActual());
        System.out.println("Actual despues de expulsar: " + juego.getActual());
        juego.mostrar();
        System.out.println();

        // Intentar expulsar jugador inexistente
        juego.eliminar("Zeus");
        System.out.println();

        // Vaciar partida
        while (!juego.esVacia()) {
            juego.eliminar(juego.getActual());
        }
        juego.mostrar();
        juego.avanzar();
        juego.retroceder();
        juego.buscar();
    }
}