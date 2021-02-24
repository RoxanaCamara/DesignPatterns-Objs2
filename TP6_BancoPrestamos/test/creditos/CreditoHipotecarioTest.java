package creditos;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import cliente.Cliente;
import cliente.Propiedad;

class CreditoHipotecarioTest {
	
	CreditoHipotecario  ch;
	@Mock Cliente c;
	@Mock Propiedad p;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
		ch = new CreditoHipotecario(45000,16,c,p);
		
	}

	@Test
	void testSIEstaAprobado() {
		when(p.getValorFiscal()).thenReturn(6000);
		when(c.getEdad()).thenReturn(26);
		when(c.getSueldoAnual()).thenReturn(66000);
		when(c.getSueldoMensual()).thenReturn(66000);
		assertTrue(ch.estaAprobado());
	}
	
	@Test
	void testNOEstaAprobado() {
		when(p.getValorFiscal()).thenReturn(6000);
		when(c.getEdad()).thenReturn(65);
		when(c.getSueldoAnual()).thenReturn(66000);
		when(c.getSueldoMensual()).thenReturn(66000);
		
		assertFalse(ch.estaAprobado());
	}

}
