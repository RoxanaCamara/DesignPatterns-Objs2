package test.empleado;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import empleado.EmpleadoPasante;

class EmpleadoPasanteTest {

	EmpleadoPasante ep;
	
	@BeforeEach
	void setUp() throws Exception {
		ep = new EmpleadoPasante(160);
	}

	@Test
	void testSueldoNeto() {
		assertEquals(ep.sueldoNeto(), 5568  ); 
	}

}
