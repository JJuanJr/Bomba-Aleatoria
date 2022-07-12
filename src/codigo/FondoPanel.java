package codigo;


import java.awt.Graphics;
import javax.swing.JPanel;

public class FondoPanel extends JPanel {
    
    private String direccion;
    private Herramientas herramientas = new Herramientas();

    public FondoPanel(String direccion) {
        this.direccion = direccion;
    }
    
    @Override
    public void paint(Graphics g) {
        g.drawImage(herramientas.leerImagen(direccion), 0, 0, getWidth(), getHeight(), this);
        setOpaque(false);
        super.paint(g);
    }
}
