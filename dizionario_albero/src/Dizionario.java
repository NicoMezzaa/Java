/**
 * autore: Nicolò Mezzanzanica
 * data: 25/05/2023
 * oggetto: classe dizionario 
 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Vector;

import javax.swing.JTextArea;

class Dizionario implements Serializable {
    private Nodo radice;

    public Dizionario() {
        radice = null;
    }

    public void inserisciParola(Nodo nuovo){
        boolean trovato = false;
        Nodo corrente = radice;

        if (radice == null) {
            radice = nuovo;
        } else {
            while (!trovato) {
                if (nuovo.parola.compareTo(radice.parola) == 0) {
                    trovato = true;
                } else if (nuovo.parola.compareTo(corrente.parola) < 0) {
                    if (corrente.sx != null) {
                        corrente = corrente.sx;
                    } else {
                        trovato = true;
                    }
                } else {
                    if (corrente.dx != null) {
                        corrente = corrente.dx;
                    } else {
                        trovato = true;
                    }
                }
            }
            if (nuovo.parola.compareTo(corrente.parola) < 0) corrente.sx = nuovo;
            if (nuovo.parola.compareTo(corrente.parola) > 0) corrente.dx = nuovo;
        }
    }

    public boolean ricercaParola(Nodo corrente, String parola) {
        if (corrente == null) {
            return false;
        }

        if (parola.compareTo(corrente.parola) == 0) {
            return true;
        } else if (parola.compareTo(corrente.parola) < 0) {
            return ricercaParola(corrente.sx, parola);
        } else {
            return ricercaParola(corrente.dx, parola);
        }
    }

    public Vector<String> getParoleInOrdine() {
        Vector<String> parole = new Vector<>();
        getParoleInOrdine(radice, parole);
        return parole;
    }

    private void getParoleInOrdine(Nodo corrente, Vector<String> parole) {
        if (corrente != null) {
            getParoleInOrdine(corrente.sx, parole);
            parole.add(corrente.parola);
            getParoleInOrdine(corrente.dx, parole);
        }
    }

    public void salvaSuFile(String nomeFile, JTextArea textArea) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomeFile))) {
            oos.writeObject(this);
            textArea.setText("Dizionario salvato nel file: " + nomeFile);
        } catch (IOException e) {
            textArea.setText("Errore durante il salvataggio del file: " + e.getMessage());
        }
    }

    public static Dizionario caricaDaFile(String nomeFile, JTextArea textArea) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomeFile))) {
            return (Dizionario) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            textArea.setText("Errore durante la lettura del file: " + e.getMessage());
        }
        return null;
    }

    public Nodo getRadice(){
        return radice;
    }
}