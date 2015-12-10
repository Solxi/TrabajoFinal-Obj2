package trabajoFinal;

import java.util.ArrayList;
import java.util.List;

public class Buscador {
	
	private List<Hotel> hoteles;

	public Buscador() {
		this.hoteles = new ArrayList<Hotel>();
	}

	public List<Hotel> buscar(Busqueda criterioDeBusqueda) {
		List<Hotel> hotelesQueAplican = new ArrayList<Hotel>();
		for (Hotel hotel : hoteles) {
			if(criterioDeBusqueda.aplicaParaHotel(hotel)){
				hotelesQueAplican.add(hotel);
			}
		}
		return hotelesQueAplican;
	}

	public void agregarHotel(Hotel hotel) {
		this.hoteles.add(hotel);		
	}
	
	public List<Hotel> getHoteles()	{ return this.hoteles; }
}
