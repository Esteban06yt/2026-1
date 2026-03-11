public class OpRotar extends Operacion {
    private final int grados;

    public OpRotar(int grados) {
        super("Rotar");
        this.grados = grados;
    }

    @Override
    public String describir() {
        return "Rotar imagen " + grados + " grados";
    }
}