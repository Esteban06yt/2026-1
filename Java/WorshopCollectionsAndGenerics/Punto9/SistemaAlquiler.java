import java.util.List;

public class SistemaAlquiler {
    public static void alquilarVehiculos(List<? extends Vehiculo> vehiculos) {
        System.out.println("Procesando " + vehiculos.size() + " vehiculo(s)");
        for (Vehiculo v : vehiculos) {
            v.alquilar();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        List<Auto> autos = List.of(
            new Auto("Toyota", "ABC-123"),
            new Auto("Mazda", "XYZ-789")
        );

        List<Moto> motos = List.of(
            new Moto("Yamaha", "MTO-456"),
            new Moto("Honda", "MTO-101")
        );

        List<Camion> camiones = List.of(
            new Camion("Volvo", "CAM-999", 20.0),
            new Camion("Kenworth", "CAM-321", 35.5)
        );

        List<Vehiculo> flota = List.of(
            new Auto("Chevrolet", "FLT-001"),
            new Moto("Suzuki", "FLT-002"),
            new Camion("Mercedes", "FLT-003", 15.0)
        );

        System.out.println("Alquiler de Autos");
        alquilarVehiculos(autos);

        System.out.println("Alquiler de Motos");
        alquilarVehiculos(motos);

        System.out.println("Alquiler de Camiones");
        alquilarVehiculos(camiones);

        System.out.println("Alquiler de Flota Mixta");
        alquilarVehiculos(flota);
    }
}