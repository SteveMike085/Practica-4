package ec.edu.ups.controlador;
import ec.edu.ups.idao.iTelefono;
import ec.edu.ups.modelo.Telefono;
import ec.edu.ups.vista.VistaTelefono;
import ec.edu.ups.dao.TelefonoDao;
import java.util.*;

/**
 *
 * @author SteveMike
 */
public class ControladorTelefono {

    private VistaTelefono vista;
    private Telefono tele;
    private iTelefono telefonoDAO;

    public ControladorTelefono(VistaTelefono vistaDireccion, iTelefono direccionDAO,TelefonoDao telefonoDAO,VistaTelefono vistaT) {
        this.vista = vistaDireccion;
        this.telefonoDAO = direccionDAO;
    }

    public ControladorTelefono(VistaTelefono vistaT, TelefonoDao telefonoDAO) {
        this.vista = vistaT;
        this.telefonoDAO = telefonoDAO;
    }

    public void registrar() {
        tele = vista.ingresarTelefono();
        telefonoDAO.create(tele);
        vista.verDireccion(tele);
    }

    public void verDireccion() {
        int id = vista.buscarTelefono();
        tele = telefonoDAO.read(id);
        vista.verDireccion(tele);
    }

    public void actualizar() {
        int codigo = vista.pedirCodigo();
        tele = telefonoDAO.read(codigo);
        if (tele != null) {
            vista.verDireccion(tele);
            tele = vista.actualizarTelefono();
            telefonoDAO.update(tele);
        }
    }

    public void eliminar() {
        int id = vista.eliminarTelefono();
        tele = telefonoDAO.read(id);
        vista.verDireccion(tele);
    }

    public void verTodosTelefonos() {
        Map<Integer, Telefono> direcciones;
        direcciones = telefonoDAO.findAll();
        vista.verTelefonos(direcciones);
    }

}
