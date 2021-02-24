package publicaciones;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import publicaciones.entidades.Articulo;

class ArticuloTest {
	
	@Mock List<String> list;
	Articulo art;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
		art = new Articulo("",list , "", "",list);
		
	}

	@Test
	void test() {
		
	}

}
