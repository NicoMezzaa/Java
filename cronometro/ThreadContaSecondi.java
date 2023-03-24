/*
AUTORE: NICOLO' MEZZANZANICA
DATA: 24/03/2023
LUOGO: CASA
OGGETTO: CLASSE THREAD CONTA SECONDI
*/

public class ThreadContaSecondi extends Thread {

    private GUILabel guiLabel;

    public ThreadContaSecondi(GUILabel guiLabel){
        this.guiLabel = guiLabel;
    }

    @Override
    public void run() {
        while (!guiLabel.isFineConteggio()){
            try {
                Thread.sleep(1000);
                guiLabel.setSecondi(guiLabel.getSecondi() + 1);
                guiLabel.getLblSecondiPassati().setText("Secondi passati: " + String.valueOf(guiLabel.getSecondi()));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}