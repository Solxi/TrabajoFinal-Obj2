package trabajoFinal.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import trabajoFinal.AdministradorDeReservas;
import trabajoFinal.Reserva;

public class TestAdministradorDeReservas  extends TestSuperClass{
	
	@Mock private Reserva reserva1;
	@Mock private Reserva reserva2;
	@Mock private Reserva reserva3;
		  private LocalDate unoDeNoviembre;
		  private LocalDate nueveDeDiciembre;
		  private LocalDate quinceDeDiciembre;
		  private AdministradorDeReservas administradorDeReservas;

	@Before
	public void setUp() throws Exception {
		super.setUp();
		MockitoAnnotations.initMocks(this);
		LocalDate unoDeNoviembre = new LocalDate(2015, 11, 01);
		LocalDate nueveDeDiciembre = new LocalDate(2015, 12, 9);
		LocalDate quinceDeDiciembre = new LocalDate(2015, 12, 15);
		administradorDeReservas = new AdministradorDeReservas();
	}

	@Test
	public void testDadoUnAdministradorDeReservasSeAgreganDosReservas() {
		this.administradorDeReservas.agregarReserva(reserva1);	
		this.administradorDeReservas.agregarReserva(reserva2);
		assertEquals( 2, this.administradorDeReservas.getReservas().size());
	}
	
	@Test
	public void testDePruebaDeFechasIsAfter(){
		assertTrue(quinceDeDiciembre.isAfter(unoDeNoviembre));
	}

	@Test
	public void testDadoUnAdministradorDeReservasConUnaSolaReservaFutura() {
		when(reserva1.getFechaDeSalida()).thenReturn(unoDeNoviembre);
		when(reserva2.getFechaDeSalida()).thenReturn(nueveDeDiciembre);
		when(reserva3.getFechaDeSalida()).thenReturn(quinceDeDiciembre);
		this.administradorDeReservas.agregarReserva(reserva1);	
		this.administradorDeReservas.agregarReserva(reserva2);
		this.administradorDeReservas.agregarReserva(reserva2);
		assertEquals( 1, this.administradorDeReservas.reservasFuturas().size());
		assertEquals( reserva3, this.administradorDeReservas.reservasFuturas().get(0));
	}

	@Test
	public void testDadoUnAdministradorDeReservasConUnaReservaEnRosario() {
		when(reserva1.getCiudad()).thenReturn("Buenos Aires");
		when(reserva2.getCiudad()).thenReturn("Rosario");
		when(reserva3.getCiudad()).thenReturn("Quilmes");
		this.administradorDeReservas.agregarReserva(reserva1);	
		this.administradorDeReservas.agregarReserva(reserva2);
		this.administradorDeReservas.agregarReserva(reserva3);
		assertEquals( 1, this.administradorDeReservas.reservasEnCiudad("Rosario").size());
		assertEquals( "Rosario", this.administradorDeReservas.reservasEnCiudad("Rosario").get(0).getCiudad());
	}

	@Test
	public void testDadoUnAdministradorDeReservasConUnaSolaReservaDentroDeSeisDias() {
		when(reserva1.getFechaDeSalida()).thenReturn(unoDeNoviembre);
		when(reserva2.getFechaDeSalida()).thenReturn(nueveDeDiciembre);
		when(reserva3.getFechaDeSalida()).thenReturn(quinceDeDiciembre);
		this.administradorDeReservas.agregarReserva(reserva1);	
		this.administradorDeReservas.agregarReserva(reserva2);
		this.administradorDeReservas.agregarReserva(reserva2);
		assertEquals( 1, this.administradorDeReservas.reservasDentroDe(6).size());
		assertEquals( reserva3, this.administradorDeReservas.reservasFuturas().get(0));
	}

	@Test
	public void testDadoUnAdministradorDeReservasConUnaSolaReservaActual() {
		when(reserva1.getFechaDeSalida()).thenReturn(unoDeNoviembre);
		when(reserva1.getFechaDeLlegada()).thenReturn(unoDeNoviembre);
		when(reserva2.getFechaDeSalida()).thenReturn(unoDeNoviembre);
		when(reserva2.getFechaDeLlegada()).thenReturn(quinceDeDiciembre);
		when(reserva3.getFechaDeSalida()).thenReturn(quinceDeDiciembre);
		when(reserva3.getFechaDeLlegada()).thenReturn(quinceDeDiciembre);
		this.administradorDeReservas.agregarReserva(reserva1);	
		this.administradorDeReservas.agregarReserva(reserva2);
		this.administradorDeReservas.agregarReserva(reserva2);
		assertEquals( 1, this.administradorDeReservas.reservasActuales().size());
	//	assertEquals( reserva2, this.administradorDeReservas.reservasFuturas().get(0));
	}
}