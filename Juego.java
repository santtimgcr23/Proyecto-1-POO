import java.awt.Color;
import java.util.Random;

public class Juego{
    private Tablero tablero;
    private Jugador jugador;
    private Aumentos aumentos;

    public Juego(){
        this.tablero = new Tablero();
        this.aumentos = new Aumentos();
        colocarValoresAumentos();
    }

    // VALORES DE AUMENTOS TEMPORALES
    public void colocarValoresAumentos(){
        aumentos.setCambiosEdad(3);
        aumentos.setCambiosEnergia(3);
        aumentos.setCambiosVelocidad(3);
        aumentos.setCambiosEdad(1);
    }

    // NUMERO ALEATORIO ENTRE 0 Y 25
    public int indexRandom(){
        Random r1 = new Random(); int low = 0;int high = 50;
        int x = r1.nextInt(high-low) + low;
        return x;
    }

    // NUMERO ALETORIO ENTRE 1 Y 2
    public int numRandom2(){
        Random r1 = new Random(); int low = 1; int high = 3;
        int x = r1.nextInt(high-low) + low;
        return x;
    }

    //-----------------------------------------------------------------------------------------------------------------------------
    // COLOCAR LOS OBJETOS EN EL MAPA
    // colocar la bacteria jugador
    public void posBacteriaJ(){
        int x = indexRandom();
        int y = indexRandom();
        Boton bJ = tablero.getMapa()[x][y];
        bJ.setBackground(Color.MAGENTA);
        bJ.setJugable(jugador.getBacteriaJ());
        jugador.getBacteriaJ().setPosicionX(x);
        jugador.getBacteriaJ().setPosicionY(y);

    }

    // colocar todos los alimentos
    public void posAlimento(){
        for (int i = 0; i < 75; i++){
            Boton bA = tablero.getMapa()[indexRandom()][indexRandom()];
            while (bA.getJugable() != null){
                bA = tablero.getMapa()[indexRandom()][indexRandom()];
            }
            if(numRandom2() == 1){
                AlimentoVision aV = new AlimentoVision();
                bA.setJugable(aV);
                bA.setBackground(Color.YELLOW);
            }
            else{
                AlimentoVelocidad aV = new AlimentoVelocidad();
                bA.setJugable(aV);
                bA.setBackground(Color.YELLOW);
            }
            }
        }
    
    // colocar todos los NPC
    public void posNPC(){
        for (int i = 0; i < 25; i++){
            Boton bA = tablero.getMapa()[indexRandom()][indexRandom()];
            while (bA.getJugable() != null){
                bA = tablero.getMapa()[indexRandom()][indexRandom()];
            }
            Bacteria b = new Bacteria();
            bA.setJugable(b);
            bA.setBackground(Color.BLUE);
        }
    }

    // se coloca un solo NPC en una posicion Aleatoria
    public void colocarUnNPCAleatorio(){
        Boton bA = tablero.getMapa()[indexRandom()][indexRandom()];
        while(bA.getJugable() != null){
            bA = tablero.getMapa()[indexRandom()][indexRandom()];
        }
        Bacteria b = new Bacteria();
        bA.setJugable(b);
        bA.setBackground(Color.BLUE);
    }

