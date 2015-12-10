package trabajoFinal;

import org.joda.time.LocalTime;

public class BusquedaPorCheckOut extends Busqueda {
	
	private LocalTime checkOut;
	
	public BusquedaPorCheckOut (LocalTime checkOut){
		this.checkOut = checkOut;
	}

	@Override
	public boolean aplicaParaHotel(Hotel hotel) {
		return (this.checkOut.equals(hotel.getCheckOut()));
	}
}
