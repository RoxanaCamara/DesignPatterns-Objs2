package test.empleado;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import empleado.EmpleadoTemporario;

class EmpleadoTemporarioTest {

	EmpleadoTemporario et;
	
	@BeforeEach
	void setUp() throws Exception {
		et = new EmpleadoTemporario( 45000, true,  160);
	}

	@Test
	void testSueldoNeto() {
		assertEquals(et.sueldoNeto(), 39933  ); 
	}

	@Test
	void testSueldoNetoSinHijosONiCasado() {
		et.tieneHijosOEstaCasado(false);
		assertEquals(et.sueldoNeto(), 39846  ); 
	}
	
}
