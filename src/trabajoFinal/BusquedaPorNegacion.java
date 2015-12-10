package trabajoFinal;

public class BusquedaPorNegacion extends Busqueda {
	
	private Busqueda criterio;
	
	public BusquedaPorNegacion(Busqueda criterio) {
		this.criterio = criterio;
	}
	
	public Busqueda getCriterio(){
		return this.criterio;
	}

	@Override
	public boolean aplicaParaHotel(Hotel hotel) {
		return !(this.getCriterio().aplicaParaHotel(hotel));
	}

}
