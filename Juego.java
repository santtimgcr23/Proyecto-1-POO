import java.awt.Color;
import java.util.Random;

public class Juego {
    private Tablero tablero;

    public Juego(){
        this.tablero = new Tablero();
    }

    public int indexRandom(){
        Random r1 = new Random(); int low = 0;int high = 50;
        int x = r1.nextInt(high-low) + low;
        return x;
    }

    public void posBacteriaJ(){
        Boton bJ = tablero.getMapa()[indexRandom()][indexRandom()];
        bJ.setBackground(Color.MAGENTA);
        bJ.setJugable(new BacteriaJ());
    }

    public void posAlimento(){
        for (int i = 0; i < 75; i++){
            Boton bA = tablero.getMapa()[indexRandom()][indexRandom()];
            while (bA.getJugable() != null){
                bA = tablero.getMapa()[indexRandom()][indexRandom()];
            }
            Alimento a = new Alimento();
            bA.setJugable(a);
            bA.setBackground(Color.YELLOW);
            }
        }
    
    public void posNPC(){
        for (int i = 0; i < 25; i++){
            Boton bA = tablero.getMapa()[indexRandom()][indexRandom()];
            while (bA.getJugable() != null){
                bA = tablero.getMapa()[indexRandom()][indexRandom()];
            }
            Bacteria b = new Bacteria();
            bA.setJugable(b);
            bA.setBackground(Color.BLUE);
            }
        }

    public Tablero getTablero() {
        return tablero;
    }
    
    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }
}
