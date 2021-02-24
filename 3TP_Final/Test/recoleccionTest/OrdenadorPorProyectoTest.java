package recoleccionTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ordenadorSTRATEGY.OrdenadorPorProyectos;
import proyecto.Proyecto;
import proyecto.ProyectoSimple;
import recoleccion.Encuesta;
import recoleccion.SistemaCientopolis;

class OrdenadorPorProyectoTest {

	private SistemaCientopolis sistem;
	private ProyectoSimple pro2;
	private ProyectoSimple pro1;
	private ProyectoSimple pro;
	private OrdenadorPorProyectos ordenador;
	private Encuesta e;
	private Encuesta e1;
	private Encuesta e2;
	private Encuesta e3;
	private Encuesta e4;
	
	
	
	
	
	@BeforeEach
	void setUp() throws Exception {
		
		ordenador= new OrdenadorPorProyectos();
		sistem=mock(SistemaCientopolis.class);
		pro=mock(ProyectoSimple.class);
		pro1=mock(ProyectoSimple.class);
		pro2=mock(ProyectoSimple.class);
		e=mock(Encuesta.class);
		e1=mock(Encuesta.class);
		e2=mock(Encuesta.class);
		e3=mock(Encuesta.class);
		e4=mock(Encuesta.class);
	}

	@Test
	void testProyectosOrdenadosAlfabeticamente() {
		List<Proyecto> resultado= new ArrayList<Proyecto>();

		resultado.add(pro2); resultado.add(pro1);resultado.add(pro);

		List <Proyecto> proyectos= new ArrayList<Proyecto>();

		proyectos.add(pro);proyectos.add(pro1);proyectos.add(pro2);

		when(pro.getNombre()).thenReturn("Recreate");

		when(pro1.getNombre()).thenReturn("ExpressArte");

		when(pro2.getNombre()).thenReturn("Biotecnologia");

		when(sistem.proyectosDeTodoElSistema()).thenReturn(proyectos);

		assertEquals(ordenador.proyectosOrdenadosAlfabeticamente(sistem),resultado);
	}
	
	
	@Test
	void testEncuestasOrdenadasPorProyectos() {
		
		List<Proyecto> resultado= new ArrayList<Proyecto>();

		resultado.add(pro2); resultado.add(pro1);resultado.add(pro);

		List <Proyecto> proyectos= new ArrayList<Proyecto>();

		proyectos.add(pro);proyectos.add(pro1);proyectos.add(pro2);

		when(pro.getNombre()).thenReturn("Recreate");

		when(pro1.getNombre()).thenReturn("ExpressArte");

		when(pro2.getNombre()).thenReturn("Biotecnologia");

		when(sistem.proyectosDeTodoElSistema()).thenReturn(proyectos);
		
		List<Encuesta> encuestaspro= new ArrayList<Encuesta>();
		encuestaspro.add(e);encuestaspro.add(e1);
		List<Encuesta> encuestaspro1=new ArrayList<Encuesta>();
		encuestaspro1.add(e2);
		List<Encuesta> encuestaspro2= new ArrayList<Encuesta>();
		encuestaspro2.add(e3);encuestaspro2.add(e4);
		
		when(pro.encuestasDisponibles()).thenReturn(encuestaspro);
		when(pro1.encuestasDisponibles()).thenReturn(encuestaspro1);
		when(pro2.encuestasDisponibles()).thenReturn(encuestaspro2);
		
		List<Encuesta> encuestaResultadoOrdenado= new ArrayList<Encuesta>();
		encuestaResultadoOrdenado.add(e3);encuestaResultadoOrdenado.add(e4);
		encuestaResultadoOrdenado.add(e2);encuestaResultadoOrdenado.add(e);
		encuestaResultadoOrdenado.add(e1);
		
		assertEquals(ordenador.ordenar(sistem),encuestaResultadoOrdenado);
	}

}
