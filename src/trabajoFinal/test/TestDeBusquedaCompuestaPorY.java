package trabajoFinal.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.joda.time.LocalTime;
import org.junit.Before;
import org.junit.Test;

import trabajoFinal.Busqueda;
import trabajoFinal.BusquedaCompuestaPorY;
import trabajoFinal.BusquedaPorCheckIn;
import trabajoFinal.BusquedaPorCiudad;
import trabajoFinal.BusquedaPorNegacion;
import trabajoFinal.Hotel;

public class TestDeBusquedaCompuestaPorY extends TestSuperClass{

	private BusquedaCompuestaPorY busquedaComp;
	private Busqueda porCiudad;
	private Busqueda porCheckIn;
	private LocalTime checkIn;
	BusquedaPorNegacion busquedaNegada;
	
	@Before
	public void setUp() throws Exception {
		super.setUp();
		checkIn = new LocalTime(18, 30);
		porCheckIn = new BusquedaPorCheckIn(checkIn);
		porCiudad = new BusquedaPorCiudad("Bs.As");
		busquedaComp = new BusquedaCompuestaPorY();
		busquedaNegada = new BusquedaPorNegacion(busquedaComp);
	}
	
	@Test
	public void testAgregarCriterio(){
		busquedaComp.agregarCriterio(porCheckIn);
		busquedaComp.agregarCriterio(porCiudad);
		assertEquals(2, busquedaComp.getCriterios().size());
	}
	
	@Test
	public void testHotelContinentalAplicaParaLaBusqueda() {
		busquedaComp.agregarCriterio(porCheckIn);
		busquedaComp.agregarCriterio(porCiudad);
		assertFalse(busquedaComp.aplicaParaHotel(this.hotelContinental()));
		assertTrue(busquedaComp.aplicaParaHotel(this.hotelSheraton()));
	}

	@Test
	public void testUnHoteleCumple() {
		busquedaComp.agregarCriterio(porCheckIn);
		busquedaComp.agregarCriterio(porCiudad);
		this.sistema().agregarHotel(this.hotelContinental());
		this.sistema().agregarHotel(this.hotelSheraton());
		List<Hotel> h = this.sistema().buscar(busquedaComp);
		assertEquals(1, h.size());
		assertEquals("Sheraton", h.get(0).getNombre());
	}

	@Test
	public void testNingunHotelCumplePorNegacion() {
		busquedaComp.agregarCriterio(porCheckIn);
		busquedaComp.agregarCriterio(porCiudad);
		this.sistema().agregarHotel(this.hotelContinental());
		this.sistema().agregarHotel(this.hotelSheraton());
		List<Hotel> h = this.sistema().buscar(busquedaNegada);
		assertEquals(1, h.size());
		assertEquals("Continental", h.get(0).getNombre());
	}
}
