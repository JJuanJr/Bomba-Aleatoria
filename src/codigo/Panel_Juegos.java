package codigo;


import static codigo.Ventana.juego1;
import static codigo.Ventana.juego2;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class Panel_Juegos extends FondoPanel implements ActionListener{

    public Boton botonJuego1;
    public JButton botonJuego2, botonVolver;
    public GridBagConstraints gbc = new GridBagConstraints();
    public JRadioButton rbFacil, rbMedio, rbDifil;
    public ButtonGroup bg;
    public JLabel labelDificultad, labelJuego1, labelJuego2;
    public static int dificultad;
    ImageIcon no, validar, a, b;
    private Herramientas herramientas = new Herramientas();
    
    public Panel_Juegos() {
        super("fondo2.jpg");
        setLayout(new GridBagLayout());
        Componentes();
    }
    
    public final double gbcW[] = {0.2, 0.2, 0.2, 0.2};
    public final double gbcH[] = {0.5, 0.5, 0.5, 0.5};
    
    public void Componentes() {
        bg = new ButtonGroup();
        a = new ImageIcon(herramientas.leerImagen("no.png"));
        b = new ImageIcon(herramientas.leerImagen("validar2.png"));
        no = new ImageIcon(a.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH));
        validar = new ImageIcon(b.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH));
        
        
        labelDificultad = herramientas.crearLabel("SELECCIONE LA DIFICULTAD", 25);
        labelDificultad.setPreferredSize(new Dimension(210, 50));
        labelDificultad.setFont(new Font("Berlin Sans FB", Font.BOLD, 60));
        labelDificultad.setForeground(Color.YELLOW);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 4;
        gbc.gridheight = 1;
        gbc.weightx = gbcW[gbc.gridx];
        gbc.weighty = gbcH[gbc.gridy];
        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(labelDificultad, gbc);
        
        rbFacil = herramientas.crearRadioButton("FACIL", 40);
        rbFacil.setOpaque(false);
        rbFacil.setFont(new Font("Berlin Sans FB", Font.BOLD, 30));
        rbFacil.setForeground(Color.YELLOW);
        rbFacil.setIcon(validar);
        rbFacil.addActionListener(this);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = gbcW[gbc.gridx];
        gbc.weighty = gbcH[gbc.gridy];
        gbc.insets = new Insets(0, 100, 0, 0);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(rbFacil, gbc);
        bg.add(rbFacil);
        rbFacil.setSelected(true);
        
        rbMedio = herramientas.crearRadioButton("MEDIO", 20);
        rbMedio.setOpaque(false);
        rbMedio.setFont(new Font("Berlin Sans FB", Font.BOLD, 30));
        rbMedio.setForeground(Color.YELLOW);
        rbMedio.setIcon(no);
        rbMedio.addActionListener(this);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = gbcW[gbc.gridx];
        gbc.weighty = gbcH[gbc.gridy];
        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(rbMedio, gbc);
        bg.add(rbMedio);
        
        rbDifil = herramientas.crearRadioButton("DIFICIL", 20);
        rbDifil.setOpaque(false);
        rbDifil.setFont(new Font("Berlin Sans FB", Font.BOLD, 30));
        rbDifil.setForeground(Color.YELLOW);
        rbDifil.setIcon(no);
        rbDifil.addActionListener(this);
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = gbcW[gbc.gridx];
        gbc.weighty = gbcH[gbc.gridy];
        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(rbDifil, gbc);
        bg.add(rbDifil);
        
        botonVolver = herramientas.crearBotones("", 115, 110, "/imagenes/volver.png");
        botonVolver.addActionListener(this);
        gbc.gridx = 3;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = gbcW[gbc.gridx];
        gbc.weighty = gbcH[gbc.gridy];
        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.fill = GridBagConstraints.NONE;
        add(botonVolver, gbc);
        
        botonJuego1 = herramientas.crearBoton("juego1.png");
        botonJuego1.setPreferredSize(new Dimension(230, 200));
        botonJuego1.setText("1");
        botonJuego1.setFont(new Font("Berlin Sans FB", Font.BOLD, 100));
        botonJuego1.setForeground(Color.YELLOW);
        botonJuego1.addActionListener(this);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.weightx = gbcW[gbc.gridx];
        gbc.weighty = gbcH[gbc.gridy];
        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.fill = GridBagConstraints.NONE;
