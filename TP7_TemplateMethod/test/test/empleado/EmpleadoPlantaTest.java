package test.empleado;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import empleado.EmpleadoPlanta;

class EmpleadoPlantaTest {

	EmpleadoPlanta ep;
	
	@BeforeEach
	void setUp() throws Exception {
		ep = new EmpleadoPlanta(3, 45000);
	}

	@Test
	void testSueldoNeto() {
		assertEquals(ep.sueldoNeto(), 5872503  ); 
	}
}
