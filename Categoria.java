import java.util.ArrayList;
import java.util.HashMap;

/**
 * Estudiante: Joel Antonio Jaquez López
 * Clase: Programación Orientada a Objetos
 * Fecha de inicio: 20/10/2023
 * Fecha de finalización: 20/10/2023
 * Ejercicio: Laboratorio 3 Herencia
 * Representación de la clase: Una categoría de productos con atributos específicos y un listado de productos asociados.
 * Cada categoría puede tener varios atributos que la definen y una lista de productos que pertenecen a esta categoría.
 */
public class Categoria {

    /** Nombre de la categoría. */
    private String nombreCategoria;

    /** Atributos específicos de la categoría en pares clave-valor. */
    private HashMap<String, String> atributosEspecificos;

    /** Listado de productos que pertenecen a esta categoría. */
    private ArrayList<Producto> productos;

    /**
     * Constructor que inicializa una nueva categoría.
     *
     * @param nombreCategoria Nombre de la categoría.
     * @param atributosEspecificos  Atributos específicos de la categoría en formato clave-valor.
     */
    public Categoria(String nombreCategoria, HashMap<String, String> atributosEspecificos) {
        this.nombreCategoria = nombreCategoria;
        this.atributosEspecificos = atributosEspecificos;
        this.productos = new ArrayList<>();
    }

    // Getters y Setters

    /**
     * Obtiene el nombre de la categoría.
     *
     * @return El nombre de la categoría.
     */
    public String getNombreCategoria() {
        return nombreCategoria;
    }

    /**
     * Establece el nombre de la categoría.
     *
     * @param nombreCategoria El nuevo nombre de la categoría.
     */
    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    /**
     * Obtiene los atributos específicos de la categoría.
     *
     * @return Los atributos específicos en formato clave-valor.
     */
    public HashMap<String, String> getAtributosEspecificos() {
        return atributosEspecificos;
    }

    /**
     * Establece los atributos específicos de la categoría.
     *
     * @param atributosEspecificos Los nuevos atributos en formato clave-valor.
     */
    public void setAtributosEspecificos(HashMap<String, String> atributosEspecificos) {
        this.atributosEspecificos = atributosEspecificos;
    }

    /**
     * Obtiene la lista de productos asociados a esta categoría.
     *
     * @return La lista de productos.
     */
    public ArrayList<Producto> getProductos() {
        return productos;
    }

    // Métodos específicos

    /**
     * Añade un producto a la lista de productos de esta categoría.
     *
     * @param producto El producto a ser añadido.
     */
    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }
}

