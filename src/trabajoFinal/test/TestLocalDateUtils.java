package trabajoFinal.test;

import static org.junit.Assert.assertEquals;

import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.Test;

import trabajoFinal.LocalDateUtils;

public class TestLocalDateUtils {
	
	private LocalDate diezDeEnero;
	private LocalDate veinteDeEnero;
	private LocalDateUtils utiles;
	
	@Before
	public void setUp(){
		this.diezDeEnero = new LocalDate(2000, 01, 10); 
		this.veinteDeEnero = new LocalDate(2000, 01, 20);
		this.utiles = new LocalDateUtils(); //para alcanzar el 100% del Coverage
	}

	@Test
	public void testFechasIntermedias() {
		int day = 10;
		for (LocalDate s : LocalDateUtils.fechasIntermedias(diezDeEnero, veinteDeEnero)) {
			assertEquals(s, new LocalDate(2000,01,day));
			day += 1;
		}
	}

}
