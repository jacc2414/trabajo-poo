package modelo;

/**
 * Clase Administrador.
 * Hereda de Persona. Tiene acceso total al sistema.
 * Aplica: herencia (extends), polimorfismo (@Override).
 */
public class Administrador extends Persona {

    // Constructor que llama al constructor del padre con super()
    public Administrador(String nombre, String usuario, String contrasena) {
        super(nombre, usuario, contrasena);
    }

    /**
     * Implementación obligatoria del método abstracto getRol().
     * @Override indica que reemplaza el método de la clase padre.
     */
    @Override
    public String getRol() {
        return "Administrador";
    }
}
