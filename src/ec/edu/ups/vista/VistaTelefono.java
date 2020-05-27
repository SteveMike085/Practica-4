package ec.edu.ups.vista;

import ec.edu.ups.modelo.Telefono;
import ec.edu.ups.modelo.Usuario;
import ec.edu.ups.ventana.Ventana;
import java.awt.*;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author SteveMike
 */

public class VistaTelefono {

    private Scanner entrada;

    public VistaTelefono() {
        entrada = new Scanner(System.in);
    }

    public int menuEditarTelefonoUsuario() {
        entrada = new Scanner(System.in);
        System.out.println("\nDigite la opcion que desea realizar:\n" + "1.-Ingresar un nuevo numero" + "\n2.-Editar un telefono" + "\n3.-Eliminar un telefono" + "\n4.-Cerrar sesion y volver al " + "menu");
        int opcionSesion = entrada.nextInt();
        return opcionSesion;
    }

    public Telefono ingresarTelefono() {
        Ventana v = new Ventana(1280,720);
        v.setLocation(new Point (320, 180));
        GridLayout l = new GridLayout(2, 2);
        Panel p = new Panel(l);
        TextField n = new TextField("numero de telefono", 10);
        TextField t = new TextField("tipo de telefono", 10);
        TextField o = new TextField("operadora", 10);
        TextField c = new TextField("codigo", 10);
        p.add(new Label("Ingrese Datos del telefono", Label.CENTER));
        p.add(n);
        p.add(t);
        p.add(o);
        p.add(c);
        v.add(p);
        v.setTitle("Ingreso de Telefono");
        v.setVisible(true);
        entrada = new Scanner(System.in);
        System.out.println("Ingresa los datos del Telefono:");
        System.out.println("Ingrese el numero: ");
        String numero = entrada.next();
        System.out.println("Ingrese el tipo de telefono: ");
        String tipo = entrada.next();
        System.out.println("Ingrese la operadora: ");
        String operadora = entrada.next();
        System.out.println("Ingrese el codigo: ");
        int codigo = entrada.nextInt();
        return new Telefono(codigo, numero, tipo, operadora);
    }

    public int confirmarCodigo() {
        entrada = new Scanner(System.in);
        System.out.println("\nConfirme el codigo del telefono: ");
        int codigo = entrada.nextInt();
        return codigo;
    }

    public int pedirCodigo() {
        entrada = new Scanner(System.in);
        System.out.println("Ingresa el codigo del telefono a actualizar");
        int id = entrada.nextInt();
        return id;
    }

    public Telefono actualizarTelefono() {
        Ventana v = new Ventana(1280,720);
        v.setLocation(new Point (320, 180));
        GridLayout l = new GridLayout(2, 2);
        Panel p = new Panel(l);
        TextField n = new TextField("el mismo codigo", 10);
        TextField t = new TextField("nuevo numero", 10);
        TextField o = new TextField("Tipo", 10);
        TextField c = new TextField("operadora", 10);
        p.add(new Label("Ingrese Nuevos datos del Telefono", Label.CENTER));
        p.add(n);
        p.add(t);
        p.add(o);
        p.add(c);
        v.add(p);
        v.setTitle("Actualizar Telefono");
        v.setVisible(true);
        entrada = new Scanner(System.in);
        System.out.println("\nIngrese los nuevos datos: ");
        System.out.println("\nIngresa el mismo codigo: ");
        int id = entrada.nextInt();
        System.out.println("Ingrese el numero: ");
        String numero = entrada.next();
        System.out.println("Ingrese el tipo: ");
        String tipo = entrada.next();
        System.out.println("Ingrese la operadora: ");
        String operadora = entrada.next();
        return new Telefono(id, numero, tipo, operadora);
    }

    public int eliminarTelefono() {
        Ventana v = new Ventana(1280,720);
        v.setLocation(new Point (320, 180));
        GridLayout l = new GridLayout(2, 2);
        Panel p = new Panel(l);
        TextField c = new TextField("codigo", 10);
        p.add(new Label("Ingrese Codigo del telefono", Label.CENTER));
        p.add(c);
        v.add(p);
        v.setTitle("Eliminar Telefono");
        v.setVisible(true);
        entrada = new Scanner(System.in);
        System.out.println("Ingresa el codigo del telefono a eliminar");
        int id = entrada.nextInt();
        return id;
    }

    public int buscarTelefono() {
        entrada = new Scanner(System.in);
        System.out.println("Ingresa el id del telefono a buscar");
        int id = entrada.nextInt();
        return id;
    }

    public void imprimirTelefonosUsuario(Usuario usuario) {
        Ventana v = new Ventana(1280,720);
        v.setLocation(new Point (320, 180));
        GridLayout l = new GridLayout(2, 2);
        Panel p = new Panel(l);
        p.add(new Label("Telefonos", Label.LEFT));
        v.add(p);
        v.setTitle("Lista de Telefonos");
        v.setVisible(true);
        if (usuario.getListaTelefonos().isEmpty()) {
            System.out.println("El usuario no tiene telefonos agregados");
        } else {
            for (Telefono telefono : usuario.getListaTelefonos()) {
                System.out.println(telefono.toString());
            }
        }
    }

    public void verDireccion(Telefono telefono) {
        System.out.println("Datos del Telefono: " + telefono);
    }

    public void verTelefonos(Map<Integer, Telefono> telefonos) {
        for (Map.Entry<Integer, Telefono> telefono2 : telefonos.entrySet()) {
            int cod = telefono2.getKey();
            Telefono tele = telefono2.getValue();
            System.out.println("Clave telefono: " + cod + "\nInformación del " + "telefono: " + tele.toString());
        }
    }
}
