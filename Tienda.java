import java.util.ArrayList;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.util.Map;

/**
 * Estudiante: Joel Antonio Jaquez López
 * Clase: Programación Orientada a Objetos
 * Fecha de inicio: 20/10/2023
 * Fecha de finalización: 20/10/2023
 * Ejercicio: Laboratorio 3 Herencia
 * Representación de la clase: Representa una tienda con funcionalidades de inventario y gestión de productos.
 */
public class Tienda {
    /** Lista que almacena todos los productos de la tienda. */
    private ArrayList<Producto> inventario;
    /** Mapa que asocia categorías a sus atributos específicos. */
    private HashMap<String, Categoria> categorias;
    /** Representa el total de ventas realizadas en la tienda. */
    private double ventasTotales;
    /** Almacena el total de comisiones obtenidas de las ventas. */
    private double comisiones;

/**
     * Constructor por defecto que inicializa la lista de productos, el mapa de categorías y los totales.
     */
    public Tienda() {
        this.inventario = new ArrayList<>();
        this.categorias = new HashMap<>();
        this.ventasTotales = 0.0;
        this.comisiones = 0.0;
    }

    /**
     * Obtiene la lista de productos en el inventario.
     * @return Lista de productos.
     */
    public ArrayList<Producto> getInventario() {
        return inventario;
    }

    /**
     * Establece la lista de productos para el inventario.
     * @param inventario Lista de productos a establecer.
     */
    public void setInventario(ArrayList<Producto> inventario) {
        this.inventario = inventario;
    }

    /**
     * Obtiene el mapa de categorías y sus atributos específicos.
     * @return Mapa de categorías.
     */
    public HashMap<String, Categoria> getCategorias() {
        return categorias;
    }

    /**
     * Establece el mapa de categorías.
     * @param categorias Mapa de categorías a establecer.
     */
    public void setCategorias(HashMap<String, Categoria> categorias) {
        this.categorias = categorias;
    }

    /**
     * Obtiene el total de ventas realizadas.
     * @return Total de ventas.
     */
    public double getVentasTotales() {
        return ventasTotales;
    }

    /**
     * Establece el total de ventas.
     * @param ventasTotales Valor del total de ventas a establecer.
     */
    public void setVentasTotales(double ventasTotales) {
        this.ventasTotales = ventasTotales;
    }

    /**
     * Obtiene el total de comisiones obtenidas.
     * @return Total de comisiones.
     */
    public double getComisiones() {
        return comisiones;
    }

 /**
     * Carga productos desde un archivo CSV y los añade al inventario.
     * @param rutaArchivo Ruta del archivo CSV que contiene los productos.
     */
    public void cargarProductosDesdeCSV(String rutaArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            br.readLine();  // Leer y descartar la primera línea (encabezados)
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                int id = Integer.parseInt(datos[0]);
                String nombre = datos[1];
                int cantidadDisponible = Integer.parseInt(datos[2]);
                int cantidadVendidos = Integer.parseInt(datos[3]);
                String estado = datos[4];
                double precio = Double.parseDouble(datos[5]);
                String categoria = datos[6];
                Producto producto;
                if ("Bebida".equalsIgnoreCase(categoria)) {
                    int ml = Integer.parseInt(datos[7]);
                    String tipo = datos[8];
                    producto = new Bebida(id, nombre, cantidadDisponible, cantidadVendidos, estado, precio, ml, tipo);
                } else {  // asumimos que si no es Bebida, es Snack
                    int gramos = Integer.parseInt(datos[7]);
                    String sabor = datos[8];
                    String tamaño = datos[9];
                    producto = new Snack(id, nombre, cantidadDisponible, cantidadVendidos, estado, precio, gramos, sabor, tamaño);
                }
                inventario.add(producto);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

/**
     * Busca un producto en el inventario por su ID.
     * @param id ID del producto a buscar.
     * @return El producto si se encuentra, null en caso contrario.
     */
    public Producto buscarProductoPorID(int id) {
        for (Producto producto : inventario) {
            if (producto.getId() == id) {
                return producto;
            }
        }
        return null;
    }

/**
     * Añade un nuevo producto al archivo CSV y a la lista de productos.
     * @param categoria Nombre de la categoría del producto.
     * @param atributosProducto Atributos del producto en formato clave-valor.
     */
    public void agregarNuevoProducto(String categoria, HashMap<String, String> atributosProducto) {
        // Suponemos que los atributosProducto tienen toda la información necesaria para crear un nuevo producto.
        try (FileWriter fw = new FileWriter("productos.csv", true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println(atributosProducto.get("id") + "," +
                        atributosProducto.get("nombre") + "," +
                        atributosProducto.get("cantidadDisponible") + "," +
                        atributosProducto.get("cantidadVendidos") + "," +
                        atributosProducto.get("estado") + "," +
                        atributosProducto.get("precio") + "," +
                        categoria + "," +
                        atributosProducto.get("dato1") + "," +
                        atributosProducto.get("dato2") + "," +
                        atributosProducto.get("dato3"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

/**
     * Gestiona la venta de un producto, actualiza el inventario y calcula las ventas y comisiones.
     * @param idProducto ID del producto a vender.
     * @param cantidad Cantidad del producto a vender.
     */
    public void venderProducto(int idProducto, int cantidad) {
        Producto producto = buscarProductoPorID(idProducto);
        if (producto != null && producto.getCantidadDisponible() >= cantidad) {
            producto.setCantidadDisponible(producto.getCantidadDisponible() - cantidad);
            producto.setCantidadVendidos(producto.getCantidadVendidos() + cantidad);
            ventasTotales += cantidad * producto.getPrecio();
            // Esta es una comprobación básica. Podrías tener una lógica más compleja dependiendo de tus categorías.
            comisiones += (0.20 * cantidad * producto.getPrecio());  // 20% de comisión para la nueva categoría
        }
    }

/**
     * Calcula y devuelve las comisiones basadas en el total de ventas.
     * @return Valor total de las comisiones.
     */
    public double calcularComisiones() {
        return ventasTotales * 0.20;  // 20% de comisión
    }

 /**
     * Muestra un informe detallado que incluye la lista de categorías, productos y el total de ventas.
     * Este método fue agregado de última hora y no se incluyó en el análisis.
     */
    public void mostrarInforme() {
    HashMap<String, Integer> categoriasConteo = new HashMap<>();
    categoriasConteo.put("Bebida", 0);
    categoriasConteo.put("Snack", 0);
    categoriasConteo.put("Nueva categoría", 0);  // Si tienes una categoría con nombre específico, reemplázalo aquí.

    for (Producto producto : inventario) {
        if (producto instanceof Bebida) {
            categoriasConteo.put("Bebida", categoriasConteo.get("Bebida") + 1);
        } else if (producto instanceof Snack) {
            categoriasConteo.put("Snack", categoriasConteo.get("Snack") + 1);
        } else {
            categoriasConteo.put("Nueva categoría", categoriasConteo.get("Nueva categoría") + 1);
        }
    }

    System.out.println("Listado de categorías con el total de productos:");
    for (Map.Entry<String, Integer> entry : categoriasConteo.entrySet()) {
        System.out.println(entry.getKey() + " - " + entry.getValue());
    }

    System.out.println("\nListado de productos:");
    for (Producto producto : inventario) {
        System.out.println(producto.getNombre());
    }

    System.out.println("\nTotal de ventas: Q" + ventasTotales);
    }
}

