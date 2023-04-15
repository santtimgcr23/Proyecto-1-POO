import java.awt.Color;
import java.util.ArrayList;

public abstract class Jugable {
    private int posX;
    private int posY;
    public Jugable() {
    }

    public Bacteria comerEsteObjeto(Bacteria bacteriaQueAtaca, Aumentos aumentos){
        Bacteria bacteriaTemporal = new Bacteria();
        return bacteriaTemporal;
    }

    public Color colorCasilla(){
        Color colorCasilla = Color.BLACK;
        return colorCasilla;
    }

    public Jugable objetoPorColocar(){
        Jugable jugable = new Bacteria();
        return jugable;
    }

    public void aumentarEdad(Aumentos aumentos){

    }

    public void comerNPC(){
        System.out.println("eso wazin");
    }

    public int getPosX() {
        return posX;
    }
    public boolean esPosibleObjetoQueComa(){
        return true;
    }

    public void imprimirInformacionObjeto(){
        
    }

    public ArrayList<Integer> obtenerObjetoJugableMasCercano(Boton[][] mapa){
        ArrayList<Integer> respuesta = new ArrayList<>();
        return respuesta;
    }
///CAMBIOS SUGERIDOS POR GITHUB

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public boolean esBacteria(){
        return true;
    }

    public boolean esPosibleMover(Boton[][] mapa, ArrayList<Integer> arrayListTemporal){
        return true;
    }

    public Boton[][] moverNPC(Boton[][] mapa, ArrayList<Integer> arrayListTemporal){
        return mapa;
    }
    
}
