package creditos;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import cliente.Cliente;

class CreditoPersonalTest {
	
	CreditoPersonal cp;
	@Mock Cliente c;
	
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		cp = new CreditoPersonal(56000, 6, c);
	}
	
	@Test
	void testSIEstaAprobado() {
		when(c.getSueldoAnual()).thenReturn(66000);
		when(c.getSueldoMensual()).thenReturn(667000);
		assertTrue(cp.estaAprobado());
	}
	
	@Test
	void testNOEstaAprobado() {
		when(c.getSueldoAnual()).thenReturn(6000);
		when(c.getSueldoMensual()).thenReturn(660);
		assertFalse(cp.estaAprobado());
	}
}
