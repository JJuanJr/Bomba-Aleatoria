package codigo;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;

public class Panel_Elegir_Punt extends FondoPanel implements ActionListener {

    public Boton j1Facil, j1Medio, j1Dificil;
    public Boton j2Facil, j2Medio, j2Dificil;
    public Boton volver;
    public JLabel labelJ1, labelJ2;
    private GridBagConstraints gbc = new GridBagConstraints();
    private Herramientas herramientas = new Herramientas();

    public Panel_Elegir_Punt() {
        super("fondo5.jpg");
        setLayout(new GridBagLayout());

        Componentes();
    }

    public final double gbcW[] = { 1.0, 1.0, 1.0 };
    public final double gbcH[] = { 1.0, 1.0, 1.0, 1.0, 1.0 };

    public void Componentes() {
        labelJ1 = herramientas.crearLabel("JUEGO 1", 60);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.gridheight = 1;
        gbc.weightx = gbcW[gbc.gridx];
        gbc.weighty = gbcH[gbc.gridy];
        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.fill = GridBagConstraints.NONE;
        add(labelJ1, gbc);

        j1Facil = herramientas.crearBoton("vacio.png");
        j1Facil.addActionListener(this);
        j1Facil.setText("FACIL");
        j1Facil.setFont(new Font("Berlin Sans FB", Font.BOLD, 20));
        j1Facil.setForeground(new Color(25, 27, 104));
        j1Facil.setPreferredSize(new Dimension(210, 70));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = gbcW[gbc.gridx];
        gbc.weighty = gbcH[gbc.gridy];
        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.fill = GridBagConstraints.NONE;
        add(j1Facil, gbc);

        j1Medio = herramientas.crearBoton("vacio.png");
        j1Medio.addActionListener(this);
        j1Medio.setText("MEDIO");
        j1Medio.setFont(new Font("Berlin Sans FB", Font.BOLD, 20));
        j1Medio.setForeground(new Color(25, 27, 104));
        j1Medio.setPreferredSize(new Dimension(210, 70));
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = gbcW[gbc.gridx];
        gbc.weighty = gbcH[gbc.gridy];
        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.fill = GridBagConstraints.NONE;
        add(j1Medio, gbc);

        j1Dificil = herramientas.crearBoton("vacio.png");
        j1Dificil.addActionListener(this);
        j1Dificil.setText("DIFICIL");
        j1Dificil.setFont(new Font("Berlin Sans FB", Font.BOLD, 20));
        j1Dificil.setForeground(new Color(25, 27, 104));
        j1Dificil.setPreferredSize(new Dimension(210, 70));
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = gbcW[gbc.gridx];
        gbc.weighty = gbcH[gbc.gridy];
        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.fill = GridBagConstraints.NONE;
        add(j1Dificil, gbc);

        labelJ2 = herramientas.crearLabel("JUEGO 2", 60);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 3;
        gbc.gridheight = 1;
        gbc.weightx = gbcW[gbc.gridx];
        gbc.weighty = gbcH[gbc.gridy];
        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.fill = GridBagConstraints.NONE;
        add(labelJ2, gbc);

        j2Facil = herramientas.crearBoton("vacio.png");
        j2Facil.addActionListener(this);
        j2Facil.setText("FACIL");
        j2Facil.setFont(new Font("Berlin Sans FB", Font.BOLD, 20));
        j2Facil.setForeground(new Color(25, 27, 104));
        j2Facil.setPreferredSize(new Dimension(210, 70));
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = gbcW[gbc.gridx];
        gbc.weighty = gbcH[gbc.gridy];
        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.fill = GridBagConstraints.NONE;
        add(j2Facil, gbc);

        j2Medio = herramientas.crearBoton("vacio.png");
        j2Medio.addActionListener(this);
        j2Medio.setText("MEDIO");
        j2Medio.setFont(new Font("Berlin Sans FB", Font.BOLD, 20));
        j2Medio.setForeground(new Color(25, 27, 104));
        j2Medio.setPreferredSize(new Dimension(210, 70));
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = gbcW[gbc.gridx];
        gbc.weighty = gbcH[gbc.gridy];
        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.fill = GridBagConstraints.NONE;
        add(j2Medio, gbc);

        j2Dificil = herramientas.crearBoton("vacio.png");
        j2Dificil.addActionListener(this);
        j2Dificil.setText("DIFICIL");
        j2Dificil.setFont(new Font("Berlin Sans FB", Font.BOLD, 20));
        j2Dificil.setForeground(new Color(25, 27, 104));
        j2Dificil.setPreferredSize(new Dimension(210, 70));
        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = gbcW[gbc.gridx];
        gbc.weighty = gbcH[gbc.gridy];
        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.fill = GridBagConstraints.NONE;
        add(j2Dificil, gbc);

        volver = herramientas.crearBoton("volver.png");
        volver.addActionListener(this);
        volver.setPreferredSize(new Dimension(115, 110));
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = gbcW[gbc.gridx];
        gbc.weighty = gbcH[gbc.gridy];
        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.fill = GridBagConstraints.NONE;
        add(volver, gbc);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        CardLayout c1 = (CardLayout) (Ventana.pEnlace.getLayout());
        if (e.getSource() == volver) {
            c1.show(Ventana.pEnlace, "MENU");
        } else if (e.getSource() == j1Facil) {
            Ventana.pPuntuaciones[0][0].actualizarTabla(0, 0);
            c1.show(Ventana.pEnlace, "J1D1");
        } else if (e.getSource() == j1Medio) {
            Ventana.pPuntuaciones[0][1].actualizarTabla(0, 1);
            c1.show(Ventana.pEnlace, "J1D2");
        } else if (e.getSource() == j1Dificil) {
            Ventana.pPuntuaciones[0][2].actualizarTabla(0, 2);
            c1.show(Ventana.pEnlace, "J1D3");
        } else if (e.getSource() == j2Facil) {
            Ventana.pPuntuaciones[1][0].actualizarTabla(1, 0);
            c1.show(Ventana.pEnlace, "J2D1");
        } else if (e.getSource() == j2Medio) {
            Ventana.pPuntuaciones[1][1].actualizarTabla(1, 1);
            c1.show(Ventana.pEnlace, "J2D2");
        } else if (e.getSource() == j2Dificil) {
            Ventana.pPuntuaciones[1][2].actualizarTabla(1, 2);
            c1.show(Ventana.pEnlace, "J2D3");
        }
    }

}
