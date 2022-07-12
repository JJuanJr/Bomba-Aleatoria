package codigo;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class Panel_Puntuaciones extends FondoPanel implements ActionListener {

    JButton volverMenu1;
    DefaultTableModel modelo;
    JTable tabla;

    /**
     * @param texto
     */
    public Panel_Puntuaciones(String texto) {
        super("fondo3.jpg");
        setLayout(new BorderLayout());
        // ----------------------------------------------------------
        JLabel puntu = new JLabel(texto, SwingConstants.CENTER);
        puntu.setPreferredSize(new Dimension(500, 120));
        puntu.setFont(new Font("Berlin Sans FB", Font.BOLD, 60));
        puntu.setForeground(Color.YELLOW);
        puntu.setOpaque(false);
        add(puntu, BorderLayout.NORTH);
        // ----------------------------------------------------------
        modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tabla = new JTable(modelo);

        TableRowSorter<TableModel> trs = new TableRowSorter<>(modelo);
        tabla.setRowSorter(trs);

        
        tabla.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                    boolean hasFocus, int row, int column) {
                final Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row,
                        column);
                setHorizontalAlignment(SwingConstants.CENTER);
                c.setBackground(row % 2 == 0 ? new Color(123, 43, 236, 35) : new Color(203, 128, 250, 50));
                return c;
            }
        });

        ListSelectionModel lsm = tabla.getSelectionModel();
        lsm.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                resaltarJugadorActual();
            }
        });

        JScrollPane scrollpane = new JScrollPane(tabla);
        scrollpane.setOpaque(false);
        scrollpane.getViewport().setOpaque(false);
        scrollpane.setBorder(BorderFactory.createEmptyBorder());

        modelo.addColumn("POSICION");
        modelo.addColumn("NOMBRE");
        modelo.addColumn("TIEMPO");
        tabla.setGridColor(Color.WHITE);
        tabla.setOpaque(false);
        tabla.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tabla.setRowHeight(40);

        tabla.getTableHeader().setOpaque(false);
        tabla.getTableHeader().setReorderingAllowed(false);
        tabla.getTableHeader().setPreferredSize(new java.awt.Dimension(0, 40));
        tabla.getTableHeader().setFont(new Font("Berlin Sans FB", Font.BOLD, 20));
        tabla.getTableHeader().setForeground(Color.YELLOW);
        tabla.getTableHeader().setBackground(new Color(12, 26, 80));

        tabla.setSelectionForeground(Color.YELLOW);
        tabla.setForeground(Color.WHITE);
        tabla.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
        add(scrollpane, BorderLayout.CENTER);
        // ----------------------------------------------------------
        volverMenu1 = crearBotones("", "7", 115, 110, "/imagenes/volver.png");
        add(volverMenu1, BorderLayout.SOUTH);
    }

    public class Pair implements Comparable<Pair> {

        String nombre;
        int punt;

        public Pair(String nombre, int punt) {
            this.nombre = nombre;
            this.punt = punt;
        }

        @Override
        public int compareTo(Pair o) {
            if (punt == o.punt) {
                return nombre.compareTo(o.nombre);
            }
            return punt - o.punt;
        }

    }

    public void actualizarTabla(int juego, int dif) {
        int tam = modelo.getRowCount();
        for (int i = 0; i < tam; ++i) {
            modelo.removeRow(0);
        }
        int cont = 0;
        ArrayList<Pair> al = new ArrayList<>();
        for (Map.Entry<String, PersonaPuntaje> en : Ventana.tmPunt.entrySet()) {
            String key = en.getKey();
            PersonaPuntaje value = en.getValue();
            if (value.punt[juego][dif] != -1) {
                al.add(new Pair(key, value.punt[juego][dif]));
            }
        }
        Collections.sort(al);
        for (int i = 0; i < al.size(); ++i) {
            modelo.addRow(new Object[] { ++cont, al.get(i).nombre, al.get(i).punt });
        }
        resaltarJugadorActual();
        modelo.setRowCount(10);
    }

    public void resaltarJugadorActual() {
        for (int i = 0; i < tabla.getRowCount(); ++i) {
            Object s = tabla.getValueAt(i, 1);
            if (s == null) continue;
            if (s.equals(Panel_Inicio.nombre.getText())) {
                tabla.changeSelection(i, 1, false, false);
                break;
            }
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
        c1.show(Ventana.pEnlace, "SCORE");
    }

}
