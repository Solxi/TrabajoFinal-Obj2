package trabajoFinal;

import org.joda.time.LocalTime;

public class BusquedaPorCheckIn extends Busqueda {

	private LocalTime checkIn;
	
	public BusquedaPorCheckIn (LocalTime checkIn){
		this.checkIn = checkIn;
	}

	@Override
	public boolean aplicaParaHotel(Hotel hotel) {
		return (this.checkIn.equals(hotel.getCheckIn()));
	}
}
