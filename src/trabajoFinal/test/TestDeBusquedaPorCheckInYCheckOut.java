package trabajoFinal.test;

import static org.junit.Assert.*;

import java.util.List;

import org.joda.time.LocalTime;
import org.junit.Before;
import org.junit.Test;

import trabajoFinal.Busqueda;
import trabajoFinal.BusquedaPorCheckIn;
import trabajoFinal.BusquedaPorCheckOut;
import trabajoFinal.BusquedaPorNegacion;
import trabajoFinal.Hotel;

public class TestDeBusquedaPorCheckInYCheckOut extends TestSuperClass {
	
	Busqueda busquedaPorCheckIn;
	Busqueda busquedaPorCheckOut;
	Busqueda checkInALasCuatro;
	Busqueda checkOutALasCuatro;
	LocalTime seis;
	LocalTime doce;
	LocalTime cuatro;
	BusquedaPorNegacion busquedaNegadaIn;
	BusquedaPorNegacion busquedaNegadaOut;
	

	@Before
	public void setUp() throws Exception {
		super.setUp();
		this.seis = new LocalTime(18, 00);
		this.doce = new LocalTime(12, 00);
		this.cuatro = new LocalTime(16, 00);
		busquedaPorCheckIn = new BusquedaPorCheckIn(seis);
		busquedaPorCheckOut = new BusquedaPorCheckOut(doce);
		checkInALasCuatro = new BusquedaPorCheckIn(cuatro);
		checkOutALasCuatro = new BusquedaPorCheckOut(cuatro);
		busquedaNegadaIn = new BusquedaPorNegacion(checkInALasCuatro);
		busquedaNegadaOut = new BusquedaPorNegacion(checkOutALasCuatro);
	}
	
	@Test
	public void test() {
		assertEquals(this.seis, this.hotelContinental().getCheckIn());
	}

	@Test
	public void testBusquedaPorCheckInAplicaParaHotelContinental() {
		assertTrue(this.busquedaPorCheckIn.aplicaParaHotel(this.hotelContinental()));
	}

	@Test
	public void testBusquedaPorCheckOutAplicaParaHotelContinental() {
		assertTrue(this.busquedaPorCheckOut.aplicaParaHotel(this.hotelContinental()));
	}

	@Test
	public void testUnHotelConCheckInALasSeis() {
		this.sistema().agregarHotel(this.hotelContinental());
		this.sistema().agregarHotel(this.hotelSheraton());
		
		List<Hotel> h = this.sistema().buscar(busquedaPorCheckIn);
		assertEquals(1, h.size());
	}

	@Test
	public void testUnHotelConCheckOutALasDoce() {
		this.sistema().agregarHotel(this.hotelContinental());
		this.sistema().agregarHotel(this.hotelSheraton());
		
		List<Hotel> h = this.sistema().buscar(busquedaPorCheckOut);
		assertEquals(1, h.size());
	}

	@Test
	public void testNingunHotelConCheckInALasCuatro() {
		this.sistema().agregarHotel(this.hotelContinental());
		this.sistema().agregarHotel(this.hotelSheraton());
		
		List<Hotel> h = this.sistema().buscar(checkInALasCuatro);
		assertTrue(h.isEmpty());
	}

	@Test
	public void testNingunHotelConCheckOutALasCuatro() {
		this.sistema().agregarHotel(this.hotelContinental());
		this.sistema().agregarHotel(this.hotelSheraton());
		
		List<Hotel> h = this.sistema().buscar(checkOutALasCuatro);
		assertTrue(h.isEmpty());
	}

	@Test
	public void testDosHotelesConCheckInALasCuatroPorNegacion() {
		this.sistema().agregarHotel(this.hotelContinental());
		this.sistema().agregarHotel(this.hotelSheraton());
		
		List<Hotel> h = this.sistema().buscar(busquedaNegadaIn);
		assertEquals(2, h.size());
	}

	@Test
	public void testDosHotelesConCheckOutALasCuatroPorNegacion() {
		this.sistema().agregarHotel(this.hotelContinental());
		this.sistema().agregarHotel(this.hotelSheraton());
		
		List<Hotel> h = this.sistema().buscar(busquedaNegadaOut);
		assertEquals(2, h.size());
	}
}
