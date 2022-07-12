package juegos;

import codigo.Boton;
import codigo.Cronometro;
import codigo.FondoPanel;
import codigo.Herramientas;
import codigo.Panel_Inicio;
import codigo.Panel_Juegos;
import codigo.PersonaPuntaje;
import codigo.Ventana;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class VentanaJuego1 extends FondoPanel implements ActionListener, KeyListener, Runnable {

    public JPanel panelTablero;
    public Boton botonesTablero[][];
    public JButton botonComenzar, botonVolver, botonValidar;
    public JTextField tfEntradaI, tfEntradaJ;
    public int tamTablero, posI, posJ;
    public Cronometro tiempo;
    public JTextPane descripcion;
    public JLabel labelResultado;
    public Thread hilo;
    public int tiempoLimite;
    private GridBagConstraints gbc = new GridBagConstraints();
    private Herramientas herramientas = new Herramientas();
    
    final double gbcW[] = {0.1, 0.2};
    final double gbcH[] = {0.02, 0.0, 0.0, 0.05, 0.05, 0.05, 0.05};

    public VentanaJuego1() {
        super("fondo3.jpg");
        posI = -1;
        posJ = -1;
        tiempoLimite = 10;
        setLayout(new GridBagLayout());
        panelTablero = new JPanel();
        panelTablero.setOpaque(false);
        enPausa = true;
        hilo = new Thread(this);
        hilo.start();
        construirDatos();
    }
    
    public void construirDatos() {
        descripcion = herramientas.crearTextPane("", 20);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = gbcW[gbc.gridx];
        gbc.weighty = gbcH[gbc.gridy];
        gbc.insets = new Insets(20, 0, 0, 0);
        gbc.fill = GridBagConstraints.BOTH;
        add(descripcion, gbc);
        
        botonComenzar = herramientas.crearBoton("jugar.png");
        botonComenzar.addActionListener(this);
        botonComenzar.setPreferredSize(new Dimension(40, 55));
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = gbcW[gbc.gridx];
        gbc.weighty = gbcH[gbc.gridy];
        gbc.insets = new Insets(10, 50, 10, 55);
        gbc.fill = GridBagConstraints.BOTH;
        add(botonComenzar, gbc);
        
        botonValidar = herramientas.crearBoton("validar.png");
        botonValidar.addActionListener(this);
        botonValidar.setPreferredSize(new Dimension(40, 55));
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = gbcW[gbc.gridx];
        gbc.weighty = gbcH[gbc.gridy];
        gbc.insets = new Insets(10, 50, 10, 50); //alto - ancho - espacio Abajo - esp Arriba
        gbc.fill = GridBagConstraints.BOTH;
        add(botonValidar, gbc);
        
        labelResultado = herramientas.crearLabel("");
        labelResultado.setBorder(herramientas.crearTitulo("Resultado"));
        labelResultado.setPreferredSize(new Dimension(50, 10));
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = gbcW[gbc.gridx];
        gbc.weighty = gbcH[gbc.gridy];
        gbc.insets = new Insets(0, 10, 10, 10);
        gbc.fill = GridBagConstraints.BOTH;
        add(labelResultado, gbc);
        
        botonVolver = herramientas.crearBoton("volver.png");
        botonVolver.addActionListener(this);
        botonVolver.setPreferredSize(new Dimension(40, 55));
        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = gbcW[gbc.gridx];
        gbc.weighty = gbcH[gbc.gridy];
        gbc.insets = new Insets(10, 50, 10, 50);
        gbc.fill = GridBagConstraints.BOTH;
        add(botonVolver, gbc);
        
        tfEntradaI = herramientas.crearTextField("Posicion (i)");
        tfEntradaI.addKeyListener(this);
        tfEntradaI.setColumns(3);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = gbcW[gbc.gridx];
        gbc.weighty = gbcH[gbc.gridy];
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.BOTH;
        add(tfEntradaI, gbc);
        
        tfEntradaJ = herramientas.crearTextField("Posicion (j)");
        tfEntradaJ.addKeyListener(this);
        tfEntradaJ.setColumns(3);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = gbcW[gbc.gridx];
        gbc.weighty = gbcH[gbc.gridy];
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.BOTH;
        add(tfEntradaJ, gbc);
        
        tiempo = new Cronometro();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = gbcW[gbc.gridx];
        gbc.weighty = gbcH[gbc.gridy];
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(tiempo.labelVista, gbc);
        
    }
    
    public void construirTablero(int tamTablero, int dif) {
        String tempMesanje ="""
                    El tamaño del tablero de %dx%d.
                    Las filas y columnas estan indexadas desde 0.
                    La dificultad es %s
                    ¿Cual es la posicion de la bomba que esta encendida?""".formatted(tamTablero, tamTablero, dif == 0 ? "FACIL" : dif == 1 ? "MEDIO" : "DIFICIL");
        descripcion.setText(tempMesanje);
        this.tamTablero = tamTablero;
        panelTablero.removeAll();
        botonesTablero = new Boton[tamTablero][tamTablero];
        panelTablero.setLayout(new GridLayout(tamTablero, tamTablero));
        for (int i = 0; i < tamTablero; i++) {
            for (int j = 0; j < tamTablero; j++) {
                botonesTablero[i][j] = herramientas.crearBoton("bombaApagada.png");
                panelTablero.add(botonesTablero[i][j]);
            }
        }
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 6;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.BOTH;
        add(panelTablero, gbc);
    }
    
    public void ubicarBombaActiva() {
        if (posI != -1 && posJ != -1) {
            botonesTablero[posI][posJ].ruta = "bombaApagada.png";
            botonesTablero[posI][posJ].repaint();
        }
        posI = herramientas.generarNumero(0, tamTablero - 1);
        posJ = herramientas.generarNumero(0, tamTablero - 1);
        botonesTablero[posI][posJ].ruta = "bombaEncendida.png";
        botonesTablero[posI][posJ].repaint();
    }
    
    public void actualizarPuntaje() {
        PersonaPuntaje x = Ventana.tmPunt.get(Panel_Inicio.nombre.getText());
        int val = x.punt[0][Panel_Juegos.dificultad];
        if (val == -1 || tiempo.segundos < val) {
            x.punt[0][Panel_Juegos.dificultad] = tiempo.segundos;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Boton temp = (Boton) e.getSource();
        if (temp == botonComenzar) {
            botonComenzar.setEnabled(false);
            tfEntradaI.setText("");
            tfEntradaJ.setText("");
            labelResultado.setText("");
            tfEntradaI.setEnabled(true);
            tfEntradaJ.setEnabled(true);
            botonValidar.setEnabled(true);
            tiempo.iniciar();
            enPausa = false;
            ubicarBombaActiva();
        } else if (temp == botonValidar) {
            String a = tfEntradaI.getText();
            String b = tfEntradaJ.getText();
            if (a.isEmpty() || b.isEmpty()) {
                labelResultado.setText("Incorrecto");
            } else if (a.equals(posI + "") && b.equals(posJ + "")) {
                labelResultado.setText("Correcto");
                tiempo.detener();
                botonValidar.setEnabled(false);
                botonComenzar.setEnabled(true);
                tfEntradaI.setEnabled(false);
                tfEntradaJ.setEnabled(false);
                enPausa = true;
                actualizarPuntaje();
            } else {
                labelResultado.setText("Incorrecto");
            }
        } else if (temp == botonVolver) {
            tiempo.detener();
            CardLayout c1 = (CardLayout) (Ventana.pEnlace.getLayout());
            c1.show(Ventana.pEnlace, "JUEGOS");
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getSource() == tfEntradaI || e.getSource() == tfEntradaJ) {
            char c = e.getKeyChar();
            if (!Character.isDigit(c)) {
                e.consume();
            } else {
                String temp = ((JTextField) e.getSource()).getText();
                if (temp.equals("0") || temp.length() >= 4) {
                    e.consume();
                }
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    private boolean enPausa;
    
    @Override
    public void run() {
        int ant = 0;
        while (true) {
            System.out.flush();
            if (enPausa) {
                continue;
            }
            int seg = tiempo.segundos;
            if (ant != seg && seg % tiempoLimite == 0) {
                ant = seg;
                ubicarBombaActiva();
            }
        }
    }
}
