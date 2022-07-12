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
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class VentanaJuego2 extends FondoPanel implements ActionListener, KeyListener, Runnable {

    public JPanel panelTablero;
    public FondoPanel panelImagenFor;
    public Boton botonesTablero[][];
    public JButton botonComenzar, botonVolver, botonValidar;
    public JTextField tfEntradaI, tfEntradaJ, tfEntradaN, tfEntradaM;
    public int tamTablero, posI, posJ, tamI, tamJ;
    public Cronometro tiempo;
    public JTextPane descripcion;
    public JLabel labelResultado;
    public Thread hilo;
    public int tiempoLimite;
    private GridBagConstraints gbc = new GridBagConstraints();
    private Herramientas herramientas = new Herramientas();

    final double gbcW[] = { 0.3, 1.0, 0.1, 0.1 };
    final double gbcH[] = { 0.1, 0.1, 0.1, 0.5, 0.2, 0.5, 0.5 };

    public VentanaJuego2() {
        super("fondo3.jpg");
        posI = -1;
        posJ = -1;
        tiempoLimite = 20;
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
        //descripcion.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3, true));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1; 
        gbc.weightx = gbcW[gbc.gridx];
        gbc.weighty = gbcH[gbc.gridy];
        gbc.insets = new Insets(10, 5, 5, 0);
        gbc.fill = GridBagConstraints.BOTH;
        add(descripcion, gbc);

        panelImagenFor = new FondoPanel("foraninado.png");
        panelImagenFor.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3, true));
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = gbcW[gbc.gridx];
        gbc.weighty = gbcH[gbc.gridy];
        gbc.insets = new Insets(5, 0, 5, 0);
        gbc.fill = GridBagConstraints.BOTH;
        add(panelImagenFor, gbc);

        tiempo = new Cronometro();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.weightx = gbcW[gbc.gridx];
        gbc.weighty = gbcH[gbc.gridy];
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(tiempo.labelVista, gbc);

        tfEntradaI = herramientas.crearTextField("(a)");
        tfEntradaI.addKeyListener(this);
        tfEntradaI.setColumns(3);
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = gbcW[gbc.gridx];
        gbc.weighty = gbcH[gbc.gridy];
        gbc.insets = new Insets(2, 0, 2, 0);
        gbc.fill = GridBagConstraints.BOTH;
        add(tfEntradaI, gbc);

        tfEntradaN = herramientas.crearTextField("(b)");
        tfEntradaN.addKeyListener(this);
        tfEntradaN.setColumns(3);
        gbc.gridx = 3;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = gbcW[gbc.gridx];
        gbc.weighty = gbcH[gbc.gridy];
        gbc.insets = new Insets(2, 0, 2, 0);
        gbc.fill = GridBagConstraints.BOTH;
        add(tfEntradaN, gbc);

        tfEntradaJ = herramientas.crearTextField("(c)");
        tfEntradaJ.addKeyListener(this);
        tfEntradaJ.setColumns(3);
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = gbcW[gbc.gridx];
        gbc.weighty = gbcH[gbc.gridy];
        gbc.insets = new Insets(2, 0, 2, 0);
        gbc.fill = GridBagConstraints.BOTH;
        add(tfEntradaJ, gbc);

        tfEntradaM = herramientas.crearTextField("(d)");
        tfEntradaM.addKeyListener(this);
        tfEntradaM.setColumns(3);
        gbc.gridx = 3;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = gbcW[gbc.gridx];
        gbc.weighty = gbcH[gbc.gridy];
        gbc.insets = new Insets(2, 0, 2, 0);
        gbc.fill = GridBagConstraints.BOTH;
        add(tfEntradaM, gbc);

        botonValidar = herramientas.crearBoton("validar.png");
        botonValidar.addActionListener(this);
        botonValidar.setPreferredSize(new Dimension(40, 50));
        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.weightx = gbcW[gbc.gridx];
        gbc.weighty = gbcH[gbc.gridy];
        gbc.insets = new Insets(10, 50, 10, 50);
        gbc.fill = GridBagConstraints.BOTH;
        add(botonValidar, gbc);

        labelResultado = herramientas.crearLabel("");
        labelResultado.setBorder(herramientas.crearTitulo("Resultado"));
        labelResultado.setPreferredSize(new Dimension(50, 40));
        gbc.gridx = 2;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.weightx = gbcW[gbc.gridx];
        gbc.weighty = gbcH[gbc.gridy];
        gbc.insets = new Insets(0, 10, 10, 10);
        gbc.fill = GridBagConstraints.BOTH;
        add(labelResultado, gbc);

        botonComenzar = herramientas.crearBoton("jugar.png");
        botonComenzar.addActionListener(this);
        botonComenzar.setPreferredSize(new Dimension(40, 50));
        gbc.gridx = 2;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.weightx = gbcW[gbc.gridx];
        gbc.weighty = gbcH[gbc.gridy];
        gbc.insets = new Insets(10, 50, 10, 50);
        gbc.fill = GridBagConstraints.BOTH;
        add(botonComenzar, gbc);

        botonVolver = herramientas.crearBoton("volver.png");
        botonVolver.addActionListener(this);
        botonVolver.setPreferredSize(new Dimension(40, 50));
        gbc.gridx = 2;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.weightx = gbcW[gbc.gridx];
        gbc.weighty = gbcH[gbc.gridy];
        gbc.insets = new Insets(10, 50, 10, 50);
        gbc.fill = GridBagConstraints.BOTH;
        add(botonVolver, gbc);
    }

    public void construirTablero(int tamTablero, int dif) {
        String tempMesanje = """
                El tamaño del tablero es de %dx%d.
                Las filas y columnas estan indexadas desde 0.
                La dificultad es %s.
                ¿Teniendo en cuenta la imagen al lado, que valores
                se deben asignar a las variables 'a, b, c y d'
                para recorrer y seleccionar las bombas activas?""".formatted(tamTablero, tamTablero, dif == 0 ? "FACIL" : dif == 1 ? "MEDIO" : "DIFICIL");
        descripcion.setText(tempMesanje);
        this.tamTablero = tamTablero;
        botonesTablero = new Boton[tamTablero][tamTablero];
        panelTablero.setLayout(new GridLayout(tamTablero, tamTablero));
        panelTablero.removeAll();
        for (int i = 0; i < tamTablero; i++) {
            for (int j = 0; j < tamTablero; j++) {
                botonesTablero[i][j] = herramientas.crearBoton("bombaApagada.png");
                panelTablero.add(botonesTablero[i][j]);
            }
        }

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.gridheight = 6;
        gbc.weightx = gbcW[gbc.gridx];
        gbc.weighty = gbcH[gbc.gridy];
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.BOTH;
        add(panelTablero, gbc);
    }

    public void ubicarBombaActiva() {
        if (posI != -1 && posJ != -1) {
            for (int i = posI; i < posI + tamJ; ++i) {
                for (int j = posJ; j < posJ + tamI; ++j) {
                    botonesTablero[i][j].ruta = "bombaApagada.png";
                    botonesTablero[i][j].repaint();
                }
            }
        }
        posI = herramientas.generarNumero(0, tamTablero - 1);
        posJ = herramientas.generarNumero(0, tamTablero - 1);
        tamI = herramientas.generarNumero(1, tamTablero - posJ);
        tamJ = herramientas.generarNumero(1, tamTablero - posI);
        for (int i = posI; i < posI + tamJ; ++i) {
            for (int j = posJ; j < posJ + tamI; ++j) {
                botonesTablero[i][j].ruta = "bombaEncendida.png";
                botonesTablero[i][j].repaint();
            }
        }
        // panelTablero.repaint();
    }

    public void actualizarPuntaje() {
        PersonaPuntaje x = Ventana.tmPunt.get(Panel_Inicio.nombre.getText());
        int val = x.punt[1][Panel_Juegos.dificultad];
        if (val == -1 || tiempo.segundos < val) {
            x.punt[1][Panel_Juegos.dificultad] = tiempo.segundos;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Boton temp = (Boton) e.getSource();
        if (temp == botonComenzar) {
            tfEntradaI.setText("");
            tfEntradaJ.setText("");
            tfEntradaN.setText("");
            tfEntradaM.setText("");
            labelResultado.setText("");
            tfEntradaI.setEnabled(true);
            tfEntradaJ.setEnabled(true);
            tfEntradaN.setEnabled(true);
            tfEntradaM.setEnabled(true);
            botonComenzar.setEnabled(false);
            botonValidar.setEnabled(true);
            tiempo.iniciar();
            enPausa = false;
            ubicarBombaActiva();
        } else if (temp == botonValidar) {
            String a = tfEntradaI.getText();
            String b = tfEntradaN.getText();
            String c = tfEntradaJ.getText();
            String d = tfEntradaM.getText();
            if (a.isEmpty() || b.isEmpty() || c.isEmpty() || d.isEmpty()) {
                labelResultado.setText("Incorrecto");
                return;
            }
            int numA = Integer.parseInt(a);
            int numB = Integer.parseInt(b);
            int numC = Integer.parseInt(c);
            int numD = Integer.parseInt(d);
            boolean flag = true;
            flag &= numA >= 0 && numA < tamTablero;
            flag &= numB >= 0 && numB <= tamTablero;
            flag &= numC >= 0 && numC < tamTablero;
            flag &= numD >= 0 && numD <= tamTablero;
            if (!flag) {
                labelResultado.setText("Incorrecto");
                return;
            }

            flag &= numA == posI;
            flag &= numB == posI + tamJ;
            flag &= numC == posJ;
            flag &= numD == posJ + tamI;

            if (flag) {
                labelResultado.setText("Correcto");
                tiempo.detener();
                botonValidar.setEnabled(false);
                botonComenzar.setEnabled(true);
                tfEntradaI.setEnabled(false);
                tfEntradaJ.setEnabled(false);
                tfEntradaN.setEnabled(false);
                tfEntradaM.setEnabled(false);
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
