import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Boton extends JButton implements ActionListener{
    Jugable jugable = null;
    String tipo;
    boolean eliminable = false;

    public Boton() {
        
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
}


