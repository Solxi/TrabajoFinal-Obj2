package trabajoFinal.test;

import static org.junit.Assert.*;

import java.time.LocalTime;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import trabajoFinal.Habitacion;
import trabajoFinal.Hotel;
import trabajoFinal.Sistema;

public class TestSuperClass {

	private Sistema sistema;
	private Hotel hotelSheraton;
	private Hotel hotelContinental;
	private Habitacion habitacion01;
	private Habitacion habitacion02;
	private Habitacion habitacion03;
	private Habitacion habitacion04;
	
	private LocalTime checkIn = null;
	private LocalTime checkOut = null;


	@Before
	public void setUp() throws Exception {
		this.hotelSheraton = new Hotel("Sheraton", "Argentina", "Bs.As", "lavalle 133", "sheraton@gmail.com", 5, checkIn, checkOut);
		this.hotelContinental = new Hotel("Continental", "Argentina", "Rosario", "ruiz 35", "continental@gmail.com", 3, checkIn, checkOut);
		this.habitacion01 = new Habitacion(01, 20.00);
		this.habitacion02 = new Habitacion(01, 50.00);
		this.habitacion03 = new Habitacion(01, 80.00);
		this.habitacion04 = new Habitacion(01, 100.00);
		
		this.hotelContinental.agregarHabitacion(habitacion01);
		this.hotelContinental.agregarHabitacion(habitacion02);
		this.hotelSheraton.agregarHabitacion(habitacion03);
		this.hotelSheraton.agregarHabitacion(habitacion04);
	}

	public Hotel hotelSheraton() { return hotelSheraton; }
	public Hotel hotelContinental() { return hotelContinental; }
	public Sistema sistema() { return sistema; }
	public Habitacion habitacion01() { return habitacion01; }
	public Habitacion habitacion02() { return habitacion02; }
	public Habitacion habitacion03() { return habitacion03; }
	public Habitacion habitacion04() { return habitacion04; }
	 

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
