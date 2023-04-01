/*
AUTORE: NICOLO' MEZZANZANICA
DATA: 28/03/2023
LUOGO: CASA
OGGETTO: CLASSE LISTENER CONFERMA SCELTA
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListenerConfermaScelta implements ActionListener {

    IndovinaImmagineGUI indovinaImmagineGUI;        // GUI

    public ListenerConfermaScelta(IndovinaImmagineGUI indovinaImmagineGUI){
        this.indovinaImmagineGUI = indovinaImmagineGUI;
    }

    // metodo che restituisce il radioButton che ha cliccato l'utente, altrimenti se non ha cliccato nulla restituisce null
    private JRadioButton ottieniOpzioneSelezionata() {
        for (int i = 0; i < indovinaImmagineGUI.getRb().length; i++) {
            if (indovinaImmagineGUI.getRb()[i].isSelected())
                return indovinaImmagineGUI.getRb()[i];
        }
        return null;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JRadioButton rb = ottieniOpzioneSelezionata();
        if(rb == null) {        // segnala all'utente che non ha selezionato il nome di un gioco
            indovinaImmagineGUI.getLblStato().setText("Stato: selezionare un gioco!");
            indovinaImmagineGUI.getLblStato().setForeground(Color.RED);
        } else if (rb.getText().equals(indovinaImmagineGUI.getNomeGiocoUscito())){      // altrimenti se l'utente ha indovinato lo informa
            indovinaImmagineGUI.getLblStato().setText("Stato: Corretto! Il gioco è " + rb.getText() + "!");
            indovinaImmagineGUI.getLblStato().setForeground(Color.GREEN);
            indovinaImmagineGUI.getT().interrupt();
            indovinaImmagineGUI.getBtnCambiaImg().setVisible(true);
        } else {            // altrimenti avvisa l'utente che non ha indovinato
            indovinaImmagineGUI.getLblStato().setText("Stato: Sbagliato! Il gioco non è " + rb.getText() + "!");
            indovinaImmagineGUI.getLblStato().setForeground(Color.RED);
        }
    }
}