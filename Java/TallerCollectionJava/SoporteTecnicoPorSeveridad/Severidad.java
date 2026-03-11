public enum Severidad {
    BAJA(1), MEDIA(2), ALTA(3), CRITICA(4);

    private final int nivel;

    Severidad(int nivel) { this.nivel = nivel; }
    public int getNivel() { return nivel; }
}