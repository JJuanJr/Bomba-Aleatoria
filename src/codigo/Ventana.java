package codigo;

import java.awt.CardLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import juegos.VentanaJuego1;
import javax.swing.JFrame;
import javax.swing.JPanel;
import juegos.VentanaJuego2;

public class Ventana extends JFrame implements WindowListener {

    public static JPanel pEnlace;
    public static Panel_Inicio pInicio;
    public static Panel_Puntuaciones[][] pPuntuaciones;
    Panel_Menu pMenu;
    Panel_Informacion pInf;
    Panel_Elegir_Punt pScore;
    Panel_Juegos pJuegos;
    public static TreeMap<String, PersonaPuntaje> tmPunt;
    public static VentanaJuego1 juego1;
    public static VentanaJuego2 juego2;

    public Ventana() {
        setTitle("[ BOMBA ALEATORIA ]");
        setSize(1000, 730);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        componentes();

        setVisible(true);
        addWindowListener(this);
    }

    public void panelEnlace() {
        pEnlace = new JPanel(new CardLayout());

        pPuntuaciones = new Panel_Puntuaciones[2][3];

        pInicio = new Panel_Inicio();

        pMenu = new Panel_Menu();

        pInf = new Panel_Informacion();

        pScore = new Panel_Elegir_Punt();

        pJuegos = new Panel_Juegos();

        juego1 = new VentanaJuego1();

        juego2 = new VentanaJuego2();
    }

    public void CargarDatos() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/datos/bd.txt"));
            while (br.ready()) {
                StringTokenizer st = new StringTokenizer(br.readLine(), ";");
                PersonaPuntaje pp = new PersonaPuntaje(st.nextToken());
                for (int i = 0; i < 2; ++i) {
                    for (int j = 0; j < 3; ++j) {
                        pp.punt[i][j] = Integer.parseInt(st.nextToken());
                    }
                }
                tmPunt.put(pp.nombre, pp);
            }
            br.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {

        }
    }

    public void GuardarDatos() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("src/datos/bd.txt"));
            for (Map.Entry<String, PersonaPuntaje> entry : tmPunt.entrySet()) {
                String key = entry.getKey();
                PersonaPuntaje value = entry.getValue();
                bw.append(key);
                for (int i = 0; i < 2; ++i) {
                    for (int j = 0; j < 3; ++j) {
                        bw.append(";" + value.punt[i][j]);
                    }
                }
                bw.append('\n');
            }
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public String obtenerDificultad(int x) {
        return switch (x) {
            case 0 -> "FACIL";
            case 1 -> "MEDIO";
            default -> "DIFICIL";
        };
    }

    public void componentes() {
        panelEnlace();

        tmPunt = new TreeMap<>();
        CargarDatos();

        pEnlace.add(pInicio, "INICIO");
        pEnlace.add(pMenu, "MENU");
        pEnlace.add(pInf, "INFO");
        pEnlace.add(pScore, "SCORE");
        pEnlace.add(pJuegos, "JUEGOS");
        pEnlace.add(juego1, "JUEGO1");
        pEnlace.add(juego2, "JUEGO2");

        for (int i = 0; i < 2; ++i) {
            for (int j = 0; j < 3; ++j) {
                pPuntuaciones[i][j] = new Panel_Puntuaciones("JUEGO " + (i + 1) + " - " + obtenerDificultad(j));
                pEnlace.add(pPuntuaciones[i][j], "J" + (i + 1) + "D" + (j + 1));
            }
        }

        add(pEnlace);
    }

    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) {
        GuardarDatos();
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }

}
