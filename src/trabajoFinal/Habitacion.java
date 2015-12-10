package trabajoFinal;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.LocalDate;

public class Habitacion {
	
	private Integer numero;
	private Double precioBase;
	private AdministradorDeOfertas administradorDeOfertas;
	private AdministradorDeDisponibilidad administradorDeDisponibilidad;
	private List<Cama> camas;
	private List<Servicio> serviciosIncluidos;
		
	public Habitacion(Integer numero, Double precio){
		this.numero = numero;
		this.precioBase = precio;
		this.administradorDeOfertas = new AdministradorDeOfertas();
		this.administradorDeDisponibilidad = new AdministradorDeDisponibilidad();
		this.camas = new ArrayList<Cama>();
		this.serviciosIncluidos = new ArrayList<Servicio>();
	}
	
	
	public void agregarCama(Cama cama){
		this.getCamas().add(cama);
	}

	public void agregarServicio(Servicio servicio){
		this.getServiciosIncluidos().add(servicio);
	}
	
	public Integer capacidadMaxima() {
		Integer contador = 0;
		for (Cama cama : camas) {
			contador = contador + cama.capacidad();
		}
		return contador;
	}

	//***DELEGACIONES***//
	public List<LocalDate> fechasReservadas() {
		return this.administradorDeDisponibilidad.getFechasReservadas();
	}
	
	public boolean esFechaReservada(LocalDate unaFecha) {
		return this.administradorDeDisponibilidad.esFechaReservada(unaFecha); 
	}

	public void reservar(LocalDate fechaDeSalida, LocalDate fechaDeLlegada) throws Exception {
		this.administradorDeDisponibilidad.reservar(fechaDeSalida, fechaDeLlegada);
	}
	
	public boolean esFechaOfertada(LocalDate fecha) {
		return this.administradorDeOfertas.esFechaOfertada(fecha);
	}

	public void agregarOferta(Oferta oferta){
		this.administradorDeOfertas.agregarOferta(oferta);
	}
	
	public Double precioDelDia(LocalDate fecha) {
		return (this.getPrecioBase() - this.administradorDeOfertas.precioDelDia(fecha));
	}

	public Double precioParaUnaEstadia (LocalDate fechaDeIngreso, LocalDate fechaDeSalida) {
		return this.administradorDeOfertas.precioParaUnaEstadiaEnHabitacion(this, fechaDeIngreso, fechaDeSalida);
	}

	public Integer getNumero() 		 	{ return numero; }
	public List<Cama> getCamas()	 	{ return this.camas; }
	public Double getPrecioBase() 	 	{ return precioBase; }
	public List<Oferta> getOfertas() 	{ return this.administradorDeOfertas.getOfertas(); }
	public List<Servicio> getServiciosIncluidos() { return this.serviciosIncluidos; }
}
