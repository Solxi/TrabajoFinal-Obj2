package trabajoFinal.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.Test;

import trabajoFinal.AdministradorDeDisponibilidad;

public class TestAdministradorDeDisponibilidad extends TestSuperClass{
	
	private AdministradorDeDisponibilidad administradorDeDisponibilidad;

	private LocalDate fechaDeSalida;
	private LocalDate fechaDeLlegada;
	private LocalDate quinceDeEnero;
	private LocalDate nueveDeEnero;
	private LocalDate treintaDeEnero;
	
	@Before
	public void setUp() throws Exception{
		super.setUp();
		administradorDeDisponibilidad = new AdministradorDeDisponibilidad();
		
		fechaDeSalida  = new LocalDate(2000, 01, 10);
		fechaDeLlegada = new LocalDate(2000, 01, 20);
		quinceDeEnero  = new LocalDate(2000, 01, 15);
		nueveDeEnero   = new LocalDate(2000, 01, 9);
		treintaDeEnero = new LocalDate(2000, 01, 30);
	}
	
	@Test
	public void testAdministradorDeDisponibilidadElNueveDeEneroNoEsFechaReservada() throws Exception{
		this.administradorDeDisponibilidad.reservar(fechaDeSalida, fechaDeLlegada);
		assertFalse(this.administradorDeDisponibilidad.esFechaReservada(nueveDeEnero));
	}

	@Test
	public void testAdministradorDeDisponibilidadElQuinceDeEneroEsFechaReservada() throws Exception{
		this.administradorDeDisponibilidad.reservar(fechaDeSalida, fechaDeLlegada);
		assertTrue(this.administradorDeDisponibilidad.esFechaReservada(quinceDeEnero));
	}

	
	@Test
	public void testAdministradorDeDisponibilidadReservarDelDiezAlVeinteDeEnero() throws Exception{
		this.administradorDeDisponibilidad.reservar(fechaDeSalida, fechaDeLlegada);
		int dia = 10;
		for (LocalDate fecha : this.administradorDeDisponibilidad.getFechasReservadas()) {
			assertEquals( fecha, new LocalDate(2000, 01, dia));
			dia += 1;
		}
	}

	@Test 
	public void testAdministradorDeDisponibilidadPuedeReservarDelNueveAlQuinceDeEnero() {
		assertTrue(this.administradorDeDisponibilidad.puedeReservar(nueveDeEnero, quinceDeEnero));
	}

	@Test
	public void testAdministradorDeDisponibilidadReservadoDelNueveAlQuinceDeEneroNoPuedeReservarDelDiezAlVeinte() throws Exception{
		this.administradorDeDisponibilidad.reservar(nueveDeEnero, quinceDeEnero);
		assertFalse(this.administradorDeDisponibilidad.puedeReservar(fechaDeSalida, fechaDeLlegada));
	}

	@Test(expected = Exception.class) 
	public void testAdministradorDeDisponibilidadReservadoDelDiezAlVeinteDeEneroNoReservaDel9AlQuinceDeEnero() throws Exception{
		this.administradorDeDisponibilidad.reservar(fechaDeSalida, fechaDeLlegada);
		this.administradorDeDisponibilidad.reservar(nueveDeEnero, quinceDeEnero);
	}

	@Test 
	public void testAdministradorDeDisponibilidadSeReservaDel9Al10DeEneroYDelVeinteAl30DeEnero() throws Exception{
		this.administradorDeDisponibilidad.reservar(nueveDeEnero, fechaDeSalida);
		this.administradorDeDisponibilidad.reservar(quinceDeEnero, treintaDeEnero);
		assertTrue(this.administradorDeDisponibilidad.esFechaReservada(fechaDeLlegada));
		assertTrue(this.administradorDeDisponibilidad.esFechaReservada(nueveDeEnero));
	}
	
	

}
	
	
