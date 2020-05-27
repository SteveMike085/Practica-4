package ec.edu.ups.ventana;
import java.awt.Frame;
/**
 *
 * @author Usuario
 */
public class Ventana extends Frame {
    
    public Ventana(String titulo){
        this.setTitle(titulo);
        this.setVisible(true);
    }
    
    public Ventana(int a, int al){
        this.setSize(a, al);
    }
}
