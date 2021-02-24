package recoleccionTest;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ordenadorSTRATEGY.OrdenadorPorProyectos;
import proyecto.Proyecto;
import recoleccion.Encuesta;
import recoleccion.Investigador;
import recoleccion.SistemaCientopolis;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;


class SistemaCientopolisTest {

	private SistemaCientopolis sistema;
	private Investigador investigador;
	private Investigador investigador1;

	private Encuesta e;
	private Encuesta e1;
	private Encuesta e2;
	private Encuesta e3;
	private Proyecto p;
	private Proyecto p1;
	private OrdenadorPorProyectos ord;
	
	
	@BeforeEach
	void setUp() throws Exception {
		
		sistema= new SistemaCientopolis();
		investigador=mock(Investigador.class);
		investigador1=mock(Investigador.class);
		e=mock(Encuesta.class);
		e1=mock(Encuesta.class);
		e2=mock(Encuesta.class);
		e3=mock(Encuesta.class);
		p=mock(Proyecto.class);
		p1=mock(Proyecto.class);
		ord=mock(OrdenadorPorProyectos.class);
		
		
	}

	@Test
	void testObtenerInvestigadores() {
		
		List <Investigador> investigadores= new ArrayList<Investigador>();
		investigadores.add(investigador);investigadores.add(investigador1);
		
		sistema.agregarInvestigador(investigador);sistema.agregarInvestigador(investigador1);
		assertEquals(sistema.getInvestigadores(),investigadores);
	}

	@Test
	void testEncuestasFinalizadasDeLosInvestigadores() {
		
		sistema.agregarInvestigador(investigador);sistema.agregarInvestigador(investigador1);
		List <Encuesta> encuestaInvestigador= new ArrayList<Encuesta>();
		encuestaInvestigador.add(e);
		List <Encuesta> encuestaInvestigador1= new ArrayList<Encuesta>();
		encuestaInvestigador1.add(e1);encuestaInvestigador1.add(e2);
		
		when(investigador.encuestasFinalizadasDeTodosLosProyectos()).thenReturn(encuestaInvestigador);
		when(investigador1.encuestasFinalizadasDeTodosLosProyectos()).thenReturn(encuestaInvestigador1);
		
		List <Encuesta> resultado= new ArrayList<Encuesta>();
		resultado.add(e);resultado.add(e1);resultado.add(e2);
		
		assertEquals(sistema.encuestasFinalizadasDeTodosLosInvestigadores(),resultado);
	}
	
	@Test
	void testencuestasFinalizadasConMayorCantidadDeRespuestas() {
		
		sistema.agregarInvestigador(investigador);sistema.agregarInvestigador(investigador1);
		List <Encuesta> encuestaInvestigador= new ArrayList<Encuesta>();
		encuestaInvestigador.add(e);
		List <Encuesta> encuestaInvestigador1= new ArrayList<Encuesta>();
		encuestaInvestigador1.add(e1);encuestaInvestigador1.add(e2);
		
		when(investigador.encuestasFinalizadasDeTodosLosProyectos()).thenReturn(encuestaInvestigador);
		when(investigador1.encuestasFinalizadasDeTodosLosProyectos()).thenReturn(encuestaInvestigador1);
		when(e.cantidadDeRespuestas()).thenReturn(4);
		when(e1.cantidadDeRespuestas()).thenReturn(10);
		when(e2.cantidadDeRespuestas()).thenReturn(2);
		
		List<Encuesta> resultado= new ArrayList <Encuesta>();
		resultado.add(e1);resultado.add(e);resultado.add(e2);
		
		assertEquals(sistema.encuestasFinalizadasConMayorCantidadDeRespuestas(),resultado);
	}
	
	@Test
	void testProyectosDeTodoElSistema() {
		
		sistema.agregarInvestigador(investigador);sistema.agregarInvestigador(investigador1);
		List <Proyecto> proinv= new ArrayList<Proyecto>();
		proinv.add(p);
		List <Proyecto> proinv1= new ArrayList<Proyecto>();
		proinv1.add(p1);
		when(investigador.getProyectos()).thenReturn(proinv);
		when(investigador1.getProyectos()).thenReturn(proinv1);
		
		List <Proyecto> resultado = new ArrayList<Proyecto>();
		resultado.add(p);resultado.add(p1);
		
		assertEquals(sistema.proyectosDeTodoElSistema(),resultado);
		
	}
	
	@Test
	void testencuestasDisponiblesDelSistema() {
		
		
		sistema.agregarInvestigador(investigador);sistema.agregarInvestigador(investigador1);
		List <Proyecto> proinv= new ArrayList<Proyecto>();
		proinv.add(p);
		List <Proyecto> proinv1= new ArrayList<Proyecto>();
		proinv1.add(p1);
		when(investigador.getProyectos()).thenReturn(proinv);
		when(investigador1.getProyectos()).thenReturn(proinv1);
		List <Encuesta> encuestapro= new ArrayList<Encuesta>();
		encuestapro.add(e);encuestapro.add(e1);
		List <Encuesta> encuestapro1= new ArrayList<Encuesta>();
		encuestapro1.add(e2);encuestapro1.add(e3);
		when(p.encuestasDisponibles()).thenReturn(encuestapro);
		when(p1.encuestasDisponibles()).thenReturn(encuestapro1);
		
		List <Encuesta> resultado= new ArrayList<Encuesta>();
		resultado.add(e);resultado.add(e1);resultado.add(e2);resultado.add(e3);
		
		assertEquals(sistema.encuestasDisponiblesDelSistema(),resultado);
	}
	
	@Test
	void testOrdenarPor() {
		
		List <Encuesta> resultado= new ArrayList <Encuesta>();
		resultado.add(e);resultado.add(e1);resultado.add(e2);resultado.add(e3);
		when(ord.ordenar(sistema)).thenReturn(resultado);
		assertEquals(sistema.ordenarPor(ord),resultado);
	}
	
}
