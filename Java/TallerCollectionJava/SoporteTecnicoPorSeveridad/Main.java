import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        MesaDeAyuda mesa = new MesaDeAyuda();

        LocalDateTime base = LocalDateTime.of(2025, 6, 10, 8, 0, 0);

        System.out.println("Registrando tickets");
        mesa.registrar(new Ticket("Servidor caido en produccion", Severidad.CRITICA, base.plusMinutes(5)));
        mesa.registrar(new Ticket("Error al generar reportes PDF", Severidad.ALTA, base.plusMinutes(2)));
        mesa.registrar(new Ticket("Pantalla azul en PC de recepcion", Severidad.MEDIA, base.plusMinutes(8)));
        mesa.registrar(new Ticket("Actualizar contrasenia de usuario", Severidad.BAJA, base.plusMinutes(1)));
        mesa.registrar(new Ticket("Base de datos sin respuesta", Severidad.CRITICA, base.plusMinutes(3)));
        mesa.registrar(new Ticket("Impresora no imprime en piso 2", Severidad.BAJA, base.plusMinutes(6)));
        mesa.registrar(new Ticket("Fallo de autenticacion en VPN", Severidad.ALTA, base.plusMinutes(4)));
        mesa.registrar(new Ticket("Correo corporativo lento", Severidad.MEDIA, base.plusMinutes(7)));

        System.out.println("\nCola de atencion (orden real)");
        mesa.mostrarPendientes();

        System.out.println("\nSiguiente a atender");
        mesa.verSiguiente();

        System.out.println("\nAtendiendo los 4 primeros tickets");
        for (int i = 0; i < 4; i++) mesa.atender();

        System.out.println("\nEstado tras 4 atenciones");
        mesa.mostrarPendientes();

        System.out.println("\nAtendiendo restantes");
        while (!mesa.estaVacia()) mesa.atender();

        mesa.atender();
    }
}