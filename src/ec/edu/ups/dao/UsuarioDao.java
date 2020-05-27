package ec.edu.ups.dao;
import ec.edu.ups.idao.iUsuario;
import ec.edu.ups.modelo.Usuario;
import java.util.*;

/**
 *
 * @author SteveMike
 */

public class UsuarioDao implements iUsuario{
    
    private Map<String, Usuario> listaUsuarios;
    
    public UsuarioDao() {
        listaUsuarios = new HashMap<>();
    }
    
    @Override
    public void create(Usuario cliente) {
        listaUsuarios.put(cliente.getCedula(), cliente);
    }

    @Override
    public Usuario read(String cedula) {
        for (Map.Entry<String, Usuario> usuario : listaUsuarios.entrySet()) {
            String key = usuario.getKey();
            Usuario valor = usuario.getValue();
            if (valor.getCedula().equals(cedula) || (valor.getCorreo().equals(cedula))) {
                Usuario usuario2 = listaUsuarios.get(key);
                return usuario2;
            }
        }
        return null;
    }

    @Override
    public void update(Usuario cliente) {
        for (Map.Entry<String, Usuario> usuario2 : listaUsuarios.entrySet()) {
            Usuario usuario3 = usuario2.getValue();
            if (usuario3.getCedula().equals(cliente.getCedula())) {
                listaUsuarios.replace(cliente.getCedula(), cliente);
                break;
            }
        }
    }

    @Override
    public void delete(Usuario cliente) {
        for (Map.Entry<String, Usuario> usuario2 : listaUsuarios.entrySet()) {
            Usuario usuario3 = usuario2.getValue();
            if (usuario3.getCedula().equals(cliente.getCedula())) {
                listaUsuarios.remove(cliente.getCedula());
                break;
            }
        }
    }

    @Override
    public Usuario iniciarSesion(String correo, String contraseña) {
        for (Map.Entry<String, Usuario> usuario : listaUsuarios.entrySet()) {
            String key = usuario.getKey();
            Usuario valor = usuario.getValue();
            if (valor.getCorreo().equals(correo)) {
                if (valor.getContraseña().equals(contraseña)) {
                    Usuario usu = new Usuario();
                    usu = listaUsuarios.get(key);
                    return usu;
                }
            }
        }
        return null;
    }

    @Override
    public Map<String, Usuario> findAll() {
        return listaUsuarios;
    }
}
