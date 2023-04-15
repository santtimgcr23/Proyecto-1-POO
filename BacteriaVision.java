import java.util.ArrayList;

public class BacteriaVision extends Bacteria{
    @Override
    public void imprimirInformacionObjeto(){
        System.out.println("Bacteria prioriza vision: ");
        System.out.println("Energia: " + this.getEnergia() + ", Vision: " + this.getVision() + ", Velocidad: " + this.getVelocidad() + ", Edad: " + this.getEdad());
    }

    @Override
    public ArrayList<Integer> obtenerObjetoJugableMasCercano(Boton[][] mapa){
        ArrayList<Integer> posicionJugableMasCercana = new ArrayList<>();
        ArrayList<Integer> posicionVelocidadMasCercana = new ArrayList<>();
        int distanciaJugable = 150;
        int distanciaVelocidad = 150;
        int distanciaTemporal;
        int visionBacteria = this.getVision();
        int xBacteria = this.getPosX();
        int yBacteria = this.getPosY();
        int xPorAnalizarInicial = xBacteria - visionBacteria;
        //VALORES PARA EL FOR
        if(xPorAnalizarInicial < 0){
            xPorAnalizarInicial = 0;
        }
        int yPorAnalizarInicial = yBacteria - visionBacteria;
        if(yPorAnalizarInicial < 0){
            yPorAnalizarInicial = 0;
        }
        int xPorAnalizarFinal = xBacteria + visionBacteria;
        if(xPorAnalizarFinal > 49){
            xPorAnalizarFinal = 50;
        }
        int yPorAnalizarFinal = yBacteria + visionBacteria;
        if(yPorAnalizarFinal > 49){
            yPorAnalizarFinal = 50;
        }
        for(int i = xPorAnalizarInicial; i < xPorAnalizarFinal; i++){
            for(int j = yPorAnalizarInicial; j < yPorAnalizarFinal; j++){
                if(mapa[i][j].jugable != null){
                    if(mapa[i][j].jugable.getClass() == this.getClass() || mapa[i][j].jugable.getClass() == AlimentoVision.class){
                        if(posicionVelocidadMasCercana.isEmpty() == true){
                            posicionVelocidadMasCercana.add(i);
                            posicionVelocidadMasCercana.add(j);
                            distanciaVelocidad = Math.abs(xBacteria - i) + Math.abs(yBacteria - j);
                        }
                        else{
                            distanciaTemporal = Math.abs(xBacteria - i) + Math.abs(yBacteria - j);
                            if(distanciaTemporal < distanciaVelocidad){
                                posicionVelocidadMasCercana.add(i);
                                posicionVelocidadMasCercana.add(j);
                            }
                        }
                    }
                    else{
                        if(posicionJugableMasCercana.isEmpty() == true){
                            posicionJugableMasCercana.add(i);
                            posicionJugableMasCercana.add(j);
                            distanciaJugable = Math.abs(xBacteria - i) + Math.abs(yBacteria - j);
                        }
                        else{
                            distanciaTemporal = Math.abs(xBacteria - i) + Math.abs(yBacteria - j);
                            if(distanciaTemporal < distanciaJugable){
                                posicionJugableMasCercana.add(i);
                                posicionJugableMasCercana.add(j);
                            }
                        }
                        
                    }
                }
            }
        }
    if(posicionVelocidadMasCercana.isEmpty() == true){
        return posicionJugableMasCercana;
    }
    return posicionVelocidadMasCercana;
    }

    @Override
    public boolean esBacteria(){
        return true;
    }

    @Override
    public boolean esPosibleMover(Boton[][] mapa, ArrayList<Integer> arrayListTemporal){
        return true;
    }
}
