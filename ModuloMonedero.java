public class ModuloMonedero {
    // Variables privadas del módulo
    private static int dineroInsertado;
    private static int dineroTotal;
    
    // Método de inicialización
    public static void inicializar() {
        dineroInsertado = 0;
        dineroTotal = 1000; // La máquina comienza con algo de cambio
        
        System.out.println("Módulo de Monedero inicializado correctamente.");
    }
    
    // Permite al usuario insertar dinero
    public static void insertarDinero(int cantidad) {
        if (cantidad > 0) {
            dineroInsertado += cantidad;
            dineroTotal += cantidad;
            System.out.println("Se han insertado " + cantidad + " céntimos.");
        } else {
            System.out.println("Error: La cantidad debe ser positiva.");
        }
    }
    
    // Consulta el dinero insertado por el usuario actual
    public static int consultarDineroInsertado() {
        return dineroInsertado;
    }
    
    // Verifica si hay dinero suficiente para comprar un producto
    public static boolean verificarDineroSuficiente(int precio) {
        return dineroInsertado >= precio;
    }
    
    // Procesa el pago de un producto
    public static boolean procesarPago(int precio) {
        if (dineroInsertado >= precio) {
            dineroInsertado -= precio;
            System.out.println("Pago procesado: " + precio + " céntimos.");
            System.out.println("Dinero restante: " + dineroInsertado + " céntimos.");
            return true;
        } else {
            System.out.println("Error: Dinero insuficiente.");
            return false;
        }
    }
    
    // Devuelve el cambio al usuario
    public static int darCambio() {
        int cambio = dineroInsertado;
        
        if (cambio > 0) {
            if (cambio <= dineroTotal) {
                dineroTotal -= cambio;
                dineroInsertado = 0;
                return cambio;
            } else {
                System.out.println("Error: La máquina no tiene suficiente cambio.");
                return 0;
            }
        }
        return 0;
    }
}
