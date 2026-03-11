public class OpEscala extends Operacion {
    private final double factor;

    public OpEscala(double factor) {
        super("Escala");
        this.factor = factor;
    }

    @Override
    public String describir() {
        return "Escalar imagen x" + factor;
    }
}