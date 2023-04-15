import java.util.ArrayList;

public class BacteriaVelocidad extends Bacteria{
    @Override
    public void imprimirInformacionObjeto(){
        System.out.println("Bacteria prioriza velocidad: ");
        System.out.println("Energia: " + this.getEnergia() + ", Vision: " + this.getVision() + ", Velocidad: " + this.getVelocidad() + ", Edad: " + this.getEdad());
    }

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
        for(int i = xPorAnalizarInicial; i < xPorAnalizarFinal ; i++){
            if(i == xBacteria){
                i++;
            }
            for(int j = yPorAnalizarInicial; j < yPorAnalizarFinal; j++){
                if(j == yBacteria){
                    j++;
                }
                if(mapa[i][j].jugable != null){
                    if(mapa[i][j].jugable.getClass() == this.getClass() || mapa[i][j].jugable.getClass() == AlimentoVelocidad.class){
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

    public ArrayList<Integer> obtenerNuevaPosicionMovimientoUnaCasilla(int xPorMover, int yPorMover, int xBacteria, int yBacteria){
        ArrayList<Integer> nuevaPosicionBacteria = new ArrayList<>();
        if(xPorMover < xBacteria){
            int nuevaPosicionX = xBacteria - 1;
            nuevaPosicionBacteria.add(nuevaPosicionX);
            nuevaPosicionBacteria.add(yBacteria);
            return nuevaPosicionBacteria;
        }
        else if(xPorMover > xBacteria){
            int nuevaPosicionX = xBacteria + 1;
            nuevaPosicionBacteria.add(nuevaPosicionX);
            nuevaPosicionBacteria.add(yBacteria);
            return nuevaPosicionBacteria;
        }
        else if(yPorMover < yBacteria){
            int nuevaPosicionY = yBacteria - 1;
            nuevaPosicionBacteria.add(xBacteria);
            nuevaPosicionBacteria.add(nuevaPosicionY);
            return nuevaPosicionBacteria;
        }
        else if(yPorMover > yBacteria){
            int nuevaPosicionY = yBacteria + 1;
            nuevaPosicionBacteria.add(xBacteria);
            nuevaPosicionBacteria.add(nuevaPosicionY);
            return nuevaPosicionBacteria;
        }
        return nuevaPosicionBacteria;
    }

    @Override
    public boolean esBacteria(){
        return true;
    }

    @Override
    public boolean esPosibleMover(Boton[][] mapa, ArrayList<Integer> arrayListTemporal){
        int xPorMover = arrayListTemporal.get(0);
        int yPorMover = arrayListTemporal.get(1);

        int xBacteria = this.getPosicionY();
        int yBacteria = this.getPosicionY();
        ArrayList <Integer> nuevaPosicionMovimientoUnaCasilla = obtenerNuevaPosicionMovimientoUnaCasilla(xPorMover, yPorMover, xBacteria, yBacteria);
        
        int nuevaPosicionX = nuevaPosicionMovimientoUnaCasilla.get(0);
        int nuevaPosicionY = nuevaPosicionMovimientoUnaCasilla.get(1);
        if(mapa[nuevaPosicionX][nuevaPosicionY].jugable == null){
            return true;
        }
        return false;
    }

    @Override
    public Boton[][] moverNPC(Boton[][] mapa, ArrayList<Integer> arrayListTemporal){
        int xPorMover = arrayListTemporal.get(0);
        int yPorMover = arrayListTemporal.get(1);

        int xBacteria = this.getPosicionY();
        int yBacteria = this.getPosicionY();

        ArrayList <Integer> nuevaPosicionMovimientoUnaCasilla = obtenerNuevaPosicionMovimientoUnaCasilla(xPorMover, yPorMover, xBacteria, yBacteria);

        int nuevaPosicionX = nuevaPosicionMovimientoUnaCasilla.get(0);
        int nuevaPosicionY = nuevaPosicionMovimientoUnaCasilla.get(1);
        
        mapa[xBacteria][yBacteria].jugable = null; // elimina la bacteria anterior
        this.setPosicionX(nuevaPosicionX);
        this.setPosicionY(nuevaPosicionY);
        mapa[nuevaPosicionX][nuevaPosicionY].jugable = this;
        
        return mapa;
    }
}
