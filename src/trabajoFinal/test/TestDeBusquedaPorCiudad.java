package trabajoFinal.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import trabajoFinal.Busqueda;
import trabajoFinal.BusquedaPorCiudad;
import trabajoFinal.BusquedaPorNegacion;
import trabajoFinal.Hotel;

public class TestDeBusquedaPorCiudad extends TestSuperClass {
	
	private Busqueda buscarCiudadRosario;
	private Busqueda buscarCiudadBuenosAires;
	private Busqueda buscarCiudadQuilmes;
	private BusquedaPorNegacion busquedaNegada;
	
	@Before
	public void setUp() throws Exception {
		super.setUp();
		buscarCiudadRosario = new BusquedaPorCiudad("Rosario");
		buscarCiudadBuenosAires = new BusquedaPorCiudad("Bs.As");
		buscarCiudadQuilmes = new BusquedaPorCiudad("Quilmes");
		busquedaNegada = new BusquedaPorNegacion(buscarCiudadQuilmes);
	}

	@Test
	public void testUnSoloHotelEnRosario() {
		this.sistema().agregarHotel(this.hotelContinental());
		this.sistema().agregarHotel(this.hotelSheraton());
		List<Hotel> h = this.sistema().buscar(buscarCiudadRosario);
		assertEquals(1, h.size());
	}

	@Test
	public void testUnSoloHotelEnBuenosAires() {
		this.sistema().agregarHotel(this.hotelContinental());
		this.sistema().agregarHotel(this.hotelSheraton());
		List<Hotel> h = this.sistema().buscar(buscarCiudadBuenosAires);
		assertEquals(1, h.size());
	}

	@Test
	public void testNingunHotelEnQuilmes() {
		this.sistema().agregarHotel(this.hotelContinental());
		this.sistema().agregarHotel(this.hotelSheraton());
		List<Hotel> h = this.sistema().buscar(buscarCiudadQuilmes);
		assertTrue(h.isEmpty());
	}

	@Test
	public void testDosHotelesQueNoEstanEnQuilmes() {
		this.sistema().agregarHotel(this.hotelContinental());
		this.sistema().agregarHotel(this.hotelSheraton());
		List<Hotel> h = this.sistema().buscar(busquedaNegada);
		assertEquals(2, h.size());
	}
}
