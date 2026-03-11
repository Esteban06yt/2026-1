public class OpBrillo extends Operacion {
    private final int nivel;

    public OpBrillo(int nivel) {
        super("Brillo");
        this.nivel = nivel;
    }

    @Override
    public String describir() {
        return "Ajustar brillo " + (nivel >= 0 ? "+" : "") + nivel + "%";
    }
}