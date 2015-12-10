package trabajoFinal.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import trabajoFinal.BusquedaPorNegacion;
import trabajoFinal.BusquedaPorNumeroDeHuespedes;
import trabajoFinal.Cama;
import trabajoFinal.CamaDoble;
import trabajoFinal.CamaSimple;
import trabajoFinal.Hotel;

public class TestDeBusquedaPorNroDeHuespedes extends TestSuperClass {

	BusquedaPorNumeroDeHuespedes busquedaPorNro;
	BusquedaPorNegacion busquedaNegada;
	Cama camaSimple;
	Cama camaDoble;
	
	@Before
	public void setUp() throws Exception{
		super.setUp();
		busquedaPorNro = new BusquedaPorNumeroDeHuespedes(2);
		busquedaNegada = new BusquedaPorNegacion(busquedaPorNro);
		camaSimple = new CamaSimple();
		camaDoble = new CamaDoble();
	}
	
	@Test
	public void testDadoUnHotelConHabitacionesParaDos() {
		this.habitacion01().agregarCama(camaSimple);
		this.habitacion02().agregarCama(camaDoble);
		this.habitacion03().agregarCama(camaSimple);
		this.hotelContinental().agregarHabitacion(this.habitacion01());
		this.hotelContinental().agregarHabitacion(this.habitacion02());
		this.hotelContinental().agregarHabitacion(this.habitacion03());
		assertTrue(this.busquedaPorNro.aplicaParaHotel(this.hotelContinental()));
	}

	@Test
	public void testDadoUnHotelSinHabitacionesParaDos() {
		this.habitacion01().agregarCama(camaSimple);
		this.habitacion02().agregarCama(camaSimple);
		this.habitacion03().agregarCama(camaSimple);
		this.hotelContinental().agregarHabitacion(this.habitacion01());
		this.hotelContinental().agregarHabitacion(this.habitacion02());
		this.hotelContinental().agregarHabitacion(this.habitacion03());
		assertFalse(this.busquedaPorNro.aplicaParaHotel(this.hotelContinental()));
	}

	@Test
	public void testDadoUnSistemaSoloUnHotelAplicaParaDos() {
		this.habitacion01().agregarCama(camaSimple);
		this.habitacion02().agregarCama(camaSimple);
		this.habitacion03().agregarCama(camaSimple);
		this.habitacion04().agregarCama(camaDoble);
		this.hotelContinental().agregarHabitacion(this.habitacion01());
		this.hotelContinental().agregarHabitacion(this.habitacion02());
		this.hotelContinental().agregarHabitacion(this.habitacion03());
		this.hotelSheraton().agregarHabitacion(this.habitacion04());
		
		this.sistema().agregarHotel(this.hotelContinental());
		this.sistema().agregarHotel(this.hotelSheraton());
		List<Hotel> h = this.sistema().buscar(busquedaPorNro);
		assertEquals(1, (h.size()));
		assertEquals("Sheraton", h.get(0).getNombre());
	}

	@Test
	public void testDadoUnHotelSinHabitacionesParaDosPorNegacion() {
		this.habitacion01().agregarCama(camaSimple);
		this.habitacion02().agregarCama(camaSimple);
		this.habitacion03().agregarCama(camaSimple);
		this.hotelContinental().agregarHabitacion(this.habitacion01());
		this.hotelContinental().agregarHabitacion(this.habitacion02());
		this.hotelContinental().agregarHabitacion(this.habitacion03());
		assertTrue(this.busquedaNegada.aplicaParaHotel(this.hotelContinental()));
	}
	
	@Test
	public void testDadoUnSistemaSoloUnHotelNoAplicaParaDosPorNegacion() {
		this.habitacion01().agregarCama(camaSimple);
		this.habitacion02().agregarCama(camaSimple);
		this.habitacion03().agregarCama(camaSimple);
		this.habitacion04().agregarCama(camaDoble);
		this.hotelContinental().agregarHabitacion(this.habitacion01());
		this.hotelContinental().agregarHabitacion(this.habitacion02());
		this.hotelContinental().agregarHabitacion(this.habitacion03());
		this.hotelSheraton().agregarHabitacion(this.habitacion04());
		
		this.sistema().agregarHotel(this.hotelContinental());
		this.sistema().agregarHotel(this.hotelSheraton());
		List<Hotel> h = this.sistema().buscar(busquedaNegada);
		assertEquals(1, (h.size()));
		assertEquals("Continental", h.get(0).getNombre());
	}
}
