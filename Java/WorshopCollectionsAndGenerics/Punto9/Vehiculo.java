public abstract class Vehiculo {
    protected String marca;
    protected String placa;

    public Vehiculo(String marca, String placa) {
        this.marca = marca;
        this.placa = placa;
    }

    public void alquilar() {
        System.out.println("Alquilando vehículo [" + marca + " - " + placa + "]");
    }
}