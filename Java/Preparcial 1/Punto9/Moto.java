public class Moto extends Vehiculo {
    public Moto(String marca, String placa) {
        super(marca, placa);
    }

    @Override
    public void alquilar() {
        System.out.println("Moto alquilada: " + marca + " (" + placa + ") - Incluye casco.");
    }

    public void conducir() {
        System.out.println("Conduciendo la moto " + marca + ".");
    }
}