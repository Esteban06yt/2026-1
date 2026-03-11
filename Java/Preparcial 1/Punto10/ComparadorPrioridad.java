import java.util.Comparator;

public class ComparadorPrioridad implements Comparator<Paquete> {
    @Override
    public int compare(Paquete a, Paquete b) {
        return Integer.compare(b.getPrioridad(), a.getPrioridad());
    }
}