package trabajoFinal.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import trabajoFinal.Habitacion;
import trabajoFinal.Hotel;
import trabajoFinal.Reserva;
import trabajoFinal.Usuario;

public class TestDeReserva extends TestSuperClass{
	
		  private Reserva reserva;
		  private Reserva reservaEnCurso;
		  private LocalDate cincoDeOctubre;
		  private LocalDate sieteDeOctubre;
		  private LocalDate cuatroDeDiciembre;
		  private LocalDate doceDeDiciembre;
	@Mock private Habitacion habitacion;
	@Mock private Hotel hotel;
	@Mock private Usuario usuario;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	//	super.setUp();
		this.reserva = new Reserva(habitacion, hotel, usuario, cincoDeOctubre, sieteDeOctubre);
		this.reservaEnCurso = new Reserva(habitacion, hotel, usuario, cuatroDeDiciembre, doceDeDiciembre);
	}
	
	@Test
	public void testDadaUnaReservaConTresDiasDeAlojamiento() {
		assertTrue(this.reservaEnCurso.estaEnCursoActualmente());
	}

	@Test
	public void testDadaUnaReservaEnCursoActualmente() {
		assertEquals(3, this.reserva.numeroDeDiasDeAlojamiento());
	}

}
