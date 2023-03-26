import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Boton extends JButton implements ActionListener{
    Jugable jugable = null;

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
        System.out.println("el pepeeeeeeeee");
    }
}


