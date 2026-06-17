package modelo;

/**
 * Clase abstracta Persona.
 * Base de la jerarquía de usuarios del sistema.
 * Aplica: abstracción, encapsulamiento.
 */
public abstract class Persona {

    // Atributos encapsulados
    private String nombre;
    private String usuario;
    private String contrasena;

    // Constructor
    public Persona(String nombre, String usuario, String contrasena) {
        this.nombre = nombre;
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    /**
     * Método abstracto que cada tipo de usuario implementa.
     * Retorna el rol del usuario en el sistema.
     * Aplica: método abstracto + polimorfismo.
     */
    public abstract String getRol();

    /**
     * Método toString para mostrar info del usuario.
     */
    @Override
    public String toString() {
        return "Nombre: " + nombre + " | Usuario: " + usuario + " | Rol: " + getRol();
    }
}
// RF-06: Polimorfismo con getRol() para cada tipo de usuario
