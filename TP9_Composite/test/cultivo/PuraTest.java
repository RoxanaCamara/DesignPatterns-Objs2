package cultivo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import cultivos.Pura;

class PuraTest {

	Pura p;

	@BeforeEach
	void setUp() throws Exception {
		p = new Pura(300, "Trigo");
	}

	@Test
	void testGetGanancia() {
		assertEquals(p.getGanancia(), 300);
	}

}
