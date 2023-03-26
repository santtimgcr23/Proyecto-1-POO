public class Aumentos {
    int cambiosEnergia;
    int cambiosVelocidad;
    int cambiosVision;
    int cambiosEdad;

    // HAY QUE CAMBIAR
    Aumentos(){
        this.cambiosEnergia = 3;
        this.cambiosVelocidad = 3;
        this.cambiosVision = 3;
        this.cambiosEdad = 3;
    }

    public int getCambiosEnergia() {
        return cambiosEnergia;
    }

    public int getCambiosEdad() {
        return cambiosEdad;
    }
    
    public int getCambiosVelocidad() {
        return cambiosVelocidad;
    }

    public int getCambiosVision() {
        return cambiosVision;
    }

    public void setCambiosEdad(int cambiosEdad) {
        this.cambiosEdad = cambiosEdad;
    }

    public void setCambiosEnergia(int cambiosEnergia) {
        this.cambiosEnergia = cambiosEnergia;
    }

    public void setCambiosVelocidad(int cambiosVelocidad) {
        this.cambiosVelocidad = cambiosVelocidad;
    }

    public void setCambiosVision(int cambiosVision) {
        this.cambiosVision = cambiosVision;
    }
    
}
