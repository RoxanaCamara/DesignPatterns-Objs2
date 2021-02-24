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
import publicaciones.notificaciones.NotificacionPorClaves;

class NotificacionPorClavesTest {

	@Mock IArticulo art;
	@Mock ILaboratorio lab;
	NotificacionPorClaves noti;
	List<String> list;	List<String> list2;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
		list = new ArrayList<String>();
		list.add("Smalltalk");
		list.add("Java");
		
		list2 = new ArrayList<String>();
		list2.add("Junit");
		list2.add("Mockito");
		noti = new NotificacionPorClaves(lab, list );
	}

	@Test
	void testNotificacionEsDeSuInteres() {
		when(art.getClaves()).thenReturn(list);
		assertEquals(noti.notificacion(art), "Ey! Este articulo podria interesarte");
	}

	@Test
	void testNotificacionNoEsDeSuInteres() {		
		when(art.getClaves()).thenReturn(list2);
		assertEquals(noti.notificacion(art), "No es de interes");
	}
}
