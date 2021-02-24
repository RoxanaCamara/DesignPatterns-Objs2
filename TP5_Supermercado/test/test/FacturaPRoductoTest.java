package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import productos.Cooperativa;
import productos.Producto;
import productos.Tradicional;
import servicios.FacturaPRoducto;

class FacturaPRoductoTest {

	Producto pt;
	Producto pc;
	FacturaPRoducto c1;
	
	@BeforeEach
	void setUp() throws Exception {
		 pt = new Tradicional( 45, 50 ); 
		 pc = new Cooperativa( 45, 50, 5 ); 
		 c1 = new FacturaPRoducto();
	}


	@Test
	void test() {
		c1.agregarProducto(pc);
		c1.agregarProducto(pt);
		assertTrue(c1.getPrecioTotal() == 85, "Error No se realizo la suma de los productos correctamente" );
	}

}
