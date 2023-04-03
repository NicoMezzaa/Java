/*
AUTORE: NICOLO' MEZZANZANICA
DATA: 03/04/2023
OGGETTO: CLASSE JTABLE GUI
*/

import javax.swing.*;
import java.io.*;
import java.util.StringTokenizer;

public class JTableGUI {

    // frame
    JFrame frmPrincipale;
    // Table
    JTable jTable;
    // prodotti.csv
    String[][] prodotti;
    // nome file
    String nomeFile = "prodotti.csv";

    // metodo per ottenere il numero di righe presenti nel file
    public int getRigheFile(){
        int righe = 0;
        try {
            FileReader fileReader = new FileReader(nomeFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            while (line != null){
                righe++;
                line = bufferedReader.readLine();
            }
        } catch (FileNotFoundException fileNotFoundException){
                System.out.println("File non trovato!");
        } catch (IOException e) {
            ;
        }

        return righe;
    }

    // metodo per ottenere il numero di prodotti.csv presenti nel file
    public String[][] ottieniProdottiDaFile() {
        String[][] prodotti = new String[getRigheFile()][4];
        int count = 0;
        int j = 0;
        try {
            FileReader fileReader = new FileReader(nomeFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            while (line != null) {
                j = 0;
                StringTokenizer stringTokenizer = new StringTokenizer(line, ";");
                while (stringTokenizer.hasMoreElements()) {
                    prodotti[count][j] = stringTokenizer.nextToken();
                    j++;
                }
                count++;
                line = bufferedReader.readLine();
            }
        } catch (FileNotFoundException fileNotFoundException) {
            ;
        } catch (IOException e) {
            ;
        }

        return prodotti;
    }

    // Constructor
    public JTableGUI() {
        // Frame initialization
        frmPrincipale = new JFrame();

        // Frame Title
        frmPrincipale.setTitle("JTable Example");

        // Column Names
        String[] campi = { "codice_prodotto", "nome_prodotto", "descrizione_breve", "prezzo_unitario" };

        // prodotti.csv
        prodotti = ottieniProdottiDaFile();
        // Initializing the JTable
        jTable = new JTable(prodotti, campi);
        jTable.setBounds(30, 40, 200, 300);

        // adding it to JScrollPane
        JScrollPane sp = new JScrollPane(jTable);
        sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        frmPrincipale.add(sp);
        // Frame Size
        frmPrincipale.setSize(500, 200);
        frmPrincipale.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Frame Visible = true
        frmPrincipale.setVisible(true);
    }
}