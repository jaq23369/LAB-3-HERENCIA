/**
 * Estudiante: Joel Antonio Jaquez López
 * Clase: Programación Orientada a Objetos
 * Fecha de inicio: 20/10/2023
 * Fecha de finalización: 20/10/2023
 * Ejercicio: Laboratorio 3 Herencia
 * Representación de la clase: Una bebida en el sistema de la tienda, extendiendo las propiedades y comportamientos
 * de un producto general.
 */
public class Bebida extends Producto {

    /** Cantidad de la bebida en mililitros. */
    private int mililitros;

    /** Tipo de bebida (ejemplo: "Refresco", "Agua", "Alcohólica"). */
    private String tipo;

    /**
     * Constructor para crear una nueva bebida.
     *
     * @param id Identificador único de la bebida.
     * @param nombre Nombre de la bebida.
     * @param cantidadDisponible Cantidad de bebida disponible en el inventario.
     * @param cantidadVendidos  Cantidad de esta bebida que se ha vendido.
     * @param estado Estado actual de la bebida.
     * @param precio Precio de la bebida.
     * @param mililitros Cantidad de la bebida en mililitros.
     * @param tipo Tipo de bebida.
     */
    public Bebida(int id, String nombre, int cantidadDisponible, 
                  int cantidadVendidos, String estado, double precio, 
                  int mililitros, String tipo) {
        super(id, nombre, cantidadDisponible, cantidadVendidos, estado, precio);
        this.mililitros = mililitros;
        this.tipo = tipo;
    }

    /**
     * Obtiene la cantidad en mililitros de la bebida.
     *
     * @return La cantidad en mililitros.
     */
    public int getMililitros() {
        return mililitros;
    }

    /**
     * Establece la cantidad en mililitros de la bebida.
     *
     * @param mililitros La nueva cantidad en mililitros.
     */
    public void setMililitros(int mililitros) {
        this.mililitros = mililitros;
    }

    /**
     * Obtiene el tipo de bebida.
     *
     * @return El tipo de bebida.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Establece el tipo de bebida.
     *
     * @param tipo El nuevo tipo de bebida.
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
