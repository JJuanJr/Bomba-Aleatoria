package codigo;

import java.awt.Dimension;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

public class Cronometro extends Thread {
    
    
    public int segundos;
    private boolean enEjecucion, enPausa;
    public JLabel labelVista;
    private Herramientas herramientas = new Herramientas();
    
    public Cronometro() {
        enEjecucion = true;
        enPausa = true;
        labelVista = herramientas.crearLabel("00:00");
        labelVista.setPreferredSize(new Dimension(50, 50));
        labelVista.setBorder(herramientas.crearTitulo("Tiempo"));
    }
    
    public void iniciar() {
        if (!this.isAlive()) {
            this.start();
        }
        labelVista.setText("00:00");
        segundos = 0;
        enPausa = false;
    }
    
    public void detener() {
        enPausa = true;
    }
    
    public void matar() {
        enEjecucion = false;
    }

    @Override
    public void run() {
        while (enEjecucion) {
            if (enPausa) {
                continue;
            }
            labelVista.setText(toString());
            try {
                Cronometro.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Cronometro.class.getName()).log(Level.SEVERE, null, ex);
            }
            segundos++;
        }
    }

    @Override
    public String toString() {
        String h = segundos / 60 + "";
        String m = segundos % 60 + "";
        while (h.length() < 2) h = "0" + h;
        while (m.length() < 2) m = "0" + m;
        return h + ":" + m;
    }
}
