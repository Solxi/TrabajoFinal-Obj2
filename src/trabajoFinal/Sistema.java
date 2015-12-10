package trabajoFinal;

import java.util.ArrayList;
import java.util.List;

public class Sistema {
	private List<Usuario> usuarios;
	private List<Servicio> serviciosComunes;
	private Buscador buscador;
	
	public Sistema(){
		this.usuarios = new ArrayList<Usuario>();
		this.buscador = new Buscador();
		this.serviciosComunes = new ArrayList<Servicio>();
	}
	
	public void agregarHotel(Hotel hotel){
		this.getHoteles().add(hotel);
		this.buscador.agregarHotel(hotel);
	}

	public void agregarUsuario(Usuario usuario){
		this.getUsuarios().add(usuario);
	}

	public void agregarServicio(Servicio servicio){
		this.getServicios().add(servicio);
	}

	
	//devuelve la lista de hoteles del sistema
	public List<Hotel> getHoteles() { 
		List<Hotel> hoteles = new ArrayList<Hotel>();
		for (Usuario usuario : this.getUsuarios()) {
			hoteles.addAll(usuario.getHoteles());
		}
		return hoteles; 
	}
		
	public List<Hotel> buscar(Busqueda criterioDeBusqueda) {
		return this.buscador.buscar(criterioDeBusqueda);
	}
	
	public Buscador getBuscador()			{ return this.buscador; }
	public List<Usuario> getUsuarios()		{ return this.usuarios; }
	public List<Servicio> getServicios()	{ return this.serviciosComunes; }

}
