/*
AUTORE: NICOLO' MEZZANZANICA
DATA: 24/03/2023
LUOGO: CASA
OGGETTO: CLASSE MAGAZZINO
*/

import java.util.LinkedList;
import java.util.Queue;

public class Magazzino {

    private static Magazzino me = null;
    private final Queue<Aereo> buffer;
    private static int MAX_VELIVOLI;
    private int tempo_totale;

    private Magazzino(){
        buffer = new LinkedList<>();
        MAX_VELIVOLI = 10;
        tempo_totale = 0;
    }

    public synchronized static Magazzino getInstance(){
        if (me == null)
            me = new Magazzino();
        return me;
    }

    public synchronized void aggiungiAereo(Aereo aereo) throws InterruptedException {
        if(buffer.size() == MAX_VELIVOLI){
            System.out.println("Buffer pieno, la fabbrica " + Thread.currentThread().getName() + " sta aspettando...");
            this.wait();
        }
        buffer.offer(aereo);
        System.out.println("la fabbrica " + Thread.currentThread().getName() + " ha prodotto un aereo: " + aereo.toString());
        tempo_totale += aereo.getT_produzione();
        notifyAll();
    }

    public synchronized void rifornituraAerei(int richieste, int tempistiche) throws InterruptedException {
        if(buffer.size() < richieste){
            System.out.println("Buffer non sufficiente, l'ente " + Thread.currentThread().getName() + " sta aspettando altri aerei...");
            this.wait();
        }
        if(buffer.size() >= richieste){
            System.out.println("L'ente " + Thread.currentThread().getName() + " ha prelevato " + richieste + " velivoli come da procedura:");
            for (int i=0; i<richieste; i++){
                Aereo aereo = buffer.poll();
                System.out.printf("- ha trasportato un %d aereo: %s\n", i+1, aereo.toString());
                notifyAll();
            }
            tempo_totale += tempistiche;
        }
    }

    public void setTempo_totale(int tempo_totale) {
        this.tempo_totale = tempo_totale;
    }

    public int getTempo_totale() {
        return tempo_totale;
    }
}