package trabajoFinal;

public class BusquedaPorCiudad extends Busqueda {
	
	private String ciudad;
	
	public BusquedaPorCiudad(String ciudad){
		this.ciudad = ciudad;
	}

	@Override
	public boolean aplicaParaHotel(Hotel hotel) {
		return (this.ciudad == hotel.getCiudad());
	}

}
