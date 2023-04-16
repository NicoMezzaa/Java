/*
AUTORE: NICOLO' MEZZANZANICA
DATA: 06/04/2023
LUOGO: CASA
OGGETTO: CLASSE LISTENER CONFERMA SCELTA
*/

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListenerConfermaSceltaNomeImmagine implements ActionListener {

    private IndovinaImmagineGUI indovinaImmagineGUI;        // GUI

    // costruttore
    public ListenerConfermaSceltaNomeImmagine(IndovinaImmagineGUI indovinaImmagineGUI){
        this.indovinaImmagineGUI = indovinaImmagineGUI;
    }

    // metodo actionPerformed
    @Override
    public void actionPerformed(ActionEvent e) {
        if(indovinaImmagineGUI.getBg().getSelection() == null) {        // segnala all'utente che non ha selezionato il nome di un gioco
            indovinaImmagineGUI.getLblStato().setText("Stato: selezionare un opzione!");
            indovinaImmagineGUI.getLblStato().setForeground(Color.RED);
        } else if (indovinaImmagineGUI.getBg().getSelection().getActionCommand().equals(indovinaImmagineGUI.getNomeImmagineUscita())){      // altrimenti se l'utente ha indovinato lo informa
            indovinaImmagineGUI.getLblStato().setText("Stato: Corretto!");
            indovinaImmagineGUI.getLblStato().setForeground(Color.GREEN);
            indovinaImmagineGUI.getT().interrupt();
            indovinaImmagineGUI.getBtnCambiaImg().setVisible(true);
            indovinaImmagineGUI.getBtnConferma().setVisible(false);
        } else {            // altrimenti avvisa l'utente che non ha indovinato
            indovinaImmagineGUI.getLblStato().setText("Stato: Sbagliato! non è " + indovinaImmagineGUI.getBg().getSelection().getActionCommand() + "!");
            indovinaImmagineGUI.getLblStato().setForeground(Color.RED);
        }
    }
}