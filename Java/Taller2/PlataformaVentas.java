import java.util.*;

class Producto implements Comparable<Producto> {
    private final String codigo;
    private final String nombre;
    private final double precio;
    private final String categoria;

    public Producto(String codigo, String nombre, double precio, String categoria) {
        this.codigo    = codigo;
        this.nombre    = nombre;
        this.precio    = precio;
        this.categoria = categoria;
    }

    public String getCodigo()    { return codigo; }
    public String getNombre()    { return nombre; }
    public double getPrecio()    { return precio; }
    public String getCategoria() { return categoria; }

    @Override
    public int compareTo(Producto otro) {
        return Double.compare(this.precio, otro.precio);
    }

    @Override
    public String toString() {
        return String.format("[%s] %-25s $%8.2f  (%s)", codigo, nombre, precio, categoria);
    }
}

class Catalogo {

    private final HashMap<String, Producto> porCodigo = new HashMap<>();

    private final LinkedList<Producto> listaProductos = new LinkedList<>();

    private final TreeMap<Double, List<Producto>> porPrecio = new TreeMap<>();

    private final HashMap<String, List<Producto>> porCategoria = new HashMap<>();

    public void agregarProducto(Producto p) {

        porCodigo.put(p.getCodigo(), p);

        listaProductos.addFirst(p);

        porPrecio.computeIfAbsent(p.getPrecio(), k -> new ArrayList<>()).add(p);

        porCategoria.computeIfAbsent(p.getCategoria(), k -> new ArrayList<>()).add(p);
    }

    public void cargaMasiva(List<Producto> nuevos) {
        for (int i = nuevos.size() - 1; i >= 0; i--) {
            agregarProducto(nuevos.get(i));
        }
    }

    public Producto buscarPorCodigo(String codigo) {
        return porCodigo.get(codigo);
    }

    public List<Producto> obtenerOrdenadosPorPrecio() {
        List<Producto> resultado = new ArrayList<>();
        for (List<Producto> grupo : porPrecio.values()) {
            resultado.addAll(grupo);
        }
        return resultado;
    }

    public List<Producto> filtrarPorCategoria(String categoria) {
        return porCategoria.getOrDefault(categoria, Collections.emptyList());
    }

    public LinkedList<Producto> getListaProductos() {
        return listaProductos;
    }

    public int totalProductos() {
        return porCodigo.size();
    }
}

class Medidor {

    public static double medirMs(Runnable accion) {
        long inicio = System.nanoTime();
        accion.run();
        return (System.nanoTime() - inicio) / 1_000_000.0;
    }

    public static long memoriaUsadaKB() {
        Runtime rt = Runtime.getRuntime();
        return (rt.totalMemory() - rt.freeMemory()) / 1024;
    }

    public static void imprimirSeparador(String titulo) {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("  " + titulo);
        System.out.println("=".repeat(60));
    }

    public static void imprimirResultado(String operacion, double ms, int elementos) {
        System.out.printf("  %-35s %8.3f ms  [n=%,d]%n", operacion, ms, elementos);
    }
}

class GeneradorDatos {

    private static final String[] CATEGORIAS = {
        "Electronicos", "Ropa", "Hogar", "Deportes", "Alimentos"
    };
    private static final String[] NOMBRES = {
        "Laptop", "Camisa", "Silla", "Bicicleta", "Arroz",
        "Tablet", "Pantalon", "Mesa", "Pelota", "Aceite",
        "Monitor", "Chaqueta", "Lampara", "Casco", "Sal"
    };

    private static final Random rnd = new Random(42);

    public static List<Producto> generar(int cantidad, String prefijoCodigo) {
        List<Producto> lista = new ArrayList<>(cantidad);
        for (int i = 0; i < cantidad; i++) {
            String codigo    = prefijoCodigo + String.format("%06d", i);
            String nombre    = NOMBRES[rnd.nextInt(NOMBRES.length)] + "-" + i;
            double precio    = Math.round((5 + rnd.nextDouble() * 995) * 100.0) / 100.0;
            String categoria = CATEGORIAS[rnd.nextInt(CATEGORIAS.length)];
            lista.add(new Producto(codigo, nombre, precio, categoria));
        }
        return lista;
    }
}

public class PlataformaVentas {

