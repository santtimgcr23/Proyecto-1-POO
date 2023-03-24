public class Bacteria extends Jugable {
    private int energia = 1;
    private int vision = 1;
    private int velocidad = 1;
    private int edad = 1;
    private int posicion = 0;
    
    public Bacteria(){}
    
    public void comer(){}

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
    public int getPosicion() {
        return posicion;
    }
    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    

}
