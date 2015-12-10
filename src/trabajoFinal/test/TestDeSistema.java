package trabajoFinal.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import trabajoFinal.Hotelero;
import trabajoFinal.Servicio;
import trabajoFinal.Turista;

public class TestDeSistema extends TestSuperClass {
	
	@Mock Turista usuarioTurista;
	@Mock Hotelero usuarioHotelero;
	@Mock Servicio wifi;
	
	@Before
	public void setUp() throws Exception {
		super.setUp();
	}
	
	@Test
	public void testDadoUSistemaSeLeAgreganDosHoteles() {
		this.sistema().agregarHotel(this.hotelContinental());
		this.sistema().agregarHotel(this.hotelSheraton());
	//	assertEquals(2, this.sistema().getHoteles().size());
		assertEquals(2, this.sistema().getBuscador().getHoteles().size());
	}
	
	@Test
	public void testDadoUnSistemaConDosHoteles(){
		this.sistema().agregarHotel(this.hotelContinental());
		this.sistema().agregarHotel(this.hotelSheraton());
		assertEquals(2, this.sistema().getBuscador().getHoteles().size());
	}
	
	@Test
	public void testDadoUnSistemaSeLeAgregaUnUsuarioTurista(){
		this.sistema().agregarUsuario(usuarioTurista);
		assertEquals( 1, this.sistema().getUsuarios().size());
	}

	@Test
	public void testDadoUnSistemaSeLeAgregaUnUsuarioHotelero(){
		this.sistema().agregarUsuario(usuarioHotelero);
		assertEquals( 1, this.sistema().getUsuarios().size());
	}

	@Test
	public void testDadoUnSistemaSeLeAgregaUnServicio(){
		this.sistema().agregarServicio(wifi);
		assertEquals( 1, this.sistema().getServicios().size());
	}

}
