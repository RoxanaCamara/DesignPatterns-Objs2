package recoleccionTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import org.mockito.*;

import preguntaStrategy.PreguntaBasica;
import recoleccion.Encuesta;
import recoleccion.ManejadorDePregunta;
import respuesta.Respuesta;

import static org.mockito.Mockito.*;

public class TestPreguntaBasica {
    private PreguntaBasica pregu ;
    
    @Mock
    private Respuesta re;
	@Mock 
	private Encuesta encuesta;
	@Mock
	private ManejadorDePregunta manejador;
	
	
	
	@Before
    public void setUp(){
		MockitoAnnotations.initMocks(this);
        pregu = new PreguntaBasica("algo");
	   
	}
    @Test
    public void respuestaPermitida() throws Exception{
    	
    	when(encuesta.manejador()).thenReturn(manejador);
    	pregu.respuestaPermitida(re, encuesta);
    	verify(encuesta,times(1)).manejador();
    	verify(manejador,times(1)).responderDeBasica(encuesta,re);
    }
    @Test
    public void esBifurcada() throws Exception{
    	when(encuesta.manejador()).thenReturn(manejador);
    	pregu.esBifurcada(encuesta);
    	verify(encuesta,times(1)).manejador();
    	verify(manejador,times(1)).preguntaSiguienteDeBasica(encuesta);
    }
    
    @Test 
	public void laSiguienteEsNula(){
		assertNull(pregu.preguntaSiguiente(re));
	}
	
	@Test 
	public void testDecimeLaPregunta() {
		assertEquals("algo", pregu.leer());
	}
	
	@Test 
	public void textoDePreguntaIncorrecta() {
		assertNotEquals("cosa",pregu.leer());
	}
	
	
	
	

}
