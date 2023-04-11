import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

public class Juego{
    private Tablero tablero;
    private int jugadorX;
    private int jugadorY;
    private Boton[][] mapa;
    private Jugador jugador;
    private Aumentos aumentos;

    public Juego(){
        this.tablero = new Tablero();
        this.mapa = tablero.getMapa();
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

    public int getJugadorX() {
        return jugadorX;
    }

    public void setJugadorX(int jugadorX) {
        this.jugadorX = jugadorX;
    }

    public int getJugadorY() {
        return jugadorY;
    }

    public void setJugadorY(int jugadorY) {
        this.jugadorY = jugadorY;
    }

    //-----------------------------------------------------------------------------------------------------------------------------
    // COLOCAR LOS OBJETOS EN EL MAPA
    // colocar la bacteria jugador
    public void posBacteriaJ(){
        int x = indexRandom();
        int y = indexRandom();
        Boton bJ = tablero.getMapa()[x][y];
        bJ.setBackground(Color.MAGENTA);
        bJ.setTipo("J");
        bJ.seTieneQueVer = true;
        bJ.setJugable(jugador.getBacteriaJ());
        jugador.getBacteriaJ().setPosicionX(x);
        jugador.getBacteriaJ().setPosicionY(y);
        setJugadorX(x); setJugadorY(y);
        
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
                bA.setTipo("AVI");
                bA.setBackground(Color.YELLOW);
            }
            else{
                AlimentoVelocidad aV = new AlimentoVelocidad();
                bA.setJugable(aV);
                bA.setTipo("AVE");
                bA.setBackground(Color.CYAN);
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
            bA.setTipo("NPC");
            bA.setBackground(Color.BLUE);
        }
    }

    public int getPasosNPC(Bacteria bacteria){
        Random r = new Random();
        return r.nextInt(bacteria.getVelocidad() - 0) + 0;
    }

    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //mover los NPC
    public void reposicionarNPC(){
            for (int i = 0; i < mapa.length; i++) {
                for (int j = 0; j < mapa[0].length; j++) {
                    if (mapa[i][j].jugable instanceof Bacteria && !(mapa[i][j].jugable instanceof BacteriaJ)) {
                        int direccion = (int) (Math.random() * 4); // 0: arriba, 1: derecha, 2: abajo, 3: izquierda
                        int nuevaFila = i, nuevaColumna = j;
                        Bacteria bacteria = (Bacteria) mapa[i][j].jugable;
                        int pasos = getPasosNPC(bacteria);
                        bacteria.setVelocidad(bacteria.getVelocidad() - pasos);
                        bacteria.setEnergia(bacteria.getEnergia() - pasos);
                        switch (direccion) {
                            case 0: // arriba
                                if (i - pasos > -1 && i > 0 && mapa[i - pasos][j].jugable == null) {
                                    nuevaFila = i - pasos;
                                }
                                break;
                            case 1: // derecha
                                if (j + pasos < 50 && j < mapa[0].length - 1 && mapa[i][j + pasos].jugable == null) {
                                    nuevaColumna = j + pasos;
                                }
                                break;
                            case 2: // abajo
                                if (i + pasos < 50 && i < mapa.length - 1 && mapa[i + pasos][j].jugable == null) {
                                    nuevaFila = i + pasos;
                                }
                                break;
                            case 3: // izquierda
                                if (j - pasos > -1 && j > 0 && mapa[i][j - pasos].jugable == null) {
                                    nuevaColumna = j - pasos;
                                }
                                break;
                        }
                        if (nuevaFila != i || nuevaColumna != j) {
                            mapa[nuevaFila][nuevaColumna].jugable = mapa[i][j].jugable;
                            mapa[i][j].jugable = null;
                            if (mapa[nuevaFila][nuevaColumna].seTieneQueVer == true){
                            mapa[nuevaFila][nuevaColumna].setBackground(Color.BLUE);
                            }
                            else {
                                mapa[nuevaFila][nuevaColumna].setBackground(Color.BLUE);//CAMBIAR A Color.BLACK
                            }
                            if (mapa[i][j].seTieneQueVer == true){
                                mapa[i][j].setBackground(new java.awt.Color(153,255,153));
                            }
                            else{
                            mapa[i][j].setBackground(new java.awt.Color(153,255,153));}//CAMBIAR A Color.BLACK
                        }
                    }
                }
            }
        }

