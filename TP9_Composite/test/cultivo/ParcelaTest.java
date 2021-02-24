package cultivo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import cultivos.Mixta;
import cultivos.Pura;
import cultivos.region.Parcela;

class ParcelaTest {

	@Mock Pura p;
	@Mock Mixta m;
	Parcela parcela;
	
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);  
		parcela = new Parcela();
		when(p.getGanancia()).thenReturn(300);
		when(m.getGanancia()).thenReturn(500);
		parcela.setRegion(p);
		parcela.setRegion(m);
	}

	@Test
	void testGetGanancia() {
		assertEquals(parcela.gananciaAnual(), 800 );
	}

}
