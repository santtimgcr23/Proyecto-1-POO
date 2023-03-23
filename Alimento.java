import java.util.Random;

public class Alimento extends Jugable {
    boolean tipo;
    int size = 1;

    public Alimento(){
        Random r = new Random();
        this.tipo = r.nextBoolean();
        setSize();
    }

    public void setSize(){
        if (tipo){
            Random r = new Random();
            this.size = r.nextInt(6-1) + 1;
        }
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    
}
