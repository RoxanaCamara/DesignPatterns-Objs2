package test.empresa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import empleado.EmpleadoPasante;
import empleado.EmpleadoPlanta;
import empleado.EmpleadoTemporario;
import empresa.Empresa;

class EmpresaTest {
	
	@Mock EmpleadoTemporario et;
	@Mock EmpleadoPasante eps;
	@Mock EmpleadoPlanta ep;
	 Empresa em;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
		em = new Empresa();		
		em.setEmpleado(et);
		em.setEmpleado(eps);
		em.setEmpleado(ep);
	}

	@Test
	void testPagarEmpleados() {
		when(et.sueldoNeto()).thenReturn(30);
		when(eps.sueldoNeto()).thenReturn(30);
		when(ep.sueldoNeto()).thenReturn(30);
		assertEquals(em.pagarALosEmpleados(), 90 ); 
	}
	

}
