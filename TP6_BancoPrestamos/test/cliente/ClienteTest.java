package cliente;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import creditos.CreditoHipotecario;
import creditos.CreditoPersonal;

class ClienteTest {

	Cliente c;
	@Mock Propiedad p;
	@BeforeEach
	void setUp() throws Exception {
		c = new Cliente("nombre", "direccion", 24, 55000 );
	}

	@Test
	void testSolicitarCreditoPersonal() {
		assertNotNull(c.solicitarCreditoPersonal(12, 45000));
		assertSame( c.solicitarCreditoPersonal(12, 45000).getClass(), CreditoPersonal.class);
	}
	
	@Test
	void testSolicitarCreditoHipotecario() {
		assertSame( c.solicitarCreditoHipotecario(90000, 12, p).getClass(), CreditoHipotecario.class);
		assertNotNull(c.solicitarCreditoHipotecario(90000, 12, p));
	}
	

	@Test
	void testGetSueldoMensual() {
		assertEquals(c.getSueldoMensual(), 55000  ); 
	}
	
	@Test
	void testGetSueldoAnual() {
		assertEquals(c.getSueldoAnual(), 660000); 
	}

}
