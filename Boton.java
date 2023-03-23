import javax.swing.*;

public class Boton extends JButton {
    Jugable jugable = null;

    public Boton() {
    }

    public Jugable getJugable() {
        return jugable;
    }

    public void setJugable(Jugable jugable) {
        this.jugable = jugable;
    }

    

}


