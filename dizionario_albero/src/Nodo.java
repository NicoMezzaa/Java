/**
 * autore: Nicolò Mezzanzanica
 * data: 25/05/2023
 * oggetto: classe Nodo
 */

import java.io.Serializable;

public class Nodo implements Serializable {
    String parola;
    Nodo sx;
    Nodo dx;

    public Nodo(String parola) {
        this.parola = parola;
        sx = null;
        dx = null;
    }
}