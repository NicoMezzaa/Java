/*
AUTORE: NICOLO' MEZZANZANICA
DATA: 28/03/2023
LUOGO: CASA
OGGETTO: CLASSE INDOVINA IMMAGINE GUI
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

public class IndovinaImmagineGUI {

    private JFrame frmPrincipale;       // frame principale
    private JPanel pnlIndovinaImmagine; // pannello composto dalle varie opzioni che ha l'utente per indovinare il gioco dall'immagine
    private JPanel pnlNord;             // pannello nord
    private JPanel pnlSud;              // pannello sud
    private Vector<String> nomi_giochi; // array dinamico formato dai nomi dei giochi
    private String nomeGiocoUscito;     // nome del gioco uscito nell'immagine
    private ButtonGroup bg;             // button group
    private JRadioButton[] rb;          // radio button ciascuno dei quali rappresenta il nome di un gioco
    private JLabel lblImg;              // label contenente l'immagine del gioco uscita
    private JButton btnCambiaImg;       // bottone per passare a un altra immagine di un gioco
    private JButton btnConferma;        // bottone per confermare l'opzione scelta dall'utente
    private JLabel lblStato;            // label per dare informazioni all'utente
    private JLabel lblTempoRimanente;   // label tempo rimanente
    private ThreadTempoRimanente t;     // thread per aggiornare il tempo

    // metodo per prelevare tutti i nomi dei giochi dal file
    private Vector<String> ottieniNomiGiochiDaFile(){
        Vector<String> nomi_giochi = new Vector<>();

        try {
            FileReader fileReader = new FileReader("giochi.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();

            while (line != null){
                nomi_giochi.add(line);
                line = bufferedReader.readLine();
            }
            bufferedReader.close();
        } catch (IOException ioException){
            ;
        }
        return nomi_giochi;
    }

    public IndovinaImmagineGUI(){

        // creazione frame
        frmPrincipale = new JFrame("Indovina il nome del gioco dall'immagine");
        Container c = frmPrincipale.getContentPane();

        nomi_giochi = ottieniNomiGiochiDaFile();

        // creazione dei panel
        pnlSud = new JPanel(new GridLayout(1,2));
        pnlNord = new JPanel(new GridLayout(1,2));
        pnlIndovinaImmagine = new JPanel(new GridLayout(nomi_giochi.size(),1));
        // creazione ButtonGroup e radioButton
        bg = new ButtonGroup();
        rb = new JRadioButton[nomi_giochi.size()];
        // creazione label
        lblImg = new JLabel();
        lblStato = new JLabel("Stato: in corso");
        lblTempoRimanente = new JLabel("Tempo rimanente: ");
        //creazione bottoni
        btnConferma = new JButton("Conferma scelta");
        btnConferma.addActionListener(new ListenerConfermaScelta(this));
        btnCambiaImg = new JButton("Prossima immagine");
        btnCambiaImg.addActionListener((ActionEvent e )-> {
            int indice = (int) (Math.random() * (nomi_giochi.size()));
            nomeGiocoUscito = nomi_giochi.get(indice);
            lblImg.setIcon(new ImageIcon("images/" + nomeGiocoUscito + ".jpg"));
            lblStato.setText("Stato: in corso");
            lblStato.setForeground(Color.BLACK);
            btnCambiaImg.setVisible(false);
            btnConferma.setVisible(true);
            t = new ThreadTempoRimanente(this);
            t.start();
        });
        btnCambiaImg.setVisible(false);

        // aggiunta componenti ai panel
        pnlNord.add(lblStato);
        pnlNord.add(lblTempoRimanente);
        pnlSud.add(btnConferma);
        pnlSud.add(btnCambiaImg);
        for (int i = 0; i < nomi_giochi.size(); i++) {
            rb[i] = new JRadioButton(nomi_giochi.get(i));
            bg.add(rb[i]);
            pnlIndovinaImmagine.add(rb[i]);
        }

        // generazione casuale della prima immagine
        int indice = (int) (Math.random() * (nomi_giochi.size()));
        nomeGiocoUscito = nomi_giochi.get(indice);
        lblImg.setIcon(new ImageIcon("images/" + nomeGiocoUscito + ".jpg"));

        //aggiunta componenti al container
        c.add(pnlIndovinaImmagine, BorderLayout.WEST);
        c.add(lblImg, BorderLayout.CENTER);
        c.add(pnlNord, BorderLayout.NORTH);
        c.add(pnlSud, BorderLayout.SOUTH);

        frmPrincipale.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmPrincipale.setSize(new Dimension(900,600));
        frmPrincipale.setVisible(true);
        // creazione e avvio del thread timer
        t = new ThreadTempoRimanente(this);
        t.start();
    }

    public JLabel getLblStato() {
        return lblStato;
    }

    public JLabel getLblTempoRimanente() {
        return lblTempoRimanente;
    }

    public JButton getBtnCambiaImg() {
        return btnCambiaImg;
    }

    public JButton getBtnConferma() {
        return btnConferma;
    }

    public JRadioButton[] getRb() {
        return rb;
    }

    public String getNomeGiocoUscito() {
        return nomeGiocoUscito;
    }

    public ThreadTempoRimanente getT() {
        return t;
    }
}