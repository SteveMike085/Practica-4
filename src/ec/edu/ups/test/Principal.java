package ec.edu.ups.test;

import ec.edu.ups.controlador.ControladorTelefono;
import ec.edu.ups.controlador.ControladorUsuario;
import ec.edu.ups.modelo.Usuario;
import ec.edu.ups.vista.VistaTelefono;
import ec.edu.ups.vista.VistaUsuario;
import ec.edu.ups.dao.TelefonoDao;
import ec.edu.ups.dao.UsuarioDao;

/**
 *
 * @author SteveMike
 */

public class Principal {

    
    
    public static void main(String[] args) {

        VistaUsuario vistaU = new VistaUsuario();
        VistaTelefono vistaT = new VistaTelefono();

        UsuarioDao clienteDAO = new UsuarioDao();
        TelefonoDao telefonoDAO = new TelefonoDao();
        
        ControladorUsuario controladorUsuario = new ControladorUsuario(vistaU, vistaT, clienteDAO, telefonoDAO);
        ControladorTelefono controladorTelefono = new ControladorTelefono(vistaT, telefonoDAO);
       
        int op = 0;
        do {
            op = vistaU.menu();
            switch (op) {
                case 1:       
                    controladorUsuario.registrar();
                    break;
                case 2:
                    Usuario usuario = controladorUsuario.iniciarSesion();
                    if (usuario != null) {
                        int opcion = 0;
                        do {
                            opcion = vistaT.menuEditarTelefonoUsuario();
                            switch (opcion) {
                                case 1:
                                    controladorTelefono.registrar();
                                    boolean contiene = controladorUsuario.verCliente();
                                    if (contiene == true) {
                                        controladorUsuario.agregarTelefono();
                                    }
                                    break;
                                case 2:
                                    controladorTelefono.actualizar();
                                    boolean contiene2 = controladorUsuario.verCliente();
                                    if (contiene2 == true) {
                                        controladorUsuario.actualizarTelefono();
                                    }
                                    break;
                                case 3:
                                    controladorTelefono.eliminar();
                                    boolean contiene3 = controladorUsuario.verCliente();
                                    if (contiene3) {

                                        controladorUsuario.eliminarTelefono();
                                    }
                                    break;
                                case 4:
                                    controladorUsuario.cerrarSesion();
                                    break;

                                default:
                                    controladorUsuario.numeroErroneo();
                                    break;
                            }
                        } while (opcion != 4);
                    }
                    break;
                case 3:
                    controladorUsuario.buscarTelefonos();
                    break;
                case 4:
                    controladorUsuario.imprimirUsuario();
                    break;
                case 5:
                    controladorUsuario.verClientes();
                    break;
                case 6:
                    controladorTelefono.verTodosTelefonos();
                    break;
                case 7:
                    controladorUsuario.salir();
                    break;
                default:
                    controladorUsuario.numeroErroneo();
                    break;
            }
        } while (op != 7);
    }
}
