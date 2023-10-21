/**
 * Estudiante: Joel Antonio Jaquez López
 * Clase: Programación Orientada a Objetos
 * Fecha de inicio: 20/10/2023
 * Fecha de finalización: 20/10/2023
 * Ejercicio: Laboratorio 3 Herencia
 * Representación de la clase: Un producto en el sistema de la tienda.
 */
public class Producto {

    /** Identificador único del producto. */
    private int id;

    /** Nombre del producto. */
    private String nombre;

    /** Cantidad de este producto que está disponible en inventario. */
    private int cantidadDisponible;

    /** Cantidad de este producto que se ha vendido. */
    private int cantidadVendidos;

    /** Estado actual del producto. */
    private String estado;

    /** Precio del producto. */
    private double precio;

    /**
     * Constructor para crear un nuevo producto.
     *
     * @param id Identificador único del producto.
     * @param nombre Nombre del producto.
     * @param cantidadDisponible Cantidad de producto disponible.
     * @param cantidadVendidos  Cantidad de producto vendido.
     * @param estado Estado actual del producto.
     * @param precio Precio del producto.
     */
    public Producto(int id, String nombre, int cantidadDisponible, 
                    int cantidadVendidos, String estado, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.cantidadDisponible = cantidadDisponible;
        this.cantidadVendidos = cantidadVendidos;
        this.estado = estado;
        this.precio = precio;
    }

    /**
     * Obtiene el ID del producto.
     *
     * @return El ID del producto.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el ID del producto.
     *
     * @param id El nuevo ID del producto.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del producto.
     *
     * @return El nombre del producto.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del producto.
     *
     * @param nombre El nuevo nombre del producto.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la cantidad disponible del producto.
     *
     * @return La cantidad disponible.
     */
    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    /**
     * Establece la cantidad disponible del producto.
     *
     * @param cantidadDisponible La nueva cantidad disponible.
     */
    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    /**
     * Obtiene la cantidad vendida del producto.
     *
     * @return La cantidad vendida.
     */
    public int getCantidadVendidos() {
        return cantidadVendidos;
    }

    /**
     * Establece la cantidad vendida del producto.
     *
     * @param cantidadVendidos La nueva cantidad vendida.
     */
    public void setCantidadVendidos(int cantidadVendidos) {
        this.cantidadVendidos = cantidadVendidos;
    }

    /**
     * Obtiene el estado actual del producto.
     *
     * @return El estado del producto.
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Establece el estado actual del producto.
     *
     * @param estado El nuevo estado del producto.
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Obtiene el precio del producto.
     *
     * @return El precio del producto.
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Establece el precio del producto.
     *
     * @param precio El nuevo precio del producto.
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * Gestiona la venta de una cantidad específica de este producto. Si no hay suficiente
     * cantidad disponible, se muestra un mensaje indicando que la cantidad no está disponible para la venta.
     *
     * @param cantidad Cantidad del producto a vender.
     */
    public void ventaProducto(int cantidad) {
        if (cantidad <= cantidadDisponible) {
            cantidadDisponible -= cantidad;
            cantidadVendidos += cantidad;
        } else {
            System.out.println("Cantidad no disponible para la venta.");
        }
    }
}

