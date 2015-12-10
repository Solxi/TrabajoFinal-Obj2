package trabajoFinal.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import trabajoFinal.Habitacion;
import trabajoFinal.Hotel;
import trabajoFinal.Reserva;
import trabajoFinal.Turista;

public class TestDeTurista {

	private Turista turista;
	@Mock private Hotel hotel;
	@Mock private Reserva reserva1;
	@Mock private Reserva reserva2;
	@Mock private Habitacion habitacion;
	private LocalDate veinteDeAbril;
	private LocalDate veintidosDeAbri;
	
	@Before
	public void setUp(){
		MockitoAnnotations.initMocks(this);
		turista = new Turista("Carlos", "654321", "mitre 400", "carlos@obj2.com", "42563232", "3333");
	}
	
	@Test
	public void testDadoUnTuristaSePidenSusDatos() {
		assertEquals("Carlos", turista.getNombre());
		assertEquals("654321", turista.getDni());
		assertEquals("mitre 400", turista.getDireccion());
		assertEquals("carlos@obj2.com", turista.getMail());
		assertEquals("42563232", turista.getTelefono());
		assertEquals("3333", turista.getNumeroDeTarjeta());
	}
	
	@Test 
	public void testDadoUnUsuarioQueAgregaUnaReserva(){
		Reserva reserva = turista.crearReserva(hotel, habitacion, veinteDeAbril, veintidosDeAbri, turista);
		turista.agregarReserva(reserva);
		assertEquals( 1, turista.getReservas().size());
	}
	
	@Test
	public void testDadoUnUsuarioTuristaNoTieneHoteles(){
		assertTrue(this.turista.getHoteles().isEmpty());
	}
	
	@Test
	public void testDadoUnUsuarioQueTieneDosReservasHechas(){
		this.turista.agregarReserva(reserva1);
		this.turista.agregarReserva(reserva2);
		assertEquals( 2, this.turista.getReservas().size());
	}

	@Test
	public void testDadoUnUsuarioQueTieneUnaReservaEnQuilmes(){
		when(reserva1.getCiudad()).thenReturn("Quilmes");
		when(reserva2.getCiudad()).thenReturn("Buenos Aires");
		this.turista.agregarReserva(reserva1);
		this.turista.agregarReserva(reserva2);
		assertEquals( 2, this.turista.getReservas().size());
	}

	@Test
	public void testDadoUnUsuarioQueTieneUnaReservaEnQuilmesYOtraEnRosario(){
		when(reserva1.getCiudad()).thenReturn("Quilmes");
		when(reserva2.getCiudad()).thenReturn("Rosario");
		this.turista.agregarReserva(reserva1);
		this.turista.agregarReserva(reserva2);
		assertEquals( 2, this.turista.ciudadesConReservas().size());
		assertTrue( this.turista.ciudadesConReservas().contains("Quilmes"));
		assertTrue( this.turista.ciudadesConReservas().contains("Rosario"));
	}

/*	@Test
	public void testDadoUnTuristaQueHaceUnaReserva() throws Exception{
		turista.reservar(hotel, habitacion, veinteDeAbril, veintidosDeAbri);
	//	assertEquals( 1, turista.getReservas().size());
		assertTrue(habitacion.esFechaReservada(veinteDeAbril));
	//	assertTrue(habitacion.esFechaReservada(veinteDeAbril));
		assertTrue(habitacion.esFechaReservada(veintidosDeAbri));
	}
*/	

}
