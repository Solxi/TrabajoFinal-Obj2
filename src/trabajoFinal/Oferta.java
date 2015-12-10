package trabajoFinal;

import java.util.List;

import org.joda.time.LocalDate;

public class Oferta {
	
	LocalDate fechaDeInicio;
	LocalDate fechaDeFin;
	Double descuento;
	
	public Oferta(Double descuento, LocalDate fechaDeInicio, LocalDate fechaDeFin){
		this.fechaDeInicio = fechaDeInicio;
		this.fechaDeFin = fechaDeFin;
		this.descuento = descuento;
	}

	public List<LocalDate> fechasOfertadas() {
		return LocalDateUtils.fechasIntermedias(this.fechaDeInicio, this.fechaDeFin);
	}
	
	//el descuento representa una cantidad de dinero que se resta al precio base de la habitacion
	// cuando un hotelero crea una oferta este debe ser el valor que quiere restarle al precio base
	//puede ser un porcentaje de descuento pero lo tratamos como un valor concreto que se descuenta.
	public Double getDescuento() 		{ return this.descuento; }							
	public LocalDate getFechaDeInicio() { return this.fechaDeInicio; }
	public LocalDate getFechaDeFin() 	{ return this.fechaDeFin; }
}
