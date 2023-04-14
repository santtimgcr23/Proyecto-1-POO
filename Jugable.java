import java.awt.Color;

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

    
}
