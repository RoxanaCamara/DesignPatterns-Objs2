package test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import productos.Cooperativa;
import productos.Producto;
import productos.Tradicional;

class ProductoTest {
	
	Producto pt;
	Producto pc;
	
	@BeforeEach
	void setUp() throws Exception {
		 pt = new Tradicional( 45, 50 ); 
		 pc = new Cooperativa( 45, 50, 5 ); 
	}


	@Test
	void testPrecioProductoTradicional() {
		assertTrue(pt.getPrecio() == 45, "Error No es el mismo precio de Prod Tradicional" );
	}
	
	@Test
	void testPrecioProductoCooperativa() {
		assertTrue(pc.getPrecio() == 40, "Error No es el mismo precio de Prod Cooperativa" );
	}

	@Test
	void testReducirStoock() {
		pc.reducirStock();
		assertTrue(pc.getStock()== 49, "Error No se redujo el stoock" );
	}
}
