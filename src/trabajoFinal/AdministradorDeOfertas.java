package trabajoFinal;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.LocalDate;

public class AdministradorDeOfertas {
	private List<Oferta> ofertas;
	
	public AdministradorDeOfertas(){
		this.ofertas= new ArrayList<Oferta>();
	}
	
	public Boolean esFechaOfertada(LocalDate fecha){
		Boolean esFechaOfertada = false;
		for(Oferta oferta : this.getOfertas()){
			esFechaOfertada = esFechaOfertada | oferta.fechasOfertadas().contains(fecha);
		}
		return esFechaOfertada;
	}
	
	public Boolean hayOfertaEntreLasFechas(LocalDate fechaDeInicio, LocalDate fechaDeFin){
		List<LocalDate> fechas = LocalDateUtils.fechasIntermedias(fechaDeInicio, fechaDeFin);
		Boolean hayOferta = false;
		for(LocalDate fecha : fechas){
			hayOferta = hayOferta | this.esFechaOfertada(fecha);
		}
		return hayOferta;
	}

	//se agrega la oferta nueva solo si no pisa a ninguna otra oferta
	public void agregarOferta(Oferta oferta){
		if(!this.hayOfertaEntreLasFechas(oferta.getFechaDeInicio(), oferta.getFechaDeFin())){
			this.getOfertas().add(oferta);
		}
	}

	//Por precondicion no debe haber mas de una oferta para la misma fecha. 
	//Contemplarlo al momento de crear una nueva oferta
	public Double precioDelDia(LocalDate fecha) {
		Double precio = 0.0;
		for (Oferta oferta : ofertas) {
			if(oferta.fechasOfertadas().contains(fecha)){
				precio += oferta.getDescuento();
			}
		}
		return precio;
	}
	
	public Double precioParaUnaEstadiaEnHabitacion (Habitacion habitacion, LocalDate fechaDeIngreso, LocalDate fechaDeSalida) {
		Double contador = 0.0;
		List<LocalDate> fechas = LocalDateUtils.fechasIntermedias(fechaDeIngreso, fechaDeSalida);
		for(LocalDate fecha : fechas){
			contador += habitacion.precioDelDia(fecha);
		}
		return contador;
	}

	public void quitarOferta(Oferta oferta){
		this.getOfertas().remove(oferta);
	}
	
	public void quitarTodasLasOfertas(){
		this.getOfertas().removeAll(this.getOfertas());
	}
	
	public List<Oferta> getOfertas() {
		return this.ofertas;
	}
}
