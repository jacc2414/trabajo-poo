package modelo;

/**
 * Clase Cajero.
 * Hereda de Persona. Solo puede registrar ventas.
 * Aplica: herencia (extends), polimorfismo (@Override).
 */
public class Cajero extends Persona {

    public Cajero(String nombre, String usuario, String contrasena) {
        super(nombre, usuario, contrasena);
    }

    /**
     * Implementación del método abstracto getRol().
     * Cada subclase devuelve su propio rol (polimorfismo).
     */
    @Override
    public String getRol() {
        return "Cajero";
    }
}
