package trabajoFinal.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import trabajoFinal.Habitacion;
import trabajoFinal.Hotel;
import trabajoFinal.Sistema;

public class TestDeHabitacion extends TestSuperClass{
	

	@Before
	public void setUp() throws Exception {
		super.setUp();
	}

	@Test
	public void test() {
		assertEquals("Sheraton", this.hotelSheraton().getNombre()); //nombre de un hotel
		assertTrue(this.habitacion04().getPrecioBase() == 100); //precio de habitacion
		assertEquals(2, this.hotelSheraton().getHabitaciones().size()); //habitaciones de un hotel
	
	}

}
