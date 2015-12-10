package trabajoFinal;

public class EnviadorDeMails {
		
	/* Esta clase hace referencia a una interface que se encargue del env�o de mails de confirmaci�n al usuario y al hotel.
	Se utiliza una clase en lugar de la interface para poder responder por los mensajes que se necesiten, 
	aunque los mismos no tengan implementaci�n y as� poder ejecutar los test sin problemas */
	
	public void enviarMailAHotel(Hotel hotel, Reserva reserva){}
	public void enviarMailAUsuario(Usuario usuario, Reserva reserva){}
	
	public void enviarConfirmacionDeReserva(Usuario usuario, Hotel hotel, Reserva reserva){
		this.enviarMailAHotel(hotel, reserva);
		this.enviarMailAUsuario(usuario, reserva);
	}
}
