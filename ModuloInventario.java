public class ModuloInventario {
    // Variables privadas del módulo
    private static String[] nombresProductos;
    private static int[] stockProductos;
    private static int[] preciosProductos;
    
    // Método de inicialización
    public static void inicializar() {
        // Inicializamos los arrays con datos de ejemplo
        nombresProductos = new String[] {
            "Agua mineral",
            "Refresco cola",
            "Zumo naranja",
            "Sandwich vegetal",
            "Chocolate"
        };
        
        stockProductos = new int[] {5, 3, 4, 2, 6};
        
        preciosProductos = new int[] {100, 150, 180, 250, 120}; // En céntimos
        
        System.out.println("Módulo de Inventario inicializado correctamente.");
    }
    
    // Muestra todos los productos disponibles
    public static void mostrarProductos() {
        System.out.println("\n--- PRODUCTOS DISPONIBLES ---");
        System.out.println("ID | Producto           | Precio  | Stock");
        System.out.println("-----------------------------------");
        
        for (int i = 0; i < nombresProductos.length; i++) {
            if (stockProductos[i] > 0) {
                System.out.printf("%2d | %-18s | %3d cts | %2d unid.%n", 
                                 i, nombresProductos[i], preciosProductos[i], stockProductos[i]);
            }
        }
    }
    
    // Verifica si hay stock de un producto
    public static boolean verificarStock(int idProducto) {
        if (idProductoValido(idProducto)) {
            if (stockProductos[idProducto] > 0) {
                return true;
            } else {
                System.out.println("Lo sentimos, producto agotado.");
                return false;
            }
        }
        return false;
    }
    
    // Consulta el precio de un producto
    public static int consultarPrecio(int idProducto) {
        if (idProductoValido(idProducto)) {
            return preciosProductos[idProducto];
        }
        return 0;
    }
    
    // Dispensa un producto (reduce su stock)
    public static void dispensarProducto(int idProducto) {
        if (idProductoValido(idProducto) && stockProductos[idProducto] > 0) {
            stockProductos[idProducto]--;
            System.out.println("Dispensando: " + nombresProductos[idProducto]);
        }
    }
    
    // Verifica si un ID de producto es válido
    private static boolean idProductoValido(int idProducto) {
        if (idProducto >= 0 && idProducto < nombresProductos.length) {
            return true;
        } else {
            System.out.println("Error: ID de producto no válido.");
            return false;
        }
    }
}
