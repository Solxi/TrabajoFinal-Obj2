package trabajoFinal;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.LocalDate;

public class AdministradorDeReservas {
	private List<Reserva> reservas;

	
	public AdministradorDeReservas() {
		this.reservas = new ArrayList<Reserva>();
	}

	public void agregarReserva(Reserva reserva){
		this.getReservas().add(reserva);
	}

	public List<Reserva> getReservas() { return this.reservas; }
	
	public List<Reserva> reservasFuturas() {
		LocalDate fechaActual = new LocalDate();
		List<Reserva> reservasFuturas = new ArrayList<Reserva>();
		for (Reserva reserva : this.getReservas()) {
			if (reserva.getFechaDeSalida().isAfter(fechaActual)) { 
				reservasFuturas.add(reserva); 
			}
		}
		return reservasFuturas;
	}

	public List<Reserva> reservasEnCiudad(String ciudad) {
		List<Reserva> reservasEnCiudad = new ArrayList<Reserva>();
		for (Reserva reserva : this.getReservas()) {
			if (ciudad == reserva.getCiudad()) {
				reservasEnCiudad.add(reserva);
			}
		}
		return reservasEnCiudad;
	}

	public List<String> cuidadesConReservas(){
		 List<String> ciudadesReservadas= new ArrayList<String>();
		 for (Reserva reserva : this.getReservas()){
			 ciudadesReservadas.add(reserva.getCiudad());
		 }
		 return ciudadesReservadas; 
	}
	
	public List<Reserva> reservasDentroDe(Integer numeroDeDias){
		LocalDate diaDeHoy= new LocalDate();
		List<Reserva> reservasDentroDe = new ArrayList<Reserva>();
		for (Reserva reserva : this.getReservas()){
			if(reserva.getCheckIn().equals(diaDeHoy.plusDays(numeroDeDias))){
				reservasDentroDe.add(reserva);
			}
		}
		return reservasDentroDe;
	}
	
	public List<Reserva> reservasActuales(){
		List<Reserva> reservasDeHoy = new ArrayList<Reserva>();
		for(Reserva reserva : this.getReservas()){
			if(reserva.estaEnCursoActualmente()){
				reservasDeHoy.add(reserva);
			}
		}
		return reservasDeHoy;
	}
}