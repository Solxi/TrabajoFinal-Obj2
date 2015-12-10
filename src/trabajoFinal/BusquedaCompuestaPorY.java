package trabajoFinal;

import java.util.ArrayList;
import java.util.List;

public class BusquedaCompuestaPorY extends Busqueda{
	
	private List<Busqueda> criterios;
	
	public BusquedaCompuestaPorY(){
		this.criterios = new ArrayList<Busqueda>();
	}

	public List<Busqueda> getCriterios() {
		return criterios;
	}

	public void agregarCriterio(Busqueda criterio) {
		this.getCriterios().add(criterio);
	}

	@Override
	public boolean aplicaParaHotel(Hotel hotel) {
		Boolean aplica = true;
		for (Busqueda criterio : criterios) {
			aplica = aplica & (criterio.aplicaParaHotel(hotel));
		}
		return aplica;
	}

}
