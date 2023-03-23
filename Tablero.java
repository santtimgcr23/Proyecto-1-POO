import java.awt.Color;
import javax.swing.border.LineBorder;

public class Tablero{
    private Boton[][] mapa;
    
    public Tablero(){
        this.mapa = new Boton[50][50];
        crearMapa();
    }

    public void crearMapa(){
        for (int i = 0; i < mapa.length; i++){
            for (int j = 0; j < mapa[i].length; j++){
            mapa[i][j] = new Boton();
            mapa[i][j].setBackground(new java.awt.Color(153, 255, 153));
            mapa[i][j].setSize(1,2);
            mapa[i][j].setBorder(new LineBorder(Color.BLACK));
            }
        }
    }

    public Boton[][] getMapa() {
        return mapa;
    }

    public void setMapa(Boton[][] mapa) {
        this.mapa = mapa;
    }

    

}