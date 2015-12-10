package trabajoFinal.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.joda.time.LocalTime;
import org.junit.Before;
import org.junit.Test;

import trabajoFinal.Busqueda;
import trabajoFinal.BusquedaCompuestaPorO;
import trabajoFinal.BusquedaPorCheckIn;
import trabajoFinal.BusquedaPorCiudad;
import trabajoFinal.BusquedaPorNegacion;
import trabajoFinal.Hotel;

public class TestDeBusquedaCompuestaPorO extends TestSuperClass {

	private BusquedaCompuestaPorO busquedaComp;
	private Busqueda porCiudad;
	private Busqueda porCheckIn;
	private LocalTime checkIn;
	private BusquedaPorNegacion busquedaNegada;
	
	@Before
	public void setUp() throws Exception {
		super.setUp();
		checkIn = new LocalTime(18, 30);
		porCheckIn = new BusquedaPorCheckIn(checkIn);
		porCiudad = new BusquedaPorCiudad("Rosario");
		busquedaComp = new BusquedaCompuestaPorO();
		busquedaNegada = new BusquedaPorNegacion(busquedaComp);
	}
	
	@Test
	public void testAgregarCriterio(){
		busquedaComp.agregarCriterio(porCheckIn);
		busquedaComp.agregarCriterio(porCiudad);
		assertEquals(2,busquedaComp.getCriterios().size());
	}
	
	@Test
	public void testHotelContinentalAplicaParaLaBusqueda() {
		busquedaComp.agregarCriterio(porCheckIn);
		busquedaComp.agregarCriterio(porCiudad);
		assertTrue(busquedaComp.aplicaParaHotel(this.hotelContinental()));
		assertTrue(busquedaComp.aplicaParaHotel(this.hotelSheraton()));
	}

	@Test
	public void testDosHotelesCumplen() {
		busquedaComp.agregarCriterio(porCheckIn);
		busquedaComp.agregarCriterio(porCiudad);
		this.sistema().agregarHotel(this.hotelContinental());
		this.sistema().agregarHotel(this.hotelSheraton());
		List<Hotel> h = this.sistema().buscar(busquedaComp);
		assertEquals(2, h.size());
	}

	@Test
	public void testNingunHotelCumplePorNegacion() {
		busquedaComp.agregarCriterio(porCheckIn);
		busquedaComp.agregarCriterio(porCiudad);
		this.sistema().agregarHotel(this.hotelContinental());
		this.sistema().agregarHotel(this.hotelSheraton());
		List<Hotel> h = this.sistema().buscar(busquedaNegada);
		assertTrue(h.isEmpty());
	}
}
