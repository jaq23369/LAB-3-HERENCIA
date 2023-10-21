import java.util.Scanner;
import java.util.HashMap;

/**
 * Estudiante: Joel Antonio Jaquez López
 * Clase: Programación Orientada a Objetos
 * Fecha de inicio: 20/10/2023
 * Fecha de finalización: 20/10/2023
 * Ejercicio: Laboratorio 3 Herencia
 * Representación de la clase:Punto de entrada principal de la aplicación para gestionar una tienda.
 * Permite listar productos, buscar por ID, vender productos, agregar nuevos
 * productos, ver comisiones, ver informe y salir.
 */
public class Main {
    /**
     * Método principal que se ejecuta al iniciar el programa.
     *
     * @param args Argumentos de la línea de comandos (no se utilizan en este contexto).
     */
    public static void main(String[] args) {
        // Creación de una nueva instancia de tienda.
        Tienda tienda = new Tienda();
        
        // Carga de productos desde un archivo CSV.
        tienda.cargarProductosDesdeCSV("productos.csv"); //  Este es el nombre del archivo CSV.

        Scanner scanner = new Scanner(System.in);
        int opcion; // Variable para almacenar la opción seleccionada por el usuario.

        do {
            System.out.println("\nTienda de Productos");
            System.out.println("1. Listar productos");
            System.out.println("2. Buscar producto por ID");
            System.out.println("3. Vender producto");
            System.out.println("4. Agregar nuevo producto");
            System.out.println("5. Ver comisiones");
            System.out.println("6. Ver informe");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");
            
            opcion = scanner.nextInt();
            scanner.nextLine();  // Consume the newline left-over

            switch (opcion) {
                case 1:
                    // Listar productos
                    for (Producto p : tienda.getInventario()) {
                        System.out.println("ID: " + p.getId() + ", Nombre: " + p.getNombre() + ", Precio: " + p.getPrecio() + ", Cantidad: " + p.getCantidadDisponible());
                    }
                    break;
                case 2:
                    // Buscar producto por ID
                    System.out.print("Ingrese el ID del producto: ");
                    int id = scanner.nextInt();
                    Producto producto = tienda.buscarProductoPorID(id);
                    if (producto != null) {
                        System.out.println("Producto encontrado: " + producto.getNombre());
                    } else {
                        System.out.println("Producto no encontrado.");
                    }
                    break;
                case 3:
                    // Vender producto
                    System.out.print("Ingrese el ID del producto que desea vender: ");
                    int idVenta = scanner.nextInt();
                    System.out.print("Ingrese la cantidad que desea vender: ");
                    int cantidadVenta = scanner.nextInt();
                    tienda.venderProducto(idVenta, cantidadVenta);
                    break;
                case 4:
                    // Agregar nuevo producto
                    HashMap<String, String> atributosProducto = new HashMap<>();
                    System.out.print("Ingrese la categoría del producto: ");
                    String categoria = scanner.nextLine();

                    System.out.print("ID del producto: ");
                    atributosProducto.put("id", scanner.nextLine());
                    System.out.print("Nombre del producto: ");
                    atributosProducto.put("nombre", scanner.nextLine());
                    System.out.print("Cantidad disponible del producto: ");
                    atributosProducto.put("cantidadDisponible", scanner.nextLine());
                    System.out.print("Cantidad vendida del producto: ");
                    atributosProducto.put("cantidadVendidos", scanner.nextLine());
                    System.out.print("Estado del producto: ");
                    atributosProducto.put("estado", scanner.nextLine());
                    System.out.print("Precio del producto: ");
                    atributosProducto.put("precio", scanner.nextLine());
                    System.out.print("Dato adicional 1 (ml o gramos): ");
                    atributosProducto.put("dato1", scanner.nextLine());
                    System.out.print("Dato adicional 2 (tipo o sabor): ");
                    atributosProducto.put("dato2", scanner.nextLine());
                    System.out.print("Dato adicional 3 (solo para Snacks, tamaño): ");
                    atributosProducto.put("dato3", scanner.nextLine());

                    tienda.agregarNuevoProducto(categoria, atributosProducto);
                    System.out.println("Producto añadido correctamente.");
                    break;
                case 5:
                    // Ver comisiones
                    System.out.println("Comisiones totales: $" + tienda.calcularComisiones());
                    break;
                case 6:
                    //Mostrar informe
                    tienda.mostrarInforme();
                    break;
                case 7:
                    //Salir del programa
                    System.out.println("Gracias por usar el programa. Adiós!");
                    break;    
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
                    break;
            }

        } while (opcion != 7); // Repetir mientras la opción no sea salir.

        scanner.close(); // Cerrar el scanner.
    }
}

