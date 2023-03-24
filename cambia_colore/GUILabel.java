/*
ATUORE: NICOLO' MEZZANZANICA
DATA: 24/03/2023
LUOGO: CASA
OGGETTO: CLASSE GUI LABEL
*/

import javax.swing.*;
import java.awt.*;

public class GUILabel {

    private JFrame frmLabel;
    private static final int NUM_LBL_ROSSE_BLU = 5;
    private JPanel pnlLbl;
    private JPanel pnlBtn;
    private JLabel[] lblRosse;
    private JLabel[] lblBlu;
    private JButton btnLblRosse;
    private JButton btnLblBlu;
    private boolean terminaCambioColoreLlbRosse;
    private boolean terminaCambioColoreLlbBlu;

    public GUILabel(){

        frmLabel = new JFrame("Cambio colori");
        Container c = frmLabel.getContentPane();
        c.setLayout(new BorderLayout());

        pnlLbl = new JPanel(new GridLayout(2, NUM_LBL_ROSSE_BLU));
        pnlBtn = new JPanel(new GridLayout(1,2));

        terminaCambioColoreLlbRosse = false;
        terminaCambioColoreLlbBlu = false;

        lblRosse = new JLabel[NUM_LBL_ROSSE_BLU];
        lblBlu = new JLabel[NUM_LBL_ROSSE_BLU];
        for (int i = 0; i < NUM_LBL_ROSSE_BLU; i++) {
            lblRosse[i] = new JLabel("Label " + (i+1) + " rossa");
            lblBlu[i] = new JLabel("Label " + (i+1) + " blu");
            lblRosse[i].setOpaque(true);
            lblBlu[i].setOpaque(true);
            pnlLbl.add(lblRosse[i]);
            pnlLbl.add(lblBlu[i]);
        }
        btnLblRosse = new JButton("Bottone label rosse");
        btnLblRosse.addActionListener(new ListenerBottoni(this));
        btnLblBlu = new JButton("Bottone label blu");
        btnLblBlu.addActionListener(new ListenerBottoni(this));
        pnlBtn.add(btnLblRosse);
        pnlBtn.add(btnLblBlu);

        c.add(pnlLbl, BorderLayout.CENTER);
        c.add(pnlBtn, BorderLayout.SOUTH);

        frmLabel.setSize(new Dimension(600,400));
        frmLabel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmLabel.setVisible(true);
    }

    public static int getNumLblRosseBlu() {
        return NUM_LBL_ROSSE_BLU;
    }

    public JLabel[] getLblBlu() {
        return lblBlu;
    }

    public JLabel[] getLblRosse() {
        return lblRosse;
    }

    public void setTerminaCambioColoreLlbBlu(boolean terminaCambioColoreLlbBlu) {
        this.terminaCambioColoreLlbBlu = terminaCambioColoreLlbBlu;
    }

    public void setTerminaCambioColoreLlbRosse(boolean terminaCambioColoreLlbRosse) {
        this.terminaCambioColoreLlbRosse = terminaCambioColoreLlbRosse;
    }

    public boolean isTerminaCambioColoreLlbBlu() {
        return terminaCambioColoreLlbBlu;
    }

    public boolean isTerminaCambioColoreLlbRosse() {
        return terminaCambioColoreLlbRosse;
    }
}