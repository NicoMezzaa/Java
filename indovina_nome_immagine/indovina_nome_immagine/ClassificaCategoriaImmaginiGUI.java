/*
AUTORE: NICOLO' MEZZANZANICA
DATA: 06/04/2023
LUOGO: CASA
OGGETTO: CLASSE CLASSIFICA CATEGORIA IMMAGINI GUI
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ClassificaCategoriaImmaginiGUI {

    private JFrame frmClassificaCategoriaImmagini;      // frame per classifica su una categoria d'immagini
    private JTable tabellaClassifica;                   // tabella per la classifica
    private JScrollPane scrollPane;                     // scroll pane
    private JButton btnIndietro;                        // bottone per tornare indietro

    // costruttore
    public ClassificaCategoriaImmaginiGUI(JFrame frmPrincipale, String[][] classificaCategoriaImmagini, String categoriaImmagini){

        //creazione finestra
        frmClassificaCategoriaImmagini = new JFrame("Classifica su immagini di " + categoriaImmagini);

        // creazione button
        btnIndietro = new JButton("INDIETRO");
        btnIndietro.setFont(GestioneIndovinaImmagineGUI.fntBtnCslTesto);
        btnIndietro.addActionListener((ActionEvent e) -> {
            frmPrincipale.setVisible(true);
            frmClassificaCategoriaImmagini.setVisible(false);
        });

        // campi
        String[] campi = {"Nome utente", "Punteggio"};
        // creazione table
        tabellaClassifica = new JTable(classificaCategoriaImmagini, campi);
        tabellaClassifica.setFont(GestioneIndovinaImmagineGUI.fntLblMenuItem);
        tabellaClassifica.setEnabled(false);
        tabellaClassifica.setGridColor(Color.YELLOW);
        tabellaClassifica.setBackground(Color.CYAN);
        //creazione scroll pane
        scrollPane = new JScrollPane(tabellaClassifica);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        //aggiunta componenti al frame
        frmClassificaCategoriaImmagini.add(btnIndietro, BorderLayout.WEST);
        frmClassificaCategoriaImmagini.add(scrollPane, BorderLayout.CENTER);
        frmClassificaCategoriaImmagini.setSize(600, 600);
        frmClassificaCategoriaImmagini.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmClassificaCategoriaImmagini.setVisible(true);
        frmPrincipale.setVisible(false);
    }
}