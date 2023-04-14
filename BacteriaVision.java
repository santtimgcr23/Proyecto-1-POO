public class BacteriaVision extends Bacteria{
    @Override
    public void imprimirInformacionObjeto(){
        System.out.println("Bacteria prioriza vision: ");
        System.out.println("Energia: " + this.getEnergia() + ", Vision: " + this.getVision() + ", Velocidad: " + this.getVelocidad() + ", Edad: " + this.getEdad());
    }
}
