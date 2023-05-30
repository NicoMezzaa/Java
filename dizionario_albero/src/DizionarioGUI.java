/**
 * autore: Nicolò Mezzanzanica
 * data: 25/05/2023
 * oggetto: classe dizionario GUI
 */

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class DizionarioGUI {
    private Dizionario dizionario;
    private JFrame frame;
    private JPanel pnlBottoni;
    private JButton btnInserisci;
    private JButton btnCerca;
    private JButton btnMostra;
    private JButton btnSalva;
    private JButton btnCarica;
    private JTextArea textArea;
    private JScrollPane scrollPane;

    public DizionarioGUI() {
        
        frame = new JFrame("Dizionario - (Nuovo)");
        frame.setIconImage(new ImageIcon("icon/dizionario-logo.png").getImage());
        frame.setSize(780, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        dizionario = new Dizionario();

        pnlBottoni = new JPanel();
        pnlBottoni.setLayout(new GridLayout(1, 5));
        pnlBottoni.setBorder(new EmptyBorder(50, 50, 20, 50));

        btnInserisci = new JButton("Nuova parola");
        btnCerca = new JButton("Cerca parola");
        btnMostra = new JButton("Mostra parole");
        btnSalva = new JButton("Salva dizionario");
        btnCarica = new JButton("Carica dizionario");

        DizionarioListener dizionarioListener = new DizionarioListener(this);
        btnInserisci.addActionListener(dizionarioListener);
        btnCerca.addActionListener(dizionarioListener);
        btnMostra.addActionListener(dizionarioListener);
        btnSalva.addActionListener(dizionarioListener);
        btnCarica.addActionListener(dizionarioListener);

        textArea = new JTextArea();
        textArea.setEditable(false);
        scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setBorder(new EmptyBorder(30, 90, 45, 90));

        pnlBottoni.add(btnInserisci);
        pnlBottoni.add(btnCerca);
        pnlBottoni.add(btnMostra);
        pnlBottoni.add(btnSalva);
        pnlBottoni.add(btnCarica);

        frame.add(pnlBottoni, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    public void mostraMessaggio(String messaggio) {
        textArea.setText(messaggio);
    }

    public void setDizionario(Dizionario dizionario) {
        this.dizionario = dizionario;
    }

    public Dizionario getDizionario() {
        return dizionario;
    }

    public JFrame getFrame() {
        return frame;
    }

    public JTextArea getTextArea() {
        return textArea;
    }
}