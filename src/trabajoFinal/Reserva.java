package trabajoFinal;

import java.util.List;

import org.joda.time.LocalDate;

public class Reserva {
	private Habitacion habitacion;
	private Hotel hotel;
	private Usuario usuario;
	private LocalDate fechaDeSalida;
	private LocalDate fechaDeLlegada;

	public Reserva(Habitacion habitacion, Hotel hotel, Usuario usuario, LocalDate fechaDeSalida, LocalDate fechaDeLlegada){
		this.setHabitacion(habitacion);
		this.setHotel(hotel);
		this.setUsuario(usuario);
		this.setFechaDeSalida(fechaDeSalida);
		this.setFechaDeLlegada(fechaDeLlegada);
	}
	
	/*public void reservarHabitacion() throws Exception{
		this.getHabitacion().reservar(this.fechaDeSalida, this.fechaDeLlegada);
	}*/
	
	public int numeroDeDiasDeAlojamiento(){
		return LocalDateUtils.fechasIntermedias(getFechaDeLlegada(), getFechaDeSalida()).size();
	}

	public boolean estaEnCursoActualmente(){
		Boolean estaEnCurso = false; 
		LocalDate fechaDeHoy = new LocalDate();
		List<LocalDate> fechas = LocalDateUtils.fechasIntermedias(getFechaDeSalida(), getFechaDeLlegada());
		for (LocalDate fecha : fechas) {
			estaEnCurso = estaEnCurso | (fecha == fechaDeHoy);
		}
		return estaEnCurso;
	}

	public Habitacion getHabitacion() 		{ return habitacion; } 
	public Hotel getHotel() 				{ return hotel; }
	public Usuario getUsuario() 			{ return usuario; }
	public LocalDate getFechaDeLlegada() 	{ return fechaDeLlegada; }
	public LocalDate getFechaDeSalida() 	{ return fechaDeSalida; }
	public String getCiudad()				{ return this.getHotel().getCiudad(); }
	public Object getCheckIn() 				{ return this.getHotel().getCheckIn(); }
	public Object getCheckOut() 			{ return this.getHotel().getCheckOut(); }
	
	public void setHabitacion(Habitacion habitacion) 			{ this.habitacion = habitacion;}
	public void setHotel(Hotel hotel) 							{ this.hotel = hotel; }
	public void setUsuario(Usuario usuario) 					{ this.usuario = usuario; }
	public void setFechaDeLlegada(LocalDate fechaDeLlegada) 	{ this.fechaDeLlegada = fechaDeLlegada; }
	public void setFechaDeSalida(LocalDate fechaDeSalida) 		{ this.fechaDeSalida = fechaDeSalida; }

}
