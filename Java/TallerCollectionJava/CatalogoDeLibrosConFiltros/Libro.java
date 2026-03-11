public class Libro {
    private final String titulo;
    private final String autor;
    private final int anio;
    private final String isbn;

    public Libro(String titulo, String autor, int anio, String isbn) {
        this.titulo = titulo;
        this.autor = autor;
        this.anio = anio;
        this.isbn = isbn;
    }

    public String getTitulo() { return titulo;}
    public String getAutor() { return autor;}
    public int getAnio() { return anio;}
    public String getIsbn() { return isbn;}

    @Override
    public String toString() {
        return String.format("Libro{titulo='%s', autor='%s', anio=%d, isbn='%s'}", titulo, autor, anio, isbn);
    }
}