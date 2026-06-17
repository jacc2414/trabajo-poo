package modelo;

import java.util.ArrayList;

/**
 * Clase Inventario.
 * Gestiona la lista de productos del negocio.
 * Relación con Producto: COMPOSICIÓN
 *   - El Inventario CREA y POSEE a los Productos.
 *     Si el Inventario desaparece, los Productos también.
 * Implementa la interfaz Reportable (contrato de reporte).
 */
public class Inventario implements Reportable {

    // ArrayList de productos: relación de Composición
    private ArrayList<Producto> listaProductos;

    // Constructor: crea la lista vacía al iniciar
    public Inventario() {
        this.listaProductos = new ArrayList<Producto>();
    }

    /**
     * RF-01: Registrar producto en el inventario.
     * Valida que no exista ya un producto con el mismo nombre.
     * @return true si se registró, false si ya existía.
     */
    public boolean agregarProducto(Producto producto) {
        // Recorremos la lista buscando duplicados
        for (int i = 0; i < listaProductos.size(); i++) {
            Producto p = listaProductos.get(i);
            if (p.getNombre().equalsIgnoreCase(producto.getNombre())) {
                return false; // Ya existe un producto con ese nombre
            }
        }
        listaProductos.add(producto);
        return true;
    }

    /**
     * RF-03: Buscar producto por nombre.
     * @return El producto si lo encuentra, null si no existe.
     */
    public Producto buscarProducto(String nombre) {
        for (int i = 0; i < listaProductos.size(); i++) {
            Producto p = listaProductos.get(i);
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                return p; // Encontrado
            }
        }
        return null; // No encontrado
    }

    /**
     * RF-02: Actualizar stock de un producto.
     * Busca el producto y modifica su stock.
     * @return true si se actualizó, false si no se encontró.
     */
    public boolean actualizarStock(String nombre, int nuevoStock) {
        Producto p = buscarProducto(nombre);
        if (p != null) {
            p.setStock(nuevoStock);
            return true;
        }
        return false;
    }

    /**
     * Retorna la lista completa de productos.
     */
    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }

    /**
     * Retorna cuántos productos hay registrados.
     */
    public int getTotalProductos() {
        return listaProductos.size();
    }

    /**
     * RF-05: Implementación del método de la interfaz Reportable.
     * Genera un reporte en texto con todos los productos.
     * @Override porque implementa el contrato de la interfaz.
     */
    @Override
    public String generarReporte() {
        // Si no hay productos, informa al usuario
        if (listaProductos.isEmpty()) {
            return "No hay productos registrados en el inventario.";
        }

        // Construye el reporte usando StringBuilder
        StringBuilder reporte = new StringBuilder();
        reporte.append("===== REPORTE DE INVENTARIO =====\n");
        reporte.append(String.format("%-20s %-10s %-10s\n", "PRODUCTO", "STOCK", "PRECIO"));
        reporte.append("---------------------------------------\n");

        // Recorre toda la lista con for-each clásico
        for (Producto p : listaProductos) {
            reporte.append(String.format("%-20s %-10d S/. %-8.2f\n",
                    p.getNombre(), p.getStock(), p.getPrecio()));
        }

        reporte.append("---------------------------------------\n");
        reporte.append("Total de productos: " + listaProductos.size());
        return reporte.toString();
    }
}
// RF-02: Metodo actualizarStock valida stock minimo
// RF-02: Metodo actualizarStock valida stock minimo
