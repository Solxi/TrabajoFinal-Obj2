package trabajoFinal;

import java.util.List;


public class Turista extends Usuario{
				
	public Turista(String nombre, String dni, String direccion, String mail, String telefono, String numeroDeTarjeta) {
		super(nombre, dni, direccion, mail, telefono, numeroDeTarjeta);
	}

	public List<Reserva> reservas(){
		return this.getAdministradorDeReservas().getReservas();
	}

	public List<Reserva> reservasEnCiudad(String ciudad){
		return this.getAdministradorDeReservas().reservasEnCiudad(ciudad);
	}
	
	public List<String> ciudadesConReservas(){
		return this.getAdministradorDeReservas().cuidadesConReservas();
	}
}
