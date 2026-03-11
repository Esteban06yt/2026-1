public class Camion extends Vehiculo {
    private final double capacidadToneladas;

    public Camion(String marca, String placa, double capacidadToneladas) {
        super(marca, placa);
        this.capacidadToneladas = capacidadToneladas;
    }

    @Override
    public void alquilar() {
        System.out.println("Camion alquilado: " + marca + " (" + placa + ") - Capacidad: " + capacidadToneladas + " ton.");
    }

    public void cargar() {
        System.out.println("Cargando el camion " + marca + " con hasta " + capacidadToneladas + " toneladas.");
    }
}