    public Tablero getTablero() {
        return tablero;
    }
    
    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }

    public Jugador getJugador() {
        return jugador;
    }
    
    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }


    // ANALIZA SI EL JUGADOR SE MUEVE O COME
    public void organizadorMoverJugador(int xSeleccionada, int ySeleccionada){
        if(jugador.getTurnoTerminado() == false){
            if(estaVaciaCasilla(xSeleccionada, ySeleccionada) == true){
                // SE MUEVE EL JUGADOR
                if(esPosibleMoverJugador(xSeleccionada, ySeleccionada) == true){
                    moverJugador(xSeleccionada, ySeleccionada);
                }
                else{
                    System.out.println("EL JUGADOR NO SE PUEDE MOVER");
                }
            }
            // SE COME UN ORGANISMO O ALIMENTO
            else{
                analizarComerCasilla(xSeleccionada, ySeleccionada);
            }
        }
        else{
            System.out.println("EL TURNO YA ACABO!");
        }
    }

    // --------------------------------------------------------------------------------------------------------------------------------------------------------
    // PARA VER SI SE PUEDE COMER LA CASILLA QUE SE SELECCIONO
    public void analizarComerCasilla(int xSeleccionada, int ySeleccionada){
        if(esPosibleComerDistancia(xSeleccionada, ySeleccionada) == true){
            intentarComerCasilla(xSeleccionada, ySeleccionada);
            jugador.setTurnoTerminado(true);
        }
        else{                                                                                 
            System.out.println("JUGADOR NO COME");
        }

    }


    public boolean esPosibleComerDistancia(int xSeleccionada, int ySeleccionada){
        int xJugador = jugador.getBacteriaJ().getPosicionX();
        int yJugador = jugador.getBacteriaJ().getPosicionY();

        int sumaCasillas = Math.abs(xJugador - xSeleccionada) + Math.abs(yJugador - ySeleccionada);
        System.out.println(sumaCasillas);
        if(sumaCasillas == 1){
            return true;
        }
        return false;
    }

    public void intentarComerCasilla(int xSeleccionada, int ySeleccionada){
        Bacteria nuevaBacteria = tablero.getMapa()[xSeleccionada][ySeleccionada].jugable.comerEsteObjeto(this.jugador.getBacteriaJ(), aumentos);
        actualizarDatosBacteriaJugador(nuevaBacteria);
        colocarNuevoObjetoEnElmapa(xSeleccionada, ySeleccionada);
        eliminarObjetoComido(xSeleccionada, ySeleccionada);
    }

    public void colocarNuevoObjetoEnElmapa(int xSeleccionada, int ySeleccionada){
        Jugable nuevoObjeto = tablero.getMapa()[xSeleccionada][ySeleccionada].jugable.objetoPorColocar();
        Color colorPorColocar = tablero.getMapa()[xSeleccionada][ySeleccionada].jugable.colorCasilla();

        Boton bA = tablero.getMapa()[indexRandom()][indexRandom()];
        while(bA.getJugable() != null){
            bA = tablero.getMapa()[indexRandom()][indexRandom()];
        }
        bA.setJugable(nuevoObjeto);
        bA.setBackground(colorPorColocar);
    }

    public void eliminarObjetoComido(int xSeleccionada, int ySeleccionada){
        tablero.getMapa()[xSeleccionada][ySeleccionada].jugable = null;
        tablero.getMapa()[xSeleccionada][ySeleccionada].setBackground(new java.awt.Color(153, 255, 153));
    }

    public void actualizarDatosBacteriaJugador(Bacteria nuevaBacteria){
        BacteriaJ bacteriaJugadorTemporal = (BacteriaJ)nuevaBacteria;
        jugador.setBacteriaJ(bacteriaJugadorTemporal);

        int x = jugador.getBacteriaJ().getPosicionX();
        int y = jugador.getBacteriaJ().getPosicionY();

        tablero.getMapa()[x][y].jugable = jugador.getBacteriaJ();
    }

    public boolean estaVaciaCasilla(int xPorMover, int yPorMover){
        if(tablero.getMapa()[xPorMover][yPorMover].jugable == null){
            return true;
        }
        return false;
    }

    //----------------------------------------------------------------------------------------------------------------
    // PARA MOVER EL JUGADOR 
    public boolean esPosibleMoverJugador(int xPorMover, int yPorMover){
        int x = jugador.getBacteriaJ().getPosicionX();
        int y = jugador.getBacteriaJ().getPosicionY();

        int casillasPorMover = Math.abs(x - xPorMover) + Math.abs(y - yPorMover);
        
        if(casillasPorMover == 1){
            if(casillasPorMover <= jugador.getBacteriaJ().getVelocidad()){
                int velocidadPasada = jugador.getBacteriaJ().getVelocidad();
                jugador.getBacteriaJ().setVelocidad(velocidadPasada - casillasPorMover);
                return true;
            }
            return false;
        }
        return false;
    }

    public void moverJugador(int xPorMover, int yPorMover){
        int xAnterior = jugador.getBacteriaJ().getPosicionX();
        int yAnterior = jugador.getBacteriaJ().getPosicionY();
        
        tablero.getMapa()[xAnterior][yAnterior].jugable = null;

        jugador.getBacteriaJ().setPosicionX(xPorMover);
        jugador.getBacteriaJ().setPosicionY(yPorMover);

        tablero.getMapa()[xPorMover][yPorMover].jugable = jugador.getBacteriaJ();

        // ACTUALIZAR VISUALEMENTE
        tablero.getMapa()[xAnterior][yAnterior].setBackground(new java.awt.Color(153, 255, 153));
        tablero.getMapa()[xPorMover][yPorMover].setBackground(Color.MAGENTA);

    }

    //---------------------------------------------------------------------------------------------------------------
    // SIMULACION NPCS
    // BOTON SIMULAR
    public void simularNPC(){
        jugador.setTurnoTerminado(false);
        realizarAccionesNPCs();
    }

    public void realizarAccionesNPCs(){
        aumentarEdadTodasLasBacterias();
        
    }

    public void aumentarEdadTodasLasBacterias(){
        for(int i = 0; i < 50; i++){
            for(int j = 0; j<50; j++){
                if(tablero.getMapa()[i][j].jugable != null){
                    tablero.getMapa()[i][j].jugable.aumentarEdad(aumentos);
                }
            }
        }
    }
}
