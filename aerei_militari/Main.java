/*
AUTORE: NICOLO' MEZZANZANICA
DATA: 24/03/2023
LUOGO: CASA
OGGETTO: CLASSE MAIN
*/

public class Main {
    public static void main(String[] args) {

        Fabbrica f1 = new Fabbrica("ALFA", 500, 800);
        Fabbrica f2 = new Fabbrica("BRAVO", 450, 400);
        Fabbrica f3 = new Fabbrica("CHARLIE", 600, 300);
        Fabbrica f4 = new Fabbrica("DELTA", 350, 600);
        Fabbrica f5 = new Fabbrica("ECHO", 720, 200);

        EnteTrasportatoreVelivoli e1 = new EnteTrasportatoreVelivoli("Marines", 3, 2000);
        EnteTrasportatoreVelivoli e2 = new EnteTrasportatoreVelivoli("US Navy", 5, 2300);
        EnteTrasportatoreVelivoli e3 = new EnteTrasportatoreVelivoli("Air Force", 7, 1500);

        f1.start();
        f2.start();
        f3.start();
        f4.start();
        f5.start();

        e1.start();
        e2.start();
        e3.start();
    }
}