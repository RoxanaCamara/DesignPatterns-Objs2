package recoleccionTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import preguntaStrategy.PreguntaBasica;
import recoleccion.GuardaPregunta;

import static org.mockito.Mockito.*;

class GuardaPreguntaTest {

	private GuardaPregunta gp;
	private PreguntaBasica p;
	

	@BeforeEach
	void setUp() throws Exception {
		
		gp= new GuardaPregunta();
		p= mock(PreguntaBasica.class);
	}

	@Test
	void testDamePregunta() {
		
		gp.guardar(p);
		assertEquals(gp.damePregunta(),p);
	}

	@Test
	void testTienePregunta() {
		
		gp.tienePregunta(true);
		assertTrue(gp.tienePregunta());
		
	}
	
}
