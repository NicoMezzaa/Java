/*
AUTORE: NICOLO' MEZZANZANICA
DATA: 06/04/2023
LUOGO: CASA
OGGETTO: CLASSE ORDINAMENTO
*/

import java.util.Vector;

public class Ordinamento {

    public static void selectionSort(Vector<Partita> classifica){
        Partita temp = null;
        for (int i = 0; i < classifica.size() - 1; i++) {
            for (int j = i+1; j < classifica.size(); j++) {
                if (classifica.get(i).getPunteggio() < classifica.get(j).getPunteggio()) {
                    temp = classifica.get(j);
                    classifica.set(j, classifica.get(i));
                    classifica.set(i, temp);
                }
            }
        }
    }
}