    public static void main(String[] args) {

        System.out.println("Escenario 2 - Plataforma de Ventas Masivas");
        System.out.println("Demostracion de estructuras de datos Java");

        Medidor.imprimirSeparador("1. DEMOSTRACIoN FUNCIONAL (10 productos)");

        Catalogo catalogo = new Catalogo();

        catalogo.agregarProducto(new Producto("P001", "Laptop HP",    1299.99, "Electronicos"));
        catalogo.agregarProducto(new Producto("P002", "Camisa Polo",               45.50, "Ropa"));
        catalogo.agregarProducto(new Producto("P003", "Silla Ergonomica",         320.00, "Hogar"));
        catalogo.agregarProducto(new Producto("P004", "Bicicleta",            780.00, "Deportes"));
        catalogo.agregarProducto(new Producto("P005", "Arroz 5kg",                  8.90, "Alimentos"));
        catalogo.agregarProducto(new Producto("P006", "Monitor 4K",              499.00, "Electronicos"));
        catalogo.agregarProducto(new Producto("P007", "Pantalon Jeans",            65.00, "Ropa"));
        catalogo.agregarProducto(new Producto("P008", "Mesa de Centro",           210.00, "Hogar"));
        catalogo.agregarProducto(new Producto("P009", "Casco Ciclismo",            90.00, "Deportes"));
        catalogo.agregarProducto(new Producto("P010", "Aceite de Oliva 1L",        12.75, "Alimentos"));

        System.out.println("\n  Productos en lista (orden insercion, mas reciente primero):");
        for (Producto p : catalogo.getListaProductos()) {
            System.out.println("    " + p);
        }

        System.out.println("\n  >> Busqueda por codigo 'P004':");
        Producto encontrado = catalogo.buscarPorCodigo("P004");
        if (encontrado != null) {
            System.out.println("     " + encontrado);
        } else {
            System.out.println("     Producto no encontrado.");
        }

        System.out.println("\n  >> Busqueda por codigo 'P999' (no existe):");
        Producto noExiste = catalogo.buscarPorCodigo("P999");
        System.out.println("     " + (noExiste != null ? noExiste : "Producto no encontrado."));

        System.out.println("\n  >> Productos ordenados por precio (menor a mayor):");
        for (Producto p : catalogo.obtenerOrdenadosPorPrecio()) {
            System.out.println("     " + p);
        }

        String[] categoriasFiltro = {"Electronicos", "Deportes", "Alimentos"};
        for (String cat : categoriasFiltro) {
            System.out.println("\n  >> Filtro categoria: " + cat);
            List<Producto> filtrados = catalogo.filtrarPorCategoria(cat);
            if (filtrados.isEmpty()) {
                System.out.println("     Sin resultados.");
            } else {
                for (Producto p : filtrados) {
                    System.out.println("     " + p);
                }
            }
        }

        System.out.println("\n  >> Carga masiva: 5 productos nuevos insertados AL INICIO:");
        List<Producto> nuevos = Arrays.asList(
            new Producto("N001", "Tablet Samsung A9",  350.00, "Electronicos"),
            new Producto("N002", "Chaqueta Invierno",  125.00, "Ropa"),
            new Producto("N003", "Lampara LED",         38.50, "Hogar"),
            new Producto("N004", "Pelota Futbol",        25.00, "Deportes"),
            new Producto("N005", "Sal 1kg",               1.80, "Alimentos")
        );
        catalogo.cargaMasiva(nuevos);
        System.out.println("  Primeros 5 en lista tras carga masiva:");
        int idx = 0;
        for (Producto p : catalogo.getListaProductos()) {
            System.out.println("     " + p);
            if (++idx == 5) break;
        }
        System.out.println("  Total productos: " + catalogo.totalProductos());

        Medidor.imprimirSeparador("2. MEDICIoN DE RENDIMIENTO");

        int[] tamanos = {100, 1_000, 10_000, 100_000};

        System.out.printf("%n  %-12s %-22s %-22s %-22s %-22s%n",
            "N productos",
            "Insercion masiva",
            "Busqueda x codigo",
            "Orden por precio",
            "Filtro categoria"
        );
        System.out.println("  " + "-".repeat(100));

        for (int n : tamanos) {
            Catalogo cat = new Catalogo();
            List<Producto> datos = GeneradorDatos.generar(n, "X");

            double tInsert = Medidor.medirMs(() -> cat.cargaMasiva(datos));

            String codigoBuscar = "X" + String.format("%06d", n / 2);
            double tBuscar = Medidor.medirMs(() -> cat.buscarPorCodigo(codigoBuscar));

            double tOrden = Medidor.medirMs(() -> cat.obtenerOrdenadosPorPrecio());

            double tFiltro = Medidor.medirMs(() -> cat.filtrarPorCategoria("Electronicos"));

            System.out.printf("  %-12s %-22s %-22s %-22s %-22s%n",
                String.format("%,d", n),
                String.format("%.3f ms", tInsert),
                String.format("%.3f ms", tBuscar),
                String.format("%.3f ms", tOrden),
                String.format("%.3f ms", tFiltro)
            );
        }

        Medidor.imprimirSeparador("3. USO DE MEMORIA APROXIMADO");

        for (int n : tamanos) {
            System.gc();
            long antes = Medidor.memoriaUsadaKB();

            Catalogo cat = new Catalogo();
            cat.cargaMasiva(GeneradorDatos.generar(n, "M"));

            long despues = Medidor.memoriaUsadaKB();
            System.out.printf("  %,8d productos → %,7d KB usados%n", n, Math.max(0, despues - antes));
        }
    }
}