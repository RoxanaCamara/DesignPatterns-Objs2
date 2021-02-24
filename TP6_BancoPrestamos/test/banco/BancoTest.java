package banco;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.when;
import creditos.CreditoHipotecario;
import creditos.CreditoPersonal;

class BancoTest {

	Banco b;
	@Mock CreditoPersonal cp;
	@Mock CreditoHipotecario ch;
	
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
		b = new Banco();
		/*when(ch.getMonto()).thenReturn(60000);
		when(cp.getMonto()).thenReturn(60000);
		when(cp.estaAprobado()).thenReturn(true);
		when(ch.estaAprobado()).thenReturn(true);*/
	
	}

	@Test
	public void testRecibirCredirHipotecarioSolicitudAprobada() {
		when(ch.estaAprobado()).thenReturn(true);
		b.recibirSolicitud(ch);
		assertEquals(b.getCreditos().size(), 1);
	}
	
	@Test
	public void testRecibirCredirHipotecarioSolicitudNoAprobada() {
		b.recibirSolicitud(ch);
		assertEquals(b.getCreditos().size(), 0);
	}
	
	@Test
	public void testRecibirCredirPersonalSolicitudAprobada() {
		b.recibirSolicitud(cp);
		assertEquals(b.getCreditos().size(), 1);
	}
	
	@Test
	public void testRecibirCredirPersonalSolicitudNoAprobada() {
		b.recibirSolicitud(cp);
		assertEquals(b.getCreditos().size(), 0);
	}

	@Test
	public void testTotalDeCreditos() {
		b.recibirSolicitud(cp);
		b.recibirSolicitud(ch);
		assertEquals(b.totalDeCreditos(), 120000  ); 
	}
}
