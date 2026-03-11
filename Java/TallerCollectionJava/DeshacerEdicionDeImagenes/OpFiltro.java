public class OpFiltro extends Operacion {
    private final String filtro;

    public OpFiltro(String filtro) {
        super("Filtro");
        this.filtro = filtro;
    }

    @Override
    public String describir() {
        return "Aplicar filtro '" + filtro + "'";
    }
}