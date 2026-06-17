package modelo;

/**
 * Clase Producto.
 * Representa un producto dentro del inventario.
 * Aplica: encapsulamiento, modificador final en constante.
 */
public class Producto {

    // Constante: el stock mínimo nunca cambia (modificador final)
    public static final int STOCK_MINIMO = 1;

    // Atributos privados (encapsulamiento)
    private String nombre;
    private int stock;
    private double precio;

    // Constructor completo
    public Producto(String nombre, int stock, double precio) {
        this.nombre = nombre;
        this.stock = stock;
        this.precio = precio;
    }

    // --- Getters ---
    public String getNombre() {
        return nombre;
    }

    public int getStock() {
        return stock;
    }

    public double getPrecio() {
        return precio;
    }

    // --- Setters ---
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setStock(int stock) {
        // Regla de negocio RN-02: no se permiten cantidades negativas
        if (stock >= 0) {
            this.stock = stock;
        }
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * Reduce el stock cuando se realiza una venta.
     * Retorna true si la operación fue exitosa.
     * Retorna false si no hay stock suficiente (RN-04).
     */
    public boolean reducirStock(int cantidad) {
        if (cantidad <= 0) {
            return false;
        }
        if (this.stock >= cantidad) {
            this.stock = this.stock - cantidad;
            return true;
        }
        return false; // Stock insuficiente
    }

    /**
     * Aumenta el stock al actualizar inventario.
     */
    public void aumentarStock(int cantidad) {
        if (cantidad > 0) {
            this.stock = this.stock + cantidad;
        }
    }

    /**
     * Representación en texto del producto.
     */
    @Override
    public String toString() {
        return nombre + " | Stock: " + stock + " | Precio: S/. " + String.format("%.2f", precio);
    }

    /**
     * Formato para guardar en archivo TXT (separado por punto y coma).
     */
    public String toArchivo() {
        return nombre + ";" + stock + ";" + precio;
    }
}
// RF-01: Validacion de productos duplicados implementada
