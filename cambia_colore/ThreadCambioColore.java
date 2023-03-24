/*
ATUORE: NICOLO' MEZZANZANICA
DATA: 24/03/2023
LUOGO: CASA
OGGETTO: CLASSE THREAD CAMBIO COLORE
*/

import java.awt.*;

public class ThreadCambioColore extends Thread {

    private GUILabel guiLabel;
    private boolean rosse;
    private boolean blu;

    public ThreadCambioColore(GUILabel guiLabel){
        this.guiLabel = guiLabel;
        rosse = false;
        blu = false;
    }

    private void resetColoreLblRosse(){
        for (int i = 0; i < GUILabel.getNumLblRosseBlu(); i++) {
            guiLabel.getLblRosse()[i].setBackground(Color.WHITE);
        }
    }

    private void resetColoreLblBlu(){
        for (int i = 0; i < GUILabel.getNumLblRosseBlu(); i++) {
            guiLabel.getLblBlu()[i].setBackground(Color.WHITE);
        }
    }
    private void startRosse(){
        while (!guiLabel.isTerminaCambioColoreLlbRosse()) {
            try {
                Thread.sleep((int) (Math.random()*100));
                guiLabel.getLblRosse()[(int) (Math.random()*GUILabel.getNumLblRosseBlu())].setBackground(Color.RED);
                guiLabel.getLblRosse()[(int) (Math.random()*GUILabel.getNumLblRosseBlu())].setBackground(Color.WHITE);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        resetColoreLblRosse();
    }

    private void startBlu(){
        while (!guiLabel.isTerminaCambioColoreLlbBlu()) {
            try {
                Thread.sleep((int) (Math.random()*100));
                guiLabel.getLblBlu()[(int) (Math.random()*GUILabel.getNumLblRosseBlu())].setBackground(Color.BLUE);
                guiLabel.getLblBlu()[(int) (Math.random()*GUILabel.getNumLblRosseBlu())].setBackground(Color.WHITE);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        resetColoreLblBlu();
    }

    @Override
    public void run() {
        if(isRosse()) startRosse();
        else startBlu();
    }

    public void setBlu(boolean blu) {
        this.blu = blu;
    }

    public void setRosse(boolean rosse) {
        this.rosse = rosse;
    }

    public boolean isBlu() {
        return blu;
    }

    public boolean isRosse() {
        return rosse;
    }
}