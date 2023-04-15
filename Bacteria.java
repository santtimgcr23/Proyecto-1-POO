import java.awt.Color;

public class Bacteria extends Jugable {
    private int energia = 10;
    private int vision = 10;
    private int velocidad = 10;
    private int edad = 1;
    private int posicionX = 0;
    private int posicionY = 0;
    
    public Bacteria(){}

    public void addEnergia(int extra){
        setEnergia(energia + extra);
    }

    public void menosEnergia(){
        setEnergia(energia - 1);
    }

    public void menosVision(){
        setVision(vision - 1);
    }

    public void addVision(int extra){
        setVision(vision + extra);
    }

    public void addVelocidad(int extra){
        setVelocidad(velocidad + extra);
    }

    public void menosVelocidad(int decremento){
        setVelocidad(velocidad - decremento);
    }

    public void addEdad(){
        setEdad(edad + 1);
    }

    public int getEnergia() {
        return energia;
    }
    public void setEnergia(int energia) {
        this.energia = energia;
    }
    public int getVision() {
        return vision;
    }
    public void setVision(int vision) {
        this.vision = vision;
    }
    public int getVelocidad() {
        return velocidad;
    }
    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public int getPosicionX() {
        return posicionX;
    }
    public void setPosicionX(int posicionx) {
        this.posicionX = posicionx;
    }

    public int getPosicionY() {
        return posicionY;
    }
    public void setPosicionY(int posiciony) {
        this.posicionY = posiciony;
    }

    @Override
    public Bacteria comerEsteObjeto(Bacteria bacteriaQueAtaca, Aumentos aumentos){
        int mitadEnergia = this.getEnergia() / 2;
        int mitadVision = this.getVision() / 2;
        int mitadVelocidad = this.getVelocidad() / 2;

        int nuevaEnergia = mitadEnergia + bacteriaQueAtaca.getEnergia();
        int nuevaVision = mitadVision + bacteriaQueAtaca.getVision();
        int nuevaVelocidad = mitadVelocidad + bacteriaQueAtaca.getVelocidad();

        bacteriaQueAtaca.setEnergia(nuevaEnergia);
        bacteriaQueAtaca.setVision(nuevaVision);
        bacteriaQueAtaca.setVelocidad(nuevaVelocidad);

        return bacteriaQueAtaca;
        
    }

    @Override
    public Color colorCasilla(){
        Color colorCasilla = Color.BLUE;
        return colorCasilla;
    }

    @Override
    public Jugable objetoPorColocar(){
        Jugable jugable = new Bacteria();
        return jugable;
    }

    @Override
    public void aumentarEdad(Aumentos aumentos){
        int nuevaEdad = this.getEdad() + aumentos.getCambiosEdad();
        this.setEdad(nuevaEdad);
    }

    @Override
    public boolean esPosibleObjetoQueComa(){
        return true;
    }

}
