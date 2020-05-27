package ec.edu.ups.controlador;
import ec.edu.ups.idao.iTelefono;
import ec.edu.ups.idao.iUsuario;
import ec.edu.ups.modelo.Telefono;
import ec.edu.ups.modelo.Usuario;
import ec.edu.ups.vista.VistaTelefono;
import ec.edu.ups.vista.VistaUsuario;
import ec.edu.ups.dao.TelefonoDao;
import ec.edu.ups.dao.UsuarioDao;
import java.util.Map;

/**
 *
 *
 * @author SteveMike
 */
public class ControladorUsuario {

    private VistaUsuario vistaU;
    private VistaTelefono vistaT;
    private Usuario cliente;
    private Telefono tele;
    private iUsuario clienteDAO;
    private iTelefono telefonoDAO;

    public ControladorUsuario(VistaUsuario vistaU, VistaTelefono vistaT, Usuario cliente, Telefono tele, iUsuario clienteDAO, iTelefono telefonoDAO) {
        this.vistaU = vistaU;
        this.vistaT = vistaT;
        this.cliente = cliente;
        this.tele = tele;
        this.clienteDAO = clienteDAO;
        this.telefonoDAO = telefonoDAO;
    }

    public ControladorUsuario(VistaUsuario vistaU, VistaTelefono vistaT, iUsuario clienteDAO, iTelefono telefonoDAO) {
        this.vistaU = vistaU;
        this.vistaT = vistaT;
        this.clienteDAO = clienteDAO;
        this.telefonoDAO = telefonoDAO;
    }

    public ControladorUsuario(){
        
    }

    public void registrar() {
        cliente = vistaU.ingresarCliente();
        clienteDAO.create(cliente);
    }

    public Usuario iniciarSesion() {
        String correo = vistaU.iniciarSesionCorreo();
        String contraseña = vistaU.iniciarSesionContraseña();
        cliente = clienteDAO.iniciarSesion(correo, contraseña);
        vistaU.verCliente(cliente);
        return cliente;
    }

    public void buscarTelefonos() {
        String id = vistaU.buscarCliente();
        cliente = clienteDAO.read(id);
        if (cliente != null) {
            vistaT.imprimirTelefonosUsuario(cliente);
        } else {
            String frase = "Usuario no encontrado";
            vistaU.frase(frase);
        }
    }

    public void imprimirUsuario() {

        String id = vistaU.buscarCliente();
        cliente = clienteDAO.read(id);
        if (cliente != null) {
            vistaU.verCliente(cliente);
        } else {
            String frase = "Usuario no encontrado";
            vistaU.frase(frase);
        }
    }

    public boolean verCliente() {
        String id = vistaU.confirmacionCedula();
        cliente = clienteDAO.read(id);
        if (cliente == null) {
            String frase = "cedula no valida";
            vistaU.frase(frase);
            return false;
        }
        return true;
    }

    public void actualizar() {
        cliente = vistaU.actualizarCliente();
        clienteDAO.update(cliente);
    }

    public void eliminar() {
        cliente = vistaU.eliminarCliente();
        clienteDAO.delete(cliente);
    }

    public void verClientes() {
        Map<String, Usuario> clientes;
        clientes = clienteDAO.findAll();
        vistaU.verClientes(clientes);
    }

    public void agregarTelefono() {
        int id = vistaT.confirmarCodigo();
        tele = telefonoDAO.read(id);
        if (tele != null) {
            cliente.agregarTelefono(tele);
            clienteDAO.update(cliente);
            vistaT.imprimirTelefonosUsuario(cliente);
        } else {
            String frase = "Codigo incorrecto";
            vistaU.frase(frase);
        }
    }

    public void actualizarTelefono() {
        int id = vistaT.confirmarCodigo();
        tele = telefonoDAO.read(id);
        if (tele != null) {
            cliente.actualizarTelefono(tele);
            clienteDAO.update(cliente);
            vistaT.imprimirTelefonosUsuario(cliente);
        } else {
            String frase = "Telefono no encontrado";
            vistaU.frase(frase);
        }
    }

    public void eliminarTelefono() {
        int id = vistaT.confirmarCodigo();
        tele = telefonoDAO.read(id);
        if (tele != null) {
            cliente.eliminarDireccion(tele);
            clienteDAO.update(cliente);
            vistaT.imprimirTelefonosUsuario(cliente);
            telefonoDAO.delete(tele);
        } else {
            String frase = "Codigo incorrecto";
            vistaU.frase(frase);
        }
    }

    public void salir() {
        String frase = "Usted ha salido del programa";
        vistaU.frase(frase);
    }

    public void numeroErroneo() {
        String frase = "Ingrese una opcion Correcta";
        vistaU.frase(frase);
    }

    public void cerrarSesion() {
        String frase = "Ha cerrado la sesion";
        vistaU.frase(frase);

    }
}
