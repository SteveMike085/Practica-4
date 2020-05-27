package ec.edu.ups.vista;
import ec.edu.ups.modelo.Usuario;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author SteveMike
 */
public class VistaUsuario {

    private Scanner entrada;

    public VistaUsuario() {
        entrada = new Scanner(System.in);
    }

    public int menu() {
        entrada = new Scanner(System.in);
        System.out.println("\nDigite el numero de accion que desea " + "ejecutar:\n" + "1.-Crear un nuevo usuario" + "\n2.-Iniciar sesion" + "\n3.-Imprimir telefonos de un usuario " + "\n4.-Buscar un usuario" + "\n5.-Imprimir todos los usuarios" + "\n6.-Imprimir todos los telefonos registrados" + "\n7.-Salir");
        int opcionMenu = entrada.nextInt();
        return opcionMenu;
    }

    public Usuario ingresarCliente() {
        entrada = new Scanner(System.in);
        System.out.println("Ingresa los datos del cliente");
        System.out.println("Ingrese la cedula: ");
        String cedula = entrada.next();
        System.out.println("Ingrese el nombre: ");
        String nombre = entrada.next();
        System.out.println("Ingrese el apellido: ");
        String apellido = entrada.next();
        System.out.println("Ingrese el correo: ");
        String correo = entrada.next();
        System.out.println("Ingrese la contraseña: ");
        String contraseña = entrada.next();

        return new Usuario(cedula, nombre, apellido, correo, contraseña);
    }

    public String iniciarSesionCorreo() {
        entrada = new Scanner(System.in);
        System.out.println("Escriba su correo: ");
        String correo = entrada.next();
        return correo;
    }

    public String iniciarSesionContraseña() {
        entrada = new Scanner(System.in);
        System.out.println("Escriba su contraseÃ±a: ");
        String contraseña = entrada.next();
        return contraseña;
    }

    public Usuario actualizarCliente() {
        entrada = new Scanner(System.in);
        System.out.println("Ingresa el id del cliente a actualizar");
        String id = entrada.next();
        System.out.println("Ingrese los nuevos Datos (nombre, apellido)");
        String nombre = entrada.next();
        String apellido = entrada.next();
        String correo = entrada.next();
        String contraseña = entrada.next();
        return new Usuario(id, nombre, apellido, correo, contraseña);
    }

    public Usuario eliminarCliente() {
        entrada = new Scanner(System.in);
        System.out.println("Ingresa el id del cliente a eliminar");
        String id = entrada.next();
        return new Usuario(id, null, null, null, null);
    }

    public String confirmacionCedula() {
        entrada = new Scanner(System.in);
        System.out.println("\nEscriba su cedula para confirmar el cambio:");
        String cedula = entrada.next();
        return cedula;
    }

    public String buscarCliente() {
        entrada = new Scanner(System.in);
        System.out.println("Ingresa el correo o cedula del cliente: ");
        String id = entrada.next();
        return id;
    }

    public void verCliente(Usuario cliente) {
        System.out.println("Datos del Cliente: " + cliente);
    }

    public void verClientes(Map<String, Usuario> clientes) {
        for (Map.Entry<String, Usuario> usuario2 : clientes.entrySet()) {
            String key = usuario2.getKey();
            Usuario persona = usuario2.getValue();
            System.out.println("\nClave del usuario: " + key + "\n" + persona);
        }
    }

    public void frase(String frase) {
        System.out.println(frase);
    }

}
