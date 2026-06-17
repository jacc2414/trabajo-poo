package modelo;

/**
 * Clase EncargadoAlmacen.
 * Hereda de Persona. Gestiona el stock del inventario.
 * Aplica: herencia (extends), polimorfismo (@Override).
 */
public class EncargadoAlmacen extends Persona {

    public EncargadoAlmacen(String nombre, String usuario, String contrasena) {
        super(nombre, usuario, contrasena);
    }

    /**
     * Implementación del método abstracto getRol().
     */
    @Override
    public String getRol() {
        return "Encargado de Almacén";
    }
}
// RF-08: Encargado de Almacen con control de stock
