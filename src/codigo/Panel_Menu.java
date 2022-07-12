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
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Panel_Menu extends FondoPanel implements ActionListener{
    
    GridBagConstraints c = new GridBagConstraints();
    JButton bInfo, bScore, bJuegos, bUser;
    private Herramientas herramientas = new Herramientas();

    public Panel_Menu() {
        super("fondo3.jpg");
        setLayout(new GridBagLayout());
        c.insets = new Insets(10, 10, 10, 10);
        
        JLabel menu = new JLabel("MENÚ", SwingConstants.CENTER);
        menu.setPreferredSize(new Dimension(210, 50));
        menu.setFont(new Font("Berlin Sans FB", Font.BOLD, 70));
        menu.setForeground(Color.YELLOW);
        menu.setOpaque(false);
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        add(menu, c);
        c.weighty = 0;
        c.gridwidth = -1;
        
        bInfo = herramientas.crearBotones("", 220, 200, "/imagenes/manual.png");
        bInfo.addActionListener(this);
        c.gridx = 0;
        c.gridy = 1;
        add(bInfo, c);
        
        JLabel info = new JLabel("MANUAL DE USUARIO", SwingConstants.CENTER);
        info.setPreferredSize(new Dimension(320, 40));
        info.setFont(new Font("Berlin Sans FB", Font.BOLD, 30));
        info.setForeground(Color.YELLOW);
        info.setOpaque(false);
        c.gridx = 0;
        c.gridy = 2;
        add(info, c);
        
        bJuegos = herramientas.crearBotones("", 220, 200, "/imagenes/juegos.png");
        bJuegos.addActionListener(this);
        c.gridx = 1;
        c.gridy = 1;
        add(bJuegos, c);
        
        JLabel juegos = new JLabel("JUEGOS", SwingConstants.CENTER);
        juegos.setPreferredSize(new Dimension(150, 40));
        juegos.setFont(new Font("Berlin Sans FB", Font.BOLD, 30));
        juegos.setForeground(Color.YELLOW);
        juegos.setOpaque(false);
        c.gridx = 1;
        c.gridy = 2;
        add(juegos, c);
        
        bScore = herramientas.crearBotones("", 220, 200, "/imagenes/score.png");
        bScore.addActionListener(this);
        c.gridx = 0;
        c.gridy = 3;
        add(bScore, c);
        
        JLabel score = new JLabel("PUNTUACIONES", SwingConstants.CENTER);
        score.setPreferredSize(new Dimension(250, 40));
        score.setFont(new Font("Berlin Sans FB", Font.BOLD, 30));
        score.setForeground(Color.YELLOW);
        score.setOpaque(false);
        c.gridx = 0;
        c.gridy = 4;
        add(score, c);
        
        bUser = herramientas.crearBotones("", 220, 200, "/imagenes/user.png");
        bUser.addActionListener(this);
        c.gridx = 1;
        c.gridy = 3;
        add(bUser, c);
        
        JLabel usuario = new JLabel("CAMBIAR DE USUARIO", SwingConstants.CENTER);
        usuario .setPreferredSize(new Dimension(350, 40));
        usuario .setFont(new Font("Berlin Sans FB", Font.BOLD, 30));
        usuario .setForeground(Color.YELLOW);
        usuario .setOpaque(false);
        c.gridx = 1;
        c.gridy = 4;
        add(usuario , c);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        CardLayout c1 = (CardLayout) (Ventana.pEnlace.getLayout());
        if (e.getSource() == bInfo) {
            c1.show(Ventana.pEnlace, "INFO");
        }
        if (e.getSource() == bUser) {
            Panel_Inicio.nombre.setText("");
            c1.show(Ventana.pEnlace, "INICIO");
        }
        if (e.getSource() == bScore) {
            c1.show(Ventana.pEnlace, "SCORE");
        }
        if (e.getSource() == bJuegos) {
            c1.show(Ventana.pEnlace, "JUEGOS");
        }
    }
    
}
