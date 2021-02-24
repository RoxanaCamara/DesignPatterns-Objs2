package recoleccionTest;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import recoleccion.Encuesta;
import recoleccion.ManejadorDePregunta;
import respuesta.RespuestaDePreguntaMultiple;

import org.junit.Before;
import org.junit.Test;

import org.mockito.*;

import preguntaStrategy.PreguntaMultipleOpcion;


public class TestDePreguntaMultipleOpcion {
	
	private PreguntaMultipleOpcion pregu ;
   
	@Mock 
	private RespuestaDePreguntaMultiple respuesta;
	@Mock
	private Encuesta encuesta;
	@Mock
	private ManejadorDePregunta manejador;
	@Before
	public void setUp(){
		MockitoAnnotations.initMocks(this);
        pregu = new PreguntaMultipleOpcion("generos favoritos de cine");
        pregu.agregarOpcion("drama");
        pregu.agregarOpcion("accion");
        pregu.agregarOpcion("romance");
        pregu.agregarOpcion("comedia");
     
	}
	@Test
	public void leer() {
	     assertEquals("generos favoritos de cine",pregu.leer());   	
	}
	@Test
	public void opciones (){
		List<String> listita = new ArrayList<String>();
		listita.add("drama");
		listita.add("accion");
		listita.add("romance");
		listita.add("comedia");
		assertEquals(listita,pregu.opciones());
	}
	
	@Test
	public void preguntaSiguienteNula() {
		
		assertNull(pregu.preguntaSiguiente(respuesta));
	}
	
	@Test
	public void respuestaPermitidaValida() throws Exception{
		when(encuesta.manejador()).thenReturn(manejador);
		pregu.respuestaPermitida(respuesta, encuesta);
        verify(encuesta,times(1)).manejador();
	 	verify(manejador,times(1)).responderDeBasica(encuesta, respuesta);
	    verify(respuesta,times(1)).respuestas(); 
	}
	
	@Test
	public void respuestaPermitidaNoValida() throws Exception{
		List<String> listita=new ArrayList<String>();
		listita.add("clasico");
		when(encuesta.manejador()).thenReturn(manejador);
		when(respuesta.respuestas()).thenReturn(listita);
		assertThrows(Exception.class,() -> pregu.respuestaPermitida(respuesta, encuesta)); 
	}
	
	@Test
	public void esBifurcada() throws Exception {
		when(encuesta.manejador()).thenReturn(manejador);
		pregu.esBifurcada(encuesta);
		verify(encuesta,times(1)).manejador();
		verify(manejador,times(1)).preguntaSiguienteDeBasica(encuesta);
	}
}

