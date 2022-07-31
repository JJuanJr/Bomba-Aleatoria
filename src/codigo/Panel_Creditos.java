package codigo;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Color;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

public class Panel_Creditos extends FondoPanel implements ActionListener {

    JLabel creditos;
    JButton volverMenu;
    JTextArea texto;
    private Herramientas herramientas = new Herramientas();
    public JTextPane descripcion, descripcion2, descripcion3,descripcion4;
    JPanel logos;
    GridBagConstraints c = new GridBagConstraints();

    public Panel_Creditos() {
        super("fondo2.jpg");
        setLayout(new FlowLayout(FlowLayout.CENTER, 500, 20));
        c.insets = new Insets(10, 10, 10, 10);
        // ----------------------------------------------------------------
        creditos = new JLabel("CRÉDITOS", SwingConstants.CENTER);
        creditos.setPreferredSize(new Dimension(350, 60));
        creditos.setFont(new Font("Berlin Sans FB", Font.BOLD, 70));
        creditos.setForeground(Color.YELLOW);
        creditos.setOpaque(false);
        add(creditos);
        // ----------------------------------------------------------------
        descripcion = herramientas.crearTextPane("", 25);
        String mensaje = """
                JUAN JOSE ORTIZ PLAZA
                ARLINSON ADRIAN ESCUDERO OSPINA
                Desarrolladores

                Ing. OSCAR FABIAN PATIÑO PERDOMO
                Coordinador""";
        descripcion.setText(mensaje);
        add(descripcion);
        // ----------------------------------------------------------------
        logos = new JPanel(new GridBagLayout());
        logos.setOpaque(false);
        add(logos);
        // ----------------------------------------------------------------
        JLabel logo = new JLabel();
        ImageIcon img = new ImageIcon(getClass().getResource("/imagenes/logoU.png"));
        logo.setPreferredSize(new Dimension(190, 160));
        logo.setIcon(new ImageIcon(img.getImage().getScaledInstance(190, 160, Image.SCALE_SMOOTH)));
        c.gridx = 0;
        c.gridy = 0;
        logos.add(logo, c);
        // ----------------------------------------------------------------
        JLabel logo2 = new JLabel();
        ImageIcon img2 = new ImageIcon(getClass().getResource("/imagenes/logoP.png"));
        logo2.setPreferredSize(new Dimension(120, 160));
        logo2.setIcon(new ImageIcon(img2.getImage().getScaledInstance(120, 160, Image.SCALE_SMOOTH)));
        c.gridx = 1;
        c.gridy = 0;
        logos.add(logo2, c);
        // ----------------------------------------------------------------
        descripcion2 = herramientas.crearTextPane("", 20);
        String mensaje2 = """
                UNIVERSIDAD DE LA
                AMAZONIA""";
        descripcion2.setText(mensaje2);
        c.gridx = 0;
        c.gridy = 1;
        logos.add(descripcion2, c);
        // ----------------------------------------------------------------
        descripcion3 = herramientas.crearTextPane("", 20);
        String mensaje3 = """
                PROGRAMA
                INGENIERÍA DE SISTEMAS""";
        descripcion3.setText(mensaje3);
        c.gridx = 1;
        c.gridy = 1;
        logos.add(descripcion3, c);
        // ----------------------------------------------------------------
        volverMenu = herramientas.crearBotones("", 115, 110, "/imagenes/volver.png");
        volverMenu.addActionListener(this);
        add(volverMenu);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        CardLayout c1 = (CardLayout) (Ventana.pEnlace.getLayout());
        c1.show(Ventana.pEnlace, "MENU");
    }

}