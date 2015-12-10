package trabajoFinal.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.Test;

import trabajoFinal.AdministradorDeOfertas;
import trabajoFinal.Hotelero;
import trabajoFinal.Oferta;
import trabajoFinal.Usuario;

public class TestAdministradorDeOfertas extends TestSuperClass{
	
	private Oferta ofertaDePrueba;
	private Oferta ofertaDePrueba2;
	private LocalDate unoDeEnero;
	private LocalDate cincoDeEnero;
	private LocalDate diezDeEnero;
	private LocalDate quinceDeEnero;
	private LocalDate tresDeFebrero;
	private LocalDate cincoDeFebrero;
	private AdministradorDeOfertas adminDeOfertas;
	
	
	@Before
	public void setUp() throws Exception{
		super.setUp();
		this.unoDeEnero = new LocalDate(2000,01,01);
		this.cincoDeEnero = new LocalDate(2000,01,05);
		this.diezDeEnero = new LocalDate(2000,01,10);
		this.quinceDeEnero = new LocalDate(2000,01,15);
		this.tresDeFebrero = new LocalDate(2000,02,03);
		this.cincoDeFebrero = new LocalDate(2000,02,05);
		this.ofertaDePrueba = new Oferta(10.0, unoDeEnero, cincoDeEnero);
		this.ofertaDePrueba2 = new Oferta(5.0, tresDeFebrero, cincoDeFebrero);
		this.adminDeOfertas = new AdministradorDeOfertas();
	}
	
	@Test
	public void testAdministradorDeOfertasAgregarOferta() {
		this.adminDeOfertas.agregarOferta(ofertaDePrueba);
		assertEquals(1, this.adminDeOfertas.getOfertas().size());
	}

	@Test
	public void testAdministradorDeOfertasNoAgregarOferta() {
		this.adminDeOfertas.agregarOferta(ofertaDePrueba);
		this.adminDeOfertas.agregarOferta(ofertaDePrueba);
		assertEquals(1, this.adminDeOfertas.getOfertas().size());
	}

	@Test
	public void testAdministradorDeOfertasEsFechaOfertada() {
		this.adminDeOfertas.agregarOferta(ofertaDePrueba);
		assertTrue(this.adminDeOfertas.esFechaOfertada(cincoDeEnero));
	}

	@Test
	public void testAdministradorDeOfertasNoEsFechaOfertada() {
		this.adminDeOfertas.agregarOferta(ofertaDePrueba);
		assertFalse(this.adminDeOfertas.esFechaOfertada(quinceDeEnero));
	}

	@Test
	public void testAdministradorDeOfertasQuitarOferta() {
		this.adminDeOfertas.agregarOferta(ofertaDePrueba);
		assertEquals(1, this.adminDeOfertas.getOfertas().size());
		this.adminDeOfertas.quitarOferta(ofertaDePrueba);
		assertTrue(this.adminDeOfertas.getOfertas().isEmpty());
	}

	@Test
	public void testAdministradorDeOfertasQuitarTodasLasOfertas() {
		this.adminDeOfertas.agregarOferta(ofertaDePrueba);
		this.adminDeOfertas.agregarOferta(ofertaDePrueba2);
		assertEquals(2, this.adminDeOfertas.getOfertas().size());
		this.adminDeOfertas.quitarTodasLasOfertas();
		assertTrue(this.adminDeOfertas.getOfertas().isEmpty());
	}

	@Test
	public void testAdministradorDeOfertasHayOfertaEntreLasFechas() {
		this.adminDeOfertas.agregarOferta(ofertaDePrueba);
		assertTrue(this.adminDeOfertas.hayOfertaEntreLasFechas(unoDeEnero, diezDeEnero));
	}

	@Test
	public void testAdministradorDeOfertasNoHayOfertaEntreLasFechas() {
		this.adminDeOfertas.agregarOferta(ofertaDePrueba);
		assertFalse(this.adminDeOfertas.hayOfertaEntreLasFechas(tresDeFebrero, cincoDeFebrero));
	}
	
	@Test
	public void testAdministradorDeOfetasPrecioParaUnaEstadiaSinOferta() {
		assertEquals(this.adminDeOfertas.precioParaUnaEstadiaEnHabitacion(this.habitacion01(), unoDeEnero, cincoDeEnero), new Double(100.0));
	}

	@Test
	public void testAdministradorDeOfetasPrecioParaUnaEstadiaConOfertaTodosLosDias() {
		this.habitacion04().agregarOferta(ofertaDePrueba);
		assertEquals(this.adminDeOfertas.precioParaUnaEstadiaEnHabitacion(this.habitacion04(), unoDeEnero, cincoDeEnero), new Double(450.0));
	}

	@Test
	public void testAdministradorDeOfetasPrecioParaUnaEstadiaConOfertaAlgunosDias() {
		this.habitacion02().agregarOferta(ofertaDePrueba);
		assertEquals(this.adminDeOfertas.precioParaUnaEstadiaEnHabitacion(this.habitacion02(), unoDeEnero, diezDeEnero), new Double(450.0));
	}
}
