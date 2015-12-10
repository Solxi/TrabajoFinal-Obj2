package trabajoFinal.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.Test;

import trabajoFinal.Habitacion;
import trabajoFinal.Hotelero;
import trabajoFinal.Servicio;

public class TestDeHotelero extends TestSuperClass {

	private Hotelero juan;
	private LocalDate seisDeOctubre;
	private LocalDate ochoDeOctubre;
	private List<Habitacion> habitacionesAOfertar;
	
	@Before
	public void setUp() throws Exception{
		super.setUp();
		seisDeOctubre = new LocalDate(2000, 10, 6);
		ochoDeOctubre = new LocalDate(2000, 10, 8);
		juan = new Hotelero("Juan", "123456", "conesa 2", "juan@obj.com", "42536393", "5555");
		habitacionesAOfertar = new ArrayList<Habitacion>();
		habitacionesAOfertar.add(this.habitacion01());
		habitacionesAOfertar.add(this.habitacion04());
	}
	
/*	@Test
	public void testDadoUnUsuarioQueConcretaUnaReservaEnviaYRecibeUnMailDeConfirmacion() {
		
	}
	
	@Test 
	public void testDadoUnUsuarioHoteleroReservarUnaHabitacion() throws Exception {
		this.juan.reservar(this.hotelContinental(), this.habitacion01(), seisDeOctubre, ochoDeOctubre);
		assertEquals( 1, this.habitacion01().esFechaReservada(ochoDeOctubre));
		assertEquals( 1, this.habitacion01().esFechaReservada(seisDeOctubre));
	}
	
	@Test
	public void testHoteleroOfertarHotel() {
		juan.ofertarHotel(this.hotelContinental(), 50.0, seisDeOctubre, ochoDeOctubre);
		assertEquals(1, this.habitacion01().getOfertas().size());
		assertEquals(1, this.habitacion02().getOfertas().size());
	}

	@Test
	public void testHoteleroOfertarTodosLosHoteles() {
		juan.agregarHotel(this.hotelContinental());
		juan.agregarHotel(this.hotelSheraton());
		juan.ofertarTodosLosHoteles(50.0, seisDeOctubre, ochoDeOctubre);
		assertEquals(1, this.habitacion01().getOfertas().size());
		assertEquals(1, this.habitacion02().getOfertas().size());
		assertEquals(1, this.habitacion03().getOfertas().size());
		assertEquals(1, this.habitacion04().getOfertas().size());
	}

	@Test
	public void testHoteleroOfertarHabitacionDeterminada() {
		juan.agregarHotel(this.hotelContinental());
		juan.agregarHotel(this.hotelSheraton());
		juan.ofertarHabitacion(this.habitacion03(), 50.0, seisDeOctubre, ochoDeOctubre);
		assertEquals(0, this.habitacion01().getOfertas().size());
		assertEquals(0, this.habitacion02().getOfertas().size());
		assertEquals(1, this.habitacion03().getOfertas().size());
		assertEquals(0, this.habitacion04().getOfertas().size());
	}
*/
	@Test
	public void testHoteleroNoOfertarHabitacionPorNoPertenecerAUnoDeSusHoteles() {
		juan.agregarHotel(this.hotelContinental());
		juan.ofertarHabitacion(this.habitacion03(), 50.0, seisDeOctubre, ochoDeOctubre);
		assertEquals(0, this.habitacion01().getOfertas().size());
		assertEquals(0, this.habitacion02().getOfertas().size());
		assertEquals(0, this.habitacion03().getOfertas().size());
		assertEquals(0, this.habitacion04().getOfertas().size());
	}

/*	@Test
	public void testHoteleroOfertarListaDeHabitaciones() {
		juan.agregarHotel(this.hotelContinental());
		juan.agregarHotel(this.hotelSheraton());
		juan.ofertarHabitaciones(habitacionesAOfertar, 50.0, seisDeOctubre, ochoDeOctubre);
		assertEquals(1, this.habitacion01().getOfertas().size());
		assertEquals(1, this.habitacion02().getOfertas().size());
		assertEquals(1, this.habitacion03().getOfertas().size());
		assertEquals(1, this.habitacion04().getOfertas().size());
	}
*/	
	@Test
	public void testHoteleroAgregarServicio() {
		Servicio wifi = new Servicio("wifi", "gratis", 0.0);
		juan.agregarServicioAHotel(wifi, this.hotelContinental());
		assertEquals(1, this.hotelContinental().getServicios().size());
	}

}
