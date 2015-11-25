package trabajoFinal;

import org.joda.time.DateTime;

public class Habitacion {
	private Integer numero;
	private Double precioBase;
	private AdministradorDeOfertas administradosDeOfertas;
	private AdministradorDeReservas administradosDeReservas;
	//donde se inicializan los admins????????????????????
		
	public Habitacion(Integer numero, Double precio){
		this.numero = numero;
		this.precioBase = precio;
		this.administradosDeOfertas = new AdministradorDeOfertas();
		this.administradosDeReservas = new AdministradorDeReservas();
	}
	
	public Integer getNumero() { return numero;	}
	public Double getPrecioBase() {	return precioBase; }
	public void setPrecioBase(Double precioBase) { this.precioBase = precioBase; }
	
}
