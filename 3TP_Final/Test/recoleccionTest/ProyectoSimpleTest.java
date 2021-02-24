package recoleccionTest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import proyecto.ProyectoSimple;

import static org.mockito.Mockito.*;

import recoleccion.Encuesta;

public class ProyectoSimpleTest {

	private ProyectoSimple proye;
	private Encuesta e1; 
	private Encuesta e2 ;
	 
	
	
	@Before 
	public void setUp(){
		
	proye = new ProyectoSimple("java");
	
	e1 = mock(Encuesta.class);
	e2 = mock(Encuesta.class);
	
	}
	
	
	
	@Test 
	public void testObtenerEncuestas(){
		
		List <Encuesta> encuestas= new ArrayList<Encuesta>();
		encuestas.add(e2);encuestas.add(e1);
		proye.agregarEncuesta(e2);
		proye.agregarEncuesta(e1);
		
		assertEquals(proye.getEncuestas(),encuestas);
		
	}


	@Test
	public void testSeObtieneLasEncuestasFinalizadasDelProyecto() {
		
		List <Encuesta> encuestasF= new ArrayList <Encuesta>();
		encuestasF.add(e1);
		proye.agregarEncuesta(e1);
		proye.agregarEncuesta(e2);
		
		when(e1.estaTerminada()).thenReturn(true);
		when(e2.estaTerminada()).thenReturn(false);
		
		assertEquals(proye.encuestasFinalizadas(),encuestasF);
		
	}
  
	@Test
	public void testEncuestasDisponibles() {
		
		Encuesta e3=mock(Encuesta.class);
		
		proye.agregarEncuesta(e1);
		proye.agregarEncuesta(e2);
		proye.agregarEncuesta(e3);
		
		
		when(e1.presentaDisponibilidad()).thenReturn(true);
		when(e2.presentaDisponibilidad()).thenReturn(false);
		when(e3.presentaDisponibilidad()).thenReturn(true);
		
		List<Encuesta> resultado= new ArrayList<Encuesta>();
		resultado.add(e1);resultado.add(e3);
		
		assertEquals(proye.encuestasDisponibles(),resultado);
	}
	
	@Test
	public void testObtenerNombre() {
		
		
		assertEquals(proye.getNombre(),"java");
	}
	
}
