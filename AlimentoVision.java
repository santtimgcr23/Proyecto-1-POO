import java.awt.Color;

public class AlimentoVision extends Alimento{
    @Override
    public Bacteria comerEsteObjeto(Bacteria bacteriaQueAtaca, Aumentos aumentos){

        int energiaPorAgregar = this.getSize() * aumentos.getCambiosEnergia();
        int visionPorAgregar = this.getSize() * aumentos.getCambiosVision();
        
        int nuevaEnergia = energiaPorAgregar + bacteriaQueAtaca.getEnergia();
        int nuevaVision = visionPorAgregar + bacteriaQueAtaca.getVision();
        
        bacteriaQueAtaca.setEnergia(nuevaEnergia);
        bacteriaQueAtaca.setVision(nuevaVision);

        return bacteriaQueAtaca;
    }

    @Override
    public Color colorCasilla(){
        Color colorCasilla = Color.YELLOW;
        return colorCasilla;
    }

    @Override
    public Jugable objetoPorColocar(){
        Jugable jugable = new AlimentoVision();
        return jugable;
    }
}
