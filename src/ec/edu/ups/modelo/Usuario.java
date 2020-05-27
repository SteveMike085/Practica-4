package ec.edu.ups.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author SteveMike
 */

public class Usuario {

    private String cedula;
    private String nombre;
    private String apellido;
    private String correo;
    private String contraseña;
    private List<Telefono> listaTelefonos;

    public Usuario() {
        listaTelefonos = new ArrayList<>();
    }

    public Usuario(String cedula, String nombre, String apellido, String correo, String contraseña) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.contraseña = contraseña;
        listaTelefonos = new ArrayList<>();
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public List<Telefono> getListaTelefonos() {
        return listaTelefonos;
    }

    public void agregarTelefono(Telefono telefono) {
        listaTelefonos.add(telefono);
    }

    public void actualizarTelefono(Telefono telefono) {
        if (listaTelefonos.contains(telefono)) {
            int index = listaTelefonos.indexOf(telefono);
            listaTelefonos.set(index, telefono);
        }
    }

    public void eliminarDireccion(Telefono telefono) {
        if (listaTelefonos.contains(telefono)) {
            int index = listaTelefonos.indexOf(telefono);
            listaTelefonos.remove(index);
        }
    }

    public List<Telefono> listar() {
        return listaTelefonos;
    }

    public Telefono buscar(int id) {
        return listaTelefonos.get(id);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.cedula);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.cedula, other.cedula)) {
            return false;
        }
        return true;
    }

    
    
    @Override
    public String toString() {
        return "\nUsuario:\n" + "cedula: " + cedula + "\nnombre: " + nombre + ", apellido: " + apellido + "\ncorreo: " + correo + ", contraseña: " + contraseña + "\ntelefono(s):\n " + listaTelefonos;
    }

}
