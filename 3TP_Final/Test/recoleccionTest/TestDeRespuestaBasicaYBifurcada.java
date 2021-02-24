package recoleccionTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import preguntaStrategy.Pregunta;
import preguntaStrategy.PreguntaBasica;
import respuesta.RespuestaBasicaYBifurcada;

class TestDeRespuestaBasicaYBifurcada {
     @Mock
     private Pregunta p1;
     @Mock
     private Pregunta p2;
     
     private RespuestaBasicaYBifurcada r1;
     
     @BeforeEach
     public void setUp() {
    	 r1 = new RespuestaBasicaYBifurcada();
     }
     
     @Test
     public void agregoRespuesta() {
    	 r1.agregarRespuesta("si");
    	 assertEquals("si",r1.respuesta());
     }
     @Test
     public void agregoPreguntaQueRespondio() {
    	 r1.preguntaQueRespondio(p1);
    	 assertEquals(p1,r1.preguntaQueRespondio());
     }
     
     @Test
     public void preguntaQueRespondioIncorrecta() {
    	 r1.preguntaQueRespondio(p2);
    	 Pregunta p= new PreguntaBasica("a");
    	 assertNotEquals(p,r1.preguntaQueRespondio());
     }
     @Test
     public void respuestasEsNull() {
    	 assertNull(r1.respuestas());
     }
}
