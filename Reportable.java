package modelo;

/**
 * Interfaz Reportable.
 * Define el contrato que deben cumplir las clases
 * que generan reportes en el sistema.
 * Aplica: interface (contrato sin implementación).
 */
public interface Reportable {

    /**
     * Genera un reporte en formato texto.
     * Toda clase que implemente esta interfaz
     * DEBE proveer su propia versión de este método.
     */
    String generarReporte();
}
