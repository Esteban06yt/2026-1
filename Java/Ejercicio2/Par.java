public class Par<T> {
    private T primero;
    private T segundo;

    public Par(T primero, T segundo) {
        this.primero = primero;
        this.segundo = segundo;
    }

    public T getPrimero() { return primero; }
    public T getSegundo() { return segundo; }

    public void setPrimero(T primero) { this.primero = primero; }
    public void setSegundo(T segundo) { this.segundo = segundo; }

    public boolean sonIguales() {
        if (primero == null && segundo == null) return true;
        if (primero == null || segundo == null) return false;
        return primero.equals(segundo);
    }

    @Override
    public String toString() {
        return "Par(" + primero + ", " + segundo + ")";
    }

    public static void main(String[] args) {
        Par<String> par1 = new Par<>("Hola", "Hola");
        System.out.println(par1 + " -> son iguales? " + par1.sonIguales());

        Par<String> par2 = new Par<>("Hola", "Mundo");
        System.out.println(par2 + " -> son iguales? " + par2.sonIguales());

        Par<Integer> par3 = new Par<>(42, 42);
        System.out.println(par3 + " -> son iguales? " + par3.sonIguales());

        Par<Integer> par4 = new Par<>(7, 13);
        System.out.println(par4 + " -> son iguales? " + par4.sonIguales());

        Par<String> par5 = new Par<>(null, null);
        System.out.println(par5 + " -> son iguales? " + par5.sonIguales());

        Par<String> par6 = new Par<>(null, "algo");
        System.out.println(par6 + " -> son iguales? " + par6.sonIguales());
    }
}