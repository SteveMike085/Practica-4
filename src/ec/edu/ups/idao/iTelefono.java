package ec.edu.ups.idao;

import ec.edu.ups.modelo.Telefono;
import java.util.*;

/**
 *
 * @author SteveMike
 */

public interface iTelefono {
    
    public void create(Telefono telefono);

    public Telefono read(int id);

    public void update(Telefono telefono);

    public void delete(Telefono telefono);

    public Map<Integer, Telefono> findAll();
}
