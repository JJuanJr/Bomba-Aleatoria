package codigo;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import org.icepdf.ri.common.ComponentKeyBinding;
import org.icepdf.ri.common.SwingController;
import org.icepdf.ri.common.SwingViewBuilder;

public class Panel_Informacion extends FondoPanel implements ActionListener{
    
    JPanel pVisor;
    JButton volverMenu;
    
    public Panel_Informacion(){
        super("fondo1.jpg");
        setLayout(new BorderLayout());
        //----------------------------------------------------------
        JPanel inf1 = new JPanel();
        inf1.setOpaque(false);
        add(inf1, BorderLayout.NORTH);
        //----------------------------------------------------------
        JLabel manual = new JLabel("MANUAL DE USUARIO", SwingConstants.CENTER);
        manual.setPreferredSize(new Dimension(700, 90));
        manual.setFont(new Font("Berlin Sans FB", Font.BOLD, 60));
        manual.setForeground(Color.YELLOW);
        manual.setOpaque(false);
        inf1.add(manual, BorderLayout.NORTH);
        //----------------------------------------------------------
        openpdf("src/libros/manual_usuario.pdf");
        
        //----------------------------------------------------------
        volverMenu = crearBotones("", "5", 115, 110, "/imagenes/volver.png");
        inf1.add(volverMenu, BorderLayout.SOUTH);
        //----------------------------------------------------------
    }
    
    public void openpdf(String file){
        try {
            SwingController control=new SwingController();
            SwingViewBuilder factry=new SwingViewBuilder(control);
            pVisor = factry.buildViewerPanel();
            ComponentKeyBinding.install(control, pVisor);
            control.getDocumentViewController().setAnnotationCallback(
            new org.icepdf.ri.common.MyAnnotationCallback(control.getDocumentViewController()));
            control.openDocument(file);;
            add(pVisor, BorderLayout.CENTER);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,"Cannot Load Pdf");
        }
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

    @Override
    public void actionPerformed(ActionEvent e) {
        CardLayout c1 = (CardLayout) (Ventana.pEnlace.getLayout());
        c1.show(Ventana.pEnlace, "MENU");
    }
    
}
