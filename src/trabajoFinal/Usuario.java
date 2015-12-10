package trabajoFinal;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.LocalDate;

public abstract class Usuario {
	private String nombre;
	private String dni;
	private String direccion;
	private String mail;
	private String telefono;
	private String numeroDeTarjeta;
	private AdministradorDeReservas administradorDeReservas;
	
	public Usuario(String nombre, String dni, String direccion, String mail, String telefono, String numeroDeTarjeta){
		this.setNombre(nombre);
		this.setDni(dni);
		this.setDireccion(direccion);
		this.setMail(mail);
		this.setTelefono(telefono);
		this.setNumeroDeTarjeta(numeroDeTarjeta);
		this.administradorDeReservas = new AdministradorDeReservas();
	}
	
	public void reservar(Hotel hotel, Habitacion habitacion, LocalDate fechaDeSalida, LocalDate fechaDeLlegada) throws Exception{
		Reserva reserva = this.crearReserva(hotel, habitacion, fechaDeSalida, fechaDeLlegada, this);
		this.agregarReserva(reserva);
		habitacion.reservar(fechaDeSalida, fechaDeLlegada);
		this.enviarMailsDeConfirmacion(this, hotel, reserva);
	}
	
	public List<Reserva> getReservas() {
		return this.getAdministradorDeReservas().getReservas(); 
	}
	
	public List<Reserva> reservasFuturas(){
		return this.getAdministradorDeReservas().reservasFuturas();
	}
	
	public void agregarReserva(Reserva reserva){
		this.getAdministradorDeReservas().agregarReserva(reserva);
	}
	
	public Reserva crearReserva(Hotel hotel, Habitacion habitacion, LocalDate fechaDeLlegada, LocalDate fechaDeSalida, Usuario usuario) {
		Reserva reserva = new Reserva(habitacion, hotel, usuario, fechaDeSalida, fechaDeLlegada);
		return reserva;
	}
	
	public void cancelarReserva(Reserva reserva){
		this.getReservas().remove(reserva);
	}
	
	public void enviarMailsDeConfirmacion(Usuario usuario, Hotel hotel, Reserva reserva){
		EnviadorDeMails enviador = new EnviadorDeMails();
		enviador.enviarConfirmacionDeReserva(usuario, hotel, reserva);
	}
	
	public String getDni() 					{ return dni; }
	public String getMail() 				{ return mail; }
	public String getNombre()				{ return nombre; }
	public String getTelefono() 			{ return telefono; }
	public String getDireccion() 			{ return direccion; }
	public List<Hotel> getHoteles() 		{ return new ArrayList<Hotel>(); } //lista vacia para el caso de los usuarios turistas
	public String getNumeroDeTarjeta()		{ return numeroDeTarjeta; }
	public AdministradorDeReservas getAdministradorDeReservas() { return this.administradorDeReservas; }
	
	public void setDni(String dni) 							{ this.dni = dni; }
	public void setMail(String mail) 						{ this.mail = mail; }
	public void setNombre(String nombre) 					{ this.nombre = nombre; }
	public void setTelefono(String telefono) 				{ this.telefono = telefono; }
	public void setDireccion(String direccion) 				{ this.direccion = direccion; }
	public void setNumeroDeTarjeta(String numeroDeTarjeta) 	{ this.numeroDeTarjeta = numeroDeTarjeta; }

}
