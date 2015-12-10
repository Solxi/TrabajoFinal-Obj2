package trabajoFinal;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.LocalDate;
import org.joda.time.LocalTime;

public class Hotel {
	private String nombre;
	private String pais;
	private String ciudad;
	private String direccion;
	private String contacto;
	private Integer categoria;
	private LocalTime checkIn;
	private LocalTime checkOut;
		
	private List<String> formasDePago;
	private List<Servicio> servicios;
	private List<Habitacion> habitaciones;
	
	public Hotel (String nombre, String pais, String ciudad,String direccion, String contacto, Integer categoria, LocalTime checkIn,
			LocalTime checkOut){
		this.setNombre(nombre);
		this.setPais(pais);
		this.setCiudad(ciudad);
		this.setDireccion(direccion);
		this.setContacto(contacto);
		this.setCategoria(categoria);
		this.setCheckIn(checkIn);
		this.setCheckOut(checkOut);
		this.formasDePago = new ArrayList<String>();
		this.servicios = new ArrayList<Servicio>();
		this.habitaciones = new ArrayList<Habitacion>();
	}

	public void agregarServicio(Servicio servicio) {
		this.getServicios().add(servicio);
	}
	
	public void agregarHabitacion(Habitacion habitacion){
		this.getHabitaciones().add(habitacion);
	}

	public void agregarFormaDePago(String formaDePago){
		this.getFormasDePago().add(formaDePago);
	}

	public void agregarOfertaATodasLasHabitaciones(Oferta oferta) {
		for (Habitacion habitacion : this.getHabitaciones()) {
			habitacion.agregarOferta(oferta);
		}
	}
	
//PROBAR PARA QUE PUEDA DEVOLVER LAS HABITACIONES DISPONIBLES PARA UNAS FECHAS O UNAS ESTADIAS...
/*	public List<Habitacion> habitacionesDisponiblesParaUnaEstadia(){
		List<Habitacion> habitacionesDisponibles = new ArrayList<Habitacion>();
		for(Habitacion habitacion : this.getHabitaciones()){
			if(habitacion.estaDisponible())
		}
	}
*/
	public void reservarHabitacion(Habitacion habitacion, LocalDate fechaDeLlegada, LocalDate fechaDeSalida) throws Exception {
		Integer indice = this.getHabitaciones().indexOf(habitacion);
		this.getHabitaciones().get(indice).reservar(fechaDeLlegada, fechaDeSalida);
	}

	public String getPais() 	   				{ return pais; }
	public String getCiudad() 	   				{ return ciudad; }
	public String getNombre() 					{ return nombre; }
	public String getContacto()    				{ return contacto; }
	public String getDireccion()   				{ return direccion; }
	public LocalTime getCheckIn()  				{ return checkIn; }
	public Integer getCategoria()  				{ return categoria; }
	public LocalTime getCheckOut() 				{ return checkOut; }
	public List<Servicio> getServicios()		{ return servicios; } 
	public List<String> getFormasDePago()		{ return formasDePago; }
	public List<Habitacion> getHabitaciones() 	{ return habitaciones; }
	
	public void setPais(String pais) 			{ this.pais = pais;	}
	public void setNombre(String nombre) 		{ this.nombre = nombre;	}
	public void setCiudad(String ciudad) 		{ this.ciudad = ciudad;	}
	public void setContacto(String contacto) 	{ this.contacto = contacto;	}
	public void setCheckIn(LocalTime checkIn)   { this.checkIn = checkIn; }
	public void setDireccion(String direccion)  { this.direccion = direccion; }
	public void setCategoria(Integer categoria) { this.categoria = categoria; }
	public void setCheckOut(LocalTime checkOut) { this.checkOut = checkOut; }

}
