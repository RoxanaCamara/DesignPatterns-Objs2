package recoleccionTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

import preguntaStrategy.Pregunta;
import recoleccion.ProtocoloEncuesta;

import java.util.ArrayList;
import java.util.List;

public class TestProtocoloEncuesta {
   private ProtocoloEncuesta protocolo;
   @Mock
   private Pregunta p1;
   @Mock
   private Pregunta p2;
   @Mock
   private Pregunta p3;
   
   @Before
   public void setUp() {
	   MockitoAnnotations.initMocks(this);
	   protocolo= new ProtocoloEncuesta();
   }
   

   @Test
   public void preguntas() {
	   protocolo.agregarPregunta(p1);
       protocolo.agregarPregunta(p2);
       protocolo.agregarPregunta(p3);
       List<Pregunta> l = new ArrayList<Pregunta>();
       l.add(p1);
       l.add(p2);
       l.add(p3);
       assertEquals(l,protocolo.preguntas());
   }
   

}
