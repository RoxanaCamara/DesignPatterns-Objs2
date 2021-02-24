package cultivo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import cultivos.Mixta;
import cultivos.Pura;

class MixtaTest {

	@Mock Pura trigo;
	@Mock Pura soja;
	Mixta m;
	Mixta m2;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
		m = new Mixta();
		m2 = new Mixta();
		when(trigo.getGanancia()).thenReturn(300);
		when(soja.getGanancia()).thenReturn(600);
		m.setPorcion(trigo);
		m.setPorcion(trigo);
		m.setPorcion(soja);
		m.setPorcion(soja);
		
		
		m2.setPorcion(soja);
		m2.setPorcion(m);

	}
	
	@Test
	void testCantidadDePorciones() {
		assertEquals(m.getPorciones().size(), 4);
	}


	@Test
	void testGetGananciaTrigo() {
		assertEquals(m.getGanancia(), 450);
	}

	@Test
	void testGetGananciaMixta() {
		assertEquals(m2.getGanancia(), 525);
	}


}
