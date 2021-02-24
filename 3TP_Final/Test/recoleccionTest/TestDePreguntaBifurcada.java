package recoleccionTest;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;



import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

import java.util.HashSet;
import java.util.Set;

import org.mockito.*;

import preguntaStrategy.PreguntaBasica;
import preguntaStrategy.PreguntaBifurcada;
import preguntaStrategy.PreguntaMultipleOpcion;
import recoleccion.Encuesta;
import recoleccion.ManejadorDePregunta;
import respuesta.RespuestaBasicaYBifurcada;
public class TestDePreguntaBifurcada {
    @Mock
    private Encuesta encuesta;
    @Mock
    private ManejadorDePregunta manejador;

	private RespuestaBasicaYBifurcada respuesta;
	private PreguntaBasica preBasica;
	private PreguntaMultipleOpcion preMultiple;
	private PreguntaBifurcada preguntaB;
	
	@Before
	public void setUp (){
	 MockitoAnnotations.initMocks(this);
	 respuesta = new RespuestaBasicaYBifurcada();
	 preguntaB = new PreguntaBifurcada("tiene casa");
     preMultiple = new PreguntaMultipleOpcion("alquila");
     preBasica= new PreguntaBasica("cuanto salio");
     preMultiple.agregarOpcion("si") ;    
     preMultiple.agregarOpcion("no") ;       
	 preguntaB.agregarPreguntaAOpcion(preBasica, "si");
	 preguntaB.agregarPreguntaAOpcion(preMultiple, "no");

	}
	
	@Test
	public void leerPregunta(){
		assertEquals("tiene casa",preguntaB.leer());
	}
	
	
	@Test
	public void opciones(){
		Set a;
		a= new HashSet<String>();
		a.add("si");
		a.add("no");
       assertEquals(a,preguntaB.opciones());
	}
	@Test
	public void esBifurcada()throws Exception{
		
		when(encuesta.manejador()).thenReturn(manejador);
		preguntaB.esBifurcada(encuesta);
		verify(encuesta,times(1)).manejador();
		verify(manejador,times(1)).preguntaSiguienteDeBifurcada(encuesta);
		
	}
	
	@Test
	public void respuestaPermitidaValida() throws Exception{
		respuesta.agregarRespuesta("si");
		when(encuesta.manejador()).thenReturn(manejador);
		preguntaB.respuestaPermitida(respuesta, encuesta);
		verify(encuesta,times(1)).manejador();
		verify(manejador,times(1)).responderDeBifurcada(encuesta, respuesta);
	}
	
	@Test
	public void respuestaPermitidaNoValida() throws Exception{
		respuesta.agregarRespuesta("a");
		assertThrows(Exception.class,() -> preguntaB.respuestaPermitida(respuesta, encuesta));
	}
	
	@Test
	public void preguntaSiguienteRSi() {
		respuesta.agregarRespuesta("si");
        assertEquals(preBasica,preguntaB.preguntaSiguiente(respuesta));
	}
	@Test
	public void preguntaSiguienteRNo() {
		respuesta.agregarRespuesta("no");
	   assertEquals(preMultiple,preguntaB.preguntaSiguiente(respuesta));                  
	}

}
