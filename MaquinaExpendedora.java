import java.util.Scanner;

public class MaquinaExpendedora {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;
        
        // Inicializar los módulos
        ModuloInventario.inicializar();
        ModuloMonedero.inicializar();
        
        System.out.println("¡Bienvenido a la Máquina Expendedora!");
        
        while (continuar) {
            System.out.println("\n--- MENÚ PRINCIPAL ---");
            System.out.println("1. Ver productos disponibles");
            System.out.println("2. Insertar dinero");
            System.out.println("3. Comprar producto");
            System.out.println("4. Solicitar cambio");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            
            int opcion = scanner.nextInt();
            
            switch (opcion) {
                case 1:
                    ModuloInventario.mostrarProductos();
                    break;
                    
                case 2:
                    System.out.print("Introduzca cantidad a insertar (céntimos): ");
                    int cantidad = scanner.nextInt();
                    ModuloMonedero.insertarDinero(cantidad);
                    System.out.println("Dinero actual: " + ModuloMonedero.consultarDineroInsertado() + " céntimos");
                    break;
                    
                case 3:
                    System.out.print("Introduzca ID del producto: ");
                    int idProducto = scanner.nextInt();
                    
                    if (ModuloInventario.verificarStock(idProducto)) {
                        int precio = ModuloInventario.consultarPrecio(idProducto);
                        
                        if (ModuloMonedero.verificarDineroSuficiente(precio)) {
                            if (ModuloMonedero.procesarPago(precio)) {
                                ModuloInventario.dispensarProducto(idProducto);
                                System.out.println("¡Producto dispensado con éxito!");
                            }
                        } else {
                            System.out.println("Dinero insuficiente. Faltan " + 
                                (precio - ModuloMonedero.consultarDineroInsertado()) + " céntimos.");
                        }
                    }
                    break;
                    
                case 4:
                    int cambio = ModuloMonedero.darCambio();
                    System.out.println("Se han devuelto " + cambio + " céntimos.");
                    break;
                    
                case 5:
                    System.out.println("Gracias por usar la máquina expendedora.");
                    ModuloMonedero.darCambio(); // Devolver el dinero restante
                    continuar = false;
                    break;
                    
                default:
                    System.out.println("Opción no válida.");
            }
        }
        
        scanner.close();
    }
}
