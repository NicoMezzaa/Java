/*
AUTORE: NICOLO' MEZZANZANICA
DATA: 24/03/2023
LUOGO: CASA
OGGETTO: CLASSE ENTE TRASPORTATORE VELIVOLI
*/

public class EnteTrasportatoreVelivoli extends Thread {

    private Magazzino magazzino;
    private int richiesti;
    private int tempistiche;

    public EnteTrasportatoreVelivoli(String nome, int richiesti, int tempistiche){
        super(nome);
        magazzino = Magazzino.getInstance();
        this.richiesti = richiesti;
        this.tempistiche = tempistiche;
    }

    @Override
    public void run() {
        while(magazzino.getTempo_totale() < (365*20)){
            try {
                magazzino.rifornituraAerei(richiesti, tempistiche);
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Ente " + Thread.currentThread().getName() + " distrutto!");
    }
}