package recoleccionTest;

import static org.junit.jupiter.api.Assertions.*;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import proyecto.Proyecto;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import recoleccion.Encuesta;
import recoleccion.Investigador;

class InvestigadorTest {

	private Investigador investigador;
	private Proyecto proyecto;
	private Proyecto proyecto1;
	private Encuesta encuesta;
	private Encuesta encuesta1;
	private Encuesta encuesta2;
	
	
	

	@BeforeEach
	void setUp() throws Exception {
		investigador= new Investigador(4,"Tamara") ;
		proyecto=mock(Proyecto.class);
		proyecto1=mock(Proyecto.class);
		encuesta=mock(Encuesta.class);
		encuesta1=mock(Encuesta.class);
		encuesta2=mock(Encuesta.class);
	}

	@Test
	void testNombreDeInvestigador() {
		assertEquals(investigador.getNombre(),"Tamara");
	}

	@Test
	void testIdentificacionDeInvestigador() {
		
		assertEquals(investigador.getIdentificacion(),new Integer(4));
	}
	
	
	@Test
	void testUnInvestigadorContieneUnProyecto() {
		
		List <Proyecto> proyectos = new ArrayList<Proyecto>();
		proyectos.add(proyecto);
		proyectos.add(proyecto1);
		investigador.agregarProyecto(proyecto);
		investigador.agregarProyecto(proyecto1);
		assertEquals(investigador.getProyectos(),proyectos);
	}
	
	
	@Test 
	void testUnInvestigadorObtieneSusEncuestasFinalizadasDeTodosSusProyectos() {
		
		investigador.agregarProyecto(proyecto);investigador.agregarProyecto(proyecto1);
		List <Encuesta> encuestasp= new ArrayList <Encuesta>();
		List <Encuesta> encuestasp1= new ArrayList <Encuesta>();
		List <Encuesta> encuestasFinalizadas= new ArrayList <Encuesta>();
		
		encuestasp.add(encuesta);
		encuestasp1.add(encuesta1); encuestasp1.add(encuesta2);
		encuestasFinalizadas.add(encuesta);
		encuestasFinalizadas.add(encuesta1);
		encuestasFinalizadas.add(encuesta2);
		
		when(proyecto.encuestasFinalizadas()).thenReturn(encuestasp);
		when(proyecto1.encuestasFinalizadas()).thenReturn(encuestasp1);
		
		assertEquals(investigador.encuestasFinalizadasDeTodosLosProyectos(),encuestasFinalizadas);
	}
	
}
