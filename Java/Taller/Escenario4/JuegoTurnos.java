public class JuegoTurnos<T> {
    private NodoDoble<T> inicio;
    private NodoDoble<T> actual;
    private int tam;

    public JuegoTurnos() {
        inicio = null;
        actual = null;
        tam = 0;
    }

    // Agregar jugador al final del ciclo
    public void agregar(T valor) {
        NodoDoble<T> nuevo = new NodoDoble<>(valor);

        if (inicio == null) {
            inicio = nuevo;
            nuevo.setProximo(inicio);
            nuevo.setAnterior(inicio);
            actual = inicio;
        } else {
            NodoDoble<T> ultimo = inicio.getAnterior(); // O(1)
            ultimo.setProximo(nuevo);
            nuevo.setAnterior(ultimo);
            nuevo.setProximo(inicio);
            inicio.setAnterior(nuevo);
        }
        tam++;
    }

    // Avanzar al siguiente jugador
    public void avanzar() {
        if (actual == null) {
            System.out.println("No hay jugadores en la partida.");
            return;
        }
        actual = actual.getProximo();
        System.out.println("Turno de: " + actual.getValor());
    }

    // Retroceder al jugador anterior
    public void retroceder() {
        if (actual == null) {
            System.out.println("No hay jugadores en la partida.");
            return;
        }
        actual = actual.getAnterior();
        System.out.println("Turno anterior: " + actual.getValor());
    }

    // Consultar jugador actual, siguiente y anterior
    public void buscar() {
        if (actual == null) {
            System.out.println("No hay jugadores en la partida.");
            return;
        }
        System.out.println("Anterior : " + actual.getAnterior().getValor());
        System.out.println("Actual   : " + actual.getValor());
        System.out.println("Siguiente: " + actual.getProximo().getValor());
    }

    // Expulsar jugador por valor — O(1) si se conoce el nodo
    public void eliminar(T valor) {
        if (inicio == null) {
            System.out.println("No hay jugadores en la partida.");
            return;
        }

        // Caso: unico jugador
        if (tam == 1) {
            if (inicio.getValor().equals(valor)) {
                inicio = null;
                actual = null;
                tam--;
                System.out.println("Jugador expulsado: " + valor);
            } else {
                System.out.println("Jugador no encontrado: " + valor);
            }
            return;
        }

        NodoDoble<T> tempo = inicio;
        do {
            if (tempo.getValor().equals(valor)) {
                // Si se expulsa al actual, mover al siguiente
                if (tempo == actual) {
                    actual = tempo.getProximo();
                }
                // Si se expulsa al inicio, mover inicio al siguiente
                if (tempo == inicio) {
                    inicio = tempo.getProximo();
                }
                // Reconectar vecinos — O(1)
                tempo.getAnterior().setProximo(tempo.getProximo());
                tempo.getProximo().setAnterior(tempo.getAnterior());
                tam--;
                System.out.println("Jugador expulsado: " + valor);
                return;
            }
            tempo = tempo.getProximo();
        } while (tempo != inicio);

        System.out.println("Jugador no encontrado: " + valor);
    }

    // Mostrar todos los jugadores marcando el actual
    public void mostrar() {
        if (inicio == null) {
            System.out.println("No hay jugadores en la partida.");
            return;
        }

        System.out.print("Jugadores: ");
        NodoDoble<T> tempo = inicio;
        do {
            if (tempo == actual) {
                System.out.print("[" + tempo.getValor() + "]");
            } else {
                System.out.print(tempo.getValor());
            }
            tempo = tempo.getProximo();
            if (tempo != inicio) System.out.print(" <-> ");
        } while (tempo != inicio);
        System.out.println(" <-> (circular) | jugadores=" + tam);
    }

    public boolean esVacia() {
        return inicio == null;
    }

    public int getTam() {
        return tam;
    }
}