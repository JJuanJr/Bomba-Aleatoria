package codigo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class Herramientas {

    public Image leerImagen(String nombre) {
        ImageIcon imagen = new ImageIcon(getClass().getResource("/imagenes/" + nombre));
        return imagen.getImage();
    }
    
    public JLabel crearLabel(String contenido) {
        JLabel x = new JLabel(contenido, SwingConstants.CENTER);
        x.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
        x.setForeground(Color.WHITE);
        return x;
    }
    
    public JLabel crearLabel(String contenido, int tam) {
        JLabel x = new JLabel(contenido, SwingConstants.CENTER);
        x.setFont(new Font("Berlin Sans FB", Font.BOLD, tam));
        x.setForeground(Color.YELLOW);
        return x;
    }
    
    public JRadioButton crearRadioButton(String contenido, int tam) {
        JRadioButton x = new JRadioButton(contenido);
        x.setFont(new Font("Berlin Sans FB", Font.PLAIN, tam));
        x.setForeground(Color.WHITE);
        return x;
    }
    
    public JTextPane crearTextPane(String contenido, int tamFont) {
        JTextPane x = new JTextPane();
        StyledDocument doc = x.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), center, false);
        x.setText(contenido);
        x.setFont(new Font("Berlin Sans FB", Font.PLAIN, tamFont));
        x.setForeground(Color.WHITE);
        x.setOpaque(false);
        x.setEditable(false);
        return x;
    }
    
    public Boton crearBoton(String ruta) {
        Boton x = new Boton(ruta);
        x.setContentAreaFilled(false);
        x.setBorderPainted(false);
        return x;
    }
    
    public JTextField crearTextField(String titulo) {
        JTextField x = new JTextField();
        x.setOpaque(false);
        x.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
        x.setForeground(Color.WHITE);
        x.setHorizontalAlignment(JTextField.CENTER);
        x.setBorder(crearTitulo(titulo));
        return x;
    }
    
    public TitledBorder crearTitulo(String titulo) {
        Border b = BorderFactory.createLineBorder(Color.WHITE, TitledBorder.ABOVE_TOP); //Poner color al borde.
        TitledBorder tb = BorderFactory.createTitledBorder(b, titulo);
        tb.setTitleFont(new Font("TBerlin Sans FB", Font.BOLD, 17));
        tb.setTitleJustification(TitledBorder.CENTER);
        tb.setTitleColor(Color.WHITE);
        return tb;
    }
    
    public JButton crearBotones(String nombre, int dimX, int dimY, String direc) {
        JButton prueba = new JButton(nombre);
        ImageIcon img = new ImageIcon(getClass().getResource(direc));
        prueba.setPreferredSize(new Dimension(dimX, dimY));
        prueba.setIcon(new ImageIcon(img.getImage().getScaledInstance(dimX, dimY, Image.SCALE_SMOOTH)));
        //prueba.setOpaque(true);
        prueba.setContentAreaFilled(false);
        prueba.setBorderPainted(false);
        return prueba;
    }
    
    public int generarNumero(int l, int r) {
        int num = (int) ((Math.random()) * (r - l + 1) + l);
        return num;
    }
}
