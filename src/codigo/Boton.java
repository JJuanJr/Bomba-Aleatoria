package codigo;

import java.awt.Graphics;
import javax.swing.JButton;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class Boton extends JButton {

    public String ruta;
    private Herramientas herramientas = new Herramientas();

    public Boton(String ruta) {
        this.ruta = ruta;
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g.drawImage(herramientas.leerImagen(ruta), 0, 0, getWidth(), getHeight(), this);
        setOpaque(false);
        super.paint(g);
    }
    
}
