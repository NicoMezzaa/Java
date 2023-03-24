/*
ATUORE: NICOLO' MEZZANZANICA
DATA: 24/03/2023
LUOGO: CASA
OGGETTO: CLASSE LISTENER BOTTONI
*/

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListenerBottoni implements ActionListener {

    private GUILabel guiLabel;
    private ThreadCambioColore tLblRosse;
    private ThreadCambioColore tLblBlu;

    public ListenerBottoni (GUILabel guiLabel){
        this.guiLabel = guiLabel;
        tLblRosse = new ThreadCambioColore(guiLabel);
        tLblBlu = new ThreadCambioColore(guiLabel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        guiLabel.setTerminaCambioColoreLlbRosse(false);
        guiLabel.setTerminaCambioColoreLlbBlu(false);
        if(e.getActionCommand().equals("Bottone label rosse")) {
            if (!tLblRosse.isAlive()) {
                tLblRosse = new ThreadCambioColore(guiLabel);
                tLblRosse.setRosse(true);
                tLblBlu.setBlu(false);
                tLblRosse.start();
            } else {
                guiLabel.setTerminaCambioColoreLlbBlu(false);
                guiLabel.setTerminaCambioColoreLlbRosse(true);
            }
        } else {
            if (!tLblBlu.isAlive()) {
                tLblBlu = new ThreadCambioColore(guiLabel);
                tLblRosse.setRosse(false);
                tLblBlu.setBlu(true);
                tLblBlu.start();
            } else {
                guiLabel.setTerminaCambioColoreLlbBlu(true);
                guiLabel.setTerminaCambioColoreLlbRosse(false);
            }
        }
    }
}