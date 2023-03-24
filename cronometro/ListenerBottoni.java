/*
AUTORE: NICOLO' MEZZANZANICA
DATA: 24/03/2023
LUOGO: CASA
OGGETTO: CLASSE LISTENER BOTTONI
*/

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListenerBottoni implements ActionListener {

    private GUILabel guiLabel;
    private ThreadContaSecondi t;

    public ListenerBottoni(GUILabel guiLabel){
        this.guiLabel = guiLabel;
        t = new ThreadContaSecondi(guiLabel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "Avvio conteggio":
                guiLabel.setFineConteggio(false);
                if(!t.isAlive()){
                    t = new ThreadContaSecondi(guiLabel);
                    t.start();
                }
                break;
            case "Interrompi conteggio":
                guiLabel.setFineConteggio(true);
                break;
        }
    }
}