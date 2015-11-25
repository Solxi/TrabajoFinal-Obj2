package trabajoFinal;

import java.util.List;

public class BusquedaCompuestaPorO extends Busqueda{
	
	private List<Busqueda> criterios;

	public List<Busqueda> getCriterios() {
		return criterios;
	}

	public void setCriterios(List<Busqueda> criterios) {
		this.criterios = criterios;
	}
}
