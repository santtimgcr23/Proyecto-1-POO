public class Jugador {
    String nombre;
    BacteriaJ bacteriaJ = new BacteriaJ();

public Jugador(String nombre){
    this.nombre = nombre;
    }

public String getNombre() {
    return nombre;
}

public void setNombre(String nombre) {
    this.nombre = nombre;
}

public BacteriaJ getBacteriaJ() {
    return bacteriaJ;
}

public void setBacteriaJ(BacteriaJ bacteriaJ) {
    this.bacteriaJ = bacteriaJ;
}
    
}
