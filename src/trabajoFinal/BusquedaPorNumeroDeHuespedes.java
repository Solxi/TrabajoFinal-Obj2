package trabajoFinal;

import java.util.List;

public class BusquedaPorNumeroDeHuespedes extends Busqueda {
	
	private Integer numeroDeHuespedes;
	
	public BusquedaPorNumeroDeHuespedes (Integer numero){
		this.numeroDeHuespedes = numero;
	}

	@Override
	public boolean aplicaParaHotel(Hotel hotel) {
		List<Habitacion> habitaciones = hotel.getHabitaciones();
		Boolean aplica = false;
		for (Habitacion habitacion : habitaciones) {
			aplica = aplica | (habitacion.capacidadMaxima() >= this.numeroDeHuespedes);
		}
		return aplica;
	}
}
