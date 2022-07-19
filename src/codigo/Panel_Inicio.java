package codigo;


import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public final class Panel_Inicio extends FondoPanel implements ActionListener, KeyListener{
    
    JLabel titulo;
    public static JTextField nombre;
    JButton iniciar;
    
    
    Panel_Inicio(){
        super("fondo1.jpg");
        setLayout(new FlowLayout(FlowLayout.CENTER, 500, 45));
        //----------------------------------------------------------------
        titulo = new JLabel();
        // titulo.setFont(new Font("Berlin Sans FB", Font.BOLD, 80));
        // String mensaje = "APRENDIZAJE\n           DE\n    MATRICES";
        //String mensaje = "\n¡BOOM!\n";
        // titulo.append(mensaje);
        // titulo.setForeground(Color.YELLOW);
        // titulo.setOpaque(false);
        // titulo.setEditable(false);
        ImageIcon img = new ImageIcon(getClass().getResource("/imagenes/titulo.png"));
        titulo.setPreferredSize(new Dimension(670, 280));
        titulo.setIcon(new ImageIcon(img.getImage().getScaledInstance(670, 280, Image.SCALE_SMOOTH)));
        add(titulo);
        //----------------------------------------------------------------
        nombre = new JTextField();
        nombre.addKeyListener(this);
        nombre.setOpaque(false);
        nombre.setPreferredSize(new Dimension(250, 80));
        nombre.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
        nombre.setForeground(Color.YELLOW);
        nombre.setHorizontalAlignment(JTextField.CENTER);
        nombre.setBorder(crearTitulo2("DIGITE SU NOMBRE", Color.YELLOW, 25));
        nombre.setText("");
        add(nombre);
        //----------------------------------------------------------------
        iniciar = crearBotones("", "0", 120, 120, "/imagenes/comenzar.png");
        add(iniciar);
    }
    
    public JButton crearBotones(String nombre, String n, int dimX, int dimY, String direc) {
        JButton prueba = new JButton(nombre);
        ImageIcon img = new ImageIcon(getClass().getResource(direc));
        prueba.setPreferredSize(new Dimension(dimX, dimY));
        prueba.setName(n);
        prueba.setIcon(new ImageIcon(img.getImage().getScaledInstance(dimX, dimY, Image.SCALE_SMOOTH)));
        prueba.setOpaque(false);
        prueba.setContentAreaFilled(false);
        prueba.setBorderPainted(false);
        prueba.addActionListener(this);
        return prueba;
    }
    
       public TitledBorder crearTitulo2(String titulo, Color x, int letra) {
        Border algo = BorderFactory.createLineBorder(x, TitledBorder.ABOVE_TOP); //Poner color al borde.
        TitledBorder titulo2 = BorderFactory.createTitledBorder(algo, titulo);
        titulo2.setTitleFont(new Font("Berlin Sans FB", Font.BOLD, letra));
        titulo2.setTitleJustification(TitledBorder.CENTER);
        titulo2.setTitleColor(x);
        return titulo2;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!nombre.getText().isEmpty()) {
            if (!Ventana.tmPunt.containsKey(nombre.getText())) {
                Ventana.tmPunt.put(nombre.getText(), new PersonaPuntaje(nombre.getText()));
            }
            CardLayout c1 = (CardLayout) (Ventana.pEnlace.getLayout());
            c1.show(Ventana.pEnlace, "MENU");
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        char c = e.getKeyChar();
        if (Character.isAlphabetic(c) || Character.isDigit(c) || c == '_') {
            e.setKeyChar(Character.toUpperCase(c));        
        } else {
            e.consume();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            iniciar.doClick();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
