/*
AUTORE: NICOLO' MEZZANZANICA
DATA: 24/03/2023
LUOGO: CASA
OGGETTO: CLASSE AEREO
*/

public class Aereo {

    private int t_produzione;
    private String nome;

    public Aereo(int t_produzione, String nome){
        this.t_produzione = t_produzione;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public int getT_produzione() {
        return t_produzione;
    }

    @Override
    public String toString() {
        return "Aereo{" +
                "t_produzione=" + t_produzione +
                ", nome='" + nome + '\'' +
                '}';
    }
}