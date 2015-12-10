package trabajoFinal.test;

import org.joda.time.LocalTime;
import org.junit.Before;

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
	
	private LocalTime checkInSheraton = new LocalTime(18, 30);
	private LocalTime checkOutSheraton = new LocalTime(12, 30);
	private LocalTime checkInContinental = new LocalTime(18, 00);
	private LocalTime checkOutContinental = new LocalTime(12, 00);


	@Before
	public void setUp() throws Exception {
		this.sistema = new Sistema();
		this.hotelSheraton = new Hotel("Sheraton", "Argentina", "Bs.As", "lavalle 133", "sheraton@gmail.com", 5, checkInSheraton, checkOutSheraton);
		this.hotelContinental = new Hotel("Continental", "Argentina", "Rosario", "ruiz 35", "continental@gmail.com", 3, checkInContinental, checkOutContinental);
		this.habitacion01 = new Habitacion(01, 20.00);
		this.habitacion02 = new Habitacion(02, 50.00);
		this.habitacion03 = new Habitacion(03, 80.00);
		this.habitacion04 = new Habitacion(04, 100.00);
	}

	public Hotel hotelSheraton() 	 { return hotelSheraton; }
	public Hotel hotelContinental()  { return hotelContinental; }
	public Sistema sistema() 		 { return sistema; }
	public Habitacion habitacion01() { return habitacion01; }
	public Habitacion habitacion02() { return habitacion02; }
	public Habitacion habitacion03() { return habitacion03; }
	public Habitacion habitacion04() { return habitacion04; }
	 
}
