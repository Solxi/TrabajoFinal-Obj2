package trabajoFinal;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.LocalDate;

public class AdministradorDeDisponibilidad {
	public List<LocalDate> fechasReservadas;

	public AdministradorDeDisponibilidad() {
		this.fechasReservadas = new ArrayList<LocalDate>();
	}

	public boolean esFechaReservada(LocalDate unaFecha){
		return this.getFechasReservadas().contains(unaFecha); 
	}
	
	public void reservar(LocalDate fechaDeSalida, LocalDate fechaDeLlegada) throws Exception {
		if(this.puedeReservar(fechaDeSalida, fechaDeLlegada)){
			fechasReservadas.addAll(LocalDateUtils.fechasIntermedias(fechaDeSalida, fechaDeLlegada));
		} else {
			throw new Exception("No es posible reservar en las fechas solicitadas");
		}
	}

	//si ninguna de las fechas intermedias esta reservada. Con al menos una fecha reservada ya no se puede reservar.
	public boolean puedeReservar(LocalDate fechaDeSalida, LocalDate fechaDeLlegada){
		Boolean puedeReservar = true;
		List<LocalDate> fechasAReservar = LocalDateUtils.fechasIntermedias(fechaDeSalida, fechaDeLlegada);
		for(LocalDate fecha : fechasAReservar){
			puedeReservar = puedeReservar & !this.esFechaReservada(fecha);
		}
		return puedeReservar;
	}
	
	public List<LocalDate> getFechasReservadas() { return fechasReservadas; }
	
}
