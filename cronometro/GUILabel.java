/*
AUTORE: NICOLO' MEZZANZANICA
DATA: 24/03/2023
LUOGO: CASA
OGGETTO: CLASSE GUI LABEL
*/

import javax.swing.*;
import java.awt.*;

public class GUILabel {

    private JFrame frmPrincipale;
    private JPanel pnlBtn;
    private JLabel lblSecondiPassati;
    private JButton btnAvvioConteggio;
    private JButton btnTerminaConteggio;
    private boolean fineConteggio;
    private int secondi;

    public GUILabel(){
        frmPrincipale = new JFrame("Cronometro");
        Container c = frmPrincipale.getContentPane();
        c.setLayout(new BorderLayout());

        secondi = 0;
        fineConteggio = false;
        pnlBtn = new JPanel(new FlowLayout());
        lblSecondiPassati = new JLabel("Secondi passati: ");
        btnAvvioConteggio = new JButton("Avvio conteggio");
        btnTerminaConteggio = new JButton("Interrompi conteggio");
        btnAvvioConteggio.addActionListener(new ListenerBottoni(this));
        btnTerminaConteggio.addActionListener(new ListenerBottoni(this));

        pnlBtn.add(btnAvvioConteggio);
        pnlBtn.add(btnTerminaConteggio);

        c.add(pnlBtn, BorderLayout.SOUTH);
        c.add(lblSecondiPassati, BorderLayout.CENTER);

        frmPrincipale.setSize(new Dimension(400, 400));
        frmPrincipale.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmPrincipale.setVisible(true);
    }

    public void setSecondi(int secondi) {
        this.secondi = secondi;
    }

    public void setFineConteggio(boolean fineConteggio){
        this.fineConteggio = fineConteggio;
    }

    public int getSecondi() {
        return secondi;
    }

    public boolean isFineConteggio() {
        return fineConteggio;
    }

    public JLabel getLblSecondiPassati(){
        return lblSecondiPassati;
    }
}