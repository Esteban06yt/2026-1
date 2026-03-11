public class OpRecortar extends Operacion {
    private final int x, y, ancho, alto;

    public OpRecortar(int x, int y, int ancho, int alto) {
        super("Recortar");
        this.x = x; this.y = y;
        this.ancho = ancho; this.alto = alto;
    }

    @Override
    public String describir() {
        return "Recortar region (" + x + "," + y + ") " + ancho + "x" + alto + "px";
    }
}