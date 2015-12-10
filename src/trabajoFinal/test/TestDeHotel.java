package trabajoFinal.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import org.junit.Before;
import org.junit.Test;

import trabajoFinal.Oferta;
import trabajoFinal.Servicio;

public class TestDeHotel extends TestSuperClass {
	
	private Oferta ofertaDePrueba;
	private LocalDate diezDeMarzo;
	private LocalDate veinteDeMarzo;
	
	@Before
	public void setUp() throws Exception {
		super.setUp();
		diezDeMarzo    = new LocalDate(2015, 03, 10);
		veinteDeMarzo  = new LocalDate(2015, 03, 20);
		ofertaDePrueba = new Oferta(50.0, diezDeMarzo, veinteDeMarzo);
	}

	@Test
	public void testDadoUnHotelSuNombreEsSheraton() {
		assertEquals("Sheraton", this.hotelSheraton().getNombre()); //nombre de un hotel
	}

	@Test
	public void testDadoUnHotelAlQueSeLeAgreganDosHabitaciones() {
		this.hotelSheraton().agregarHabitacion(this.habitacion01());
		this.hotelSheraton().agregarHabitacion(this.habitacion02());
		assertEquals(2, this.hotelSheraton().getHabitaciones().size()); //habitaciones de un hotel
	}
	
	@Test
	public void testDadoUnHotelConCheckInDoceTreintaYCheckOutSeisTreinta() {
		LocalTime doceTreinta = new LocalTime(12, 30);
		LocalTime seisTreinta = new LocalTime(18, 30);
		assertEquals(doceTreinta, this.hotelSheraton().getCheckOut());
		assertEquals(seisTreinta, this.hotelSheraton().getCheckIn());
	}
	
	@Test
	public void testDadoUnHotelSeAgregaUnaOfertaAtodasSusHabitaciones(){
		this.hotelContinental().agregarHabitacion(this.habitacion01());
		this.hotelContinental().agregarHabitacion(this.habitacion02());
		this.hotelContinental().agregarOfertaATodasLasHabitaciones(ofertaDePrueba);
		assertEquals(1, this.habitacion01().getOfertas().size());
		assertEquals(1, this.habitacion02().getOfertas().size());
	}
	
	@Test
	public void testDadoUnHotelSeAgregaUnServicio(){
		Servicio wifi = new Servicio("wifi", "gratis", 0.0);
		this.hotelSheraton().agregarServicio(wifi);
		assertEquals(1, this.hotelSheraton().getServicios().size());
		assertEquals("wifi", this.hotelSheraton().getServicios().get(0).getNombre());
		assertEquals("gratis", this.hotelSheraton().getServicios().get(0).getDescripcion());
		assertEquals(new Double(0.0), this.hotelSheraton().getServicios().get(0).getPrecio());
	}

	@Test
	public void testDadoUnHotelSeAgregaUnaFormaDePago(){
		this.hotelSheraton().agregarFormaDePago("tarjeta visa");
		assertEquals(1, this.hotelSheraton().getFormasDePago().size());
	}

	@Test
	public void testDadoUnHotelConReservaEnUnaHabitacionLasFechasReservadasSonCorrectas() throws Exception {
		this.hotelSheraton().agregarHabitacion(this.habitacion01());
		this.hotelSheraton().agregarHabitacion(this.habitacion02());
		this.hotelSheraton().agregarHabitacion(this.habitacion03());
		this.hotelSheraton().reservarHabitacion(this.habitacion02(), diezDeMarzo, veinteDeMarzo);
		int dia = 10;
		for (LocalDate fecha : this.habitacion02().fechasReservadas()) {
			assertEquals( fecha, new LocalDate(2015, 03, dia));
			dia += 1;
		}
		assertTrue(this.habitacion01().fechasReservadas().isEmpty());
		assertTrue(this.habitacion03().fechasReservadas().isEmpty());
	}


}