    public void pintar(){
        for(int i = 0; i < mapa.length; i++){
            for(int j = 0; j < mapa[0].length; j++){
                mapa[i][j].pintarDeSuColor();
            }}}

    
    public void crearCampoVision(int x, int y){
        BacteriaJ bJ = (BacteriaJ)mapa[x][y].jugable;
        int vision = bJ.getVision();
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 50; j++) {
                // Si el Botón está dentro del cuadrado de visión, lo pintamos de blanco
                if (i >= x - vision && i <= x + vision && j >= y - vision && j <= y + vision) {
                    mapa[i][j].setSeTieneQueVer(true);
                } else {
                    // Si no, lo pintamos de negro
                    mapa[i][j].setSeTieneQueVer(false);
                }
        pintar();
    }}}

    public boolean estaEnCampo(int i, int j){
        int x = jugadorX;
        int y = jugadorY;
        BacteriaJ bJ = (BacteriaJ)mapa[x][y].jugable;
        int vision = bJ.getVision();
        if (i >= x - vision && i <= x + vision && j >= y - vision && j <= y + vision) {
            return true;
        }
        return false;}

    public void pintarNegro(){
        for (int i = 0; i < mapa.length; i++){
            for (int j = 0; j < mapa[i].length; j++){
                mapa[i][j].setBackground(Color.BLACK);
            }
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
    public void determinarAccionJugador(int xSeleccionada, int ySeleccionada){
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
            tablero.getMapa()[xSeleccionada][ySeleccionada].jugable.imprimirInformacionObjeto();
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

    public void analizarComerCasillaNCP(int xPorComer, int yPorComer, int xAtacante, int yAtacante){
        intentarComerCasillaNPC(xPorComer, yPorComer, xAtacante, yAtacante);
    }

    public void intentarComerCasillaNPC(int xPorComer, int yPorComer, int xAtacante, int yAtacante){
        Bacteria bacteriaAtacante = (Bacteria) tablero.getMapa()[xAtacante][yAtacante].jugable;
        Bacteria nuevaBacteria = tablero.getMapa()[xPorComer][yPorComer].jugable.comerEsteObjeto(bacteriaAtacante, aumentos);
        boolean bacteriaAtacanteGano = nuevaBacteria.getBacteriaGanoCombate();
        if(bacteriaAtacanteGano == true){
            colocarNuevoObjetoEnElmapa(xPorComer, yPorComer);
            eliminarObjetoComido(xPorComer, yPorComer);
            System.out.println("LA BACTERIA ATACANTE GANOOOOOOOOOOOOOO");
        }
        else{
            colocarNuevoObjetoEnElmapa(xAtacante, yAtacante);
            eliminarObjetoComido(xAtacante, yAtacante);
            System.out.println("ESO WAZIIIIIIIIN PERDIO LA BATALLA D:");
        }
    }

    public void intentarComerCasilla(int xSeleccionada, int ySeleccionada){
        Bacteria nuevaBacteria = tablero.getMapa()[xSeleccionada][ySeleccionada].jugable.comerEsteObjeto(this.jugador.getBacteriaJ(), aumentos);
        boolean bacteriaAtacanteGano = nuevaBacteria.getBacteriaGanoCombate();
        if(bacteriaAtacanteGano == true){
            actualizarDatosBacteriaJugador(nuevaBacteria);
            colocarNuevoObjetoEnElmapa(xSeleccionada, ySeleccionada);
            eliminarObjetoComido(xSeleccionada, ySeleccionada);
            moverJugador(xSeleccionada, ySeleccionada);
            System.out.println("LA BACTERIA ATACANTE GANOOOOOOOOO!");
        }
        else{

            System.out.println("LA BACTERIA ATACANTE PERDIO");
        }

    }

    //ES POSIBLE COMER PARA UN NPC
    public boolean esPosibleComerNPC(int xNPC, int yNPC){
        boolean esBacteria = tablero.getMapa()[xNPC][yNPC].jugable.esPosibleObjetoQueComa();
        if(esBacteria == false){
            return false;
        }
        int xPorRevisar;
        int yPorRevisar;
        // revisar arriba
        xPorRevisar = xNPC - 1;
        yPorRevisar = yNPC;
        if(xPorRevisar >= 0){
            if(esPosibleComerPosicionEspecifica(xPorRevisar, yPorRevisar) == true){
                return true;
            }
        }
        // revisar izquierda
        xPorRevisar = xNPC;
        yPorRevisar = yNPC - 1;
        if(yPorRevisar >= 0){
            if(esPosibleComerPosicionEspecifica(xPorRevisar, yPorRevisar) == true){
                return true;
            }
        }
        //revisar derecha
        xPorRevisar = xNPC;
        yPorRevisar = yNPC + 1;
        if(yPorRevisar < 50){
            if(esPosibleComerPosicionEspecifica(xPorRevisar, yPorRevisar) == true){
                return true;
            }
        }
        // revisar abajo
        xPorRevisar = xNPC + 1;
        yPorRevisar = yNPC;
        if(xPorRevisar < 50){
            if(esPosibleComerPosicionEspecifica(xPorRevisar, yPorRevisar) == true){
                return true;
            }
        }
        return false;
    }

    //OBTIENE LA POSICION QUE VA A SER ATACADA POR UN NPC
    public ArrayList<Integer> obtenerPosicionPorComerDeNPC(int xNPC, int yNPC){
        ArrayList<Integer> posicionPorComerPorNPC = new ArrayList<>();
        int xPorRevisar;
        int yPorRevisar;
        // revisar arriba
        xPorRevisar = xNPC - 1;
        yPorRevisar = yNPC;
        if(xPorRevisar >= 0){
            if(esPosibleComerPosicionEspecifica(xPorRevisar, yPorRevisar) == true){
                posicionPorComerPorNPC.add(xPorRevisar);
                posicionPorComerPorNPC.add(yPorRevisar);
                return posicionPorComerPorNPC;
            }
        }
        // revisar izquierda
        xPorRevisar = xNPC;
        yPorRevisar = yNPC - 1;
        if(yPorRevisar >= 0){
            if(esPosibleComerPosicionEspecifica(xPorRevisar, yPorRevisar) == true){
                posicionPorComerPorNPC.add(xPorRevisar);
                posicionPorComerPorNPC.add(yPorRevisar);
                return posicionPorComerPorNPC;
            }
        }
        //revisar derecha
        xPorRevisar = xNPC;
        yPorRevisar = yNPC + 1;
        if(yPorRevisar < 50){
            if(esPosibleComerPosicionEspecifica(xPorRevisar, yPorRevisar) == true){
                posicionPorComerPorNPC.add(xPorRevisar);
                posicionPorComerPorNPC.add(yPorRevisar);
                return posicionPorComerPorNPC;
            }
        }
        // revisar abajo
        xPorRevisar = xNPC + 1;
        yPorRevisar = yNPC;
        if(xPorRevisar < 50){
            if(esPosibleComerPosicionEspecifica(xPorRevisar, yPorRevisar) == true){
                posicionPorComerPorNPC.add(xPorRevisar);
                posicionPorComerPorNPC.add(yPorRevisar);
                return posicionPorComerPorNPC;
            }
        }
        return posicionPorComerPorNPC;
    }

    public boolean esPosibleComerPosicionEspecifica(int xPorRevisar, int yPorRevisar){
        if(tablero.getMapa()[xPorRevisar][yPorRevisar].jugable != null){
            return true;
        }
        return false;
    }

    public void colocarNuevoObjetoEnElmapa(int xSeleccionada, int ySeleccionada){
        Jugable nuevoObjeto = tablero.getMapa()[xSeleccionada][ySeleccionada].jugable.objetoPorColocar();
        Color colorPorColocar = tablero.getMapa()[xSeleccionada][ySeleccionada].jugable.colorCasilla();
        int xR = indexRandom(); int yR = indexRandom();
        Boton bA = tablero.getMapa()[xR][yR];
        while(bA.getJugable() != null){
            xR = indexRandom();yR = indexRandom();
            bA = tablero.getMapa()[xR][yR];
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

    public void actualizarDatosBacteriaGanadora(Bacteria nuevaBacteria, int xGanadora, int yGanadora){
        
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
                jugador.getBacteriaJ().setEnergia(jugador.getBacteriaJ().getEnergia() - casillasPorMover);
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

        tablero.getMapa()[xAnterior][yAnterior].setBackground(new java.awt.Color(153, 255, 153));
        tablero.getMapa()[xPorMover][yPorMover].setBackground(Color.MAGENTA);
        tablero.getMapa()[xPorMover][yPorMover].setTipo("J");
        tablero.getMapa()[xAnterior][yAnterior].setTipo("");

        setJugadorX(xPorMover); setJugadorY(yPorMover);

        //moverCampoVision(xPorMover, yPorMover);

    }

    //----------------------------------------------------------------------------------------------------------------------------------------------------
    // SIMULACION DEL NPC

    public void simulacionNPC(){
        jugador.setTurnoTerminado(false);
        realizarAccionesNPCs();
    }

    public void realizarAccionesNPCs(){
        reposicionarNPC();
        NPCComen();
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

    //----------------------------------------------------------------------------------------------------------------------------------------------------------
    // accion de comer los NPC
    public void NPCComen(){
        for(int i = 0; i < 50; i++){
            for(int j = 0; j<50; j++){
                if(tablero.getMapa()[i][j].jugable != null){
                    if(esPosibleComerNPC(i, j) == true){ //si es true el npc come
                        ArrayList <Integer> arraylistPosicionPorComer = obtenerPosicionPorComerDeNPC(i, j);
                        int xPorComer = arraylistPosicionPorComer.get(0);
                        int yPorComer = arraylistPosicionPorComer.get(1);
                        analizarComerCasillaNCP(xPorComer, yPorComer, i, j);
                    }
                }
            }
        }
    }


    //*******************************************************************************************************************************************************************************
    // Imprimir cosas

    public void imprimirMapa(){
        for(int i = 0; i<50; i++){
            for(int j= 0; j<50;j++){
                System.out.print(tablero.getMapa()[i][j].jugable);
                System.out.print(", ");
            }
            System.out.println();
            }
        }

}
