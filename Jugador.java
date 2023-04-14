public class Jugador {
    private String nombre;
    private BacteriaJ bacteriaJ = new BacteriaJ();
    private boolean turnoTerminado = false;
    private int direccionMovimiento = 0;

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

public boolean getTurnoTerminado(){
    return turnoTerminado;
}

public void setTurnoTerminado(boolean turnoTerminado){
    this.turnoTerminado = turnoTerminado;
}

public int getDireccionMovimiento(){
    return direccionMovimiento;
}

public void setDireccionMovimiento(int direccionMovimiento){
    this.direccionMovimiento = direccionMovimiento;
}
    
}
