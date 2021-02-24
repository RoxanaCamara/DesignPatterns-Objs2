package cliente;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PropiedadTest {

	Propiedad p;
	@BeforeEach
	void setUp() throws Exception {
		p = new Propiedad("Descripcion", "Direccion", 67000);
	}

	@Test
	void testGetValorFiscal() {
		assertEquals(p.getValorFiscal(), 67000);
	}

}
