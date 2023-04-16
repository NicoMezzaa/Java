/*
AUTORE: NICOLO' MEZZANZANICA
DATA: 06/04/2023
LUOGO: CASA
OGGETTO: CLASSE UTENTE
*/

public class Utente extends Persona {

    private String nomeUtente;      // nome utente
    private String password;        // password
    private final int ID;           // ID

    // costruttore
    public Utente(String nomeUtente, String nomeReale, Data dataNascita, String sesso, String password, int ID) {
        super(nomeReale, dataNascita, sesso);
        this.nomeUtente = nomeUtente;
        this.password = password;
        this.ID = ID;
    }

    public String getNomeUtente() {
        return nomeUtente;
    }

    public String getPassword() {
        return password;
    }
}