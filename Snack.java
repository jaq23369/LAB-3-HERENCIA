/**
 * Estudiante: Joel Antonio Jaquez López
 * Clase: Programación Orientada a Objetos
 * Fecha de inicio: 20/10/2023
 * Fecha de finalización: 20/10/2023
 * Ejercicio: Laboratorio 3 Herencia
 * Representación de la clase: Un snack en el sistema de la tienda, extendiendo las propiedades y comportamientos
 * de un producto general.
 */
public class Snack extends Producto {

    /** Cantidad del snack en gramos. */
    private int gramos;

    /** Sabor específico del snack. */
    private String sabor;

    /** Tamaño del snack (ejemplo: "Pequeño", "Mediano", "Grande"). */
    private String tamaño;

    /**
     * Constructor para crear un nuevo snack.
     *
     * @param id Identificador único del snack.
     * @param nombre Nombre del snack.
     * @param cantidadDisponible Cantidad de snack disponible en el inventario.
     * @param cantidadVendidos  Cantidad de este snack que se ha vendido.
     * @param estado Estado actual del snack.
     * @param precio Precio del snack.
     * @param gramos Cantidad del snack en gramos.
     * @param sabor Sabor específico del snack.
     * @param tamaño Tamaño del snack.
     */
    public Snack(int id, String nombre, int cantidadDisponible, 
                 int cantidadVendidos, String estado, double precio, 
                 int gramos, String sabor, String tamaño) {
        super(id, nombre, cantidadDisponible, cantidadVendidos, estado, precio);
        this.gramos = gramos;
        this.sabor = sabor;
        this.tamaño = tamaño;
    }

    /**
     * Obtiene la cantidad en gramos del snack.
     *
     * @return La cantidad en gramos.
     */
    public int getGramos() {
        return gramos;
    }

    /**
     * Establece la cantidad en gramos del snack.
     *
     * @param gramos La nueva cantidad en gramos.
     */
    public void setGramos(int gramos) {
        this.gramos = gramos;
    }

    /**
     * Obtiene el sabor del snack.
     *
     * @return El sabor del snack.
     */
    public String getSabor() {
        return sabor;
    }

    /**
     * Establece el sabor del snack.
     *
     * @param sabor El nuevo sabor del snack.
     */
    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    /**
     * Obtiene el tamaño del snack.
     *
     * @return El tamaño del snack.
     */
    public String getTamaño() {
        return tamaño;
    }

    /**
     * Establece el tamaño del snack.
     *
     * @param tamaño El nuevo tamaño del snack.
     */
    public void setTamaño(String tamaño) {
        this.tamaño = tamaño;
    }
}

