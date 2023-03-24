/*
AUTORE: NICOLO' MEZZANZANICA
DATA: 24/03/2023
LUOGO: CASA
OGGETTO: CLASSE FABBRICA
*/

public class Fabbrica extends Thread {

    private Magazzino magazzino;
    private int t_produzione;
    private int distanza;

    public Fabbrica(String nome, int t_produzione, int distanza){
        super(nome);
        magazzino = Magazzino.getInstance();
        this.t_produzione = t_produzione;
        this.distanza = distanza;
    }

    @Override
    public void run() {
        int i = 1;
        while (magazzino.getTempo_totale() < (365*20)){
            Aereo aereo = new Aereo(t_produzione, Thread.currentThread().getName() + i);
            try {
                magazzino.aggiungiAereo(aereo);
                Thread.sleep(distanza * (1/10));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            i++;
        }
        System.out.println("Fabbrica " + Thread.currentThread().getName() + " distrutta!");
    }
}