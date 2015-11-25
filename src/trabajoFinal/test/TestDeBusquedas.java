package trabajoFinal.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import trabajoFinal.Habitacion;
import trabajoFinal.Hotel;
import trabajoFinal.Sistema;

public class TestDeBusquedas extends TestSuperClass{
	
	@Before
	public void setUp() throws Exception {
		super.setUp();
	}

	@Test
	public void test() {
		assertEquals("Sheraton", this.hotelSheraton().getNombre());
	}

}
