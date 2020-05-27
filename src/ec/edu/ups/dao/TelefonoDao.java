package ec.edu.ups.dao;
import ec.edu.ups.idao.iTelefono;
import ec.edu.ups.modelo.Telefono;
import java.util.*;

/**
 *
 * @author SteveMike
 */

public class TelefonoDao implements iTelefono{
    private Map<Integer, Telefono> listaTelefonos;

    public TelefonoDao() {
        listaTelefonos = new HashMap<>();
    }

    public void create(Telefono telefono) {
        listaTelefonos.put(telefono.getCodigo(), telefono);
    }

    public Telefono read(int id) {
        for (Map.Entry<Integer, Telefono> telefono : listaTelefonos.entrySet()) {
            int cod = telefono.getKey();
            if (cod == id) {
                Telefono tele = listaTelefonos.get(cod);
                return tele;
            }
        }
        return null;
    }

    public void update(Telefono telefono) {
        for (Map.Entry<Integer, Telefono> telefono2 : listaTelefonos.entrySet()) {
            int cod = telefono2.getKey();
            if (cod == telefono.getCodigo()) {
                listaTelefonos.replace(cod, telefono);
                break;
            }
        }
    }

    public void delete(Telefono telefono) {
        for (Map.Entry<Integer, Telefono> telefono2 : listaTelefonos.entrySet()) {
            int cod = telefono2.getKey();
            if (cod == telefono.getCodigo()) {
                listaTelefonos.remove(telefono.getCodigo());
                break;
            }
        }
    }

    public Map<Integer, Telefono> findAll() {
        return listaTelefonos;
    }
}
