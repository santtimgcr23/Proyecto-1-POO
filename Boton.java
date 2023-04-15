import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Boton extends JButton implements ActionListener{
    Jugable jugable = null;
    int x;
    int y;
    String tipo = "VACIO";
    boolean seTieneQueVer = false;

    public Boton(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Jugable getJugable() {
        return jugable;
    }

    public void setJugable(Jugable jugable) {
        this.jugable = jugable;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    public String getTipo() {
        return tipo;
    }

    public void pintarDeSuColor(){
        if (seTieneQueVer){
            if (tipo == "NPC"){
                setBackground(Color.BLUE);
            }
            else if (tipo == "J"){
                setBackground(Color.MAGENTA);
            }
            else if (tipo == "AVI"){
                setBackground(Color.YELLOW);
            }
            else if (tipo == "AVE"){
                setBackground(Color.CYAN);
            }
            else{
                setBackground(new java.awt.Color(153, 255, 153));
            }
        }
        else {
            setBackground(Color.BLACK);
        }
    }

    public void bacterizar(Jugable bacteria, int i, int j, Boton[][] mapa){
        jugable = bacteria;
        setBackground(Color.BLUE);
        mapa[i][j].setJugable(null);
        mapa[i][j].setBackground(new java.awt.Color(153, 255, 153));
    }

    public void setDefault(){
        setJugable(null);
        setBackground(new java.awt.Color(153, 255, 153));
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isSeTieneQueVer() {
        return seTieneQueVer;
    }

    public void setSeTieneQueVer(boolean seTieneQueVer) {
        this.seTieneQueVer = seTieneQueVer;
    }
}


