import java.awt.Color;

public abstract class Jugable {

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


}