//        gbc.anchor = GridBagConstraints.CENTER;
        add(botonJuego1, gbc);
        
        
        botonJuego2 = herramientas.crearBoton("juego1.png");
        botonJuego2.setPreferredSize(new Dimension(230, 200));
        botonJuego2.setText("2");
        botonJuego2.setFont(new Font("Berlin Sans FB", Font.BOLD, 100));
        botonJuego2.setForeground(Color.YELLOW);
        botonJuego2.addActionListener(this);
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.weightx = gbcW[gbc.gridx];
        gbc.weighty = gbcH[gbc.gridy];
        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.fill = GridBagConstraints.NONE;
        //gbc.anchor = GridBagConstraints.SOUTH;
        add(botonJuego2, gbc);
        gbc.anchor = GridBagConstraints.CENTER;
        
        labelJuego1 = herramientas.crearLabel("JUEGO");
        labelJuego1.setPreferredSize(new Dimension(200, 25));
        labelJuego1.setFont(new Font("Berlin Sans FB", Font.BOLD, 30));
        labelJuego1.setForeground(Color.YELLOW);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.weightx = gbcW[gbc.gridx];
        gbc.weighty = gbcH[gbc.gridy];
        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.NORTH;
        add(labelJuego1, gbc);
        
        labelJuego2 = herramientas.crearLabel("JUEGO");
        labelJuego2.setPreferredSize(new Dimension(200, 25));
        labelJuego2.setFont(new Font("Berlin Sans FB", Font.BOLD, 30));
        labelJuego2.setForeground(Color.YELLOW);
        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.weightx = gbcW[gbc.gridx];
        gbc.weighty = gbcH[gbc.gridy];
        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.NORTH;
        add(labelJuego2, gbc);
    }
    

    
    public void configJuego1(int tam, int dif) {
        juego1.posI = -1;
        juego1.posJ = -1;
        juego1.tiempoLimite = 10 + 5 * (2 - dificultad);
        juego1.construirTablero(tam, dif);
        juego1.tiempo.labelVista.setText("00:00");
        juego1.labelResultado.setText("");
        juego1.botonComenzar.setEnabled(true);
        juego1.botonValidar.setEnabled(false);
        juego1.tfEntradaI.setEnabled(false);
        juego1.tfEntradaJ.setEnabled(false);
        juego1.tfEntradaI.setText("");
        juego1.tfEntradaJ.setText("");
    }
    
    public void configJuego2(int tam, int dif) {
        juego2.posI = -1;
        juego2.posJ = -1;
        juego2.tiempoLimite = 20 + 5 * (2 - dificultad);
        juego2.construirTablero(tam, dif);
        juego2.tiempo.labelVista.setText("00:00");
        juego2.labelResultado.setText("");
        juego2.botonComenzar.setEnabled(true);
        juego2.botonValidar.setEnabled(false);
        juego2.tfEntradaI.setEnabled(false);
        juego2.tfEntradaJ.setEnabled(false);
        juego2.tfEntradaN.setEnabled(false);
        juego2.tfEntradaM.setEnabled(false);
        juego2.tfEntradaI.setText("");
        juego2.tfEntradaJ.setText("");
        juego2.tfEntradaN.setText("");
        juego2.tfEntradaM.setText("");
    }

    public int obtenerDificultad() {
        if (rbFacil.isSelected()) {
            dificultad = 0;
            return herramientas.generarNumero(4, 5);
        } else if (rbMedio.isSelected()) {
            dificultad = 1;
            return herramientas.generarNumero(6, 7);
        } else {
            dificultad = 2;
            return herramientas.generarNumero(8, 10);
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        CardLayout c1 = (CardLayout) (Ventana.pEnlace.getLayout());
        if (e.getSource() == botonJuego1) {
            configJuego1(obtenerDificultad(), dificultad);
            c1.show(Ventana.pEnlace, "JUEGO1");
        } else if (e.getSource() == botonJuego2) {
            configJuego2(obtenerDificultad(), dificultad);
            c1.show(Ventana.pEnlace, "JUEGO2");
        } else if (e.getSource() == botonVolver) {
            c1.show(Ventana.pEnlace, "MENU");
            rbFacil.setIcon(validar);
            rbMedio.setIcon(no);
            rbDifil.setIcon(no);
        } else if (e.getSource() == rbFacil){
            rbFacil.setIcon(validar);
            rbMedio.setIcon(no);
            rbDifil.setIcon(no);
        } else if (e.getSource() == rbMedio){
            rbFacil.setIcon(no);
            rbMedio.setIcon(validar);
            rbDifil.setIcon(no);
        } else if (e.getSource() == rbDifil){
            rbFacil.setIcon(no);
            rbMedio.setIcon(no);
            rbDifil.setIcon(validar);
        }
    }
    
}
