package modelo;

import java.util.ArrayList;

/**
 * Clase Reporte.
 * Gestiona el historial de ventas y genera reportes.
 * Relación con Venta: COMPOSICIÓN
 *   - El Reporte POSEE la lista de ventas.
 * Implementa Reportable (herencia múltiple de comportamiento via interfaz).
 */
public class Reporte implements Reportable {

    // Lista interna de ventas realizadas
    private ArrayList<Venta> listaVentas;

    // Constructor
    public Reporte() {
        this.listaVentas = new ArrayList<Venta>();
    }

    /**
     * Agrega una venta al historial.
     */
    public void agregarVenta(Venta venta) {
        listaVentas.add(venta);
    }

    /**
     * Retorna la lista de ventas registradas.
     */
    public ArrayList<Venta> getListaVentas() {
        return listaVentas;
    }

    /**
     * Calcula el total acumulado de todas las ventas.
     */
    public double calcularTotalVentas() {
        double total = 0;
        for (int i = 0; i < listaVentas.size(); i++) {
            total = total + listaVentas.get(i).getTotal();
        }
        return total;
    }

    /**
     * Implementación obligatoria de la interfaz Reportable.
     * Genera reporte de ventas realizadas.
     */
    @Override
    public String generarReporte() {
        if (listaVentas.isEmpty()) {
            return "No hay ventas registradas.";
        }

        StringBuilder reporte = new StringBuilder();
        reporte.append("===== REPORTE DE VENTAS =====\n");
        reporte.append(String.format("%-12s %-18s %-8s %-10s\n",
                "FECHA", "PRODUCTO", "CANT.", "TOTAL"));
        reporte.append("--------------------------------------------------\n");

        for (int i = 0; i < listaVentas.size(); i++) {
            Venta v = listaVentas.get(i);
            reporte.append(String.format("%-12s %-18s %-8d S/. %-8.2f\n",
                    v.getFecha(),
                    v.getProducto().getNombre(),
                    v.getCantidad(),
                    v.getTotal()));
        }

        reporte.append("--------------------------------------------------\n");
        reporte.append("TOTAL ACUMULADO: S/. " + String.format("%.2f", calcularTotalVentas()));
        return reporte.toString();
    }
}
// RF-05: Reporte de ventas con formato tabular
