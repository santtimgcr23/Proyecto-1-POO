import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameScreen extends javax.swing.JFrame{
    Aumentos aumentos;
    Juego juego;
    GameScreen(String jugadorN, Aumentos aumentos) {
        setTitle("MICROBIA - Pantalla de Juego");
        this.aumentos = aumentos;
        this.juego = new Juego(aumentos);
        Jugador jugador = new Jugador(jugadorN);
        this.juego.setJugador(jugador);
        juego.posBacteriaJ();
        juego.posAlimento();
        juego.posNPC();
        initComponents();
        initialize();
        juego.crearCampoVision(juego.getJugadorX(), juego.getJugadorY());
    }
    
    public void initialize(){
        Boton[][] mapa = juego.getTablero().getMapa();
        gamePAN.setLayout(new GridLayout(50,50));
        for (int i = 0; i < 50; i++){
            for (int j = 0; j < 50; j++){
                mapa[i][j].setSize(1, 1);
                int x = i;
                int y = j;
                mapa[i][j].addActionListener(e -> accionPresionarBoton(x, y));
                gamePAN.add(mapa[i][j]);
            }
        }
    }
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtData = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        gamePAN = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 0, 102));

        jLabel1.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 255, 153));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("MICROBIA");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(51, 0, 102));

        txtData.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 24)); // NOI18N
        txtData.setForeground(new java.awt.Color(153, 255, 153));
        txtData.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtData.setText(juego.getJugador().getNombre() + " / ENERGÍA: " + juego.getJugador().getBacteriaJ().getEnergia() + " / VISIÓN: " + juego.getJugador().getBacteriaJ().getVision() + " / VELOCIDAD: " + juego.getJugador().getBacteriaJ().getVelocidad() + " / EDAD: " + juego.getJugador().getBacteriaJ().getEdad());

        jButton4.setBackground(new java.awt.Color(153, 255, 153));
        jButton4.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(51, 0, 102));
        jButton4.setText("SIMULAR");
        

        // SIMULACION SIMULACION SIMULACION SIMULACION SIMULACION SIMULACION SIMULACION SIMULACION SIMULACION SIMULACION SIMULACION SIMULACION SIMULACION SIMULACION SIMULACION
        ActionListener accion = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                juego.simulacionNPC();
                txtData.setText(juego.getJugador().getNombre() + " / ENERGÍA: " + juego.getJugador().getBacteriaJ().getEnergia() + " / VISIÓN: " + juego.getJugador().getBacteriaJ().getVision() + " / VELOCIDAD: " + juego.getJugador().getBacteriaJ().getVelocidad() + " / EDAD: " + juego.getJugador().getBacteriaJ().getEdad());
            }
        };

        jButton4.addActionListener(accion);


        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 565, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addContainerGap())
        );

        gamePAN.setBackground(new java.awt.Color(51, 0, 102));

        javax.swing.GroupLayout gamePANLayout = new javax.swing.GroupLayout(gamePAN);
        gamePAN.setLayout(gamePANLayout);
        gamePANLayout.setHorizontalGroup(
            gamePANLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 769, Short.MAX_VALUE)
        );
        gamePANLayout.setVerticalGroup(
            gamePANLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 397, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(gamePAN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(gamePAN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>                 

    // Variables declaration - do not modify                     
    private javax.swing.JPanel gamePAN;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel txtData;
    // End of variables declaration                   

    public void accionPresionarBoton(int i, int j){
        juego.determinarAccionJugador(i, j);
        actualizarDatosPantalla();
    }

    public void actualizarDatosPantalla(){
        txtData.setText(juego.getJugador().getNombre() + " / ENERGÍA: " + juego.getJugador().getBacteriaJ().getEnergia() + " / VISIÓN: " + juego.getJugador().getBacteriaJ().getVision() + " / VELOCIDAD: " + juego.getJugador().getBacteriaJ().getVelocidad() + " / EDAD: " + juego.getJugador().getBacteriaJ().getEdad());
    }

}
