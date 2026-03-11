import java.util.Iterator;
import java.util.Stack;

public class EditorImagenes {
    private final Stack<Operacion> historial;
    private final String imagen;

    public EditorImagenes(String imagen) {
        this.imagen = imagen;
        this.historial = new Stack<>();
    }

    public void aplicar(Operacion op) {
        historial.push(op);
        System.out.println("Aplicado : " + op);
    }

    public void undo() {
        if (historial.isEmpty()) {
            System.out.println("No hay operaciones para deshacer.");
            return;
        }
        Operacion deshecha = historial.pop();
        System.out.println("Deshecho : " + deshecha);
    }

    public void verUltima() {
        if (historial.isEmpty()) {
            System.out.println("Historial vacio.");
            return;
        }
        System.out.println("Ultima op  : " + historial.peek());
    }

    public void mostrarHistorial() {
        if (historial.isEmpty()) {
            System.out.println("(historial vacio)");
            return;
        }
        System.out.println("Historial [tope -> fondo]:");
        Iterator<Operacion> it = historial.iterator();
        Stack<Operacion> aux = new Stack<>();
        while (it.hasNext()) aux.push(it.next());
        Iterator<Operacion> itInv = aux.iterator();
        int paso = historial.size();
        while (itInv.hasNext()) {
            System.out.println("    " + paso-- + ". " + itInv.next());
        }
    }

    public boolean historialVacio() { return historial.isEmpty(); }
    public String  getImagen() { return imagen; }
}