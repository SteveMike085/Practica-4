package ec.edu.ups.idao;
import ec.edu.ups.modelo.Usuario;
import java.util.*;

/**
 *
 * @author SteveMike
 */

public interface iUsuario {
    
    public void create(Usuario usuario);

    public Usuario read(String cedula);

    public void update(Usuario usuario);

    public void delete(Usuario usuario);

    public Usuario iniciarSesion(String correo, String contraseña);

    public Map<String, Usuario> findAll();
}
