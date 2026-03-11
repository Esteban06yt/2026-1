
public class Main {
    public static void main(String[] args) {
        CatalogoLibros catalogo = new CatalogoLibros();

        catalogo.agregar(new Libro("Cien años de soledad", "Gabriel Garcia Marquez", 1967, "ISBN-001"));
        catalogo.agregar(new Libro("El amor en los tiempos del colera", "Gabriel Garcia Marquez", 1985, "ISBN-002"));
        catalogo.agregar(new Libro("1984", "George Orwell", 1949, "ISBN-003"));
        catalogo.agregar(new Libro("Rebelion en la granja", "George Orwell", 1945, "ISBN-004"));
        catalogo.agregar(new Libro("El principito", "Antoine de Saint-Exupery", 1943, "ISBN-005"));
        catalogo.agregar(new Libro("Harry Potter y la piedra filosofal", "J.K. Rowling", 1997, "ISBN-006"));
        catalogo.agregar(new Libro("Harry Potter y la camara secreta", "J.K. Rowling", 1998, "ISBN-007"));
        catalogo.agregar(new Libro("El nombre del viento", "Patrick Rothfuss", 2007, "ISBN-008"));
        catalogo.agregar(new Libro("Sapiens", "Yuval Noah Harari", 2011, "ISBN-009"));
        catalogo.agregar(new Libro("Atomic Habits", "James Clear", 2018, "ISBN-010"));

        System.out.println("Libros por anio ascendente");
        for (Libro l : catalogo.listarPorAnioAscendente()) {
            System.out.println("  " + l);
        }

        System.out.println("\nLibros de George Orwell");
        for (Libro l : catalogo.buscarPorAutor("George Orwell")) {
            System.out.println("  " + l);
        }

        System.out.println("\n5 libros mas recientes");
        for (Libro l : catalogo.cincoMasRecientes()) {
            System.out.println("  " + l);
        }

        System.out.println("\nEliminar ISBN-003 (1984)");
        boolean ok = catalogo.eliminarPorISBN("ISBN-003");
        System.out.println("Eliminado: " + ok + " | Total libros: " + catalogo.cantidad());

        System.out.println("\nLibros de George Orwell tras eliminacion");
        for (Libro l : catalogo.buscarPorAutor("George Orwell")) {
            System.out.println("  " + l);
        }
    }
}