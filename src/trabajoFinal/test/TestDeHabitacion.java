package trabajoFinal.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import trabajoFinal.Cama;
import trabajoFinal.Oferta;
import trabajoFinal.Servicio;

public class TestDeHabitacion extends TestSuperClass{
	
	@Mock private Cama camaSimple;
	@Mock private Cama camaDoble;
	@Mock private Servicio wifi;
		  
	private Oferta ofertaDePrueba;
	private LocalDate unoDeEnero;
	private LocalDate cincoDeEnero;
	private LocalDate diezDeEnero;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		super.setUp();
		
		this.unoDeEnero = new LocalDate(2000,01,01);
		this.cincoDeEnero = new LocalDate(2000,01,05);
		this.diezDeEnero = new LocalDate(2000,01,10);

		this.ofertaDePrueba = new Oferta(10.0, unoDeEnero, cincoDeEnero);
	}

	@Test
	public void testDadaUnaHabitacionSuPrecioEs100() {
		assertEquals(new Double(100.0), this.habitacion04().getPrecioBase()); //precio de habitacion
	}

	@Test
	public void testDadaUnaHabitacionSuNumeroEs4() {
		assertEquals(new Integer(4), this.habitacion04().getNumero());
	}

	@Test
	public void testDadaUnaHabitacionSeAgreganDosCamas() {
		this.habitacion01().agregarCama(camaSimple);
		this.habitacion01().agregarCama(camaDoble);
		assertEquals(2, this.habitacion01().getCamas().size()); //numero de habitaciones
	}
	
	@Test
	public void testDadaUnaHabitacionConUnaCamaSimpleYUnaDobleSuCapacidadEsTres() {
		when(camaSimple.capacidad()).thenReturn(1);
		when(camaDoble.capacidad()).thenReturn(2);
		this.habitacion01().agregarCama(camaSimple);
		this.habitacion01().agregarCama(camaDoble);
		assertEquals(new Integer(3), this.habitacion01().capacidadMaxima()); //capacidad maxima
	}

	@Test
	public void testDadaUnaHabitacionSeLeAgregaUnaOferta() {
		this.habitacion02().agregarOferta(ofertaDePrueba);
		assertEquals(1, this.habitacion02().getOfertas().size());
	}

	@Test
	public void testDadaUnaHabitacionSeLeAgregaUnServicio(){
		this.habitacion03().agregarServicio(wifi);
		assertEquals( 1, this.habitacion03().getServiciosIncluidos().size());
	}
	
	@Test
	public void testPrecioDeHabitacionElDiaDiezDeEneroSinOferta() {
		assertEquals(new Double(20.00), this.habitacion01().precioDelDia(diezDeEnero));
	}

	@Test
	public void testDadaUnaHabitacionReservadaElDiaCincoDeEnero() {
		this.habitacion01().agregarOferta(ofertaDePrueba);
		assertTrue(this.habitacion01().esFechaOfertada(cincoDeEnero));
	}
	
	@Test
	public void testPrecioDeHabitacionElDiaCincoDeEneroConOferta() {
		this.habitacion01().agregarOferta(ofertaDePrueba);
		assertEquals(new Double(10.00), this.habitacion01().precioDelDia(cincoDeEnero));
	}

	@Test
	public void testDadaUnaHabitacionSuPrecioParaUnaEstadiaSinOfertaEs100() {
		assertEquals(new Double(100.0), this.habitacion01().precioParaUnaEstadia(unoDeEnero, cincoDeEnero));
	}
	
	@Test
	public void testDadaUnaHabitacionSuPrecioParaUnaEstadiaConOfertaTodosLosDiasEs450() {
		this.habitacion04().agregarOferta(ofertaDePrueba);
		assertEquals(new Double(450.0), this.habitacion04().precioParaUnaEstadia(unoDeEnero, cincoDeEnero));
	}
	
	@Test
	public void testDadaUnaHabitacionSuPrecioParaUnaEstadiaConOfertaAlgunosDiasEs450() {
		this.habitacion02().agregarOferta(ofertaDePrueba);
		assertEquals(new Double(450.0), this.habitacion02().precioParaUnaEstadia(unoDeEnero, diezDeEnero));
	}
	
	@Test
	public void testDadaUnaHabitacionConFechasReservadasCorrectasDelUnoAlDiezDeEnero() throws Exception{
		this.habitacion03().reservar(unoDeEnero, diezDeEnero);
		int dia = 1;
		for (LocalDate fecha : this.habitacion01().fechasReservadas()) {
			assertEquals( fecha, new LocalDate(2000, 01, dia));
			dia += 1;
		}
	}

	@Test
	public void testDadaUnaHabitacionDondeElCincoDeEneroEsFechaReservada() throws Exception{
		this.habitacion01().reservar(unoDeEnero, diezDeEnero);
		assertTrue(this.habitacion01().esFechaReservada(cincoDeEnero));
	}
	
	@Test
	public void testDadaUnaHabitacionDondeElUnoDeEneroNoEsFechaReservada() throws Exception {
		this.habitacion01().reservar(cincoDeEnero, diezDeEnero);
		assertFalse(this.habitacion01().esFechaReservada(unoDeEnero));
	}
}
