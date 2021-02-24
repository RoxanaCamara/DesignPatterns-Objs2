package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import caja.Caja;
import productos.Cooperativa;
import productos.Tradicional;
import servicios.FacturaPRoducto;

class CajaTest {

	Caja caja;
	FacturaPRoducto c1;
	
	@BeforeEach
	void setUp() throws Exception {
		
		caja = new Caja();
		 c1 = new FacturaPRoducto();
		 c1.agregarProducto(new Tradicional( 45, 50 ));
		 c1.agregarProducto(new Cooperativa( 45, 50, 5 ));
		 
	}
	
	@Test
	void testFacturaPRoducto() {

	}
	
	@Test
	void testImpuesto() {

	}
	
	
	@Test
	void testServicio() {

	}

}
