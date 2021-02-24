package publicaciones.suscripciones;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import publicaciones.entidades.IArticulo;
import publicaciones.entidades.ILaboratorio;
import publicaciones.notificaciones.NotificacionPorTipoDeArticulo;

class NotificacionPorTipoDeArticuloTest {


	@Mock IArticulo art;
	@Mock ILaboratorio lab;
	NotificacionPorTipoDeArticulo noti;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
		noti = new NotificacionPorTipoDeArticulo(lab, "" );
	}

	@Test
	void testNotificacionEsDeSuInteres() {
		when(art.getTipoDeArticulo()).thenReturn("");
		assertEquals(noti.notificacion(art), "Ey! Este articulo podria interesarte");
	}

	@Test
	void testNotificacionNoEsDeSuInteres() {		
		when(art.getTipoDeArticulo()).thenReturn("");
		assertEquals(noti.notificacion(art), "No es de interes");
	}

}
