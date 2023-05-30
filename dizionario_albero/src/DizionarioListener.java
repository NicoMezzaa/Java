/**
 * autore: Nicolò Mezzanzanica
 * data: 25/05/2023
 * oggetto: classe dizionario listener
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JOptionPane;

public class DizionarioListener implements ActionListener {

    private DizionarioGUI dizionarioGUI;
    private String nomeFile;
    private boolean isSaved;

    public DizionarioListener(DizionarioGUI dizionarioGUI) {
        this.dizionarioGUI = dizionarioGUI;
        nomeFile = null;
        isSaved = false;
    }

    private void alert(String message){
        JOptionPane.showMessageDialog(dizionarioGUI.getFrame(), message);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        switch (command) {
            case "Nuova parola":
                String parola = JOptionPane.showInputDialog(null, "Inserisci una parola:");

                if (parola != null) {
                    if (!parola.isEmpty()) {
                        dizionarioGUI.getDizionario().inserisciParola(new Nodo(parola));
                        dizionarioGUI.mostraMessaggio("Parola inserita: " + parola);
                    } else {
                        alert("Inserisci una parola");
                    }
                }
                break;

            case "Cerca parola":
                String parolaDaCercare = JOptionPane.showInputDialog(null, "Cerca una parola:");
                if (parolaDaCercare != null) {
                    if (!parolaDaCercare.isEmpty()) {
                        boolean trovato = dizionarioGUI.getDizionario().ricercaParola(dizionarioGUI.getDizionario().getRadice(), parolaDaCercare);
                        if (trovato) {
                            dizionarioGUI.mostraMessaggio("La parola '" + parolaDaCercare + "' è presente nel dizionario.");
                        } else {
                            dizionarioGUI.mostraMessaggio("La parola '" + parolaDaCercare + "' non è presente nel dizionario.");
                        }
                    } else {
                        alert("Inserisci una parola da cercare");
                    }
                }
                break;

            case "Mostra parole":
                Vector<String> parole = dizionarioGUI.getDizionario().getParoleInOrdine();

                if (parole.isEmpty()) {
                    dizionarioGUI.mostraMessaggio("Non ci sono parole");
                } else {
                    StringBuilder sb = new StringBuilder();
                    for (String p : parole) {
                        sb.append(p).append("\n");
                    }
                    dizionarioGUI.mostraMessaggio(sb.toString());
                }
                break;

            case "Salva dizionario":
                if (!isSaved) {
                    nomeFile = JOptionPane.showInputDialog(null, "Inserisci il nome del file di destinazione:");
                }
                
                if (nomeFile != null) {
                    if (!nomeFile.isEmpty()) {
                        if (!isSaved) {
                            nomeFile+=".dat";
                        }
                        dizionarioGUI.getDizionario().salvaSuFile("file/" + nomeFile, dizionarioGUI.getTextArea());
                        dizionarioGUI.mostraMessaggio("Dizionario salvato nel file: " + nomeFile);
                        dizionarioGUI.getFrame().setTitle("Dizionario - " + nomeFile);
                        isSaved = true;
                    } else {
                        alert("Inserisci un nome di un file");
                    }
                } 
                break;

            case "Carica dizionario":
                String nome = JOptionPane.showInputDialog(null, "Inserisci il nome del file da caricare:");
                
                if (nome != null) {
                    if (!nome.isEmpty()) {
                        nome+=".dat";
                        Dizionario dizionario = Dizionario.caricaDaFile("file/" + nome, dizionarioGUI.getTextArea());
                        if (dizionario != null) {
                            nomeFile = nome;
                            dizionarioGUI.setDizionario(dizionario);
                            dizionarioGUI.mostraMessaggio("Dizionario caricato dal file: " + nomeFile);
                            dizionarioGUI.getFrame().setTitle("Dizionario - " + nomeFile);
                            isSaved = true;
                        }
                    } else {
                        alert("Inserisci un nome di un file");
                    }
                } 
                break;
        }
    }
}