public class Auto extends Vehiculo {
    public Auto(String marca, String placa) {
        super(marca, placa);
    }

    @Override
    public void alquilar() {
        System.out.println("Auto alquilado: " + marca + " (" + placa + ") - Incluye seguro basico.");
    }

    public void conducir() {
        System.out.println("Conduciendo el auto " + marca + ".");
    }
}