package recoleccionTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import preguntaStrategy.Pregunta;
import preguntaStrategy.PreguntaBasica;
import respuesta.RespuestaDePreguntaMultiple;

class TestDeRespuestaDePreguntaMultiple {

   @Mock
   private Pregunta p1;
   
   private RespuestaDePreguntaMultiple r1;

   @BeforeEach
   public void setUp() {
	   r1= new RespuestaDePreguntaMultiple();
   }
   
   @Test
   public void agregoRespuestas() {
	   r1.agregarRespuesta("comedia");
       r1.agregarRespuesta("accion");
       r1.agregarRespuesta("romance");
       List<String> lis= new ArrayList<String>();
       lis.add("comedia");
       lis.add("accion");
       lis.add("romance");
       assertEquals(lis,r1.respuestas());
   }

   @Test
   public void respuestaEsNull() {
	   assertNull(r1.respuesta());
   }

   @Test
   public void agregoPreguntaQueRespondio() {
	   r1.preguntaQueRespondio(p1);
	   assertEquals(p1,r1.preguntaQueRespondio());
   }
   @Test
   public void preguntaQueRespondioIncorrecta() {
	   r1.preguntaQueRespondio(p1);  
	   Pregunta p2 = new PreguntaBasica("si");
	   assertNotEquals(p2,r1.preguntaQueRespondio());
	   
   }


}
