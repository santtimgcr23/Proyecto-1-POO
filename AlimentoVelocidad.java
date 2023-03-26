import java.awt.Color;

public class AlimentoVelocidad extends Alimento {
    public Bacteria comerEsteObjeto(Bacteria bacteriaQueAtaca, Aumentos aumentos){
        int energiaPorAgregar = this.getSize() * aumentos.getCambiosEnergia();
        int velocidadPorAgregar = this.getSize() * aumentos.getCambiosVelocidad();
        
        int nuevaEnergia = energiaPorAgregar + bacteriaQueAtaca.getEnergia();
        int nuevaVelocidad = velocidadPorAgregar + bacteriaQueAtaca.getVelocidad();
        
        bacteriaQueAtaca.setEnergia(nuevaEnergia);
        bacteriaQueAtaca.setVelocidad(nuevaVelocidad);

        return bacteriaQueAtaca;
    }

    @Override
    public Color colorCasilla(){
        Color colorCasilla = Color.YELLOW;
        return colorCasilla;
    }

    @Override
    public Jugable objetoPorColocar(){
        Jugable jugable = new AlimentoVelocidad();
        return jugable;
    }
}