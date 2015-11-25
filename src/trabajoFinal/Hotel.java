package trabajoFinal;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;

public class Hotel {
	private String nombre;
	private String pais;
	private String ciudad;
	private String direccion;
	private String contacto;
	private Integer categoria;
	private LocalTime checkIn;
	private LocalTime checkOut;
		
	List<String> formasDePago;
	List<Habitacion> habitaciones;
	
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
		this.habitaciones = new ArrayList<Habitacion>();
	}
	
	public void agregarHabitacion(Habitacion habitacion){
		this.habitaciones.add(habitacion);
	}

	public String getNombre() {	return nombre;	}

	public void setNombre(String nombre) {	this.nombre = nombre;	}

	public List<Habitacion> getHabitaciones() {	return this.habitaciones;	}
	
	public String getPais() {	return pais;	}

	public void setPais(String pais) {	this.pais = pais;	}

	public String getCiudad() {	return ciudad;	}

	public void setCiudad(String ciudad) {	this.ciudad = ciudad;	}

	public String getDireccion() {	return direccion;	}

	public void setDireccion(String direccion) {	this.direccion = direccion;	}

	public String getContacto() {	return contacto;	}

	public void setContacto(String contacto) {	this.contacto = contacto;	}

	public Integer getCategoria() {	return categoria;	}

	public void setCategoria(Integer categoria) {	this.categoria = categoria;	}

	public LocalTime getCheckIn() {	return checkIn;	}

	public void setCheckIn(LocalTime checkIn) {	this.checkIn = checkIn;	}
	
	public LocalTime getCheckOut() {	return checkOut;	}
	
	public void setCheckOut(LocalTime checkOut) {	this.checkOut = checkOut;	}

}
