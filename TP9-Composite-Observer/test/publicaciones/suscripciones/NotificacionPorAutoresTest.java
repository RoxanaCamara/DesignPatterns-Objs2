package publicaciones.suscripciones;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import publicaciones.entidades.IArticulo;
import publicaciones.entidades.ILaboratorio;
import publicaciones.notificaciones.NotificacionPorAutores;

class NotificacionPorAutoresTest {
	
	@Mock IArticulo art;
	@Mock ILaboratorio lab;
	NotificacionPorAutores noti;
	List<String> list;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
		list = new ArrayList<String>();
		list.add("HAlan Poet");
		list.add("Stifeng Quing");
		
		noti = new NotificacionPorAutores(lab, list );
	}

	@Test
	void testNotificacionEsDeSuInteres() {
		when(art.getAutores()).thenReturn(list);
		assertEquals(noti.notificacion(art), "EY! Tu autor Favorito saco un nuevo Articulo!");
	}

	@Test
	void testNotificacionNoEsDeSuInteres() {
		assertEquals(noti.notificacion(art), "No es de interes");
	}

}
