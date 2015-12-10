package trabajoFinal;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.LocalDate;

public class Hotelero extends Usuario {

	private List<Hotel> hoteles;
	
	public Hotelero(String nombre, String dni, String direccion, String mail, String telefono, String numeroDeTarjeta) {
		super(nombre, dni, direccion, mail, telefono, numeroDeTarjeta);
		this.hoteles = new ArrayList<Hotel>();
	}

	public void agregarHotel(Hotel hotel){
		this.getHoteles().add(hotel);
	}

	public void agregarServicioAHotel(Servicio servicio, Hotel hotel){
		hotel.agregarServicio(servicio);
	}
	
	public Oferta crearOferta(Double descuento, LocalDate fechaDeInicio, LocalDate fechaDeFin){
		return (new Oferta(descuento, fechaDeInicio, fechaDeFin));
	}
	
	//oferta todas las habitaciones de un hotel determinado. Se asume que el hotel le pertenece
	public void ofertarHotel(Hotel hotel, Double descuento, LocalDate fechaDeInicio, LocalDate fechaDeFin){
		Oferta oferta = this.crearOferta(descuento, fechaDeInicio, fechaDeFin);
		hotel.agregarOfertaATodasLasHabitaciones(oferta);
	}
	
	//oferta todas las habitaciones de todos los hoteles
	public void ofertarTodosLosHoteles(Double descuento, LocalDate fechaDeInicio, LocalDate fechaDeFin){
		for(Hotel hotel : this.getHoteles()){
			this.ofertarHotel(hotel, descuento, fechaDeInicio, fechaDeFin);
		}
	}
	
	//por precondicion se asume que la habitacion existe en alguno de los hoteles del hotelero
	public void ofertarHabitacion(Habitacion habitacion, Double descuento, LocalDate fechaDeInicio, LocalDate fechaDeFin){
		Oferta oferta = this.crearOferta(descuento, fechaDeInicio, fechaDeFin);
		for(Hotel hotel : this.getHoteles()){
			if(hotel.getHabitaciones().contains(habitacion)){
				habitacion.agregarOferta(oferta);
			}
		}
	}
	
	//oferta una lista de habitaciones sin importar a que hotel pertenezcan
	public void ofertarHabitaciones(List<Habitacion> habitaciones, Double descuento, LocalDate fechaDeInicio, LocalDate fechaDeFin){
		for(Habitacion habitacion : habitaciones){
			this.ofertarHabitacion(habitacion, descuento, fechaDeInicio, fechaDeFin);
		}
	}
	
	public List<Reserva> reservasActuales(){
		return this.getAdministradorDeReservas().reservasActuales();
	}
	
	public List<Reserva> reservasDentroDe(Integer numeroDeDias){
		return this.getAdministradorDeReservas().reservasDentroDe(numeroDeDias);
	}

	public List<Hotel> getHoteles() 							{ return this.hoteles; }
	public AdministradorDeReservas getAdministradorDeReservas() { return this.getAdministradorDeReservas(); }

	
}
