package modelo;

/**
 * Clase Venta.
 * Registra una operación de venta realizada en el sistema.
 * Relación con Producto: AGREGACIÓN
 *   - La Venta referencia a un Producto, pero el Producto
 *     puede existir sin la Venta.
 */
public class Venta {

    // Atributos de la venta
    private Producto producto;   // Relación de Agregación con Producto
    private int cantidad;
    private double total;
    private String fecha;

    // Constructor
    public Venta(Producto producto, int cantidad, String fecha) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.total = producto.getPrecio() * cantidad; // Calcula el total
        this.fecha = fecha;
    }

    // Getters
    public Producto getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getTotal() {
        return total;
    }

    public String getFecha() {
        return fecha;
    }

    /**
     * Representación en texto de la venta.
     */
    @Override
    public String toString() {
        return "[" + fecha + "] Producto: " + producto.getNombre()
                + " | Cantidad: " + cantidad
                + " | Total: S/. " + String.format("%.2f", total);
    }

    /**
     * Formato para guardar en archivo TXT.
     */
    public String toArchivo() {
        return fecha + ";" + producto.getNombre() + ";" + cantidad + ";" + total;
    }
}
// RF-04: Descuento automatico de stock al vender
// RF-04: Calculo automatico de total en constructor
