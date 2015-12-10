package trabajoFinal;

public class Servicio {
	
	private String nombre;
	private String descripcion;
	private Double precio;
	
	public Servicio(String nombre, String descripcion, Double precio){
		this.nombre = nombre;
		this.precio = precio;
		this.descripcion = descripcion;
	}
	
	public String getNombre() 		{ return this.nombre; }
	public String getDescripcion() 	{ return this.descripcion; }
	public Double getPrecio() 		{ return this.precio; }
}
